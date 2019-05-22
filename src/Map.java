import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

/**
 * @author Nile Cochen
 * The map class holds and creates the graph. It creates all rooms and halls.
 */
public class Map {
    private Graph<Tile> graph = new Graph<>(); // The graph holds all tiles
    private Group root; // Copy of root for drawing
    private ArrayList<Room> rooms = new ArrayList<>(); //Holds all rooms outside of graph so they are easily accessible

    /**
     * Constructor for map defines root and calls create map
     * @param root definition of root
     */
    public Map(Group root) {
        this.root = root;
        createMap();
    }

    /**
     * createMap adds all extensions of Tile, and links all rooms and halls. Rooms are never linked to other rooms.
     */
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
        graph.link(1,2, 73);
        graph.link(2, 3, 33);
        graph.link(3, 4, 12);
        graph.link(4, 5, 34);
        graph.link(5, 6, 12);
        graph.link(1, 7, 44);
        graph.link(7, 8, 87);
        graph.link(8, 9, 10);
        graph.link(9, 35, 64);
        graph.link(35, 10, 20);
        graph.link(10, 11, 52);
        graph.link(11, 12, 21);
        graph.link(12, 13, 25);
        graph.link(13, 14, 25);
        graph.link(14, 15, 14);
        graph.link(11, 16, 36);
        graph.link(16, 17, 67);
        graph.link(17, 18, 19);
        graph.link(18, 19, 44);
        graph.link(19, 20, 42);
        graph.link(20, 21, 11);
        graph.link(21, 22, 98);
        graph.link(22, 23, 27);
        graph.link(23, 24, 35);
        graph.link(24, 25, 25);
        graph.link(25, 26, 17);
        graph.link(22, 27, 11);
        graph.link(27, 28, 93);
        graph.link(28, 29, 65);
        graph.link(29, 30, 52);
        graph.link(28, 31, 109);
        graph.link(31, 32, 41);
        graph.link(32, 33, 68);
        graph.link(33, 34, 45);
        graph.link(34, 35, 89);
        graph.link(16, 36, 90); //top terron to bottom terron
        graph.link(36, 37, 56);
        graph.link(37, 38, 36);
        graph.link(38, 39, 73);
        graph.link(39, 40, 46);
        graph.link(40, 41, 59);
        graph.link(41, 42, 25);
        graph.link(42, 43, 57);
        graph.link(43, 44, 91);
        graph.link(44, 45, 22);
        graph.link(36, 46, 24);
        graph.link(46, 47, 28);
        graph.link(47, 48, 46);
        graph.link(48, 49, 46);

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

    /**
     * Finds a room in the rooms ArrayList from room id
     * @param id id of Room being searched for
     * @return returns room with matching id
     */
    public Room findRoom(String id) {
        for(Room room: rooms) { //Linear search used because there is nothing that rooms can be compared to (they can't be sorted)
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Searches to see if rooms contains a room with specific id
     * @param id id to search for
     * @return true if matching room is found, false if matching room isn't found
     */
    public boolean hasRoom(String id) {
        for(Room room: rooms) { //Linear search used because there is nothing that rooms can be compared to (they can't be sorted)
            if (room.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Draws path between room with id matching start and id matching end
     * @param start id of current room
     * @param end id of destination room
     */
    public void drawLinks(String start, String end) {

        Label message = Controller.getStaticMessage(); //message is displayed giving information on invalid rooms or use of map
        if (!hasRoom(start) && !hasRoom(end)) { //both rooms do not exist
            message.setText("Start and end rooms don't exist");
            return;
        } else if (!hasRoom(start)) { //start room does not exist
            message.setText("Start room doesn't exist");
            return;
        } else if (!hasRoom(end)) { //end room does not exist
            message.setText("End room doesn't exist");
            return;
        } else { //both rooms valid, instructions on difference between start room and end room
            message.setText("Red is start, green is end");
        }

        ArrayList<Tile> path = graph.findPath(findRoom(start), findRoom(end)); //find path

        for (int i = 0; i < path.size() -1; i++)  {//print path
            Line line = new Line(path.get(i).getX(), path.get(i).getY(), path.get(i+1).getX(), path.get(i+1).getY());
            line.setStroke(Color.BLUE);
            root.getChildren().add(line);
        }

        //draw start and end room
        findRoom(start).drawStart();
        findRoom(end).drawEnd();

    }

}
