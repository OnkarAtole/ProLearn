package com.onkar.ProLearn.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SignalServer {

    @MessageMapping("/offer")
    @SendTo("/topic/offer")
    public String handleOffer(String message) {
        return message;
    }

    @MessageMapping("/answer")
    @SendTo("/topic/answer")
    public String handleAnswer(String message) {
        return message;
    }

    @MessageMapping("/candidate")
    @SendTo("/topic/candidate")
    public String handleCandidate(String message) {
        return message;
    }
}
