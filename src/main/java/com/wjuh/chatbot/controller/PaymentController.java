package com.wjuh.chatbot.controller;

import com.wjuh.chatbot.model.Loser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/fail")
    public void postFail(@RequestBody Loser loser) {
        log.info("Loser: " + loser);
    }
}
