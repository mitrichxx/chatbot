package com.wjuh.chatbot.message.edu;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class EduQuestion extends Message {
    private final String question;
    private final String[] answers;

    public EduQuestion(User user, Chat chat, String[] arguments, String question, String[] answers) {
        super(user, chat, arguments);
        this.question = question;
        this.answers = answers;
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText(question)
                .setReplyMarkup(getUnitsKeyboard(answers));
    }

    @Override
    public String getTag() {
        return "PRODUCTMESSAGE";
    }

    private static ReplyKeyboardMarkup getUnitsKeyboard( String[] answers) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        for (String answer : answers) {
            KeyboardRow row = new KeyboardRow();
            row.add(answer);
            keyboard.add(row);
        }
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
