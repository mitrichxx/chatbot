package com.wjuh.chatbot;

import com.wjuh.chatbot.command.HelloCommand;
import com.wjuh.chatbot.command.StartCommand;
import com.wjuh.chatbot.message.ConfMessage;
import com.wjuh.chatbot.message.ProductAnswerMessage;
import com.wjuh.chatbot.message.ProductMessage;
import com.wjuh.chatbot.message.ProductQuestionMessage;
import com.wjuh.chatbot.service.SenderService;
import com.wjuh.chatbot.state.BaseState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.helpCommand.HelpCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Component
public class VjuhBot extends TelegramLongPollingBot {

    public static Map<Integer, BaseState> USER_MAP = new HashMap<>();

    private static Map<String, BotCommand> commandMap = new HashMap<>();
    static {
        commandMap.put("/hello", new HelloCommand());
        commandMap.put("/help", new HelpCommand());
    }

    @Autowired
    private StartCommand startCommand;
    @Autowired
    private SenderService senderService;

    @PostConstruct
    public void init() {
        commandMap.put("/start", startCommand);
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("onUpdateReceived");
        // We check if the update has a message and the message has text

        try {
            if (update.hasMessage()) {
                if (update.getMessage().isCommand()) {
                    String[] strings = update.getMessage().getText().split(" ");
                    String[] args = Arrays.stream(strings).skip(1).toArray(String[]::new);
                    BotCommand botCommand = commandMap.get(strings[0]);
                    if (botCommand == null) {
                        SendMessage message = new SendMessage()
                                .setChatId(update.getMessage().getChatId())
                                .setText("Unknown command");
                        execute(message);
                    } else {
                        log.info("Try to execute command: " + " " + this.getBaseUrl() + " " + update.getMessage().getChat().getDescription());
                        botCommand.execute(this, update.getMessage().getFrom(), update.getMessage().getChat(), args);
                    }
                } else if (update.getMessage().hasText()) {
                    String text = update.getMessage().getText();
                    log.info("###" + text);

                    BaseState state = VjuhBot.USER_MAP.get(update.getMessage().getFrom().getId());
                    switch (state) {
                        case FRAUD:
                            log.info("### fraud state, userId=" + update.getMessage().getFrom().getId());
                            if (ConfMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new ProductMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                senderService.send(this, new ProductQuestionMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if (ProductQuestionMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new ProductAnswerMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            }
                            break;
                        default:
                            log.info("### state not found, userId=" + update.getMessage().getFrom().getId());
                            SendMessage message = new SendMessage()
                                    .setChatId(update.getMessage().getChatId())
                                    .setText(text);
                            execute(message);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            log.info("Failed process message", e);
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        log.info("onUpdateReceivedList");
        for (Update update : updates) {
            onUpdateReceived(update);
        }
    }

    @Override
    public String getBotUsername() {
        return "vjuh_bot";
    }

    @Override
    public String getBotToken() {
        return "1316571024:AAF9M6Qz0rOl2mRkN-f8kp6_MfPBlkC1-5M";
    }

}
