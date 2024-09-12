//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AddressBook addressBook = new AddressBook();
        boolean on = true;

        while (on)
        {
            System.out.println("Welcome to Address Book. What would you like to do?");
            System.out.println("(A)dd new contact");
            System.out.println("(V)iew existing contacts");
            System.out.println("(S)earch for a contact");
            System.out.println("(E)dit existing contact ");
            System.out.println("(D)elete unwanted contacts");
            System.out.println("(Q)uit");

            String reply = input.nextLine().toLowerCase();
            if (reply.equals("a"))
            {
                System.out.println("What's the full name of the new contact?");
                String name = input.nextLine();
                System.out.println("What's the phone number of the new contact?");
                String phone = input.nextLine();
                System.out.println("What's the email of the new contact?");
                String email = input.nextLine();
                Contact newContact = new Contact(name, phone, email);
                addressBook.addContact(newContact);
                System.out.println("Added!");
                System.out.println();
            }
            else if (reply.equals("v"))
            {
                ArrayList<Contact> alpha = addressBook.alphabeticalOrder();
                boolean hasContact = false;
                for (int i = 0; i < alpha.size(); i++)
                {
                    if (i == 0)
                    {
                        System.out.println("Here is the entire list of existing contacts alphabetically ordered:");
                    }
                    System.out.println(i+1 + ") " + alpha.get(i));
                    hasContact = true;
                }
                if (!hasContact)
                {
                    System.out.println("Please enter a contact first.");
                }
                System.out.println();
            }
            else if (reply.equals("s"))
            {
                System.out.println("What is the full name you would like to search by:");
                String name = input.nextLine();
                ArrayList<String> allNames = addressBook.searchName(name);
                if (allNames == null) // TODO: DOESNT GET TO THIS POINT !!
                {
                    System.out.println("No contact found with such name. Please add contact or edit contact information.");
                }
                else
                {
                    System.out.println("Contact(s) found: " + "\n");
                    for (int i = 0; i < allNames.size(); i++)
                    {
                        System.out.println(allNames.get(i));
                    }
                }
                System.out.println();
            }
            else if (reply.equals("e"))
            {
                System.out.println("You will need to enter in all the contact details in order to edit it");
                System.out.println("Enter the full contact name");
                String name = input.nextLine();
                System.out.println("Enter the contact phone");
                String phone = input.nextLine();
                System.out.println("Enter the contact email");
                String email = input.nextLine();
                int num = addressBook.nbOfContacts(name, phone, email);
                if (num == 0)
                {
                    System.out.println("No contact exists. Please try again.");
                    System.out.println();
                }
                else if (num == 1)
                {
                    System.out.println("Contact found! What do you want to change?");
                    System.out.println("(N)ame");
                    System.out.println("(P)hone");
                    System.out.println("(E)mail");
                    String toChange = input.nextLine().toLowerCase();
                    Contact contact = addressBook.getContact(name, phone, email);
                    if (toChange.equals("n"))
                    {
                        System.out.println("Enter new full name");
                        String newName = input.nextLine();
                        contact.setName(newName);
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange.equals("p"))
                    {
                        System.out.println("Enter new phone number");
                        String newPhone = input.nextLine();
                        contact.setPhone(newPhone);
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange.equals("e"))
                    {
                        System.out.println("Enter new email");
                        String newEmail = input.nextLine();
                        contact.setEmail(newEmail);
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("You didn't enter a proper letter. Please try again.");
                        System.out.println();
                    }
                }
                else
                {
                    System.out.println("There are multiple contacts with this information. Since Address Book is case" +
                            " sensitive, we will merge these contacts.");
                    int counter = addressBook.mergeContact(name, phone, email);
                    if (counter > 0)
                    {
                        System.out.println("Merged!");
                    }
                }
            }
            else if (reply.equals("d"))
            {
                System.out.println("You will need to enter in all the contact details in order to delete it");
                System.out.println("Enter the full contact name");
                String name = input.nextLine();
                System.out.println("Enter the contact phone");
                String phone = input.nextLine();
                System.out.println("Enter the contact email");
                String email = input.nextLine();
                int count = addressBook.deleteContact(name, phone, email);
                if (count == 0)
                {
                    System.out.println("There are no contacts that match this information. Add a contact or fix " +
                            "the information.");
                }
                else
                {
                    System.out.println("Deleted " + count + " contact(s)");
                }
                System.out.println();
            }
            else if (reply.equals("q"))
            {
                on = false;
                System.out.println("Thanks for using the Address Book!");
            }
            else
            {
                System.out.println("You didn't enter a proper letter. Please try again.");
                System.out.println();
            }
        }
    }
}