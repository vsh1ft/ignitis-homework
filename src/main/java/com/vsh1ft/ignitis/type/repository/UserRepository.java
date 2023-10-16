package com.vsh1ft.ignitis.type.repository;

import com.vsh1ft.ignitis.type.Person;

import java.time.LocalDateTime;

public interface UserRepository {

    void saveUser(Person person);

    Person findUser(String userId);

    boolean doesNameExist(String name);

    void deleteUser(String userId);

    int countMessagesByUserId(String userId);

    LocalDateTime findFirstMessageByUserId(String userId);

    LocalDateTime findLastMessageByUserId(String userId);

    Double findAverageMessageLength(String userId);

    String findLastMessageTextByUserId(String userId);
}
