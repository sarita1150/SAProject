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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class MenuController {

    @FXML
    Button logout;

    @FXML
    Button wherehouse;

    @FXML
    Button modifyProduct;

    @FXML
    Button orderDetail;

    @FXML
    Button checkCustomer;



    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;


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
