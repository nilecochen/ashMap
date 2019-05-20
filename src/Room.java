import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Room extends Tile {
    private String id;
    //private Group root;


    public Room(int x, int y, Group root, String id) {
        setX(x);
        setY(y);
        setRoot(root);
        //this.root = root;
        this.id = id;
    }

    /*
    public void setId(String id) {
        this.id = id;
    }

     */

    public String getId() {
        return id;
    }

    /*
    @Override
    public void draw() {
        Circle circle = new Circle(1, Color.RED);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }
     */
}
