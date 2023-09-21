package domain;

/**
 *
 * @author sarataha 
 * Sept 2023
 */

/**
 * The Customer class represents an entity that stores information about
 * customer It includes attributes such as a customer's name, contact details,
 * and other information.
 */
public class Customer {
    
// Unique objects
    private String id;
    private String firstName;
    private String lastName;
    private String group;
    private String email;
    private String customerCode;

    /**
     * Set the id for the customer.
     *
     * @param id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the first Name for the customer.
     *
     * @param firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the last name for the customer.
     *
     * @param lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the code for the customer.
     *
     * @param customerCode.
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * Set the group for the customer.
     *
     * @param group.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Set the email for the customer.
     *
     * @param email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieve the Id of the Customer.
     *
     * @return The Customer's Id.
     */
    public String getId() {
        return id;
    }

    /**
     * Get the Customer's first name.
     *
     * @return The Customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the Customer's last name.
     *
     * @return The Customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the Customer's code.
     *
     * @return The Customer's code.
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Get the Customer's group.
     *
     * @return The Customer's group.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Get the customer's email.
     *
     * @return The Customer's email.
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", group=" + group + ", email=" + email + ", customerCode=" + customerCode + '}';
    }
}
