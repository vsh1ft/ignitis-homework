package com.vsh1ft.ignitis.controller;


import com.vsh1ft.ignitis.service.ChatService;
import com.vsh1ft.ignitis.type.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ChatController {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @PostMapping("/message")
    public void saveMessage(@RequestBody Message message) {
        service.saveMessage(message);
    }

    @GetMapping("/messages")
    public Collection<Message> getMessages() {
        return service.getMessagesOrderedByLatest();
    }

}
