package com.wjuh.chatbot.message.test;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class ResultTestMessage extends Message {
    public ResultTestMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Спасибо что прошли тест!\n Для принятия решения по оценке \"5+\" Ваши результаты отправлены в службу безопасности банка.")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return null;
    }
}
