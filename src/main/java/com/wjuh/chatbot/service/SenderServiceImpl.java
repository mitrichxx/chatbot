package com.wjuh.chatbot.service;

import com.wjuh.chatbot.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Service
public class SenderServiceImpl implements SenderService {
    @Override
    public void send(AbsSender absSender, Message message) {
        try {
            absSender.execute(message.execute());
        } catch (Exception e) {
            log.error(message.getTag(), e);
        }
    }
}
