package Registraator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by kristjan on 10/01/16.
 */
public class Confirmprompt {

    Button okButton;
    Button cancelButton;

    Stage stage = new Stage();




    public Confirmprompt(String prompt){
        setupScene(prompt);

    }

    private void setupScene(String prompt) {
        GridPane layout = new GridPane();
        Scene scene = new Scene(layout, 300, 100);
        Label activityLabel = new Label(prompt);
        okButton = new Button("OK");
        cancelButton = new Button("Cancel");

        layout.add(activityLabel, 0, 0);
        layout.add(okButton, 0, 1);
        layout.add(cancelButton, 1, 1);
        layout.setVgap(50);




        stage.setScene(scene);
        stage.show();

    }


}
