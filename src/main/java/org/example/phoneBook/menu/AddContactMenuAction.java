package org.example.phoneBook.menu;


import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.InMemoryContactsService;
import org.example.phoneBook.contactService.TextSerializationContactsService;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    private InMemoryContactsService inMemoryContactsService;
    private TextSerializationContactsService textSerializationContactsService;

    public AddContactMenuAction(InMemoryContactsService inMemoryContactsService) {
        this.inMemoryContactsService = inMemoryContactsService;
    }

    public AddContactMenuAction(TextSerializationContactsService textSerializationContactsService) {
        this.textSerializationContactsService = textSerializationContactsService;
    }

    @Override
    public void doAction(Scanner scan) {
//        System.out.print("Enter contact name:  ");
//        String name = scan.nextLine();
//        System.out.print("Enter contact phone number: ");
//        String phone = scan.nextLine();
//        Contact newContact = new Contact(name, phone);
//        inMemoryContactsService.add(newContact);
//        textSerializationContactsService.add(newContact);
//        textSerializationContactsService.save(textSerializationContactsService.getAll());
//        System.out.println(textSerializationContactsService.load());
    }

    @Override
    public String getName() {
        return "Add new contact";
    }

}
