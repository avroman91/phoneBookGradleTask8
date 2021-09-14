package org.example.phoneBook.contactService;


import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ByteSerializationContactsService extends SerializationHelperAbstractClass {

    @Override
    public void save() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Contacts.obj"))) {
            objectOutputStream.writeObject(cache);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ContactList load() {
        if (cache == null){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Contacts.obj"))) {
                cache = (ContactList) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cache;
    }
}
