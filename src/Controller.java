import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Nile Cochen
 * The Controller class handles input from the stage.
 */
public class Controller {
    private static Group root; //Copy of root from GUI
    private static Parent layout; //Copy of Layout from GUI
    @FXML
    private TextField currentPos; //TextField used to find id of start room
    @FXML
    private TextField dest; //TestField used to find id of end room
    @FXML
    private Label message; //Label used to display messages
    private static Label staticMessage; //Static copy of message so other classes can access message without initialising Controller

    /**
     * Called when reset button is pressed. Removes all lines and dots from root, clears text in TextFields and
     * message:Label. Calls setStart and setEnd with empty Strings.
     * @param event
     */
    @FXML
    public void reset(ActionEvent event) {
        root.getChildren().clear();
        root.getChildren().addAll(layout);
        message.setText("");
        GUI.setEnd("");
        GUI.setStart("");
        currentPos.setText("");
        dest.setText("");
    }

    /**
     * Called when findPath:Button pressed. Removes all lines and dots from the root. Calls setStart and setEnd with
     * text from the currentPos and dest Textfields.
     * @param event
     */
    @FXML
    public void findPathBtn(ActionEvent event) {
        staticMessage = message; //staticMessage copied here because Controller is never initialised so constructor would never be called. Action listeners are the only way to access non-static objects
        root.getChildren().clear();
        root.getChildren().addAll(layout);
        GUI.setStart(currentPos.getText());
        GUI.setEnd(dest.getText());
        GUI.pathFind();
    }

    /**
     * setter for root
     * @param root Group that this.root is set to
     */
    public static void setRoot(Group root) {
        Controller.root = root;
    }

    /**
     * setter for layout
     * @param layout Parent that this.layout is set to
     */
    public static void setLayout(Parent layout) {
        Controller.layout = layout;
    }

    /**
     * getter for the staticMessage
     * @return returns Static message
     */
    public static Label getStaticMessage() {
        return staticMessage;
    }

}