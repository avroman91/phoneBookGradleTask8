package org.example.phoneBook;

import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.InMemoryContactsService;
import org.example.phoneBook.contactService.TextSerializationContactsService;
import org.example.phoneBook.menu.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<MenuAction> actions = new ArrayList<>();
//        InMemoryContactsService memory = new InMemoryContactsService();
//        TextSerializationContactsService memory2 = new TextSerializationContactsService();
//        actions.add(new ReadAllMenuAction(memory));
//        actions.add(new AddContactMenuAction(memory2));
//        actions.add(new RemoveContactMenuAction(memory));
//        actions.add(new FindContactMenuAction(memory));
//        Menu menu = new Menu(actions);
//        menu.run();


        List<Contact> contacts = null;
        try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
            contacts = fileReader.lines().map(s -> new Contact(s.split(" ")[1], s.split(" ")[3])).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(contacts);


//        try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
//            List<Contact> strings = fileReader.lines().skip().map(s -> new Contact(s.split(" ")[0],s.split(" ")[1])).collect(Collectors.toList());
//            System.out.println(strings);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
