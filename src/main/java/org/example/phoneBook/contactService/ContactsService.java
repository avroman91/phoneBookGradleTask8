package org.example.phoneBook.contactService;

public interface ContactsService {


    ContactList getAll();

    void remove(int index);

    void add(Contact contact);


}
