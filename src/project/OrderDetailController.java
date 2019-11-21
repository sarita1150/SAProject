package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class OrderDetailController {

    @FXML
    private TableView<Order> tableView;

    @FXML
    private TableColumn<Integer,Order> orderid;

    @FXML
    private TableColumn<String,Order> cusname;

    @FXML
    private TableColumn<String,Order> proname;

    @FXML
    private TableColumn<Integer,Order> quan;

    @FXML
    private TableColumn<String,Order> status;

    @FXML
    private Button back;

    @FXML
    private Button confirm;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ChoiceBox select1;

    @FXML
    private ChoiceBox selcet2;

    public static OrderDetailController orderDetailController;


    public void initialize(){

        orderDetailController= this;
        for (Product p : DatabaseConnection.showProduct()){
            select1.getItems().addAll(p.getProduct_id());
        }
        selcet2.getItems().addAll("Packed");

        orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        cusname.setCellValueFactory(new PropertyValueFactory<>("cusname"));
        proname.setCellValueFactory(new PropertyValueFactory<>("proname"));
        quan.setCellValueFactory(new PropertyValueFactory<>("quan"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.setItems(FXCollections.observableArrayList(DatabaseConnection.showorderdetail()));

    }

    @FXML
    private void loadBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = back.getScene();
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
    private void clickConfirm(ActionEvent event) throws IOException {
        System.out.println((String) selcet2.getSelectionModel().getSelectedItem() + (int)select1.getSelectionModel().getSelectedItem());
        DatabaseConnection.editStatus((String) selcet2.getSelectionModel().getSelectedItem(),(int)select1.getSelectionModel().getSelectedItem());
        tableView.setItems(FXCollections.observableArrayList(DatabaseConnection.showorderdetail()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ป้าแกลบ");
        alert.setHeaderText("Congratulation");
        alert.setContentText("Edit Complete\n");
        alert.showAndWait();

    }


}
