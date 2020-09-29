package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class ItsOkToShareYourDataMessage extends Message {
    public ItsOkToShareYourDataMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Напоминаем, что номер карты не следует сообщать посторонним лицам, в том числе и сотрудникам Банка. Однако сейчас вы общаетесь с роботом по секретному каналу и это совершенно безопасно.")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "ItsOkToShareYourDataMessage";
    }
}
