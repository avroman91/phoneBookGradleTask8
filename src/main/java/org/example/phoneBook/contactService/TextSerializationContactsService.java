package org.example.phoneBook.contactService;

import org.example.phoneBook.utils.ListUtils;

import java.io.*;
import java.util.stream.Collectors;

public class TextSerializationContactsService implements ContactsService {

    private ContactList cache = null;

    @Override
    public ContactList getAll() {
        return load();
    }

    @Override
    public void remove(int index) {
        if (cache.size() == 0) {
            System.out.println("Phonebook is empty");
        } else if (index < 0 || index >= cache.size()) {
            System.out.println("Incorrect input");
        } else {
            cache = load();
            cache.remove(index);
            save(cache);
        }
    }

    @Override
    public void add(Contact contact) {
        cache = load();
        cache.add(contact);
        save(cache);
    }

    @Override
    public void save(ContactList contacts) {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Contacts.text"))) {
            fileWriter.write(contacts.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ContactList findByName(String name) {
        if (cache == null) cache = load();
        return ListUtils.filter(cache, contact -> contact.getName().contains(name));
    }

    @Override
    public ContactList load() {
        if(cache == null) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
                cache = new ContactList((fileReader.lines().filter(s->s.split(" ").length==4).map(s -> new Contact(s.split(" ")[1], s.split(" ")[3])).collect(Collectors.toList())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
