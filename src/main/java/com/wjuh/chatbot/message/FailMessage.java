package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class FailMessage extends Message {
    public FailMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("*Это была проверка кибербезопастности, которую вы не прошли.*\n" +
                        "В реальной жизни злоомушленники могли бы получить" +
                        "  информацию о ваших персональный данных и ваших счетах. Чтоб не попасться в будущем рекомендуем пройти обучения по киберграммотности :\n" +
                        "Не сообщайте никому свои пароли, ПИН- и CVV-коды и коды из СМС. Даже сотрудникам банка." +
                        "\nНе переходите по подозрительным ссылкам: мошенники могут заразить ваш компьютер или телефон вирусом и украсть ваши данные" +
                        "\nИспользуйте только официальные приложения банка в App Store, Google Play и Microsoft Store." +
                        "\nИспользуйте антивирусы. Приложение Сбербанк Онлайн на Android имеет бесплатный антивируc" +
                        "\nСообщите банку о смене номера мобильного: есть риск, что ваши данные попадут новому владельцу" +
                        "\nПроверяйте реквизиты переводов и платежей, которые приходят в СМС от банка" +
                        "\nЧтобы узнать больше о возможных атаках злоумышленников введите команду `/education`")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "FailFiledMessage";
    }
}
