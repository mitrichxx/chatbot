package com.wjuh.chatbot;

import com.wjuh.chatbot.commands.HelloCommand;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.helpCommand.HelpCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.*;

@Slf4j
public class VjuhBot extends TelegramLongPollingBot {

    private static Map<String, BotCommand> commandMap = new HashMap<>();
    static {
        commandMap.put("/hello", new HelloCommand());
        commandMap.put("/help", new HelpCommand());
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("onUpdateReceived");
        // We check if the update has a message and the message has text

        try {
            if (update.hasMessage()) {
                if (update.getMessage().isCommand()) {
                    String[] args = update.getMessage().getText().split(" ");
                    BotCommand botCommand = commandMap.get(args[0]);
                    if (botCommand == null) {
                        SendMessage message = new SendMessage()
                                .setChatId(update.getMessage().getChatId())
                                .setText("Unknown command");
                        execute(message);
                    } else {
                        log.info("Try to execute command: " + " " + this.getBaseUrl() + " " + update.getMessage().getChat().getDescription());
                        botCommand.execute(this, update.getMessage().getFrom(), update.getMessage().getChat(), Arrays.stream(args).skip(1).toArray(String[]::new));
                    }
                } else if (update.getMessage().hasText()) {
                    log.info("###" + update.getMessage().getText());
                    SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                            .setChatId(update.getMessage().getChatId())
                            .setText(update.getMessage().getText())
                            .setReplyMarkup(getUnitsKeyboard());
                    execute(message);
                }
            }
        } catch (Exception e) {
            log.info("Failed process message", e);
        }
    }

    private static ReplyKeyboardMarkup getUnitsKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("123");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("456");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("789");
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
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
