package com.vsh1ft.ignitis.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TimeService {

    public LocalDateTime getCurrentTimeUTC() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

}
