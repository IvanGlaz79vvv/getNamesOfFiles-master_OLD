//package org.fx;
//
//import javafx.application.Application;
//import javafx.geometry.Orientation;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.FlowPane;
//import javafx.stage.Stage;
//
//public class HelloApplication extends Application {
//    public static void main(String[] args) {
//        launch();
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//
//        Label lbl = new Label();
//        TextField textField = new TextField();
//        textField.setPrefColumnCount(11);
//        Button btn = new Button("Click");
//        btn.setOnAction(event -> lbl.setText("Input: " + textField.getText()));
//        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, textField, btn, lbl);
//        Scene scene = new Scene(root, 250, 200);
//
//        stage.setScene(scene);
//        stage.setTitle("TextField in JavaFX");
//        stage.show();
//    }
//
//
//}