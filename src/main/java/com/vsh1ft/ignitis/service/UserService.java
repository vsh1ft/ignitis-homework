package com.vsh1ft.ignitis.service;

import com.vsh1ft.ignitis.factory.IdFactory;
import com.vsh1ft.ignitis.type.Person;
import com.vsh1ft.ignitis.type.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository repository;
    private final IdFactory idFactory;

    public UserService(UserRepository repository, IdFactory idFactory) {
        this.repository = repository;
        this.idFactory = idFactory;
    }

    public void createUser(Person person) {
        person.setId(idFactory.create());

        repository.saveUser(person);
    }

    public void deleteUser(String userId) {
        repository.deleteUser(userId);
    }

    public boolean doesNameExist(String name) {
       return repository.doesNameExist(name);
    }

    public Person findUser(String userId) {
        return repository.findUser(userId);
    }

    public int getMessageCountByUserId(String userId) {
        return repository.countMessagesByUserId(userId);
    }

    public LocalDateTime findFirstMessageTimeByUserId(String userId) {
        return repository.findFirstMessageByUserId(userId);
    }

    public LocalDateTime findLastMessageTimeByUserId(String userId) {
        return repository.findLastMessageByUserId(userId);
    }

    public double findAverageMessageLength(String userId) {
        return repository.findAverageMessageLength(userId);
    }

    public String findLastMessageTextByUserId(String userId) {
        return repository.findLastMessageTextByUserId(userId);
    }
}
