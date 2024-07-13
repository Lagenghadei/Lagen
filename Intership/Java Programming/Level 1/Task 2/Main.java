import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact [Name=" + name + ", Phone Number=" + phoneNumber + ", Email=" + email + "]";
    }
}

public class AddressBook {
    private static List<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nAddress Book");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        System.out.println("\nContacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void editContact() {
        System.out.print("Enter Name of the contact to edit: ");
        String name = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter new Email: ");
                String email = scanner.nextLine();
                
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    private static void deleteContact() {
        System.out.print("Enter Name of the contact to delete: ");
        String name = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
