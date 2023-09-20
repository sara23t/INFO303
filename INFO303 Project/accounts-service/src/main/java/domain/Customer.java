package domain;

public class Customer implements Comparable<Customer> {

    private String id;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String group;

    public Customer() {
    }

    public Customer(String id, String email, String username, String firstName, String lastName, String group) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setid(String id) {
        this.id = id;
    }

    public void setfirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setgroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setlastname(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" + "email=" + email + ", username=" + username + ", firstname=" + firstName + ", lastname=" + lastName + ", group=" + group + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Customer ids) {
        return this.id.compareTo(ids.getId());
    }
}
