package com.wjuh.chatbot.model;

import com.wjuh.chatbot.state.BaseState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.TimerTask;

@Getter
@Setter
@RequiredArgsConstructor
public class StateModel {
    final private BaseState state;
    final private Chat chat;
    final private User user;
    private TimerTask hurryUp;
}
