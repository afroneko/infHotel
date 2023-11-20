package com.lisa.infhotel;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FlowPane root = new FlowPane();

        FlowPane sidebar = new FlowPane();
        sidebar.setPrefWidth(100);
        sidebar.setPrefHeight(600);
        sidebar.setStyle("-fx-background-color: #ffbb99");

        TextField text =  new TextField();

        double sidebarWidth = sidebar.getPrefWidth();
        Label label = new Label("LogoHere");
        label.setPrefSize(sidebarWidth, 50);
        label.setStyle("-fx-background-color: #ffffff");
        label.setAlignment(Pos.CENTER);


        sidebar.getChildren().add(label);
        root.getChildren().add(sidebar);
        root.getChildren().add(text);

        Scene scene = new Scene(root, 1024, 600);
        stage.setTitle("infHotel");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}