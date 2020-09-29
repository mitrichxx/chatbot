package com.wjuh.chatbot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loser {
    private String userId;
    private boolean isFiled;

    public String toSting() {
        return "User " + userId;
    }
}
