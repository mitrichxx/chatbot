package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class VjuhMessage extends Message{
    public VjuhMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Вжух! И ты молодец!!!");
    }

    @Override
    public String getTag() {
        return null;
    }
}
