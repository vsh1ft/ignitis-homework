package com.vsh1ft.ignitis.factory


import spock.lang.Specification

class IdFactoryTest extends Specification {

    def "Creates id"() {
        when:
        def id = new IdFactory().create()

        then:
        id != null
        !id.isEmpty()
    }

}
