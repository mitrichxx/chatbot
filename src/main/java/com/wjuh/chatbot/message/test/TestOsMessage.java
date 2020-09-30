package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestOsMessage extends TestMessage {
    public static final String ANSWER_1 = "Сразу переведу деньги";
    public static final String ANSWER_2 = "Переключусь на мобильный интернет и выполню перевод";
    public static final String ANSWER_3 = "Подключусь к другой открытой Wi-Fi точке и совершу перевод";

    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);
    public TestOsMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "Сидя в кафе Вы подключились к Wi-Fi без пароля и читаете новости. Вам написала подруга и попросила перевести деньги через онлайн-банк. Что будете делать?";
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
