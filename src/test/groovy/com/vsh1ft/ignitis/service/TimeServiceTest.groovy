package com.vsh1ft.ignitis.service

import spock.lang.Specification

import java.time.LocalDateTime

class TimeServiceTest extends Specification {

    def "Provides time"() {
        when:
        def time = new TimeService().getCurrentTimeUTC()

        then:
        time.isBefore(LocalDateTime.now())
    }
}