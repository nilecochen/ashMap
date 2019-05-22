import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Nile Cochen
 * The GUI class is in charge of creating and configuring the scene and stage. It is also the driver that creates the
 * map.
 */
public class GUI extends Application {
    private Scene scene;
    private Parent layout; //layout fxml
    private static Map map; //Copy of map
    private static String start = ""; //string that holds the id for the room the user is currently in
    private static String end = ""; //string that holds the id for the room the user wants to go to

    /**
     * Main method calls launch
     * @param args not used
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Functions as the main method. Configures the scene, layout, root and stage.
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ash Maps");
        Group root = new Group();

        layout = FXMLLoader.load(getClass().getResource("layout.fxml"));
        root.getChildren().addAll(layout);

        Controller.setRoot(root);
        Controller.setLayout(layout);


        map = new Map(root);;

        scene = new Scene(root, 1000, 1000);
        stage.setScene(scene);
        stage.show();

    }


    /**
     * setter for Start
     * @param start new start definition
     */
    public static void setStart(String start) {
        GUI.start = start;
    }

    /**
     * setter for End
     * @param end new end definition
     */
    public static void setEnd(String end) {
        GUI.end = end;
    }

    /**
     * calls map.drawLinks if end and start are not empty Strings
     */
    public static void pathFind() {
        if (!end.equals("") && !start.equals("")) {
            map.drawLinks(start, end);
        }
    }
}
