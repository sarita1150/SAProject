package project;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Product {
    private Alert alert;
    private int product_id,price,quantity;
    private String product_name,description;
    private Button button;

    public Product() {
    }

    public Product(int id , String name , int quantity , int price , String  description) {
        this.product_id = id;
        this.product_name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.button = new Button("Info");

        alert = new Alert(Alert.AlertType.INFORMATION);

        button.setOnAction(click ->{

            alert.setTitle("ป้าแกลบ");
            alert.setHeaderText("Product Detail");
            alert.setContentText(description);
            alert.showAndWait();
        });
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


    public Button getterbutton() {
        return button;
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


    public Button getButton(){
        return button;
    }
}