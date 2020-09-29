package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

public class ProductMessage extends Message {
    public ProductMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("*На этой конференции среди прочих были представлены продукты:*\n" +
                        "\n" +
                        "*Приставка SberBox для любого телевизора с HDMI*\n" +
                        "SberBox позволяет смотреть ТВ-каналы, фильмы, сериалы и видео, слушать музыку в отличном качестве, играть в игры на большом экране, а также делегировать различные рутинные задачи виртуальному помощнику, понимающему голосовые команды.\n" +
                        "\n" +
                        "*Умный экран SberPortal*\n" +
                        "Сбер представил устройство SberPortal — мультимедийный смарт-дисплей с премиальной акустикой, виртуальным ассистентом, сенсорным, голосовым и жестовым управлением.\n" +
                        "\n" +
                        "*СберПрайм — подписка на сервисы экосистемы*\n" +
                        "Сбер анонсировал семейство подписок на сервисы экосистемы. В подписку входит скидки в онлайн-кинотеатре Оkko, аккаунт без рекламы в СберЗвуке, бесплатная доставка продуктов через СберМаркет, 30 Гб в облачном хранилище СберДиск, скидка 10% на 10 заказов в месяц в Delivery Club, скидка 10% на такси Ситимобил и др.")
                .enableMarkdown(true);
    }

    @Override
    public String getTag() {
        return "PRODUCTMESSAGE";
    }
}
