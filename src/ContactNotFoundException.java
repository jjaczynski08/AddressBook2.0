public class ContactNotFoundException extends RuntimeException
{
    private String name;

    public ContactNotFoundException(String name)
    {
        super("Contact not found.");
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
