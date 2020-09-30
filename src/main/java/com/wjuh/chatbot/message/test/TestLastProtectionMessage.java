package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLastProtectionMessage extends TestMessage{
    public static final String ANSWER_1 = "Предоставлю доступ, почему бы и нет? Вдруг пригодится.";
    public static final String ANSWER_2 = "Я разрешу доступ в зависимости от приложения и его функций.";
    public static final String ANSWER_3 = "Я не предоставлю доступ к этой информации.";

    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);

    public TestLastProtectionMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "Вы начали устанавливать новое приложение для обработки фотографий, а оно просит доступ к геопозиции, микрофону и контактам. Что будете делать?";
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
