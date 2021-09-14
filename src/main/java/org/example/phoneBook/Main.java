package org.example.phoneBook;

import org.example.phoneBook.contactService.Contact;
import org.example.phoneBook.contactService.ContactList;
import org.example.phoneBook.contactService.ContactsService;
import org.example.phoneBook.menu.*;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

//        ContactList test = new ContactList();
//        test.add(new Contact("Vasia", "031"));
//        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Contacts.obj"))) {
//            objectOutputStream.writeObject(test);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Contacts.obj"))) {
//            ContactList test2 = (ContactList) objectInputStream.readObject();
//            System.out.println(test2);
//        } catch (FileNotFoundException e) {
//            throw  new RuntimeException("File Not found");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } ;

        List<MenuAction> actions = new ArrayList<>();
        Menu menu = new Menu(actions);
        ContactsService memory = menu.chooseType();
        actions.add(new ReadAllMenuAction(memory));
        actions.add(new AddContactMenuAction(memory));
        actions.add(new RemoveContactMenuAction(memory));
        actions.add(new FindContactMenuAction(memory));
        menu.run();

    }
}
