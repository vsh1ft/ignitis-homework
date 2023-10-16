package com.vsh1ft.ignitis.type.repository;

import com.vsh1ft.ignitis.type.Message;

import java.util.List;

public interface ChatRepository {

    void saveMessage(Message message);
    List<Message> findMessagesOrderedByLatest();
     
}
