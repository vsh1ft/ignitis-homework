package com.vsh1ft.ignitis.exception.handler

import org.springframework.http.HttpStatus
import spock.lang.Specification

class RestExceptionHandlerTest extends Specification {

    def "should convert UserExistsException to ResponseEntity"() {
        given:
        def expectedErrorMessage = "ERROR_MESSAGE"

        when:
        def responseEntity = new RestExceptionHandler().handleUserAlreadyExistsException(new RuntimeException(expectedErrorMessage))

        then:
        expectedErrorMessage == responseEntity.body.message()
        HttpStatus.CONFLICT == responseEntity.statusCode
    }

}
