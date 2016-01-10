package Registraator;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kristjan on 05/01/16.
 */
public class Host {
    GridPane addHostPane;
    GridPane viewHostPane;
    Button addingButton;
    double prefWidth = 150;
    double prefHeight = 50;


    String firstName;
    String familyName;


    public void setupViewHostsPane() {
        viewHostPane = new GridPane();
        viewHostPane.setGridLinesVisible(true);
        Database d = new Database();
        ArrayList data;
        data = d.getHosts();
        d.closeConnection();
        //Label firstName = new Label();
        //Label familyName;
        for (int i = 0; i < data.size(); i++) {
            HashMap<String, String> hash;
            hash = (HashMap<String, String>) data.get(i);
            System.out.println(hash);
            //System.out.println(i);
            Label label0 = new Label(String.valueOf(i));
            label0.setMinSize(prefWidth, prefHeight);
            viewHostPane.add(label0, 0, i);
            Label label1 = new Label(hash.get("firstName"));
            label1.setMinSize(prefWidth, prefHeight);
            viewHostPane.add(label1, 1, i );
            Label label2 =new Label(hash.get("familyName"));
            label2.setMinSize(prefWidth, prefHeight);
            viewHostPane.add(label2, 2, i);
            }
    }


    public void setupAddHostPane() {
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

            firstName = nameTextField.getText();
            familyName = surNameTextField.getText();
            HashMap<String, String> data = new HashMap<String, String>();
            data.put("firstName", firstName);
            data.put("familyName", familyName);

            Database d = new Database();
            d.addHost(data);
            d.closeConnection();

        });
    }



    }

