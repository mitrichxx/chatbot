package com.wjuh.chatbot.message.edu;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class EduExplanation extends Message {
    private String explanation;

    public EduExplanation(User user, Chat chat, String[] arguments, String explanation) {
        super(user, chat, arguments);
        this.explanation = explanation;
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText(explanation);
    }

    @Override
    public String getTag() {
        return "EDUCORRECT";
    }

}
