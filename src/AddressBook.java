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
        return res;
    }

    /**
     * Finds all the Contacts that have the same name
     * @param name
     * @return allNames - ArrayList of matching names
     */
    public ArrayList<String> searchName(String name)
    {
        ArrayList<String> allNames = new ArrayList<String>();
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name))
            {
                allNames.add(curr.toString());
            }
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
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                num++;
            }
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
        for (int i = 0; i < allContacts.size(); i++)
        {
            Contact curr = allContacts.get(i);
            if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                return curr;
            }
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
            }
            else if (curr.getName().equals(name) && curr.getPhone().equals(phone) && curr.getEmail().equals(email))
            {
                counter++;
                allContacts.remove(i);
                i--;
            }
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
        return count;
    }
}