package com.inpowered.model;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AddressBook {
    private TreeSet<Contact> contacts = new TreeSet<>((o1, o2) -> o1.getBirthDate().compareTo(o2.getBirthDate()));
    private static AddressBook INSTANCE;

    private AddressBook(){ }

    public static AddressBook getInstance(){
        if(INSTANCE == null){
            INSTANCE  = new AddressBook();
        }

        return INSTANCE;
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public Contact getOldestPerson(){
        return contacts.first();
    }

    public static long getDaysBetween(Contact contact1, Contact contact2){
        return ChronoUnit.DAYS.between(contact1.getBirthDate(), contact2.getBirthDate());
    }

    public List<Contact> getByName(String name){
        return this.contacts.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    public long getNumberOfMales(){
        return this.contacts.stream().filter(x -> x.getGender().equals(Gender.MALE)).count();
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "contacts=" + contacts +
                '}';
    }
}
