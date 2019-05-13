import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Map {
    private Graph<Tile> graph = new Graph<>();
    private Group root;
    private ArrayList<Room> rooms = new ArrayList<>();
    public Map(Group root) {
        this.root = root;
        createMap();
    }

    public void draw() {
        for (int i = 0; i < graph.size(); i++) {
            graph.getVerticeData(i).draw();
        }
        drawLinks();


    }

    public void createMap() {
        //add halls
        graph.add(new Hall(370, 150, root)); //hall 1
        graph.add(new Hall(443, 150, root));
        graph.add(new Hall(476, 150, root));
        graph.add(new Hall(476, 162, root));
        graph.add(new Hall(510, 162, root)); //hall 5
        graph.add(new Hall(510, 150, root));
        graph.add(new Hall(405, 178, root));
        graph.add(new Hall(405, 265, root));
        graph.add(new Hall(405, 275, root));
        graph.add(new Hall(405, 359, root)); //hall 10
        graph.add(new Hall(405, 411, root));
        graph.add(new Hall(426, 411, root));
        graph.add(new Hall(426, 436, root));
        graph.add(new Hall(451, 436, root));
        graph.add(new Hall(451, 450, root)); //hall 15
        graph.add(new Hall(373, 429, root));
        graph.add(new Hall(306, 429, root));
        graph.add(new Hall(306, 448, root));
        graph.add(new Hall(262, 448, root));
        graph.add(new Hall(220, 448, root)); //hall 20
        graph.add(new Hall(209, 448, root));
        graph.add(new Hall(111, 448, root));
        graph.add(new Hall(111, 475, root));
        graph.add(new Hall(111, 510, root));
        graph.add(new Hall(111, 535, root)); //hall 25
        graph.add(new Hall(111, 552, root));
        graph.add(new Hall(111, 437, root));
        graph.add(new Hall(111, 344, root));
        graph.add(new Hall(111, 279, root));
        graph.add(new Hall(151, 245, root)); //hall 30
        graph.add(new Hall(220, 344, root));
        graph.add(new Hall(220, 303, root));
        graph.add(new Hall(288, 303, root));
        graph.add(new Hall(316, 339, root));
        graph.add(new Hall(405, 339, root)); //hall 35
        graph.add(new Hall(373, 519, root));
        graph.add(new Hall(322, 544, root));
        graph.add(new Hall(299, 572, root));
        graph.add(new Hall(299, 645, root));
        graph.add(new Hall(334, 675, root)); //hall 40
        graph.add(new Hall(393, 675, root));
        graph.add(new Hall(418, 675, root));
        graph.add(new Hall(473, 657, root));
        graph.add(new Hall(477, 566, root));
        graph.add(new Hall(455, 566, root)); //hall 45
        graph.add(new Hall(373, 543, root));
        graph.add(new Hall(345, 543, root));
        graph.add(new Hall(314, 577, root));
        graph.add(new Hall(314, 623, root));






        // Add Rooms

        rooms.add(new Room(443, 126, root, "heritage room"));
        graph.add(rooms.get(0));

        rooms.add(new Room(510, 130, root, "t101"));
        graph.add(rooms.get(1));

        rooms.add(new Room(527, 150, root, "t102"));
        graph.add(rooms.get(2));

        rooms.add(new Room(427, 178, root, "student services"));
        graph.add(rooms.get(3));

        rooms.add(new Room(385, 265, root, "110"));
        graph.add(rooms.get(4));

        rooms.add(new Room(385, 275, root, "111"));
        graph.add(rooms.get(5));

        rooms.add(new Room(385, 359, root, "114"));
        graph.add(rooms.get(6));

        rooms.add(new Room(268, 392, root, "128"));
        graph.add(rooms.get(7));

        rooms.add(new Room(151, 228, root, "learning strategist"));
        graph.add(rooms.get(8));

        rooms.add(new Room(90, 437, root, "228"));
        graph.add(rooms.get(9));

        rooms.add(new Room(44, 490, root, "227"));
        graph.add(rooms.get(10));

        rooms.add(new Room(92, 552, root, "226"));
        graph.add(rooms.get(11));

        rooms.add(new Room(135, 535, root, "225"));
        graph.add(rooms.get(12));

        rooms.add(new Room(209, 478, root, "224"));
        graph.add(rooms.get(13));

        rooms.add(new Room(220, 478, root, "223"));
        graph.add(rooms.get(14));

        rooms.add(new Room(262, 478, root, "222"));
        graph.add(rooms.get(15));

        rooms.add(new Room(306, 478, root, "221"));
        graph.add(rooms.get(16));

        rooms.add(new Room(358, 657, root, "theater"));
        graph.add(rooms.get(17));

        rooms.add(new Room(408, 767, root, "big gym"));
        graph.add(rooms.get(18));

        rooms.add(new Room(498, 566, root, "small gym"));
        graph.add(rooms.get(19));

        rooms.add(new Room(455, 529, root, "164"));
        graph.add(rooms.get(20));

        rooms.add(new Room(430, 450, root, "163"));
        graph.add(rooms.get(21));

        rooms.add(new Room(471, 450, root, "162"));
        graph.add(rooms.get(22));

        rooms.add(new Room(370, 130, root, "entrance"));
        graph.add(rooms.get(23));

        rooms.add(new Room(102, 315, root, "library"));
        graph.add(rooms.get(24));


        // Create Links between halls
        graph.link(1,2, 1);
        graph.link(2, 3, 1);
        graph.link(3, 4, 1);
        graph.link(4, 5, 1);
        graph.link(5, 6, 1);
        graph.link(1, 7, 1);
        graph.link(7, 8, 1);
        graph.link(8, 9, 1);
        graph.link(9, 35, 1);
        graph.link(35, 10, 1);
        graph.link(10, 11, 1);
        graph.link(11, 12, 1);
        graph.link(12, 13, 1);
        graph.link(13, 14, 1);
        graph.link(14, 15, 1);
        graph.link(11, 16, 1);
        graph.link(16, 17, 1);
        graph.link(17, 18, 1);
        graph.link(18, 19, 1);
        graph.link(19, 20, 1);
        graph.link(20, 21, 1);
        graph.link(21, 22, 1);
        graph.link(22, 23, 1);
        graph.link(23, 24, 1);
        graph.link(24, 25, 1);
        graph.link(25, 26, 1);
        graph.link(22, 27, 1);
        graph.link(27, 28, 1);
        graph.link(28, 29, 1);
        graph.link(29, 30, 1);
        graph.link(28, 31, 1);
        graph.link(31, 32, 1);
        graph.link(32, 33, 1);
        graph.link(33, 34, 1);
        graph.link(34, 35, 1);
        graph.link(16, 36, 1); //top terron to bottom terron
        graph.link(36, 37, 1);
        graph.link(37, 38, 1);
        graph.link(38, 39, 1);
        graph.link(39, 40, 1);
        graph.link(40, 41, 1);
        graph.link(41, 42, 1);
        graph.link(42, 43, 1);
        graph.link(43, 44, 1);
        graph.link(44, 45, 1);
        graph.link(36, 46, 1);
        graph.link(46, 47, 1);
        graph.link(47, 48, 1);
        graph.link(48, 49, 1);

        //Create links between halls and rooms
        graph.link(1, findRoom("entrance"), 1000);
        graph.link(2, findRoom("heritage room"), 1000);
        graph.link(6, findRoom("t101"), 1000);
        graph.link(6, findRoom("t102"), 1000);
        graph.link(7, findRoom("student services"), 1000);
        graph.link(8, findRoom("110"), 1000);
        graph.link(9, findRoom("111"), 1000);
        graph.link(10, findRoom("114"), 1000);
        graph.link(34, findRoom("128"), 1000);
        graph.link(31, findRoom("128"), 1000);
        graph.link(30, findRoom("learning strategist"), 1000);
        graph.link(28, findRoom("library"), 1000);
        graph.link(29, findRoom("library"), 1000);
        graph.link(23, findRoom("227"), 1000);
        graph.link(24, findRoom("227"), 1000);
        graph.link(26, findRoom("226"), 1000);
        graph.link(25, findRoom("225"), 1000);
        graph.link(25, findRoom("225"), 1000);
        graph.link(25, findRoom("225"), 1000);
        graph.link(25, findRoom("225"), 1000);
        graph.link(21, findRoom("224"), 1000);
        graph.link(20, findRoom("223"), 1000);
        graph.link(19, findRoom("222"), 1000);
        graph.link(18, findRoom("221"), 1000);
        graph.link(27, findRoom("228"), 1000);

        graph.link(15, findRoom("162"), 1000);
        graph.link(15, findRoom("163"), 1000);
        graph.link(45, findRoom("164"), 1000);
        graph.link(44, findRoom("small gym"), 1000);
        graph.link(49, findRoom("theater"), 1000);

        graph.link(42, findRoom("big gym"), 1000);
        graph.link(41, findRoom("big gym"), 1000);

























    }

    public Room findRoom(String id) {
        for(Room room: rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public void drawLinks() {
        /*
        ArrayList<Tile> points = new ArrayList<>();
        points = graph.getEdges();
        for (int i = 1; i < points.size(); i++) {
            if (i > 1) {
                if (points.get(i - 1) == points.get(i - 2)) {
                    continue;
                }
            }
            Line line = new Line(points.get(i-1).getX(), points.get(i-1).getY(), points.get(i).getX(), points.get(i).getY());
            line.setStroke(Color.GREEN);
            root.getChildren().add(line);
        }
        */
        ArrayList<Tile> path = graph.findPath(rooms.get(18), rooms.get(1));

        for (Tile step: path) {
            System.out.println(step.getX() + ", " + step.getY());

        }

        for (ArrayList<Tile> points: graph.getEdges()) {
            Line line = new Line(points.get(0).getX(), points.get(0).getY(), points.get(1).getX(), points.get(1).getY());
            line.setStroke(Color.GREEN);
            root.getChildren().add(line);
        }

        for (int i = 0; i < path.size() -1; i++)  {
            Line line = new Line(path.get(i).getX(), path.get(i).getY(), path.get(i+1).getX(), path.get(i+1).getY());
            line.setStroke(Color.RED);
            root.getChildren().add(line);
        }
    }

}
