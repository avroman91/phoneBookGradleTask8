package org.example.phoneBook.contactService;

import java.io.*;
import java.util.stream.Collectors;

public class TextSerializationContactsService extends SerializationHelperAbstractClass {

    private ContactList cache = null;

    private File file;

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
    public ContactList load() {
        if(cache == null) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
                cache.setContacts(fileReader.lines().map(s->new Contact( s.split(" ")[2],s.split(" ")[4])).collect(Collectors.toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
