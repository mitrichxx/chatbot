package com.wjuh.chatbot.message.test;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class CallLogMessage extends Message {
    public CallLogMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Позвоните в банк и сообщите свой новый номер, чтобы мошенники не воспользовались вашим старым номером для перевода.")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return null;
    }
}
