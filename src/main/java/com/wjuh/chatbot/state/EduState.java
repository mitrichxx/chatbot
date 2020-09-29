package com.wjuh.chatbot.state;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EduState {
    START,
    Q1,
    Q2,
    Q3,
    Q4,
    Q5,
    Q6,
    Q7;

    public static Map<Integer, EduState> states = new ConcurrentHashMap<>();

}
