package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductQuestionMessage extends Message {
    public static final String SBER_BOX = "Приставка SberBox";
    public static final String SBER_PORTAL = "Умный экран SberPortal";
    public static final String SBER_PRIME = "SberPrime - подписка на сервисы экосистемы";

    public static final List<String> PRODUCTS = Arrays.asList(SBER_BOX, SBER_PORTAL, SBER_PRIME);

    public ProductQuestionMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Какой продукт вам понравился больше всего")
                .setReplyMarkup(getUnitsKeyboard());
    }

    @Override
    public String getTag() {
        return "CONFMESSAGE";
    }

    private static ReplyKeyboardMarkup getUnitsKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(SBER_BOX);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(SBER_PORTAL);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(SBER_PRIME);
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
