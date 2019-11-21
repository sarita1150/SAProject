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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class ShopController {

    @FXML
    Button back;

    @FXML
    Button confirm;


    @FXML
    TextField show1;

    @FXML
    TextField show2;

    @FXML
    TextField show3;

    @FXML
    Label quantity1;
    @FXML
    Label quantity2;
    @FXML
    Label quantity3;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane;


    public void initialize(){
        quantity1.setText(Integer.toString(DatabaseConnection.showProduct().get(0).getQuantity()));
        quantity2.setText(Integer.toString(DatabaseConnection.showProduct().get(1).getQuantity()));
        quantity3.setText(Integer.toString(DatabaseConnection.showProduct().get(2).getQuantity()));



    }
    @FXML
    private void loadConfirm(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Summary.fxml"));
        Scene scene = confirm.getScene();
        root.translateYProperty().set(scene.getHeight());

        ArrayList<Integer> quantity = new ArrayList<>();

        quantity.add(0,Integer.parseInt(quantity1.getText())-Integer.parseInt(show1.getText()));
        quantity.add(1,Integer.parseInt(quantity2.getText())-Integer.parseInt(show2.getText()));
        quantity.add(2,Integer.parseInt(quantity3.getText())-Integer.parseInt(show3.getText()));

        DatabaseConnection.shopUpdate(quantity);

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
