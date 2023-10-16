package com.vsh1ft.ignitis.type;


import java.time.LocalDateTime;

public class Message {

    private String id;
    private String content;
    private LocalDateTime timeReceived;
    private Person person;

    public Message(String id, String content, LocalDateTime timeReceived, Person person) {
        this.id = id;
        this.content = content;
        this.timeReceived = timeReceived;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(LocalDateTime timeReceived) {
        this.timeReceived = timeReceived;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
