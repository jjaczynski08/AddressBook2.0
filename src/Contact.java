public class Contact {
    private String name;
    private String phone;
    private String email;

    /**
     * Contact Constructor
     * @param name
     * @param phone
     * @param email
     */
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Gets Contact's full name
     * @return name - full name of Contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name
     * @param name - new full name of Contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Contact's phone number
     * @return phone - phone number of Contact
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets new phone number
     * @param phone - new phone number of Contact
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets Contact's email
     * @return email - email of Contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new email
     * @param email - new email of Contact
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * All contact information
     * @return "Jessica Jaczynski, 1800, jj@gmail.com"
     */
    @Override
    public String toString() {
        return name + ", " + phone + ", " + email;
    }
}