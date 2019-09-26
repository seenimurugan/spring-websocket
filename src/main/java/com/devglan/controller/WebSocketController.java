package com.devglan.controller;

import com.devglan.domain.Event;
import com.devglan.domain.MessageWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	@Autowired
    private ObjectMapper objectMapper;

	@MessageMapping("/message")
	public void processMessageFromClient(@Payload String message, Principal principal) throws Exception {
		Event event = new Event("test", "service", "class", true);
		MessageWrapper holder = new MessageWrapper("test", event);
		IntStream.range(1, 20).forEach(value -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                messagingTemplate.convertAndSend("/topic/replytopic", objectMapper.writeValueAsBytes(holder));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}
	
	@MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }


}
