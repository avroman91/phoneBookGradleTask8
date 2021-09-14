package org.example.phoneBook.contactService;

import org.example.phoneBook.utils.ListUtils;

import java.io.*;
import java.util.stream.Collectors;

public class TextSerializationContactsService extends SerializationHelperAbstractClass {

    private File file = new File("Contacts.text");

    @Override
    public void save() {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Contacts.text"))) {
            fileWriter.write(cache.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
