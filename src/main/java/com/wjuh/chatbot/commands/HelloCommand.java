package com.wjuh.chatbot.commands;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class HelloCommand extends BotCommand {
    private static final String LOGTAG = "HELLOCOMMAND";

    public HelloCommand() {
        super("hello", "Say hallo to this bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

//        if (!DatabaseManager.getInstance().getUserStateForCommandsBot(user.getId())) {
//            return;
//        }return
        log.info("### hello");
        String userName = chat.getUserName();
        log.info("### Username: " + userName);
        if (userName == null || userName.isEmpty()) {
            userName = user.getFirstName() + " " + user.getLastName();
        }

        StringBuilder messageTextBuilder = new StringBuilder("Hello ").append(userName);
        if (arguments != null && arguments.length > 0) {
            messageTextBuilder.append("\n");
            messageTextBuilder.append("Thank you so much for your kind words:\n");
            messageTextBuilder.append(String.join(" ", arguments));
        }

        log.info("Chat: " + chat.getTitle());

        SendMessage answer = new SendMessage();
        answer.setChatId(chat.getId().toString());
        answer.setText(messageTextBuilder.toString());
        log.info("Answer: " + answer.getText());
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            log.error(LOGTAG, e);
        }
    }
}
