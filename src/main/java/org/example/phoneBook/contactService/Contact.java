package org.example.phoneBook.contactService;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Contact implements Serializable {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + phone;
    }
}
