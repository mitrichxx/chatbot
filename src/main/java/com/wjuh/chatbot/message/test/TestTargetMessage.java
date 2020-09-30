package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTargetMessage extends TestMessage{
    public static final String ANSWER_1 = "Скачаю приложение которое посоветовала подруга и переведу ей деньги.";
    public static final String ANSWER_2 = "Поищу в интернете другие приложения.через которые можно перевести деньги";
    public static final String ANSWER_3 = "Дождусь,когда заработает сайт Сбербанка или скачаю приложение с Play Маркет";

    public static final List<String> ANSWERS = Arrays.asList(ANSWER_1, ANSWER_2, ANSWER_3);
    public TestTargetMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public String getTag() {
        return "Вам звонит подруга и просит срочно перевести ей деньги на телефон, но у вас не установлено приложение Сбербанк,сайт временно не доступен. Она предлагает скачать аналог приложения для пополнения счета с MnogoProgramm.com.";
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
