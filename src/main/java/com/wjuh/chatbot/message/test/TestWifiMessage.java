package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestWifiMessage extends TestMessage {
    public static final String TRANSFER_MONEY = "Сразу переведу деньги!";
    public static final String MOBILE_NET = "Переключусь на мобильный интернет и выполню перевод!";
    public static final String ANOTHER_WIFI = "Подключусь к другой открытой Wi-Fi точке и совершу перевод!";

    public static final List<String> ANSWERS = Arrays.asList(TRANSFER_MONEY, MOBILE_NET, ANOTHER_WIFI);

    public TestWifiMessage(User user, Chat chat, String[] arguments) {
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
        row.add(TRANSFER_MONEY);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(MOBILE_NET);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(ANOTHER_WIFI);
        keyboard.add(row);
        return keyboard;
    }
}
