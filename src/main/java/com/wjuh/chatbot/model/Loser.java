package com.wjuh.chatbot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loser {
    private Integer userId;
    private Boolean isFiled;

    public String toSting() {
        return "User=" + userId + ", isFiled=" + isFiled;
    }
}
