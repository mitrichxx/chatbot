package com.wjuh.chatbot.message;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

@Slf4j
public abstract class Message {
    private final User user;
    private final Chat chat;
    private final String[] arguments;

    public Message(User user, Chat chat, String[] arguments) {
        this.user = user;
        this.chat = chat;
        this.arguments = arguments;

        String userName = chat.getUserName();
        if (userName == null || userName.isEmpty()) {
            userName = user.getFirstName() + " " + user.getLastName();
        }
        log.info("### Username: " + userName);
        log.info("### Chat: " + chat.getTitle());
    }

    public abstract SendMessage execute();

    public abstract String getTag();

    public User getUser() {
        return user;
    }

    public Chat getChat() {
        return chat;
    }

    public String[] getArguments() {
        return arguments;
    }
}
