package com.wjuh.chatbot.message.edu;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class EduTheory extends Message {
    private final String theory;

    public EduTheory(User user, Chat chat, String[] arguments, String theory) {
        super(user, chat, arguments);
        this.theory = theory;
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText(theory);
    }

    @Override
    public String getTag() {
        return "EDUTHEORY";
    }
}
