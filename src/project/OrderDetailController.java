package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class OrderDetailController<ProductTable> {

    @FXML
    private TableColumn<String,OrderDetailController> productid;
    private TableColumn<String,OrderDetailController> cusname;
    private TableColumn<String,OrderDetailController> proname;
    private TableColumn<String,OrderDetailController> quan;
    private TableColumn<String,OrderDetailController> status;
    @FXML
    private Button back;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;

    ArrayList<OrderDetailController> orderDetailControllers ;
    public void initialize(){
        productid.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        cusname.setCellValueFactory(new PropertyValueFactory<>("customer_name"));
        proname.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        quan.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        status.setCellValueFactory(new PropertyValueFactory<>("order_status"));

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
