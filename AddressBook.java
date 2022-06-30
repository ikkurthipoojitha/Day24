package com.bridgelabz.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class AddressBook {

    Contacts person = new Contacts();
    List<Contacts> contact = new ArrayList<>();

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of contacts you want to enter");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {

//            checking the duplicate contact by contact name.
            System.out.println("Enter the first name of person");
            String fName = scanner.next();
            if (fName.equals(person.getFirstName())) {
                System.out.println("The entered person is already exist. Enter new name");
            }
            else {
                System.out.println("Enter the contact details of person ");
                addNewContact();
                System.out.println("contact added Successfully");
            }
        }
    }

    public void addNewContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name : ");
        String firstName = scanner.next();
        System.out.println("Enter Last Name : ");
        String lastName = scanner.next();
        System.out.println("Enter Address : ");
        String address = scanner.next();
        System.out.println("Enter City : ");
        String city = scanner.next();
        System.out.println("Enter State : ");
        String state = scanner.next();
        System.out.println("Enter ZipCode : ");
        int zipCode = scanner.nextInt();
        System.out.println("Enter Mobile Number : ");
        long mobileNumber = scanner.nextLong();
        System.out.println("Enter EmailId : ");
        String emailId = scanner.next();
        person = new Contacts(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
        contact.add(person);
    }

    public void searchByName(String name) {
        List<Contacts> collect = contact.stream().filter(p -> p.getFirstName().equalsIgnoreCase(name)).collect(Collectors.toList());
        for (Contacts contact : collect) {
            System.out.println("Search result: " + contact);
        }
    }

    public void searchByCity(String city) {
        List<Contacts> collect = contact.stream().filter(p -> p.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        for (Contacts cont : collect) {
            System.out.println("Result: " + cont);
        }
    }

    public void searchByState(String state) {
        List<Contacts> collect = contact.stream().filter(p -> p.getCity().equalsIgnoreCase(state)).collect(Collectors.toList());
        for (Contacts cont : collect) {
            System.out.println("Result: " + cont);
        }
    }

    public void editContact() {
        System.out.println("Enter firstname of contact you want to edit");
        Scanner scanner = new Scanner(System.in);
        String editName = scanner.next();
        for (int i = 0; i < contact.size(); i++) {
            String name = contact.get(i).getFirstName();
            if (name.equalsIgnoreCase(editName)) {
                System.out.println("found first name");
                while (true) {
                    System.out.println("1. edit \n 2. edit all \n 3. menu");
                    int choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            contact.remove(i);
                            addNewContact();
                            break;
                        case 2:
                            while (true) {
                                System.out.println("1.  First Name\n 2.  Last Name\n 3.  City\n 4. State\n" +
                                        " 5.  Zip Code\n 6.  Mobile\n 7. Email\n 8. menu");
                                int option = scanner.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("Enter  First Name");
                                        String newFirstName = scanner.next();
                                        contact.get(i).setFirstName(newFirstName);
                                        break;
                                    case 2:
                                        System.out.println("Enter  Last Name");
                                        String newLastName = scanner.next();
                                        contact.get(i).setLastName(newLastName);
                                        break;
                                    case 3:
                                        System.out.println("Enter City");
                                        String newCity = scanner.next();
                                        contact.get(i).setCity(newCity);
                                        break;
                                    case 4:
                                        System.out.println("Enter State");
                                        String newState = scanner.next();
                                        contact.get(i).setState(newState);
                                        break;
                                    case 5:
                                        System.out.println("Enter ZipCode");
                                        int newZip = scanner.nextInt();
                                        contact.get(i).setZipCode(newZip);
                                        break;
                                    case 6:
                                        System.out.println("Enter Mobile Number");
                                        int newPNumber = scanner.nextInt();
                                        contact.get(i).setMobileNo(newPNumber);
                                        break;
                                    case 7:
                                        System.out.println("Enter Email");
                                        String newEmail = scanner.next();
                                        contact.get(i).setEmailId(newEmail);
                                        break;
                                    case 8:
                                        return;
                                    default:
                                        System.out.println("Invalid choice");
                                }
                            }
                        case 3:
                            return;
                        default:
                            System.out.println("invalid choice");
                    }
                }
            }else {
                System.out.println("name not exist");
            }
        }
    }

    public void countContactsByUsingCity(String cityName) {
        long count = 0;
        long count1 = contact.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName)).count();
        for (Contacts contact : contact) {
            count1 = count1 + count;
        }
        System.out.println("Contact List :" + count1);

    }

    public void sortByName() {
        List<Contacts> list = contact.stream().collect(Collectors.toList());
        list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }


    public void sortByCity() {
        List<Contacts> list = contact.stream().collect(Collectors.toList());
        list.stream().sorted((g1, g2) -> ((String) g1.getCity()).compareTo(g2.getCity()))
                .forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
    }

    public void deleteContact() {
        System.out.println("Enter the first name of contact you want to delete");
        Scanner scanner = new Scanner(System.in);
        String deleteName = scanner.next();
        for (int i = 0; i < contact.size(); i++) {
            if (deleteName.equalsIgnoreCase(contact.get(i).getFirstName())) {
                contact.remove(i);
                System.out.println("contact deleted successfully");
            } else {
                System.out.println("entered name does not exist");
            }
        }
    }
}

