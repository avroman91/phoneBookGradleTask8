package org.example.phoneBook.menu;


import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.InMemoryContactsService;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    private InMemoryContactsService inMemoryContactsService;

    public AddContactMenuAction(InMemoryContactsService inMemoryContactsService) {
        this.inMemoryContactsService = inMemoryContactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Enter contact name:  ");
        String name = scan.nextLine();
        System.out.print("Enter contact phone number: ");
        String phone = scan.nextLine();
        Contact newContact = new Contact(name, phone);
        inMemoryContactsService.add(newContact);
    }

    @Override
    public String getName() {
        return "Add new contact";
    }

}
