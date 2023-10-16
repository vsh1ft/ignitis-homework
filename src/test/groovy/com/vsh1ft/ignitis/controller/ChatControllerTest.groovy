package com.vsh1ft.ignitis.controller

import com.vsh1ft.ignitis.service.ChatService
import com.vsh1ft.ignitis.type.Message
import com.vsh1ft.ignitis.type.Person
import spock.lang.Specification

import java.time.LocalDateTime

class ChatControllerTest extends Specification {

    private ChatController controller
    private ChatService serviceMock

    void setup() {
        serviceMock = Mock()
        controller = new ChatController(serviceMock)
    }

    def "should save a message"() {
        given:
        def message = createMessage()

        when:
        controller.saveMessage(message)

        then:
        1 * serviceMock.saveMessage(message)
    }

    def "should retrieve all messages"() {
        when:
        def messages = controller.getMessages()

        then:
        1 * serviceMock.getMessagesOrderedByLatest() >> List.of(createMessage())
        1 == messages.size()
    }

    private Message createMessage() {
        return new Message("id", "msg", LocalDateTime.now(),
                new Person("s", true, false, "name"))
    }

}
