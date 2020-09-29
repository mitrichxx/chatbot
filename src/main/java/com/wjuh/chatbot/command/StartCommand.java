package com.wjuh.chatbot.command;

import com.wjuh.chatbot.VjuhBot;
import com.wjuh.chatbot.message.StartMessage;
import com.wjuh.chatbot.message.WelcomeMessage;
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
public class StartCommand extends BotCommand {
    private static final String LOGTAG = "STARTCOMMAND";

    @Autowired
    private SenderService senderService;

    public StartCommand() {
        super("start", "Say start to this bot");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("### Start");
        VjuhBot.USER_MAP.compute(user.getId(), (k, v) -> BaseState.FRAUD);
        senderService.send(absSender, new StartMessage(user, chat, arguments));
        senderService.send(absSender, new WelcomeMessage(user, chat, arguments));
    }
}
