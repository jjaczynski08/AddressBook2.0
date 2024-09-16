import java.util.ArrayList;

public class AddressBook
{
    private final ArrayList<Contact> allContacts;

    /**
     * AddressBook Constructor
     * Creates an Arraylist of Contacts
     */
    public AddressBook()
    {
        allContacts = new ArrayList<Contact>();
    }

    /**
     * Adds Contact to ArrayList
     * @param newContact
     */
    public void addContact(Contact newContact)
    {
        allContacts.add(newContact);
    }

    /**
     * Sorts ArrayList of Contacts by name alphabetically
     * @return res - sorted Arraylist of Contacts
     */
    public ArrayList<Contact> alphabeticalOrder()
    {
        ArrayList<Contact> res = new ArrayList<Contact>(allContacts);
        if (Main.verbose)
        {
            System.out.println("[verbose] Starting sort...");
        }

        for (int i = 0; i < res.size(); i++)
        {
            for (int j = i+1; j < res.size(); j++)
            {
                String first = res.get(i).getName();
                String next = res.get(j).getName();
                if (first.compareTo(next) > 0)
                {
                    Contact temp = res.get(j);
                    res.set(j, res.get(i));
                    res.set(i, temp);
                }
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Finished sort.");
        }
        return res;
    }

    /**
     * Finds all the Contacts that have the same name
     * @param name
     * @return allNames - ArrayList of matching names
     */
    public ArrayList<String> searchName(String name) throws ContactNotFoundException
    {
        ArrayList<String> allNames = new ArrayList<String>();
        if (Main.verbose)
        {
            System.out.println("[verbose] Searching for name...");
        }
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name))
            {
                allNames.add(curr.toString());
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Found " + allNames.size() + " contact(s).");
        }
        if (allNames.size() == 0)
        {
            throw new ContactNotFoundException(name);
        }
        return allNames;
    }

    /**
     * Finds how many matching contacts there are
     * @param name
     * @param phone
     * @param email
     * @return num - total number of matches
     */
    public int nbOfContacts(String name, String phone, String email)
    {
        int num = 0;
        if (Main.verbose)
        {
            System.out.println("[verbose] Finding matching contacts...");
        }
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                num++;
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Found " + num + " contact(s).");
        }
        return num;
    }

    /**
     * Searches for first matching contact
     * @param name
     * @param phone
     * @param email
     * @return curr - if found, else null
     */
    public Contact getContact(String name, String phone, String email)
    {
        if (Main.verbose)
        {
            System.out.println("[verbose] Finding matching contacts...");
        }
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                if (Main.verbose)
                {
                    System.out.println("[verbose] Found contact.");
                }
                return curr;
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Found 0 matches.");
        }
        return null;
    }

    /**
     * Deletes all extra contacts if match (not first one)
     * @param name
     * @param phone
     * @param email
     * @return counter - how many contacts deleted
     */
    public int mergeContact(String name, String phone, String email)
    {
        boolean first = false;
        int counter = 0;
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email) && !first)
            {
                first = true;
                if (Main.verbose)
                {
                    System.out.println("[verbose] Found first contact match.");
                }
            }
            else if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                counter++;
                allContacts.remove(i);
                i--;
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Merged " + counter + " contact(s).");
        }
        return counter;
    }

    /**
     * Deletes any given contact that matches
     * @param name
     * @param phone
     * @param email
     * @return count - how many contacts deleted
     */
    public int deleteContact(String name, String phone, String email) // DONE
    {
        int count = 0;
        if (Main.verbose)
        {
            System.out.println("[verbose] Finding matching contacts...");
        }
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                allContacts.remove(i);
                i--;
                count++;
            }
        }
        if (Main.verbose)
        {
            System.out.println("[verbose] Deleted " + count + " contact(s).");
        }
        return count;
    }

    /**
     *
     * @param parsedFile
     */
    public void fileRead(String[] parsedFile)
    {
        if (parsedFile.length > 3) // checking that it exists so it doesn't crash
        {
            allContacts.add(new Contact(parsedFile[0], parsedFile[1], parsedFile[3]));
        }
        Contact curr = allContacts.get(allContacts.size()-1);
        curr.setPhone2(parsedFile[2]);
        if (parsedFile.length > 4)
        {
            curr.setEmail2(parsedFile[4]);
        }
        if (parsedFile.length > 5)
        {
            curr.setAddress(parsedFile[5]);
        }
        if (parsedFile.length > 6)
        {
            curr.setBday(parsedFile[6]);
        }
        if (parsedFile.length > 7)
        {
            curr.setSocial(parsedFile[7]);
        }
    }
}