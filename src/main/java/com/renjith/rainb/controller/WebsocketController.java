package com.renjith.rainb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.renjith.rainb.dto.MessageDto;

@Controller
public class WebsocketController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	// @Autowired
	// public TradeServiceImpl(SimpMessagingTemplate messagingTemplate) {
	// this.messagingTemplate = messagingTemplate;
	// }

	@MessageMapping("/chat")
	public void send(MessageDto message) throws Exception {
		messagingTemplate.convertAndSendToUser(message.getTo(), "/topic/chat", message.getText());
		messagingTemplate.convertAndSendToUser(message.getFrom(), "/topic/chat", message.getText());
		// return "received message from " + message.getFrom() + " to " +
		// message.getTo();
	}

}
