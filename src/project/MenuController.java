package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class MenuController {

    @FXML
    Button logout;


    @FXML
    Button checkPayment;

    @FXML
    Button wherehouse;

    @FXML
    Button modifyProduct;

    @FXML
    Button orderDetail;

    @FXML
    Button checkCustomer;

    @FXML
    TableView<Product> tableView;

    @FXML
    TableColumn<String,Product> lastupdate;

    @FXML
    TableColumn<String,Product> product_name;

    @FXML
    TableColumn<Integer,Product> product_id;

    @FXML
    TableColumn<Integer,Product> weight;

    @FXML
    TableColumn<Integer,Product> price;


    @FXML
    TableColumn<Integer,Product> quantity;

    @FXML
    TableColumn<Button , Product> detail_button;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;

    public void initialize(){
        Product test = new Product(1,"test",3,3,"test","test");
        tableView.getItems().addAll(DatabaseConnection.showProduct());
        product_name.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        product_id.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        detail_button.setCellValueFactory(new PropertyValueFactory<>("button"));


    }
//    @FXML
//    private void setDetail_button() throws IOException {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("ป้าแกลบ");
//        alert.setHeaderText("Congratulation");
//        alert.setContentText("Login Complete\n");
//        alert.showAndWait();
//    }

    @FXML
    private void loadLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene scene = logout.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

    @FXML
    private void loadWarehouse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WarehouseDepartment.fxml"));
        Scene scene = wherehouse.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

    @FXML
    private void loadCheckPayment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CheckPayment.fxml"));
        Scene scene = checkPayment.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

    @FXML
    private void loadModifyProduct(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        Scene scene = modifyProduct.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

    @FXML
    private void loadOrderDetail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderDetail.fxml"));
        Scene scene = orderDetail.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

    @FXML
    private void loadCheckCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CheckCustomer.fxml"));
        Scene scene = checkCustomer.getScene();
        root.translateYProperty().set(scene.getHeight());


        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            stackPane.getChildren().remove(anchorPane);
        });
        timeline.play();

    }

}