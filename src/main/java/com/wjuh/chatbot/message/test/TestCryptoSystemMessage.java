package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCryptoSystemMessage extends TestMessage{
    public static final String ANSWER_1 = "Удалю письмо. Это же фишинг!";
    public static final String ANSWER_2 = "Скачаю файл и прочитаю. Это полезная информация.";
    public static final String ANSWER_3 = "Отправлю друзьям, поделюсь скидками.";
    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);
    public TestCryptoSystemMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "На вашу электронную почту пришло письмо от портала государственных услуг с адреса rosuslugi@gmail.com. Письмо содержит вложение формата ZIP «Перечень скидок на медицинские услуги рядом с вашим домом». В то же время в нём нет персонального обращения и контактов отправителя. Что сделаете?";
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
