package Registraator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Created by kristjan on 13/12/15.
 */
public class Controller {
    Stage stage = new Stage();
    BorderPane mainPane;
    GridPane viewVisitorsPane;
    TilePane addHostPane;
    VBox leftPane;
    Button viewVisitors;
    Button checkInVisitor;
    Button checkOutVisitor;
    Button viewHosts;
    Button addHosts;

    int rows = 3;
    int columns = 4;


    public Controller() {
        setupScene("");
        addHosts();

        stage.show();
    }

    private void setupScene(String mid) {
        mainPane = new BorderPane();
        leftPane = new VBox();
        setupViewVisitorsPane();
        setupLeftPane();
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

/*    private void setupMidPane(String mid) {
        switch (mid){
            case "":
            case "viewVisitors":
                viewVisitorsPane();
                mainPane.setCenter(viewVisitorsPane);
                break;
            case "addHosts":
                addHostPane();
                mainPane.setCenter(addHostPane);
                break;
        }
    }
*/


    private void setupViewVisitorsPane() {
        viewVisitorsPane = new GridPane();
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < columns; j++) {
                Label info = new Label();
                info.setPrefWidth(150);
                info.setWrapText(true);
                viewVisitorsPane.add(info, j, i);
            }
        }
        viewVisitorsPane.setGridLinesVisible(true);
        mainPane.setCenter(viewVisitorsPane);
    }

    private void addHosts(){
        addHosts.setOnAction(event -> {
            System.out.println("vajutasid add hosts");
            Host host = new Host();
            //setupScene("addHosts");
            setupAddHostPane();
            mainPane.setCenter(addHostPane);
            stage.show();
        });
    }

    private void setupAddHostPane() {
        addHostPane = new TilePane();
        addHostPane.setPrefColumns(2);
        TextField nameTextField = new TextField();
        addHostPane.getChildren().addAll(nameTextField);
    }
}
