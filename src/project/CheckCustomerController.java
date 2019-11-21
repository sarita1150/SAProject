package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class CheckCustomerController {

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Integer,Customer> customer_id;

    @FXML
    private TableColumn<String,Customer> customer_name;

    @FXML
    private TableColumn<String,Customer> email;

    @FXML
    private TableColumn<String,Customer> tel;

    @FXML
    private TableColumn<String,Customer> address;

    @FXML
    private TableColumn<String,Customer> type;

    @FXML
    private Button back;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;

    public static CheckCustomerController checkCustomerController;


    public void initialize(){

        checkCustomerController = this;
        tableView.setItems(FXCollections.observableArrayList(DatabaseConnection.showCustomer()));
        customer_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        customer_name.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));


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


}
