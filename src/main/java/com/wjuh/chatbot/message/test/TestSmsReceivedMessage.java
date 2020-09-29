package com.wjuh.chatbot.message.test;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSmsReceivedMessage extends TestMessage{
    public static final String GO_LINK = "Перейду по ссылке";
    public static final String DELETE_SMS = "Удалю СМС";
    public static final String CALL_NUMBER = "Позвоню по номеру, с которого пришло СМС";

    public static final List<String> ANSWERS = Arrays.asList(GO_LINK, DELETE_SMS, CALL_NUMBER);

    public TestSmsReceivedMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return super.execute();
    }

    @Override
    protected List<KeyboardRow> createKeyboard() {
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add(GO_LINK);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(DELETE_SMS);
        keyboard.add(row);
        row = new KeyboardRow();
        row.add(CALL_NUMBER);
        keyboard.add(row);
        return keyboard;
    }

    @Override
    public String getTag() {
        return "Для перевода нужен только номер карты, а чаще всего достаточно номера вашего мобильного телефона. ПИН- и CVV-коды от банковских карт не следует сообщать никому, даже сотрудникам банка.\n" +
        "        Для перевода нужен только номер карты, а чаще всего достаточно номера вашего мобильного телефона.\n" +
                "                ПИН- и CVV-коды от банковских карт не следует сообщать никому, даже сотрудникам банка.\n\n" +
                "Вам пришла СМС, что карта заблокирована, а разблокировать можно по ссылке из СМС. Что будете делать?";
    }
}
