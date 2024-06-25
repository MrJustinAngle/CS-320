package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContactField(String contactId, String fieldName, String newValue) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            switch (fieldName.toLowerCase()) {
                case "firstname":
                    contact = new Contact(contact.getId(), newValue, contact.getLastName(), contact.getPhone(), contact.getAddress());
                    break;
                case "lastname":
                    contact = new Contact(contact.getId(), contact.getFirstName(), newValue, contact.getPhone(), contact.getAddress());
                    break;
                case "phone":
                    contact = new Contact(contact.getId(), contact.getFirstName(), contact.getLastName(), newValue, contact.getAddress());
                    break;
                case "address":
                    contact = new Contact(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), newValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field name for update.");
            }
            contacts.put(contactId, contact);
        }
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }
}