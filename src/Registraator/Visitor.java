package Registraator;

import javafx.collections.FXCollections;
import javafx.scene.Node;
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
        selectFromVieWVisitors();

        Label label00 = new Label("#");
        Label label10 = new Label("Firstname");
        Label label20 = new Label("Familyname");
        Label label30 = new Label("Visitorscard nr");
        Label label40 = new Label("Host");
        viewVisitorsPane.add(label00, 0,0);
        viewVisitorsPane.add(label10, 1,0);
        viewVisitorsPane.add(label20, 2,0);
        viewVisitorsPane.add(label30, 3,0);
        viewVisitorsPane.add(label40, 4,0);

        Database d = new Database();
        ArrayList data;
        data = d.getVisitors();
        d.closeConnection();

        for (int i = 0; i <data.size(); i++) {
            HashMap<String, String> hash;
            hash = (HashMap<String, String>) data.get(i);
            //System.out.println(hash);
            //System.out.println(i);
            int row = i+1;

            String labelId = i + " " + hash.get("firstName") + " " + hash.get("familyName") +
                    " " + hash.get("hostToVisit");
            Label label0 = new Label(String.valueOf(i));
            label0.setPrefSize(prefWidth, prefHeight);
            label0.setId(labelId);
            viewVisitorsPane.add(label0, 0, row);
            Label label1 = new Label(hash.get("firstName"));
            label1.setPrefSize(prefWidth, prefHeight);
            label1.setId(labelId);
            viewVisitorsPane.add(label1, 1, row );
            Label label2 =new Label(hash.get("familyName"));
            label2.setPrefSize(prefWidth, prefHeight);
            label2.setId(labelId);
            viewVisitorsPane.add(label2, 2, row);
            Label label3 = new Label(hash.get("cardNumber"));
            label3.setPrefSize(prefWidth, prefHeight);
            label3.setId(labelId);
            viewVisitorsPane.add(label3, 3, row);
            Label label4 = new Label(hash.get("hostToVisit"));
            label4.setPrefSize(prefWidth, prefHeight);
            label4.setId(labelId);
            viewVisitorsPane.add(label4, 4, row);
        }

    }

    public void selectFromVieWVisitors() {
        viewVisitorsPane.setOnMouseClicked(event -> {
            try {
                Label label = (Label) event.getTarget();
                String id = label.getId();
                System.out.println(id);


                //Collection labels = viewVisitorsPane.getChildren();
                /*for (Node node : viewVisitorsPane.getChildren() ) {
                    String s = node.getId();
                    System.out.println(s);
                    System.out.println(id);
                    if (s.equals(id)){
                        System.out.println("olema");
                    }else {
                        System.out.println("muu");
                    }

                }
                */

                //int firstnameIndex = (Integer.parseInt(row)*5 + 2);
                //int familyNameIndex = (Integer.parseInt(row)*5 + 3);
                //System.out.println(viewVisitorsPane.getChildren().get(firstnameIndex).toString());
                //System.out.println(familyNameIndex);
            } catch (Exception e){}
        });
    }
}
