package com.wjuh.chatbot.message.test;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class VirusLogMessage extends Message {

    public VirusLogMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("По ссылке может быть приложение с вирусом, которое загрузится на телефон, или сайт-ловушка, на котором мошенники попытаются получить номера банковских карт, ПИН- и CVV-коды.")
                .enableMarkdown(true);

    }

    @Override
    public String getTag() {
        return null;
    }
}
