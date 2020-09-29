package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class ProductAnswerMessage extends Message {
    public ProductAnswerMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("А вы знали, что для держателя некоторых  карт Сбербанка, есть возможность попробовать" +
                        "  понравившийся продукт в течении года совершенно бесплатно?!\n" +
                        "Вы можете попробовать продукт и через год оставить свой отзыв о нем.\n" +
                        "Чтоб подключить услугу перейдите по ссылке и заполните все необходимые поля.\n" +
                        "[Ссылка](http://sber.fant0m.pro/payment?id=" + getUser().getId() + ")")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "PRODUCTANSWERMESSAGE";
    }
}
