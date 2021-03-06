package com.wjuh.chatbot.command;

import com.wjuh.chatbot.VjuhBot;
import com.wjuh.chatbot.message.edu.EduQuestion;
import com.wjuh.chatbot.message.edu.EduTheory;
import com.wjuh.chatbot.message.edu.EduWelcomeMessage;
import com.wjuh.chatbot.model.StateModel;
import com.wjuh.chatbot.service.SenderService;
import com.wjuh.chatbot.state.BaseState;
import com.wjuh.chatbot.state.EduState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Component
public class EduCommand extends BotCommand {
    @Autowired
    private SenderService senderService;

    public EduCommand() {
        super("edu", "Education");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("### Education");
        VjuhBot.USER_MAP.compute(user.getId(), (k, v) -> new StateModel(BaseState.EDUCATION, chat, user));
        final EduState initState = EduState.states.compute(user.getId(), (k, v) -> EduState.Q1);
        senderService.send(absSender, new EduWelcomeMessage(user, chat, arguments));
        senderService.send(absSender, new EduTheory(user, chat, null,
                initState.getTheory()));
        senderService.send(absSender, new EduQuestion(user, chat, null,
                initState.getQuestion(), initState.getAnswers()));

    }
}
