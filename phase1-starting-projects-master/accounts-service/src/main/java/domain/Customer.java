package domain;

public class Customer implements Comparable<Customer> {

    private String id;
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String group;

    public Customer() {
    }

    public Customer(String email, String username, String firstname, String lastname, String group, String id) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
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

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setgroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" + "email=" + email + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", group=" + group + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Customer ids) {
        return this.id.compareTo(ids.getId());
    }
}
