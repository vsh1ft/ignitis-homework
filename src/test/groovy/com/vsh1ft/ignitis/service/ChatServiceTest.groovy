package com.vsh1ft.ignitis.service

import com.vsh1ft.ignitis.factory.IdFactory
import com.vsh1ft.ignitis.type.Message
import com.vsh1ft.ignitis.type.Person
import com.vsh1ft.ignitis.type.repository.ChatRepository
import spock.lang.Specification

import java.time.LocalDateTime

class ChatServiceTest extends Specification {

    private ChatService service
    private ChatRepository repositoryMock;
    private IdFactory idFactoryMock;
    private TimeService timeServiceMock;


    void setup() {
        repositoryMock = Mock()
        idFactoryMock = Mock()
        timeServiceMock = Mock()
        service = new ChatService(repositoryMock, idFactoryMock, timeServiceMock)
    }

    def "should retrieve messages ordered by latest"() {
        when:
        def messages = service.getMessagesOrderedByLatest()

        then:
        1 * repositoryMock.findMessagesOrderedByLatest() >> List.of(createMessage())
        1 == messages.size()
    }

    def "should save a message"() {
        given:
        def message = createMessage()
        def currentTime = LocalDateTime.now()
        idFactoryMock.create() >> "newId"
        timeServiceMock.getCurrentTimeUTC() >> currentTime

        when:
        service.saveMessage(message)

        then:
        1 * repositoryMock.saveMessage(_) >>
                { Message actualMessage ->
                    assert "newId" == actualMessage.id
                    assert currentTime == actualMessage.timeReceived
                }
    }

    private Message createMessage() {
        return new Message("id", "msg", LocalDateTime.now(),
                new Person("s", true, false, "name"))
    }

}
