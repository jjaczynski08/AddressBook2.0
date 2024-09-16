//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean verbose = false;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean addFile = false;
        AddressBook addressBook = new AddressBook();

        String filePathRead = "";
        String filePathWrite = "";
        for (int i = 0; i < args.length; i++)
        {
            if (args[i].equals("-v"))
            {
                verbose = true;
            }
            else if (args[i].equals("-a"))
            {
                if (i+1<args.length)
                {
                    filePathRead = args[i+1];
                    addFile = true;
                }
                i++;
            }
            else if (args[i].equals("-s"))
            {
                if (i+1<args.length)
                {
                    filePathWrite = args[i+1];
                }
                i++;
            }
        }

        if (addFile)
        {
            if (verbose)
            {
                System.out.println("[verbose] Reading from: " + filePathRead);
            }
            int count = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePathRead))) {
                String line;
                boolean firstLine = false;
                while ((line = reader.readLine()) != null) {
                    String[] parsedLine = line.split(",");
                    if (!firstLine)
                    {
                        firstLine = true;
                    }
                    else
                    {
                        addressBook.fileRead(parsedLine);
                        count++;
                    }
                }
            }
            catch (FileNotFoundException f)
            {
                System.out.println("File not found.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            if (verbose)
            {
                System.out.println("[verbose] Added " + count + " new contacts.");
                System.out.println();
            }
        }

        boolean on = true;

        while (on)
        {
            System.out.println("(A)dd new contact");
            System.out.println("(V)iew existing contacts");
            System.out.println("(L)ook for a contact");
            System.out.println("(E)dit existing contact");
            System.out.println("(D)elete unwanted contacts");
            System.out.println("(S)ave contact list");
            System.out.println("(Q)uit");

            String reply = input.nextLine().toLowerCase();
            if (reply.equals("a"))
            {
                System.out.print("New contact full name: ");
                String name = input.nextLine();
                System.out.print("New contact phone number: ");
                String phone = input.nextLine();
                System.out.print("New contact alternate phone number: ");
                String phone2 = input.nextLine();
                System.out.print("New contact email: ");
                String email = input.nextLine();
                System.out.print("New contact alternate email: ");
                String email2 = input.nextLine();
                System.out.print("New contact emailing address: ");
                String address = input.nextLine();
                System.out.print("New contact birthday: ");
                String bday = input.nextLine();
                System.out.print("New contact social media profile: ");
                String social = input.nextLine();
                Contact newContact = new Contact(name, phone, email);
                addressBook.addContact(newContact);
                newContact.setPhone2(phone2);
                newContact.setEmail2(email2);
                System.out.println("Added contact.");
                System.out.println();
            }
            else if (reply.equals("v"))
            {
                ArrayList<Contact> alpha = addressBook.alphabeticalOrder();
                boolean hasContact = false;
                for (int i = 0; i < alpha.size(); i++)
                {
                    System.out.println(i+1 + ") " + alpha.get(i));
                    hasContact = true;
                }
                if (!hasContact)
                {
                    System.out.println("No contacts.");
                }
                System.out.println();
            }
            else if (reply.equals("l"))
            {
                System.out.print("Contact's full name:");
                String name = input.nextLine();
                try
                {
                    ArrayList<String> allNames = addressBook.searchName(name);
                    System.out.println("Contact(s) found: " + "\n");
                    for (int i = 0; i < allNames.size(); i++)
                    {
                        System.out.println(allNames.get(i));
                    }
                }
                catch(ContactNotFoundException c)
                {
                    System.out.println("No contact found with name " + c.getName());
                }
                System.out.println();
            }
            else if (reply.equals("e"))
            {
                System.out.print("Contact's full name: ");
                String name = input.nextLine();
                System.out.print("Contact's phone number: ");
                String phone = input.nextLine();
                System.out.print("Contact's email: ");
                String email = input.nextLine();
                int num = addressBook.nbOfContacts(name, phone, email);
                if (num == 0)
                {
                    System.out.println("No contact found.");
                    System.out.println();
                }
                else if (num == 1)
                {
                    System.out.println("What do you want to change?");
                    System.out.println("1 Name");
                    System.out.println("2 Phone");
                    System.out.println("3 Alternate Phone");
                    System.out.println("4 Email");
                    System.out.println("5 Alternate Email");
                    System.out.println("6 Mailing Address");
                    System.out.println("7 Birthday");
                    System.out.println("8 Social Media Profile");

                    int toChange = input.nextInt();
                    input.nextLine();
                    Contact contact = addressBook.getContact(name, phone, email);
                    if (toChange == 1)
                    {
                        System.out.print("New full name: ");
                        String newName = input.nextLine();
                        String oldName = contact.getName();
                        contact.setName(newName);
                        if (verbose)
                        {
                            System.out.println("[verbose] Name change: " + oldName + " to " + newName);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 2)
                    {
                        System.out.print("New phone number: ");
                        String newPhone = input.nextLine();
                        String oldPhone = contact.getPhone();
                        contact.setPhone(newPhone);
                        if (verbose)
                        {
                            System.out.println("[verbose] Phone number change: " + oldPhone + " to " + newPhone);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 3)
                    {
                        System.out.print("New alternate phone number: ");
                        String newPhone2 = input.nextLine();
                        String oldPhone2 = contact.getPhone2();
                        contact.setPhone2(newPhone2);
                        if (verbose)
                        {
                            System.out.println("[verbose] Phone number change: " + oldPhone2 + " to " + newPhone2);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 4)
                    {
                        System.out.print("New email: ");
                        String newEmail = input.nextLine();
                        String oldEmail = contact.getEmail();
                        contact.setEmail(newEmail);
                        if (verbose)
                        {
                            System.out.println("[verbose] Email change: " + oldEmail + " to " + newEmail);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 5)
                    {
                        System.out.print("New alternate email: ");
                        String newEmail2 = input.nextLine();
                        String oldEmail2 = contact.getEmail2();
                        contact.setEmail2(newEmail2);
                        if (verbose)
                        {
                            System.out.println("[verbose] Alternate email change: " + oldEmail2 + " to " + newEmail2);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 6)
                    {
                        System.out.print("New mailing address: ");
                        String newAddress = input.nextLine();
                        String oldAddress = contact.getAddress();
                        contact.setAddress(newAddress);
                        if (verbose)
                        {
                            System.out.println("[verbose] Mailing address change: " + oldAddress + " to " + newAddress);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 7)
                    {
                        System.out.print("New birthday: ");
                        String newBday = input.nextLine();
                        String oldBday = contact.getBday();
                        contact.setBday(newBday);
                        if (verbose)
                        {
                            System.out.println("[verbose] Birthday change: " + oldBday + " to " + newBday);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else if (toChange == 8)
                    {
                        System.out.print("New social media profile: ");
                        String newSocial = input.nextLine();
                        String oldSocial = contact.getSocial();
                        contact.setSocial(newSocial);
                        if (verbose)
                        {
                            System.out.println("[verbose] Social media profile change: " + oldSocial + " to " + newSocial);
                        }
                        System.out.println("Set!");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Incorrect input.");
                        System.out.println();
                    }
                }
                else
                {
                    System.out.println("There are multiple contacts with this information. Since Address Book is case" +
                            " sensitive, we will merge these contacts.");
                }
            }
            else if (reply.equals("d"))
            {
                System.out.print("Contact's full name: ");
                String name = input.nextLine();
                System.out.print("Contact's phone number: ");
                String phone = input.nextLine();
                System.out.print("Contact's email: ");
                String email = input.nextLine();
                int count = addressBook.deleteContact(name, phone, email);
                if (count == 0)
                {
                    System.out.println("No contacts found.");
                }
                System.out.println();
            }
            else if (reply.equals("s"))
            {
                ArrayList<Contact> alphaContact = addressBook.alphabeticalOrder();
                if (Main.verbose)
                {
                    System.out.println("[verbose] Saving to file: " + filePathWrite);
                }
                int counter = 0;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathWrite, false))) {
                    for (Contact contact : alphaContact) {
                        writer.write(contact.toString());
                        counter++;
                        writer.newLine(); // Write a new line after each entry
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (Main.verbose)
                {
                    System.out.println("[verbose] " + counter + " contact(s) saved to file.");
                }
            }
            else if (reply.equals("q"))
            {
                on = false;
                if (Main.verbose)
                {
                    System.out.println("[verbose] Quit.");
                }
            }
            else
            {
                if (Main.verbose)
                {
                    System.out.println("[verbose] Invalid input.");
                }
                System.out.println();
            }
        }
    }
}