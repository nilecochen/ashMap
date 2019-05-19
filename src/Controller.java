import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private static Group root;
    private static Parent layout;

    @FXML
    private Canvas canvas = new Canvas();
    @FXML
    private Button confirmDest;
    @FXML
    private Button confirmCurr;
    @FXML
    private Button reset;
    @FXML
    private TextField currentPos;
    @FXML
    private TextField dest;

    @FXML
    public void confirmCurrentPosition(ActionEvent event) {
        System.out.println("TADA!");
        GUI.setStart(currentPos.getText());
    }

    @FXML
    public void confirmDestination(ActionEvent event) {
        System.out.println("TADA!");
        GUI.setEnd(dest.getText());
    }

    @FXML
    public void reset(ActionEvent event) {
        root.getChildren().clear();
        root.getChildren().addAll(layout);
        GUI.setEnd("");
        GUI.setStart("");
        currentPos.setText("");
        dest.setText("");

    }

    public static void setRoot(Group root) {
        Controller.root = root;
    }

    public static void setLayout(Parent layout) {
        Controller.layout = layout;
    }
}
