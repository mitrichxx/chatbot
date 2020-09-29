package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class HurryUpMessage extends Message {
    public HurryUpMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Сообщаем, что акция ограничена по времени")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "HurryUpMessage";
    }
}
