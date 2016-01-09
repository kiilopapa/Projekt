package Registraator;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * Created by kristjan on 13/12/15.
 */
public class Visitor {
    GridPane checkInPane;
    Button checkInButton;
    double prefWidth = 150;
    double prefHeight = 50;

    public void setupCheckInPane() {
        checkInPane = new GridPane();
        Label firstNameLabel = new Label("First Name");
        checkInPane.add(firstNameLabel, 1, 1);
        TextField nameTextField = new TextField();
        checkInPane.add(nameTextField, 2, 1);
        Label familyNameLabel = new Label("Family Name");
        checkInPane.add(familyNameLabel, 1, 2);
        TextField surNameTextField = new TextField();
        checkInPane.add(surNameTextField, 2, 2);
        Label visitorCardLabel = new Label("Card Nr");
        checkInPane.add(visitorCardLabel, 1, 3);
        TextField visitorCardTextField = new TextField();
        checkInPane.add(visitorCardTextField, 2,3);

        ChoiceBox hostChoiceBox = new ChoiceBox();
        ArrayList hosts;
        //Database d = new Database();
        //hosts = d.getNamesOfHosts() ;
        FXCollections.observableArrayList();

        hostChoiceBox.itemsProperty();

        checkInButton = new Button("Register");
        checkInPane.add(checkInButton, 3, 4);
        checkInPane.setVgap(10);
        checkInPane.setHgap(10);

    }
}
