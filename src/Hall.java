import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Hall extends Tile {
    //Group root;
    public Hall(int x, int y, Group root){
        setX(x);
        setY(y);
        //this.root = root;
        setRoot(root);
    }


    /*
    @Override
    public void draw() {
        Circle circle = new Circle(1, Color.BLUE);
        circle.setCursor(Cursor.MOVE);
        circle.setCenterX(getX());
        circle.setCenterY(getY());
        root.getChildren().addAll(circle);
    }
     */



}
