package com.vsh1ft.ignitis.controller

import com.vsh1ft.ignitis.exception.UserExistsException
import com.vsh1ft.ignitis.service.UserService
import com.vsh1ft.ignitis.type.Person
import spock.lang.Specification

import java.time.LocalDateTime

class UserControllerTest extends Specification {

    private UserController controller
    private UserService serviceMock

    void setup() {
        serviceMock = Mock()
        controller = new UserController(serviceMock)
    }

    def "should create a unique user"() {
        given:
        def user = createUser()
        serviceMock.doesNameExist(user.name) >> false

        when:
        controller.createUser(user)

        then:
        1 * serviceMock.createUser(user)
    }

    def "should not create user if it already exists"() {
        given:
        def user = createUser()
        serviceMock.doesNameExist(user.name) >> true

        when:
        controller.createUser(user)

        then:
        0 * serviceMock.createUser(user)
        thrown UserExistsException
    }

    def "should retrieve user info"() {
        given:
        def user = createUser()
        serviceMock.doesNameExist(user.name) >> true

        when:
        def actualUser = controller.getUser(user.id)

        then:
        user == actualUser
        1 * serviceMock.findUser(user.id) >> user
    }

    def "should retrieve user message count"() {
        given:
        def userId = "userId"

        when:
        def actualCount = controller.getUserMessageCount(userId)

        then:
        1 == actualCount
        1 * serviceMock.getMessageCountByUserId(userId) >> 1
    }

    def "should retrieve earliest user message timestamp"() {
        given:
        def userId = "userId"
        def expectedTime = LocalDateTime.now()

        when:
        def actualTime = controller.findEarliestMessage(userId)

        then:
        expectedTime == actualTime
        1 * serviceMock.findFirstMessageTimeByUserId(userId) >> expectedTime
    }

    def "should retrieve latest user message timestamp"() {
        given:
        def userId = "userId"
        def expectedTime = LocalDateTime.now()

        when:
        def actualTime = controller.findLatest(userId)

        then:
        expectedTime == actualTime
        1 * serviceMock.findLastMessageTimeByUserId(userId) >> expectedTime
    }

    def "should retrieve average user message length"() {
        given:
        def userId = "userId"
        double expectedLength = 1.0

        when:
        def actualLength = controller.findAverageMessageLength(userId)

        then:
        expectedLength == actualLength
        1 * serviceMock.findAverageMessageLength(userId) >> expectedLength
    }

    def "should retrieve latest message content"() {
        given:
        def userId = "userId"
        def expectedMessage = "message"

        when:
        def actualMessage = controller.findLastMessageText(userId)

        then:
        expectedMessage == actualMessage
        1 * serviceMock.findLastMessageTextByUserId(userId) >> expectedMessage
    }

    private Person createUser() {
        return new Person("id", false, false, "name")
    }

}
