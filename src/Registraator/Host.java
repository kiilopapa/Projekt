package Registraator;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * Created by kristjan on 05/01/16.
 */
public class Host {
    GridPane addHostPane;
    Button addingButton;


    private String givenName;
    private String surName;
    private Button updateButton;

    public Host() {
        setupAddHostPane();


    }


    private void setupAddHostPane() {
        addHostPane = new GridPane();
        Label firstNameLabel = new Label("First Name");
        addHostPane.add(firstNameLabel, 0, 1);
        Label familyNameLabel = new Label("Family Name");
        addHostPane.add(familyNameLabel, 2, 1);
        TextField nameTextField = new TextField();
        addHostPane.add(nameTextField, 1, 1);
        TextField surNameTextField = new TextField();
        addHostPane.add(surNameTextField, 3, 1);
        addingButton = new Button("add");
        addHostPane.add(addingButton, 3, 4);
        addHostPane.setVgap(10);
        addHostPane.setHgap(10);

        addingButton.setOnAction(event -> {
            HashMap<String, String> data = new HashMap<String, String>();
            data.put("firstName", firstNameLabel.getText());
            data.put("familyName", familyNameLabel.getText());

            Database d = new Database();
            d.addHost(data);
            d.closeConnection();

        });
    }



    }

