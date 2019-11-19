package project;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInController {

    @FXML
    Button login;

    @FXML
    Button back;

    @FXML
    TextField username;

    @FXML
    PasswordField password;


    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;


    @FXML
    private void loadLogin(ActionEvent event) throws IOException {

        boolean status = DatabaseConnection.isLogin(username.getText(),password.getText());
        if (status == true) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ป้าแกลบ");
            alert.setHeaderText("Congratulation");
            alert.setContentText("Login Complete\n");
            alert.showAndWait();

            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Scene scene = login.getScene();
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

        }if (status == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ป้าแกลบ");
            alert.setHeaderText("Login ไม่สำเร็จ");
            alert.setContentText("กรุณากรอกข้อมูลใหม่\n");
            alert.showAndWait();
        }
    }

    @FXML
    private void loadBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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