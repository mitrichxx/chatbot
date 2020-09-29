package com.wjuh.chatbot.model;

import com.wjuh.chatbot.state.BaseState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

@Getter
@Setter
@AllArgsConstructor
public class StateModel {
    private BaseState state;
    private Chat chat;
    private User user;
}
