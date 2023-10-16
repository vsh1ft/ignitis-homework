package com.vsh1ft.ignitis.factory;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IdFactory {

    public String create() {
        return UUID.randomUUID().toString();
    }

}
