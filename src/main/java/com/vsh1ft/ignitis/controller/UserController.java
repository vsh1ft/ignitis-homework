package com.vsh1ft.ignitis.controller;


import com.vsh1ft.ignitis.exception.UserExistsException;
import com.vsh1ft.ignitis.type.Person;
import com.vsh1ft.ignitis.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void createUser(@RequestBody Person user) {
        if (service.doesNameExist(user.getName()))
            throw new UserExistsException();

        service.createUser(user);
    }

    @GetMapping("/{userId}")
    public Person getUser(@PathVariable String userId) {
        return service.findUser(userId);
    }

    @GetMapping("/{userId}/message/count")
    public int getUserMessageCount(@PathVariable String userId) {
        return service.getMessageCountByUserId(userId);
    }

    @GetMapping("/{userId}/message/received/earliest")
    public LocalDateTime findEarliestMessage(@PathVariable String userId) {
        return service.findFirstMessageTimeByUserId(userId);
    }

    @GetMapping("/{userId}/message/received/latest")
    public LocalDateTime findLatest(@PathVariable String userId) {
        return service.findLastMessageTimeByUserId(userId);
    }

    @GetMapping("/{userId}/message/average-length")
    public double findAverageMessageLength(@PathVariable String userId) {
        return service.findAverageMessageLength(userId);
    }

    @GetMapping("/{userId}/message/last-text")
    public String findLastMessageText(@PathVariable String userId) {
        return service.findLastMessageTextByUserId(userId);
    }

}
