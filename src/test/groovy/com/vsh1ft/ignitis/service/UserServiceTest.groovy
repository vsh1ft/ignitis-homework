package com.vsh1ft.ignitis.service

import com.vsh1ft.ignitis.factory.IdFactory
import com.vsh1ft.ignitis.type.Person
import com.vsh1ft.ignitis.type.repository.UserRepository
import spock.lang.Specification

import java.time.LocalDateTime

class UserServiceTest extends Specification {

    private UserService service
    private UserRepository repositoryMock;
    private IdFactory idFactoryMock;


    void setup() {
        repositoryMock = Mock()
        idFactoryMock = Mock()
        service = new UserService(repositoryMock, idFactoryMock)
    }

    def "should create a user"() {
        given:
        idFactoryMock.create() >> "newId"

        when:
        service.createUser(createPerson())

        then:
        1 * repositoryMock.saveUser(_) >>
                { Person actualPerson ->
                    assert "newId" == actualPerson.id
                }
    }

    def "should delete a user"() {
        given:
        def userId = "userId"

        when:
        service.deleteUser(userId)

        then:
        1 * repositoryMock.deleteUser(userId)
    }

    def "checks if user exists"() {
        given:
        def userId = "userId"

        when:
        def doesExist = service.doesNameExist(userId)

        then:
        doesExist
        1 * repositoryMock.doesNameExist(userId) >> true
    }

    def "should retrieve a user by id"() {
        given:
        def expectedUser = createPerson()

        when:
        def actualPerson = service.findUser(expectedUser.id)

        then:
        expectedUser == actualPerson
        1 * repositoryMock.findUser(expectedUser.id) >> expectedUser
    }

    def "should retrieve message count for a user"() {
        given:
        def userId = "userId"

        when:
        def actualCount = service.getMessageCountByUserId(userId)

        then:
        5 == actualCount
        1 * repositoryMock.countMessagesByUserId(userId) >> 5
    }

    def "should retrieve when user wrote the first message"() {
        given:
        def expectedTime = LocalDateTime.now()

        when:
        def actualTime = service.findFirstMessageTimeByUserId("userId")

        then:
        expectedTime == actualTime
        1 * repositoryMock.findFirstMessageByUserId("userId") >> expectedTime
    }

    def "should retrieve when user wrote the latest message"() {
        given:
        def expectedTime = LocalDateTime.now()

        when:
        def actualTime = service.findLastMessageTimeByUserId("userId")

        then:
        expectedTime == actualTime
        1 * repositoryMock.findLastMessageByUserId("userId") >> expectedTime
    }

    def "should retrieve average message length for a user"() {
        given:
        double expectedLength = 2.5

        when:
        def actualLength = service.findAverageMessageLength("userId")

        then:
        expectedLength == actualLength
        1 * repositoryMock.findAverageMessageLength("userId") >> expectedLength
    }

    def "should retrieve last message content"() {
        given:
        def expectedContent = "message"

        when:
        def actualContent = service.findLastMessageTextByUserId("userId")

        then:
        expectedContent == actualContent
        1 * repositoryMock.findLastMessageTextByUserId("userId") >> expectedContent
    }

    private Person createPerson() {
        return new Person("s", true, false, "name")
    }
}
