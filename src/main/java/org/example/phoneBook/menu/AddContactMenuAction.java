package org.example.phoneBook.menu;


import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.InMemoryContactsService;
import org.example.phoneBook.contactService.TextSerializationContactsService;

import java.util.Scanner;

public class AddContactMenuAction implements MenuAction {

    private InMemoryContactsService inMemoryContactsService;
    private TextSerializationContactsService textSerializationContactsService;
    private int choose = 0;

    public AddContactMenuAction(InMemoryContactsService inMemoryContactsService) {
        this.inMemoryContactsService = inMemoryContactsService;
        choose = 1;
    }

    public AddContactMenuAction(TextSerializationContactsService textSerializationContactsService) {
        this.textSerializationContactsService = textSerializationContactsService;
        choose = 2;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Enter contact name:  ");
        String name = scan.nextLine();
        System.out.print("Enter contact phone number: ");
        String phone = scan.nextLine();
        Contact newContact = new Contact(name, phone);
                switch (choose) {
                    case 1:
                        inMemoryContactsService.add(newContact);
                        choose = 0;
                        break;
                    case 2:
                        textSerializationContactsService.add(newContact);
                        textSerializationContactsService.save(textSerializationContactsService.getAll());
                        choose = 0;
                        break;
                    default:
                        break;
                }
    }

        @Override
        public String getName () {
            return "Add new contact";
        }

    }
