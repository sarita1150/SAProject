package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;

public class AddProductController {

    @FXML
    private Button confirm;

    @FXML
    private Button back;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField durain1;

    @FXML
    private TextField durain2;

    @FXML
    private TextField durain3;

    @FXML
    private Label quatity1;

    @FXML
    private Label quatity2;

    @FXML
    private Label quatity3;

    Product product = new Product();

    public void initialize(){

    }
    @FXML
    private void loadConfirm(ActionEvent event) throws IOException {
      DatabaseConnection.addProduct(Integer.parseInt(durain1.getText()),2);
        DatabaseConnection.addProduct(Integer.parseInt(durain2.getText()),3);
        DatabaseConnection.addProduct(Integer.parseInt(durain3.getText()),4);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ป้าแกลบ");
        alert.setHeaderText("Congratulation");
        alert.setContentText("Add Complete\n");
        alert.showAndWait();

        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = confirm.getScene();
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
