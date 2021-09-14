//package org.example.phoneBook.contactService;
//
//public abstract class SerializationHelperAbstractClass implements ContactsService{
//
//    private ContactList contacts = new ContactList();
//
//    @Override
//    public ContactList getAll() {
//        return contacts;
//    }
//
//    @Override
//    public void remove(int index) {
//
//        if (contacts.size() == 0) {
//            System.out.println("Phonebook is empty");
//        } else if (index < 0 || index >= contacts.size()) {
//            System.out.println("Incorrect input");
//        } else {
//            contacts.remove(index);
//        }
//
//    }
//
//
//
//}
