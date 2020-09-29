package com.wjuh.chatbot.service;

import com.wjuh.chatbot.message.Message;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Service
public interface SenderService {
    void send(AbsSender absSender, Message message);
}
