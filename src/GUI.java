import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {

    //Button button;
    /*
    public GUI(String[] args) {
        launch(args);
    }
    */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world");
        //button = new Button();
        //StackPane layout = new StackPane();
        Parent layout = FXMLLoader.load(getClass().getResource("layout.fxml"));

        //layout.getChildren().add(button);

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }
}
