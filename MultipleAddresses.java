package com.bridgelabz.StreamAPI;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class MultipleAddresses {

    Map<String, AddressBook> addressBookMap = new HashMap<>();

    public void addAddressBook() {
        System.out.println("Enter Name of new Address Book: ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        if (addressBookMap.containsKey(bookName)) {
            System.out.println("Address book with this name exists, Enter new name.");
            addAddressBook();
        }
        else {
            AddressBook addressBook = new AddressBook();
            addressBookMap.put(bookName, addressBook);
            System.out.println("added addressbook");
            System.out.println("still want to add another book press 1 for yes and 2 for no");
            int ch = scanner.nextInt();
            if (ch == 1) {
                addAddressBook();
            }
            else
                System.exit(0);
            }
        }

    public void addressBookOperations() {
        System.out.println("Enter the Address book name to add, edit or delete");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if (addressBookMap.containsKey(bookName)) {
            addressBookMap.get(bookName);
        while (true) {
            System.out.println("1. add \n 2. edit \n 3. delete \n 4.  menu");
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                addressBookMap.get(bookName).addContact();
                break;
            case 2:
                addressBookMap.get(bookName).editContact();
                break;
            case 3:
                addressBookMap.get(bookName).deleteContact();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice");
            }
        }
        }
        }

    public void deleteAddressBook() {
        System.out.println("Address book name to delete.");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        if (addressBookMap.containsKey(bookName)) {
            addressBookMap.remove(bookName);
        }
        else {
            System.out.println(" book not found");
        }
    }

    public void printAddressBook() {
        System.out.println("AddressBooks are:");
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            System.out.println(entry.getKey() + "[]");
        }
    }

    public void printAddressBookContacts() {
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            System.out.println("Address Book contacts < " + entry.getKey() + " > are:");
            System.out.println(entry.getValue().contact);
        }
    }
}