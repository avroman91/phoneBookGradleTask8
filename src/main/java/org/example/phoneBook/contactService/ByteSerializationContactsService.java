package org.example.phoneBook.contactService;


import java.io.*;
import java.util.stream.Collectors;

public class ByteSerializationContactsService extends SerializationHelperAbstractClass {

    @Override
    public void save() {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Contacts.obj"))) {
            objectOutputStream.writeObject(cache);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ContactList load() {
        if (cache == null) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
                cache = new ContactList((fileReader.lines().filter(s -> s.split(" ").length == 4).map(s -> new Contact(s.split(" ")[1], s.split(" ")[3])).collect(Collectors.toList())));
            } catch (IOException e) {
                throw new RuntimeException("There is no such file");
            }
        }
        return cache;
    }
}
