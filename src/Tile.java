import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Nile Cochen
 * The tile class forms a point on the map. The tiles are kept in a graph. Every tile can be drawn and has a position.
 * The tile is abstract because every tile must either be a hall or a room
 */
public abstract class Tile {
    private int x; // x coordinate of the tile
    private int y; // y coordinate of the tile
    private Group root; // copy of root

    /**
     * getter for x
     * @return returns x cord
     */
    public int getX() {
        return x;
    }

    /**
     * setter for root
     * @param root new root definition
     */
    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * getter for y
     * @return returns y cord
     */
    public int getY() {
        return y;
    }

    /**
     * setter for x
     * @param x new x definition
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter for y
     * @param y new y definition
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * drawStart draws a red circle at coordinates. Used to draw the tile the user is currently in.
     */
    public void drawStart() {
        Circle circle = new Circle(3, Color.RED);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }

    /**
     * drawEnd draws a blue circle at coordinates. Used to draw the tile the user is wants to go to.
     */
    public void drawEnd() {
        Circle circle = new Circle(3, Color.GREEN);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }
}
