package com.wjuh.chatbot.controller;

import com.wjuh.chatbot.VjuhBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, Object> hello(@RequestParam(value = "name", defaultValue = "Boxfuse") String name) {
        Map<String, Object> result = new HashMap<>();
        result.put("greeting", "Hello " + name + "!");
        log.info(name + "\n");
        return result;
    }

    @RequestMapping(value = "/get_bot_name", method = RequestMethod.GET)
    public Map<String, Object> getBotName() {
        Map<String, Object> result = new HashMap<>();
        result.put("botUserName: ", new VjuhBot().getBotUsername());
        return result;
    }
}
