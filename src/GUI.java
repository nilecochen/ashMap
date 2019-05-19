import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GUI extends Application {
    Scene scene;
    Parent layout;
    static Map map;

    static String start = "";
    static String end = "";


    //Button button;

    /*

    public GUI(String[] args) {
        launch(args);
    }

     */

    @FXML
    private Canvas canvas = new Canvas();
    @FXML
    private Button confirmCurr;



    public static void main(String[] args) {
        launch(args);
    }





    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world");
        Group root = new Group();


        /*
        Circle circle = new Circle(50, Color.BLUE);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(10);
        circle.setCenterY(10);
         */


        //GraphicsContext g = canvas.getGraphicsContext2D();
        //g.strokeRect(10, 20, 20, 20);




        //button = new Button();
        //StackPane layout = new StackPane();
        layout = FXMLLoader.load(getClass().getResource("layout.fxml"));
        root.getChildren().addAll(layout);
        //root.getChildren().addAll(circle);


        Controller.setRoot(root);
        Controller.setLayout(layout);



        map = new Map(root);
        //map.draw();
        //layout.getChildrenUnmodifiable().addAll();

        //layout.getChildren().add(button);

        scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();

        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("x: " + event.getX() + " y: " + event.getY());

            }
        });
    }


    @FXML
    public void buttonPress(ActionEvent event) {
        System.out.println("TADA!");
    }
    /*

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("x: " + event.getX() + " y: " + event.getY());
        }
    };

     */

    public static void setStart(String start) {
        GUI.start = start;
        pathFind();

    }

    public static void setEnd(String end) {
        GUI.end = end;
        pathFind();
    }

    private static void pathFind() {
        if (!end.equals("") && !start.equals("")) {
            map.drawLinks(start, end);
        }
    }

    public static String getStart() {
        return start;
    }

    public static String getEnd() {
        return end;
    }
}
