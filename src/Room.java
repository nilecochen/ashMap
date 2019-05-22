import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Nile Cochen
 * The room is an extension of the tile class. The purpose of the room is to have an ID
 */
public class Room extends Tile {
    private String id; //Identification String used to identify String

    /**
     * Constructor defines x, y, root, and String
     * @param x x definition
     * @param y y definition
     * @param root root definition
     * @param id id definition
     */
    public Room(int x, int y, Group root, String id) {
        setX(x);
        setY(y);
        setRoot(root);
        this.id = id;
    }

    /**
     * getter for id
     * @return returns id
     */
    public String getId() {
        return id;
    }
}
