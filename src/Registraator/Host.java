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


    String firstName;
    String familyName;

    public Host() {
        setupAddHostPane();
    }

    public void setupViewHostsPane() {
        viewHostPane = new GridPane();
        Database d = new Database();
        ArrayList data;
        data = d.getHosts();
        d.closeConnection();

        //Label firstName = new Label();
        //Label familyName;
        for (int i = 0; i < data.size(); i++) {
            //HashMap<String, String> hash =new HashMap<String, String>();
            HashMap hash = new HashMap();
            hash = (HashMap) data.get(i);
            System.out.println(hash);
            //System.out.println(i);
            for (int j = 0; j < hash.size(); j++) {
                Label info = new Label((String) hash.get(j));
                //System.out.println(info.getText());
                viewHostPane.add(info, j, i);
            }
        }
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

