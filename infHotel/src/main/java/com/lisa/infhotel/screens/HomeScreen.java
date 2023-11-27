package com.lisa.infhotel.screens;

import com.lisa.infhotel.enums.PaymentStatus;
import com.lisa.infhotel.models.Reservation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomeScreen {

  private Scene scene;
  private FlowPane sidebar;
  private FlowPane menu;

  public HomeScreen() {
    Pane root = new Pane();
    scene = new Scene(root, 1024, 600);

    sidebar = new FlowPane();
    sidebar.setStyle("-fx-background-color: #ffbb99");
    sidebar.setPrefSize(140, scene.getHeight());
    sidebar.setMaxSize(140, scene.getHeight());
    sidebar.setOrientation(Orientation.VERTICAL);



    double sidebarWidth = sidebar.getPrefWidth();
    Label logo = new Label("InfHotel");
    logo.setPrefSize(sidebar.getMaxWidth(), 50);
    logo.setStyle("-fx-background-color: #ffffff");
    logo.setAlignment(Pos.CENTER);

    menu = new FlowPane();
    menu.setStyle("-fx-background-color: #fff000");
    menu.setMaxSize(sidebar.getMaxWidth(), 300);

    for(int i=0; i<5; i++) {
      generateMenuItem("Menu Item" + i);
    }

    double whitespace = scene.getWidth() - sidebar.getMaxWidth();

    ScrollPane scrollPane = new ScrollPane();
    scrollPane.setStyle("-fx-background-color: #ff00ff");
    scrollPane.relocate(sidebar.getMaxWidth(), 50);
    scrollPane.setPrefSize(whitespace / 2, scene.getHeight() - scrollPane.getTranslateY());

    VBox content = new VBox(10);
    content.setPrefWidth(whitespace / 2);
    content.getChildren().addAll(
            new Reservation("John", "Doe", PaymentStatus.PAYED, null, 404).show(),
            new Reservation("Lisa", "Tyem", PaymentStatus.PARTIALLY_PAYED, null, 406).show(),
            new Reservation("Jinte", "van Oers", PaymentStatus.RESERVED, null, 410).show(),
            new Reservation("Ruben", "Kolijn", PaymentStatus.PARTIALLY_PAYED, null, 415).show(),
            new Reservation("Esther", "Zygmuntoicz", PaymentStatus.RESERVED, null, 412).show(),
            new Reservation("Lina", "Hoefman", PaymentStatus.PAYED, null, 414).show()
    );

    scrollPane.setContent(content);
    sidebar.getChildren().addAll(logo, menu);
    root.getChildren().addAll(sidebar, scrollPane);
  }

  public void generateMenuItem(String title) {
    FlowPane menuItem = new FlowPane();
    menuItem.setStyle("-fx-background-color: #00fc03");
    menuItem.setPrefSize(sidebar.getMaxWidth(), sidebar.getMaxWidth()-30);

    Pane activeIndicator = new Pane();
    activeIndicator.setStyle("-fx-background-color: #ff0000");
    activeIndicator.setPrefSize(10, menuItem.getPrefHeight());

    FlowPane itemInfo = new FlowPane();
    itemInfo.setStyle("-fx-background-color: #ffff00");
    itemInfo.setPrefSize(menuItem.getPrefWidth() - activeIndicator.getPrefWidth(), menuItem.getPrefHeight());

    Text itemName = new Text(title);
    itemName.setStyle("-fx-font-size: 20px");

    itemInfo.getChildren().add(itemName);

    menuItem.getChildren().addAll(activeIndicator, itemInfo);
    menu.getChildren().addAll(menuItem);
  }

  public Scene getScene() {
    return scene;
  }
}
