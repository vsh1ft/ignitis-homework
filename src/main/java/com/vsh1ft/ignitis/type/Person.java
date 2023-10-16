package com.vsh1ft.ignitis.type;

public class Person {

    private String id;
    private boolean isAdmin;
    private boolean isActive;
    private String name;

    public Person(String id, boolean isAdmin, boolean isActive, String name) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
