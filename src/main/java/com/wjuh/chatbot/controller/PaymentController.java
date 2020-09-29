package com.wjuh.chatbot.controller;

import com.wjuh.chatbot.VjuhBot;
import com.wjuh.chatbot.message.FailFiledMessage;
import com.wjuh.chatbot.message.FailMessage;
import com.wjuh.chatbot.model.Loser;
import com.wjuh.chatbot.model.StateModel;
import com.wjuh.chatbot.service.SenderService;
import com.wjuh.chatbot.state.BaseState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private SenderService senderService;
    @Autowired
    private VjuhBot vjuhBot;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/fail")
    public void postFail(@RequestBody Loser loser) {
        log.info("Loser: " + loser.toSting());

        StateModel state = VjuhBot.USER_MAP.get(loser.getUserId());
        if (state == null) {
            log.info("State not found");
            return;
        }

        if (Boolean.TRUE.equals(loser.getIsFiled())) {
            log.info("Send message");
            senderService.send(vjuhBot, new FailFiledMessage(state.getUser(), state.getChat(), null));
            VjuhBot.USER_MAP.remove(loser.getUserId());
        } else {
            sendMessageTimer(loser.getUserId());
        }
    }

    private void sendMessageTimer(Integer userId) {
        TimerTask task = new TimerTask() {
            public void run() {
                StateModel state = VjuhBot.USER_MAP.get(userId);
                if (state == null) {
                    log.info("State not found");
                    return;
                }

                if (!BaseState.FRAUD.equals(state.getState())) {
                    log.info("State not fraud");
                    return;
                }

                log.info("Send message");
                senderService.send(vjuhBot, new FailMessage(state.getUser(), state.getChat(), null));
                VjuhBot.USER_MAP.remove(userId);
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 90000L;
        timer.schedule(task, delay);
    }
}
