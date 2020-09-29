package com.wjuh.chatbot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ProductMessage extends Message {
    public ProductMessage(User user, Chat chat, String[] arguments) {
        super(user, chat, arguments);
    }

    @Override
    public SendMessage execute() {
        return new SendMessage()
                .setChatId(getChat().getId())
                .setText("Приставка SberBox для любого телевизора с HDMI.\nСбер выпустил мультимедийную ТВ-приставку-медиаплеер SberBox " +
                        " с семейством виртуальных ассистентов Салют и голосовым управлением." +
                        " SberBox позволяет смотреть ТВ-каналы, фильмы, сериалы и видео, слушать музыку в отличном качестве," +
                        " играть в игры на большом экране, а также делегировать различные рутинные задачи виртуальному помощнику, понимающему голосовые команды.\n" +
                        "\n\nУмный экран SberPortal \nСбер представил устройство SberPortal — мультимедийный смарт-дисплей с" +
                        " премиальной акустикой, виртуальным ассистентом, сенсорным, голосовым и жестовым управлением. Устройство поступит" +
                        " в продажу в конце 2020 года. Пользователям SberPortal будут доступны фильмы, сериалы и образовательные лекции" +
                        " в онлайн-кинотеатре Okko; игры, музыкальные клипы, фильмы, сериалы, спортивные трансляции, видео в интернете и цифровые ТВ-каналы;" +
                        " музыка от партнёрского сервиса СберЗвук. \nВ ходе презентации показали, как \"первый смарт-дисплей на российском рынке\" реагирует на жесты (а не только на голосовые команды)," +
                        " а затем предлагает пользователю информацию, проанализировав содержание разговора по видеосвязи. При этом в \"Сбере\" говорят," +
                        " что данные пользователя \"хранятся надежно, как банковская тайна\"" +
                        "\n\nСберПрайм — подписка на сервисы экосистемы\nСбер анонсировал семейство подписок на сервисы экосистемы." +
                        "  Базовая подписка СберПрайм предлагает без дополнительной оплаты пользоваться рядом сервисов, а также получить специальные" +
                        "  условия и скидки при приобретении других продуктов и услуг экосистемы Сбера. В компании обещают экономию более 20 000 рублей в год." +
                        "  Стоимость СберПрайм — 199 рублей в месяц, а первые 30 дней бесплатно. До конца 2020 действуют специальные условия на годовую подписку" +
                        "  — всего 999 рублей в год. Регулярная цена годовой подписки на базовый СберПрайм начиная с 2021 года составит не более 1990 рублей в год," +
                        "  а возможно и меньше. В подписку входит скидки в онлайн-кинотеатре Оkko, аккаунт без рекламы в СберЗвуке," +
                        "  бесплатная доставка продуктов через СберМаркет, 30 Гб в облачном хранилище СберДиск, скидка 10% на 10 заказов в месяц в Delivery Club," +
                        "  скидка 10% на такси Ситимобил и др.")
                .setReplyMarkup(getUnitsKeyboard());
    }

    @Override
    public String getTag() {
        return "PRODUCTMESSAGE";
    }

    private static ReplyKeyboardMarkup getUnitsKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Да");
        keyboard.add(row);
        row = new KeyboardRow();
        row.add("Нет");
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}
