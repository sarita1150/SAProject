package project;

public class Customer {

    private int customer_id;
    private String customer_name;
    private String email;
    private String tel;
    private String address;
    private String type;

    public Customer(int customer_id, String customer_name, String email, String tel, String address, String type) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
