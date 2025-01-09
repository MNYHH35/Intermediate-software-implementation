package com.example.movieplanet.controller;

import com.example.movieplanet.entity.Message;
import com.example.movieplanet.service.MessagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @PostMapping("/add/message")
    public void postMessage(@RequestParam String userEmail,
                            @RequestBody Message messageRequest) {
        messagesService.postMessage(messageRequest, userEmail);
    }

    @GetMapping("/all")
    public Page<Message> getAllMessages(Pageable pageable) {
        return messagesService.findAllMessages(pageable);
    }
}
