package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSecurityFraudMessage extends TestMessage{
    public static final String ANSWER_1 = "http://naprimer.ru";
    public static final String ANSWER_2 = "https://naprimer.ru";
    public static final String ANSWER_3 = "https://napremer.ru";

    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);
    public TestSecurityFraudMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "Вы хотите оплатить заказ в онлайн-магазине «Naprimer.ru». На какой странице вы уверенно введёте данные своей карты?";
    }

    @Override
    protected List<KeyboardRow> createKeyboard() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(ANSWER_1);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(ANSWER_2);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(ANSWER_3);
        keyboard.add(row);
        return keyboard;
    }
}
