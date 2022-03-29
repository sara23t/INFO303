package domain;

public class Customer implements Comparable<Customer>{
    private String id;
    private String firstname;
    private String lastname;
    private String group;
    private String email;
    private String customerCode;
    
    public Customer(String id, String firstname, String lastname, String email, String customerCode){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.customerCode = customerCode;
        
    }

    public Customer() {
    }

    public String getcustomerCode(){
        return customerCode;
        
    }
    public void setcustomerCode(String customerCode){
        this.customerCode=customerCode;
    }
    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGroup() {
        return group;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        	return  "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", group=" + group + ", email=" + email;
    }

    @Override
    public int compareTo(Customer ids) {
        return this.id.compareTo(ids.getId());
    }
}