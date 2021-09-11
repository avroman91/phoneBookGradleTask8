package org.example.phoneBook.contactService;


import org.example.phoneBook.utils.ListUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InMemoryContactsService implements ContactsService {


    private ContactList contactList = new ContactList();


    @Override
    public ContactList getAll() {
        return contactList;
    }

    @Override
    public void remove(int index) {

        if (contactList.size() == 0) {
            System.out.println("Phonebook is empty");
        } else if (index < 0 || index >= contactList.size()) {
            System.out.println("Incorrect input");
        } else {
            contactList.remove(index);
        }
    }

    @Override
    public void add(Contact contact) {
        contactList.add(contact);
    }

    @Override
    public void saveBytesToFile() {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Contacts.obj")
        )) {
            for (int i = 0; i < contactList.size(); i++) {
                objectOutputStream.writeObject(contactList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToCSV() {

    }


    public ContactList findByName(String name) {
        return ListUtils.filter(contactList, contact -> contact.getName().contains(name));
    }

}
