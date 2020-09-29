package com.wjuh.chatbot.message;

import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class WelcomeMessage extends Message {
    @Value("${string.glad_to_hear_your_opinion}")
    private String qwe;

    public WelcomeMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Мы стремимся стать лучше и хотим еще больше радовать наших клиентов! Поэтому нам так важно услышать ваше мнение. " + qwe);
    }

    @Override
    public String getTag() {
        return "WELCOMEMESSAGE";
    }
}
