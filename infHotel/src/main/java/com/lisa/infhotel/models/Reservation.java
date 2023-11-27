package com.lisa.infhotel.models;

import com.lisa.infhotel.enums.PaymentStatus;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.Date;

public class Reservation {

  private String firstName;
  private String lastName;
  private PaymentStatus status;
  private Date checkInDate;
  private int roomNumber;


  public Reservation(String firstName, String lastName, PaymentStatus status, Date checkInDate, int roomNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.checkInDate = checkInDate;
    this.roomNumber = roomNumber;

  }

  public String getLastName() {
    return lastName;
  }

  public FlowPane show(){
    FlowPane reservation = new FlowPane();
    Label fullName = new Label(firstName + " " + lastName);
    
    reservation.setPrefHeight(120);
    reservation.getChildren().add(fullName);

    /*
    if(status == PaymentStatus.PAYED) {
      reservation.setStyle("-fx-background-color: #00fc03");
    } else if (status == PaymentStatus.PARTIALLY_PAYED) {
      reservation.setStyle("-fx-background-color: #0000ff");
    } else {
      reservation.setStyle("-fx-background-color: #ff9900");
    }
     */

    //Een enum is perfect om een switch bij te gebruiken

    switch (status) {
      case PAYED:
        reservation.setStyle("-fx-background-color: #00fc03");
        break;
      case PARTIALLY_PAYED:
        reservation.setStyle("-fx-background-color: #0000ff");
        break;
      case RESERVED:
        reservation.setStyle("-fx-background-color: #ff9900");
        break;
    }

    return reservation;
  }
}
