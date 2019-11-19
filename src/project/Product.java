package project;

import javafx.scene.control.Button;
public class Product {
    private  int product_id,price,quantity;
    private  String product_name,description,lastupdate;
    private  int wight;

    public Product(int id , String name , int quantity , int price , String  description ,String lastupdate) {
        this.product_id = id;
        this.product_name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.lastupdate = lastupdate;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getPrice() {
        return price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public int getWight() {
        return wight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public Button getButton(){
        return new Button("รายละเอียด");
    }
}