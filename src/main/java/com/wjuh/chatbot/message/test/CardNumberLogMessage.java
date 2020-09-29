package com.wjuh.chatbot.message.test;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class CardNumberLogMessage extends Message {
    public CardNumberLogMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Для перевода нужен только номер карты, а чаще всего достаточно номера вашего мобильного телефона. ПИН- и CVV-коды от банковских карт не следует сообщать никому, даже сотрудникам банка.\n" +
                        "        Для перевода нужен только номер карты, а чаще всего достаточно номера вашего мобильного телефона.\n" +
                        "                ПИН- и CVV-коды от банковских карт не следует сообщать никому, даже сотрудникам банка."
                        + getUser().getId() + ")")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return null;
    }
}
