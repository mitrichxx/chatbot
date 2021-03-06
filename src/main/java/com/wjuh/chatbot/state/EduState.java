package com.wjuh.chatbot.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EduState {
    Q1("1. Не сообщайте никому свои пароли, ПИН- и CVV-коды и коды из СМС. Даже сотрудникам банка",
            "Вам звонит знакомый и говорит.что готов вернуть вам долг,но для этого ему нужно знать номер вашей карты, cvv-код и код из смс. Сообщители вы ему эти данные?",
            new String[]{
                    "Да,это мой знакомый,я ему доверяю",
                    "Нет,продиктую только номер карты,этого достаточно для перевода",
                    "Повешу трубку",
            }, "Нет,продиктую только номер карты,этого достаточно для перевода",
            "Для перевода нужен только номер карты, а чаще всего достаточно номера вашего мобильного телефона. " +
                    "ПИН- и CVV-коды от банковских карт не следует сообщать никому, даже сотрудникам банка."
    ),
    Q2("2. Не переходите по подозрительным ссылкам: мошенники могут заразить ваш компьютер или телефон вирусом и украсть ваши данные",
            "Вам пришла СМС, что карта заблокирована, а разблокировать можно по ссылке из СМС. Что будете делать?",
            new String[]{
                    "Перейду по ссылке",
                    "Удалю СМС",
                    "Позвоню по номеру, с которого пришло СМС",
            }, "Удалю СМС",
            "По ссылке может быть приложение с вирусом, которое загрузится на телефон, или сайт-ловушка, на " +
                    "котором мошенники попытаются получить номера банковских карт, ПИН- и CVV-коды."
    ),
    Q3("3. Используйте только официальные приложения банка в App Store, Google Play и Microsoft Store",
            "Вам звонит подруга и просит срочно перевести ей деньги на телефон, но у вас не установлено приложение Сбербанк,сайт временно не доступен. " +
                    "Она предлагает скачать аналог приложения для пополнения счета с MnogoProgramm.com.",
            new String[]{
                    "Скачаю приложение,которое посоветовала подруга и переведу ей деньги",
                    "Поищу в интернете другие приложения.через которые можно перевести деньги",
                    "Дождусь,когда заработает сайт Сбербанка или скачаю приложение с Play Маркет",
            }, "Дождусь,когда заработает сайт Сбербанка или скачаю приложение с Play Маркет",
            "Используйте только официальные приложения банка в App Store, Google Play и Microsoft Store"),
    Q4("4. Используйте антивирусы. Приложение Сбербанк Онлайн на Android имеет бесплатный антивируc",
            "Надо ли устанавливать на смартфон Антивирус если он уже есть в приложении Сбербанк Онлайн?",
            new String[]{
                    "Нет, встроенного антивирусника будет достаточно,чтоб обезопасить работу в приложении",
                    "Да, перестраховаться всегда не помешает",
                    "Да и встроенный не нужен,поищу как его отключить",
            }, "Нет, встроенного антивирусника будет достаточно,чтоб обезопасить работу в приложении",
            "Приложение Сбербанк Онлайн на Android имеет бесплатный антивируc, который поможет сохранить конфиденциальную информацию."),
    Q5("5.Сообщите банку о смене номера мобильного: есть риск, что ваши данные попадут новому владельцу",
            "Вы сменили номер телефона, к которому привязана банковская карта. Какие ваши дальнейшие действия?",
            new String[]{
                    "Позвоню в банк и сообщу об этом",
                    "Отправлю СМС банку",
                    "Не буду ничего предпринимать",
            }, "Позвоню в банк и сообщу об этом",
            "Позвоните в банк и сообщите свой новый номер, чтобы мошенники не воспользовались вашим старым номером для перевода."),
    Q6("6. Проверяйте реквизиты переводов и платежей, которые приходят в СМС от банка",
            "Вам пришло СМС-сообщение от банка, но почему-то оно попало в отдельную переписку в телефоне. Можно ли доверять такому сообщению?",
            new String[]{
                    "Нет, это СМС от мошенников. Я его удалю.",
                    "Конечно, можно. Наверное, телефон глючит.",
            }, "Нет, это СМС от мошенников. Я его удалю.",
            "Все СМС от банка приходят в одну переписку. Например, Сбербанк присылает сообщения с номера 900 или 9000. " +
                    "Поэтому лучше удалите подозрительное сообщение и при необходимости уточните информацию в банке."),
    Q7("7. При использовании банкомата осмотрите его и убедитесь,что на нем нет дополнительных устройст,  при наборе ПИН-кода прикрывайте клавиатуру рукой, не принимайте помощь от незнакомцев.",
            "Вы пришли в отделение Сбербанка, чтоб снять в банкомате деньги, на входе в отделение  установлено устройство, которое требует ПИН-код вашей карты. Ваши действия",
            new String[]{
                    "Не буду ничего вводить, позвоню на горячую линию Сбербанка и сообщу об инциденте",
                    "Введу пароль, это же отделение Сбербанка и мне же надо снять деньги",
                    "Просто уйду",
            }, "Не буду ничего вводить, позвоню на горячую линию Сбербанка и сообщу об инциденте",
            "Если на входе в помещение с банкоматом установлено устройство, которое требует ПИН-код вашей карты, не вводите ПИН и не входите туда."),
    ;

    public static Map<Integer, EduState> states = new ConcurrentHashMap<>();

    private String theory;
    private String question;
    private String[] answers;
    private String explanation;
    private String correct;


    EduState(String theory, String question, String[] answers, String correct, String explanation) {
        this.theory = theory;
        this.question = question;
        this.answers = answers;
        this.explanation = explanation;
        this.correct = correct;
    }

    public String getTheory() {
        return theory;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getCorrect() {
        return correct;
    }
}
