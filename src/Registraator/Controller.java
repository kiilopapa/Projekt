package Registraator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Created by kristjan on 13/12/15.
 */
public class Controller {
    Stage stage = new Stage();
    BorderPane mainPane;
    GridPane viewVisitorsPane;
    //GridPane addHostPane;
    VBox leftPane;
    Button viewVisitors;
    Button checkInVisitor;
    Button checkOutVisitor;
    Button viewHosts;
    Button addHosts;
    //Button addingButton;

    int rows = 3;
    int columns = 4;
    double prefWidth = 150;
    double prefHeight = 50;



    public Controller() {

        setupScene();

        viewVisitors();
        checkInVisitor();
        addHosts();
        viewHosts();

        Visitor v = new Visitor();
        v.setupViewVisitorsPane();

        stage.show();
    }


    private void setupScene() {
        mainPane = new BorderPane();
        leftPane = new VBox();
        setupLeftPane();
        mainPane.setLeft(leftPane);
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> System.exit(0));

    }

    private void setupLeftPane() {
        viewVisitors = new Button("View Visitors");
        viewVisitors.setPrefSize(prefWidth, prefHeight);
        checkInVisitor = new Button("Check In");
        checkInVisitor.setPrefSize(prefWidth, prefHeight);
        checkOutVisitor = new Button("Check out");
        checkOutVisitor.setPrefSize(prefWidth, prefHeight);
        viewHosts = new Button("View Hosts");
        viewHosts.setPrefSize(prefWidth, prefHeight);
        addHosts = new Button("Add Hosts");
        addHosts.setPrefSize(prefWidth, prefHeight);

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

    private void viewVisitors() {
        viewVisitors.setOnAction(event -> {
            System.out.println("vajutasid view visitors");
            Visitor visitor = new Visitor();
            visitor.setupViewVisitorsPane();
            mainPane.setCenter(viewVisitorsPane);
            stage.show();
        });
    }


    private void checkInVisitor() {
        checkInVisitor.setOnAction(event -> {
            System.out.println("vajutasid check in");
            Visitor visitor = new Visitor();
            visitor.setupCheckInPane();
            mainPane.setCenter(visitor.checkInPane);
            stage.show();
        });

    }

    private void addHosts(){
        addHosts.setOnAction(event -> {
            System.out.println("vajutasid add hosts");
            Host host = new Host();
            host.setupAddHostPane();
            mainPane.setCenter(host.addHostPane);
            stage.show();
        });
    }

    private void viewHosts (){
        viewHosts.setOnAction(event -> {
            System.out.println("vajutasid nuppu view hosts");
            Host host = new Host();
            host.setupViewHostsPane();
            mainPane.setCenter(host.viewHostPane);
            stage.show();
        });
    }

}
