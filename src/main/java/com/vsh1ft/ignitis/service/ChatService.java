package com.vsh1ft.ignitis.service;

import com.vsh1ft.ignitis.factory.IdFactory;
import com.vsh1ft.ignitis.type.Message;
import com.vsh1ft.ignitis.type.repository.ChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ChatService {

    private final ChatRepository repository;
    private final IdFactory idFactory;
    private final TimeService timeService;

    public ChatService(ChatRepository repository, IdFactory idFactory, TimeService timeService) {
        this.repository = repository;
        this.idFactory = idFactory;
        this.timeService = timeService;
    }

    public Collection<Message> getMessagesOrderedByLatest() {
        return repository.findMessagesOrderedByLatest();
    }

    public void saveMessage(Message message) {
        message.setId(idFactory.create());
        message.setTimeReceived(timeService.getCurrentTimeUTC());

        repository.saveMessage(message);
    }


}
