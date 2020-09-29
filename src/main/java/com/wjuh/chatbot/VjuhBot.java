package com.wjuh.chatbot;

import com.wjuh.chatbot.command.*;
import com.wjuh.chatbot.message.*;
import com.wjuh.chatbot.message.edu.*;
import com.wjuh.chatbot.model.StateModel;
import com.wjuh.chatbot.message.test.*;
import com.wjuh.chatbot.service.SenderService;
import com.wjuh.chatbot.state.BaseState;
import com.wjuh.chatbot.state.EduState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class VjuhBot extends TelegramLongPollingBot {
    public static ConcurrentHashMap<Integer, StateModel> USER_MAP = new ConcurrentHashMap<>();
    private static final Map<String, BotCommand> COMMAND_MAP = new HashMap<>();
    private static final List<String> RED_WORDS = Arrays.asList("мошен", "фишинг", "нельз", "безопасн", "карт");

    @Autowired
    private StartCommand startCommand;
    @Autowired
    private InfoCommand infoCommand;
    @Autowired
    private SenderService senderService;
    @Autowired
    private TestCommand testCommand;
    @Autowired
    private HelpCommand helpCommand;
    @Autowired
    private HelloCommand helloCommand;
    @Autowired
    private VjuhCommand vjuhCommand;
    @Autowired
    private EduCommand eduCommand;

    @PostConstruct
    public void init() {
        COMMAND_MAP.put("/start", startCommand);
        COMMAND_MAP.put("/info", infoCommand);
        COMMAND_MAP.put("/test", testCommand);
        COMMAND_MAP.put("/help", helpCommand);
        COMMAND_MAP.put("/hello", helloCommand);
        COMMAND_MAP.put("/vjuh", vjuhCommand);
        COMMAND_MAP.put("/education", eduCommand);
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("onUpdateReceived");
        // We check if the update has a message and the message has text

        try {
            if (update.hasMessage()) {
                if (update.getMessage().isCommand()) {
                    String[] strings = update.getMessage().getText().split(" ");
                    String[] args = Arrays.stream(strings).skip(1).toArray(String[]::new);
                    BotCommand botCommand = COMMAND_MAP.get(strings[0]);
                    if (botCommand == null) {
                        SendMessage message = new SendMessage()
                                .setChatId(update.getMessage().getChatId())
                                .setText("Unknown command");
                        execute(message);
                    } else {
                        log.info("Try to execute command: " + " " + this.getBaseUrl() + " " + update.getMessage().getChat().getDescription());
                        botCommand.execute(this, update.getMessage().getFrom(), update.getMessage().getChat(), args);
                    }
                } else if (update.getMessage().hasText()) {
                    String text = update.getMessage().getText();
                    log.info("###" + text);

                    StateModel state = VjuhBot.USER_MAP.get(update.getMessage().getFrom().getId());
                    if (state == null) {
                        return;
                    }
                    switch (state.getState()) {
                        case FRAUD:
                            log.info("### fraud state, userId=" + update.getMessage().getFrom().getId());
                            if (ConfMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new ProductMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                senderService.send(this, new ProductQuestionMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if (ProductQuestionMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new ProductAnswerMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                if (state.getHurryUp() == null) {
                                    state.setHurryUp(new TimerTask() {
                                        @Override
                                        public void run() {
                                            if (BaseState.FRAUD.equals(state.getState())) {
                                                senderService.send(VjuhBot.this, new HurryUpMessage(state.getUser(), state.getChat(), null));
                                            }
                                        }
                                    });
                                    Timer timer = new Timer("Timer");

                                    long delay = 30000L;
                                    timer.schedule(state.getHurryUp(), delay);
                                }
                            } else if (RED_WORDS.stream().anyMatch(text::contains)) {
                                senderService.send(this, new ItsOkToShareYourDataMessage(state.getUser(), state.getChat(), null));
                            }
                            break;
                        case TEST:
                            log.info("### Test state, userId=" + update.getMessage().getFrom().getId());
                            if(TestSmsReceivedMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestPhoneNumberChangedMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if (TestPhoneNumberChangedMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new CallLogMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                senderService.send(this, new TestWifiMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if (TestWifiMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new WifiLogMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                senderService.send(this, new TestAuthentificationMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if (TestAuthentificationMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestOsMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestOsMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestLastProtectionMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestLastProtectionMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestSecurityFraudMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestSecurityFraudMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestSecurityWayMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestSecurityWayMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestCryptoSystemMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestCryptoSystemMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new TestBootVirusMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestBootVirusMessage.ANSWERS.contains(text)){
                                senderService.send(this, new TestStuxnetMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestStuxnetMessage.ANSWERS.contains(text)){
                                senderService.send(this, new TestTargetMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            } else if(TestTargetMessage.ANSWERS.contains(text)) {
                                senderService.send(this, new ResultTestMessage(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                            }
                            break;
                        case EDUCATION:
                            EduState eduState = EduState.states.get(update.getMessage().getFrom().getId());

                            if (Arrays.stream(eduState.getAnswers()).noneMatch(s -> s.equals(text))) {
                                senderService.send(this, new EduQuestion(update.getMessage().getFrom(), update.getMessage().getChat(), null,
                                        eduState.getQuestion(), eduState.getAnswers()));
                                return;
                            } else {
                                if (text.equals(eduState.getCorrect())) {
                                    senderService.send(this, new EduCorrect(update.getMessage().getFrom(), update.getMessage().getChat(), null ));
                                } else {
                                    senderService.send(this, new EduIncorrect(update.getMessage().getFrom(), update.getMessage().getChat(), null ));
                                }
                                senderService.send(this, new EduExplanation(update.getMessage().getFrom(), update.getMessage().getChat(), null, eduState.getExplanation() ));

                                EduState next = null;
                                switch (eduState) {

                                    case Q1:
                                        next = EduState.Q2;
                                        break;
                                    case Q2:
                                        next = EduState.Q3;
                                        break;
                                    case Q3:
                                        next = EduState.Q4;
                                        break;
                                    case Q4:
                                        next = EduState.Q5;
                                        break;
                                    case Q5:
                                        next = EduState.Q6;
                                        break;
                                    case Q6:
                                        next = EduState.Q7;
                                        break;
                                    case Q7:
                                        senderService.send(this, new EduFinal(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                        EduState.states.remove(update.getMessage().getFrom().getId());
                                        VjuhBot.USER_MAP.remove(update.getMessage().getFrom().getId());
                                        return;
                                }
                                EduState.states.put(update.getMessage().getFrom().getId(), next);
                                senderService.send(this, new EduNext(update.getMessage().getFrom(), update.getMessage().getChat(), null));
                                senderService.send(this, new EduTheory(update.getMessage().getFrom(), update.getMessage().getChat(), null,
                                        next.getTheory()));
                                senderService.send(this, new EduQuestion(update.getMessage().getFrom(), update.getMessage().getChat(), null,
                                        next.getQuestion(), next.getAnswers()));
                            }
                            break;
                        default:
                            log.info("### state not found, userId=" + update.getMessage().getFrom().getId());
                            SendMessage message = new SendMessage()
                                    .setChatId(update.getMessage().getChatId())
                                    .setText(text);
                            execute(message);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            log.info("Failed process message", e);
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        log.info("onUpdateReceivedList");
        for (Update update : updates) {
            onUpdateReceived(update);
        }
    }

    @Override
    public String getBotUsername() {
        return "vjuh_bot";
    }

    @Override
    public String getBotToken() {
        return "1316571024:AAF9M6Qz0rOl2mRkN-f8kp6_MfPBlkC1-5M";
    }
}
