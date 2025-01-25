package mobilePhone;

import java.util.*;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) == -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact.getName()) >=0) {
            int contactIndex = findContact(oldContact);
            myContacts.set(contactIndex, newContact);
            return true;
        }
        return false;

    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact myContact = myContacts.get(i);
            if (myContact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        int contactIndex = findContact(contactName);
        if (contactIndex == -1) {
            return null;
        }
        return myContacts.get(contactIndex);
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i=0;i<myContacts.size();i++){
            Contact contact = myContacts.get(i);
            System.out.println((i+1)+". "+contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

}
