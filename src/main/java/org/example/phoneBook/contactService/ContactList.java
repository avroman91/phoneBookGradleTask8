package org.example.phoneBook.contactService;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<Contact> contacts = new ArrayList();

    public Contact get(int index) {
        return contacts.get(index);
    }

    public void set(int index, Contact contact) {
        contacts.set(index, contact);
    }

    public int size() {
        return contacts.size();
    }

    public void remove(int index) {
        contacts.remove(index);
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }


    @Override
    public String toString() {
        if (contacts.size() == 0) return "Phonebook is empty";
        StringBuilder st = new StringBuilder();
        st.append("Your phone book: \n");
        for (int i = 0; i < contacts.size(); i++) {
            st.append(i + 1).append(".").append(contacts.get(i).getName()).append(" : ").append(contacts.get(i).getPhone()).append("\n");
        }
        st.append("End");
        return st.toString();
    }

}
