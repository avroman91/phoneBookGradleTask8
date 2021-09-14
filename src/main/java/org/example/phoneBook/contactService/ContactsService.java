package org.example.phoneBook.contactService;

import java.util.List;

public interface ContactsService {


    ContactList getAll();

    void remove(int index);

    void add(Contact contact);

    void save();

    public ContactList findByName(String name);

    ContactList load();

}
