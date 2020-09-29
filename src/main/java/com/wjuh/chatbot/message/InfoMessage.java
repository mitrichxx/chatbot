package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class InfoMessage extends Message {
    public InfoMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("[Информация о команде](http://sber.fant0m.pro/" + getUser().getId() + ")")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "InfoMessage";
    }
}
