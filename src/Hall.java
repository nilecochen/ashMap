import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Nile Cochen
 * Extension of hall. Functionally the same as the tile. Made to differentiate between Room and Tile
 */
public class Hall extends Tile {
    /**
     * Constructor defines all objects of Tile
     * @param x x definition
     * @param y y definition
     * @param root root definition
     */
    public Hall(int x, int y, Group root){
        setX(x);
        setY(y);
        setRoot(root);
    }

}
