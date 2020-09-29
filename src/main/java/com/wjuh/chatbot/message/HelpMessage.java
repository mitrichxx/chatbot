package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class HelpMessage extends Message {
    public HelpMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("*info - информация*\n" +
                        "*start - начало работы*\n" +
                        "*help - помощь*\n" +
                        "*test - пройти тестирование*\n" +
                        "*education - пройти обучение*")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "HelpMessage";
    }
}
