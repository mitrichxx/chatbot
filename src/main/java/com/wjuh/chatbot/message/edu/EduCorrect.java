package com.wjuh.chatbot.message.edu;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class EduCorrect extends Message {
    public EduCorrect(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Верно!");
    }

    @Override
    public String getTag() {
        return "EDUCORRECT";
    }

}
