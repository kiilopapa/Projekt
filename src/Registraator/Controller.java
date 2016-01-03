package Registraator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by kristjan on 13/12/15.
 */
public class Controller {
    Stage stage = new Stage();
    BorderPane mainPane;
    GridPane midPane;
    VBox leftPane;
    Button viewVisitors;
    Button checkInVisitor;
    Button checkOutVisitor;
    Button viewHosts;
    Button addHosts;

    int rows = 3;
    int columns = 4;


    public Controller() {
        setupScene();
        stage.show();
    }

    private void setupScene() {
        mainPane = new BorderPane();
        midPane = new GridPane();
        leftPane = new VBox();
        setupMidPane();
        setupLeftPane();
        mainPane.setCenter(midPane);
        mainPane.setLeft(leftPane);
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> System.exit(0));

    }

    private void setupLeftPane() {
        viewVisitors = new Button("View Visitors");
        viewVisitors.setPrefSize(100, 50);
        checkInVisitor = new Button("Check In");
        checkInVisitor.setPrefSize(100, 50);
        checkOutVisitor = new Button("Check out");
        checkOutVisitor.setPrefSize(100, 50);
        viewHosts = new Button("View Hosts");
        viewHosts.setPrefSize(100, 50);
        addHosts = new Button("Add Hosts");
        addHosts.setPrefSize(100, 50);

        leftPane.getChildren().addAll(viewVisitors, checkInVisitor, checkOutVisitor, viewHosts, addHosts);



    }

    private void setupMidPane() {
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < columns; j++) {
                Label info = new Label();
                info.setPrefWidth(150);
                info.setWrapText(true);
                midPane.add(info, j, i);
            }

        }
        midPane.setGridLinesVisible(true);

    }

}
