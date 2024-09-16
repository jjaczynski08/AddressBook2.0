public class Contact {
    private String name;
    private String phone;
    private String phone2;
    private String email;
    private String email2;
    private String address;
    private String bday;
    private String social;

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
     * Gets Contact's phone 2nd number
     * @return phone - 2nd phone number of Contact
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Sets new phone number
     * @param phone - new phone number of Contact
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets new 2nd phone number
     * @param phone2 - new 2nd phone number of Contact
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * Gets Contact's email
     * @return email - email of Contact
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets Contact's 2nd email
     * @return email - 2nd email of Contact
     */
    public String getEmail2() {
        return email2;
    }

    /**
     * Sets new email
     * @param email - new email of Contact
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets new 2nd email
     * @param email2 - new 2nd email of Contact
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     * Gets Contact's mailing address
     * @return address - mailing address of Contact
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets new mailing address
     * @param address - new mailing address of Contact
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets Contact's birthdau
     * @return bday - birthday of Contact
     */
    public String getBday() {
        return bday;
    }

    /**
     * Sets new birthday
     * @param bday - new birthday of Contact
     */
    public void setBday(String bday) {
        this.bday = bday;
    }

    /**
     * Gets Contact's social media profile
     * @return social - social media profile of Contact
     */
    public String getSocial() {
        return social;
    }

    /**
     * Sets new social media profile
     * @param social - new social media profile of Contact
     */
    public void setSocial(String social) {
        this.social = social;
    }

    /**
     * All contact information
     * @return "Jessica Jaczynski, 1800, jj@gmail.com"
     */
    @Override
    public String toString() {
        return name + "," + phone + "," + phone2 + "," + email + "," + email2 + "," + address + "," +
                bday + "," + social;
    }
}