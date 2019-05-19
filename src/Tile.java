import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class Tile {
    private int x;
    private int y;
    private Group root;

    public int getX() {
        return x;
    }

    public void setRoot(Group root) {
        this.root = root;
    }



    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void drawStart() {
        Circle circle = new Circle(3, Color.RED);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }

    public void drawEnd() {
        Circle circle = new Circle(3, Color.GREEN);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }
}
