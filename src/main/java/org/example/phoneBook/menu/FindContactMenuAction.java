package org.example.phoneBook.menu;

import org.example.phoneBook.contactService.ContactList;
import org.example.phoneBook.contactService.InMemoryContactsService;

import java.util.Scanner;

public class FindContactMenuAction implements MenuAction {

    private InMemoryContactsService inMemoryContactsService;

    public FindContactMenuAction(InMemoryContactsService inMemoryContactsService) {
        this.inMemoryContactsService = inMemoryContactsService;
    }

    @Override
    public void doAction(Scanner scan) {
        System.out.print("Please enter contact name or part of the name: ");
        String name = scan.nextLine();
        ContactList found = inMemoryContactsService.findByName(name);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("There is no such contact");
        }
    }

    @Override
    public String getName() {
        return "Find by name";
    }

}
