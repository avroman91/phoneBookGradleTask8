package org.example.phoneBook.contactService;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + phone;
    }
}
