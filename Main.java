package com.bridgelabz.StreamAPI;

import java.util.Scanner;

public class Main {

    public void choose() {
        MultipleAddresses obj1 = new MultipleAddresses();
        AddressBook obj2 = new AddressBook();
        while (true) {
            System.out.println("1. add AddressBook\n 2.AddressBook operations\n 3. To delete the AddressBook\n " +
                    "4. To Print the AddressBook\n 5. To Print the contacts in AddressBook\n 0. to exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    obj1.addAddressBook();
                    break;
                case 2:
                    obj1.addressBookOperations();
                    break;
                case 3:
                    obj1.deleteAddressBook();
                    break;
                case 4:
                    obj1.printAddressBook();
                    break;
                case 5:
                    obj1.printAddressBookContacts();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the wrong input");
            }
        }
    }
    public static void main(String[] args) {
        Main addressBookMain = new Main();
        addressBookMain.choose();
    }
}
