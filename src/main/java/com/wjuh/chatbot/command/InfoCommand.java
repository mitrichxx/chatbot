package com.wjuh.chatbot.command;

import com.wjuh.chatbot.message.InfoMessage;
import com.wjuh.chatbot.service.SenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
@Component
public class InfoCommand extends BotCommand {
    @Autowired
    private SenderService senderService;

    public InfoCommand() {
        super("info", "info");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("### Info");
        senderService.send(absSender, new InfoMessage(user, chat, arguments));
    }
}
