package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBootVirusMessage extends TestMessage{
    public static final String ANSWER_1 = "Нет, это СМС от мошенников. Я его удалю";
    public static final String ANSWER_2 = "Конечно, можно. Наверное, телефон глючит.";
    public static final String ANSWER_3 = "Да, просто Банк отправил смс с другого номера";

    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);
    public TestBootVirusMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "Вам пришло СМС-сообщение от банка, но почему-то оно попало в отдельную переписку в телефоне. Можно ли доверять такому сообщению?";
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
