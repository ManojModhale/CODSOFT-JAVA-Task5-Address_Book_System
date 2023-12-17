package task5;

import java.util.Scanner;

public class ConsoleAddressBookApp 
{
	public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
        	System.out.println();
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Load from Storage");
            System.out.println("6. Save to Storage");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    
                    Contact newContact = createContact(scanner);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    
                    System.out.print("Enter the name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    addressBook.removeContact(nameToRemove);
                    break;
                case 3:
                    
                    System.out.print("Enter the name to search: ");
                    String nameToSearch = scanner.nextLine();
                    Contact foundContact = addressBook.searchConatct(nameToSearch);
                    if (foundContact != null) {
                        System.out.println("Contact Found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    
                    addressBook.displayAll();
                    break;
                case 5:
                    
                    System.out.print("Enter the filename to load from: ");
                    String loadFilename = scanner.nextLine();
                    addressBook.readFromStorage(loadFilename);
                    break;
                case 6:
                    
                    System.out.print("Enter the filename to save to: ");
                    String saveFilename = scanner.nextLine();
                    addressBook.writeToStorage(saveFilename);
                    break;
                case 7:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static Contact createContact(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter street: ");
        String street=scanner.nextLine();
        System.out.println("Enter City: ");
        String city=scanner.nextLine();
        System.out.println("Enter State: ");
        String state=scanner.nextLine();
        System.out.println("Enter Zipcode: ");
        int zipcode=scanner.nextInt();

        return new Contact(name, phone, email, new Address(street, city, state, zipcode));
    }
}
