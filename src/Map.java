import javafx.scene.Group;
import javafx.scene.Parent;

public class Map {
    private Graph<Tile> graph = new Graph<>();
    private Group root;
    public Map(Group root) {
        this.root = root;
        graph.add(new Hall(100, 100, root));
        graph.add(new Hall(200, 100, root));
    }

    public void draw() {
        for (int i = 0; i < graph.size(); i++) {
            graph.getVerticeData(i).draw();
        }
    }

}
