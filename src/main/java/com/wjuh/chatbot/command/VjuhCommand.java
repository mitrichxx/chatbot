package com.wjuh.chatbot.command;

import com.wjuh.chatbot.VjuhBot;
import com.wjuh.chatbot.message.VjuhMessage;
import com.wjuh.chatbot.model.StateModel;
import com.wjuh.chatbot.service.SenderService;
import com.wjuh.chatbot.state.BaseState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Component
public class VjuhCommand extends BotCommand {
    @Autowired
    private SenderService senderService;

    public VjuhCommand() {
        super("vjuh", "Petukh");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("### Vjuh");
        VjuhBot.USER_MAP.compute(user.getId(), (k, v) -> new StateModel(BaseState.TEST, chat, user));
        senderService.send(absSender, new VjuhMessage(user, chat, arguments));
    }
}