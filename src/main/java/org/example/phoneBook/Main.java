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
        List<MenuAction> actions = new ArrayList<>();
        Menu menu = new Menu(actions);
        actions.add(new AddContactMenuAction(menu.chooseType()));
        actions.add(new ReadAllMenuAction(menu.chooseType()));
        actions.add(new RemoveContactMenuAction(menu.chooseType()));
        actions.add(new FindContactMenuAction(menu.chooseType()));
        menu.run();


//        List<Contact> contacts = null;
//        try (BufferedReader fileReader = new BufferedReader(new FileReader("Contacts.text"))) {
//            contacts = fileReader.lines().filter(s->s.split(" ").length==4).map(s -> new Contact(s.split(" ")[1], s.split(" ")[3])).collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(contacts);

    }
}
