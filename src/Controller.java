import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private static Group root;
    private static Parent layout;

    /*
    @FXML
    private Canvas canvas = new Canvas();
    @FXML
    private Button confirmDest;
    @FXML
    private Button confirmCurr;
    @FXML
    private Button reset;
     */
    @FXML
    private TextField currentPos;
    @FXML
    private TextField dest;
    @FXML
    private Label message;

    private static Label staticMessage; //Static copy of message so other classes can access message without initialising Controller

    /*
    @FXML
    public void confirmCurrentPosition(ActionEvent event) {
        //System.out.println("TADA!");
        GUI.setStart(currentPos.getText());
        GUI.pathFind();

    }

    @FXML
    public void confirmDestination(ActionEvent event) {
        //System.out.println("TADA!");
        GUI.setEnd(dest.getText());
        GUI.pathFind();
    }

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

    @FXML
    public void findPathBtn(ActionEvent event) {
        staticMessage = message; //staticMessage copied here because Controller is never initialised so constructor would never be called. Action listeners are the only way to access non-static objects
        root.getChildren().clear();
        root.getChildren().addAll(layout);
        GUI.setStart(currentPos.getText());
        GUI.setEnd(dest.getText());
        GUI.pathFind();
    }


    public static void setRoot(Group root) {
        Controller.root = root;
    }

    public static void setLayout(Parent layout) {
        Controller.layout = layout;
    }

    public static Label getStaticMessage() {
        return staticMessage;
    }

    /*
    public static void transferMessage() {
        GUI.setMessage(message);
    }

     */

    /*public static void setMessageText(String messageText) {
        System.out.println(message.getText());
        //message.setText("");
    }
     */

}