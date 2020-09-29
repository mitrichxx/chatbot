package com.wjuh.chatbot.message.test;

import com.wjuh.chatbot.message.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class WifiLogMessage extends Message {
    public WifiLogMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Преступники легко взламывают открытые сети Wi-Fi. Поэтому для входа в онлайн-банк лучше воспользоваться мобильным интернетом\n"
                + "Основная масса угроз информационной безопасности приходится на\nТроянские программы\nЧерви\nШпионские программы"
                        + getUser().getId() + ")")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return null;
    }
}
