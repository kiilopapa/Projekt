package Registraator;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by kristjan on 13/12/15.
 */
public class Visitor {
    String firstName;
    String familyname;
    String cardNumber;
    String hostToVisit;
    GridPane checkInPane;
    GridPane viewVisitorsPane;
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
        checkInPane.add(visitorCardTextField, 2, 3);

        Label choiceBoxLabel = new Label("Host To Visit");
        checkInPane.add(choiceBoxLabel, 1, 4);
        ChoiceBox hostChoiceBox;
        ArrayList hosts;
        ArrayList checkBoxList = new ArrayList();
        Database d = new Database();
        hosts = d.getHosts();
        System.out.println(hosts.toString());
        for (int i = 0; i < hosts.size(); i++) {
            HashMap<String, String> hash;
            hash = (HashMap<String, String>) hosts.get(i);
            //System.out.println(hash);
            checkBoxList.add(String.valueOf(hash.get("firstName") + " " + hash.get("familyName")));
            //System.out.println(i);
        }
        System.out.println(checkBoxList.toString());
        //Collections.sort(checkBoxList);

        hostChoiceBox = new ChoiceBox(FXCollections.observableArrayList(checkBoxList));
        checkInPane.add(hostChoiceBox, 2, 4);



        checkInButton = new Button("Register");
        checkInPane.add(checkInButton, 3, 4);

        checkInButton.setOnAction(event -> {
            firstName = nameTextField.getText();
            familyname = surNameTextField.getText();
            cardNumber = visitorCardTextField.getText();
            hostToVisit = hostChoiceBox.getValue().toString();

            HashMap<String, String> data = new HashMap<String, String>();
            data.put("firstName", firstName);
            data.put("familyName", familyname);
            data.put("cardNumber", cardNumber);
            data.put("hostToVisit", hostToVisit);

            d.addVisitor(data);
            d.closeConnection();



        });

        checkInPane.setVgap(10);
        checkInPane.setHgap(10);

    }

    public void setupViewVisitorsPane() {
        viewVisitorsPane = new GridPane();
        viewVisitorsPane.setGridLinesVisible(true);

        Database d = new Database();
        ArrayList data;
        data = d.getVisitors();
        d.closeConnection();

        for (int i = 0; i <data.size(); i++) {
            HashMap<String, String> hash;
            hash = (HashMap<String, String>) data.get(i);
            System.out.println(hash);
            System.out.println(i);
            Label label0 = new Label(String.valueOf(i));
            label0.setPrefSize(20, prefHeight);
            viewVisitorsPane.add(label0, 0, i);
            Label label1 = new Label(hash.get("firstName"));
            label1.setPrefSize(prefWidth, prefHeight);
            viewVisitorsPane.add(label1, 1, i );
            Label label2 =new Label(hash.get("familyName"));
            label2.setPrefSize(prefWidth, prefHeight);
            viewVisitorsPane.add(label2, 2, i);
            Label label3 = new Label(hash.get("cardNumber"));
            label3.setPrefSize(prefWidth, prefHeight);
            viewVisitorsPane.add(label3, 3, i);
            Label label4 = new Label(hash.get("hostToVisit"));
            label4.setPrefSize(prefWidth, prefHeight);
            viewVisitorsPane.add(label4, 4, i);
        }

    }
}
