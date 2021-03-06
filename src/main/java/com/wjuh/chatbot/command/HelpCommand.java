package com.wjuh.chatbot.command;

import com.wjuh.chatbot.message.HelpMessage;
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
public class HelpCommand extends BotCommand {
    @Autowired
    private SenderService senderService;

    public HelpCommand() {
        super("help", "help");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("### Help");
        senderService.send(absSender, new HelpMessage(user, chat, arguments));
    }
}
