import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Nile Cochen
 * @param <T> Class type that the Graph stores
 * The Graph class is used to store data. Although the elements added are part of a linear list, they have no order when
 * added. The elements are connected by linking them. Each link (edge) has a weight. The graph format is used so the
 * shortest path between two points can be found.
 */
public class Graph<T extends Tile> {

    private ArrayList<Vertice> vertices = new ArrayList<>(); //Holds all vertices added to graph
    private ArrayList<Edge> edges = new ArrayList<>(); //Holds all edges added to the graph (links)

    /**
     * @param data object to be added to the graph
     * @return returns false if object is already in the graph. Returns true if object is not in graph.
     * Adds object of type T to graph. Data added to vertices.
     */
    public boolean add(T data) {
        for (int i = 0; i < vertices.size(); i++) { //Check if object is already contained in graph
            if(vertices.get(i).getData() == data) {
                return false;
            }
        }
        vertices.add(new Vertice(data));
        return true;
    }

    /**
     * @param object1 first vertice held by edge
     * @param object2 second vertice held by edge
     * @param weight weight of the edge
     * @return false if either of the objects are not in graph. True if vertices successfully linked
     * Creates edge between 2 vertices.
     */
    public boolean link (T object1, T object2, int weight) {
        int vertice1index = 0;

        for (int i = 0; i < vertices.size(); i++) { //find the first vertice that holds first object
            if (vertices.get(i).getData() == object1) {
                vertice1index = i;
                break;
            }
            if (i == vertices.size()-1) {
                return false;
            }
        }


        int vertice2index = 0;
        for (int i = 0; i < vertices.size(); i++) { //find the second vertice that holds second object
            if (vertices.get(i).getData() == object2) {
                vertice2index = i;
                break;
            }
            if (i == vertices.size()-1) {
                return false;
            }
        }

        Edge edge = new Edge(vertices.get(vertice1index), vertices.get(vertice2index), weight);
        edges.add(edge);
        return true;
    }

    /**
     * @param i1 index of object 1
     * @param i2 index of object 2
     * @param weight weight of the edge
     * @return false if either of the objects are not in graph. True if vertices successfully linked
     * 2nd version of overloaded link method. Calls first version of link using index of objects in vertices
     */
    public boolean link (int i1, int i2, int weight) {
        return link(vertices.get(i1-1).getData(), vertices.get(i2-1).getData(), weight);
    }

    /**
     * @param i1 inedex of object 1
     * @param object2 pointer to object 2
     * @param weight weight of edge
     * @return false if either of the objects are not in graph. True if vertices successfully linked
     * 3rd version of overloaded link method. Calls first version of link using mix of index and actual object
     */
    public boolean link (int i1, T object2, int weight) {
        return link(vertices.get(i1-1).getData(), object2, weight);
    }

    /**
     * The Vertice is used to hold an element of the graph. Comparable by weight
     */
    private class Vertice implements Comparable <Vertice> {
        private T data; //data that is held by vertice
        private int Weight; //weight of vertice
        private ArrayList<Edge> edges = new ArrayList<>(); //all edges that hold this vertice
        private ArrayList<Vertice> path = new ArrayList<>(); //path from start to this vertice

        /**
         * @param value data set to value
         * constructor defines data
         */
        public Vertice(T value) {
            data = value;
        }

        /**
         * adds edge to edges
         * @param edge edge to be added
         */
        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        /**
         * getter for data
         * @return returns data
         */
        public T getData() {
            return data;
        }

        /**
         * getter for edge in edges
         * @param i index of edge in edges
         * @return returns edge at i in edges
         */
        public Edge getEdge(int i) {
            return edges.get(i);
        }

        /**
         * getter for weight
         * @return returns weight
         */
        public int getWeight() {
            return Weight;
        }

        /**
         * setter for weight
         * @param weight returns weight
         */
        public void setWeight(int weight) {
            Weight = weight;
        }

        /**
         * @return returns ArrayList of all adjacent vertices
         */
        public ArrayList<Vertice> getNeighbours() {
            ArrayList<Vertice> neighbours = new ArrayList<>();
            for (Edge edge:edges) {
                neighbours.add(edge.getOther(this));
            }
            return neighbours;
        }

        /**
         * setter for path
         * @param path new path
         */
        public void setPath(ArrayList<Vertice> path) {
            this.path = path;
        }

        /**
         * vertice to be added to path
         * @param vertice vertice to be added
         */
        public void addToPath(Vertice vertice) {
            path.add(vertice);
        }

        /**
         * compareTo allows Vertice class to be comparable.
         * @param other Vertice that this is being compared to
         * @return difference between this weight and weight of other
         */
        @Override
        public int compareTo(Vertice other) {
            return getWeight() - other.getWeight();
        }

        /**
         * returns Array contain the data in each vertice in path Array
         * @return Array of data
         */
        public ArrayList<T> getPathData() {
            ArrayList<T> pathData = new ArrayList<>();
            for (Vertice vertice: path) {
                pathData.add(vertice.getData());
            }
            return pathData;
        }

        /**
         * returns a separate copy of the path
         * @return returns separate copy of the path
         */
        public ArrayList<Vertice> getPathCopy () {
            ArrayList<Vertice> pathCopy = new ArrayList<>();
            pathCopy.addAll(path);
            return pathCopy;
        }

        /**
         * clears the path ArrayList
         */
        private void clearPath() {
            path = new ArrayList<>();
        }

    }

    /**
     * sets weight of all vertices to 0
     */
    private void unWeightVertices(){
        for (Vertice vertice: vertices) {
            vertice.setWeight(0);
        }
    }

    /**
     * Edges connect two vertices with a weight
     */
    private class Edge {
        private Vertice vertice1; //first vertice that is connected
        private Vertice vertice2; //second vertice that is connected
        private int weight; //weight of vertice

        /**
         * Constructor defines weight, vertice1 and vertice2
         * @param vertice1 to be set to this.vertice1
         * @param vertice2 to be set to this.vertice2
         * @param weight to be set to this.weight
         */
        public Edge(Vertice vertice1, Vertice vertice2, int weight) {
            this.vertice1 = vertice1;
            vertice1.addEdge(this);
            this.vertice2 = vertice2;
            vertice2.addEdge(this);
            this.weight = weight;
        }

        /**
         * getter for weight
         * @return returns weight
         */
        public int getWeight() {
            return weight;
        }

        /**
         * returns either vertice1, or vertice2 that isnt the input vvertice
         * @param verticeCheck vertice that is used to find other vertice
         * @return returns vertice that isn't verticeCheck
         */
        public Vertice getOther(Vertice verticeCheck) {
            if (verticeCheck.equals(vertice1)) {
                return vertice2;
            } else {
                return vertice1;
            }

        }
    }

    /**
     * gets a vertice in vertices Array that holds object
     * @param data object that the targeted vertice must contain
     * @return vertice that contains data
     */
    public Vertice getVertice (T data) {
        for (int i = 0; i < vertices.size(); i ++) {
            if (vertices.get(i).getData() == data) {
                return vertices.get(i);
            }
        }
        return null;
    }

    /**
     * Finds path between vertice that holds start data and vertice that holds end data. Path is the shortest path
     * @param start data the start vertice must hold
     * @param end data the end vertice must hold
     * @return returns an ArrayList of the data of the vertices that form the shortest path between the start and finish
     */
    public ArrayList<T> findPath(T start, T end) { //Dijkstra
        ArrayList<Vertice> frontier = new ArrayList<>(); //separate copy of vertices
        for (Vertice vertice: vertices) { //set all weights to 1000000 except start (set to 0)
            if (vertice.getData() == start) {
                vertice.setWeight(0);
                vertice.clearPath();
            } else {
                vertice.setWeight(1000000);
            }
            frontier.add(vertice);

        }

        Vertice current; //vertice being analysed

        while (frontier.size() != 0) { //loop until frontier empty


            Collections.sort(frontier);//sort frontier

            current = frontier.get(0);//set current to the




            if(current.getData() == end){ //break if the current matches the end
                unWeightVertices();
                current.addToPath(current);
                break;
            }
            ArrayList<Vertice> neighbours = current.getNeighbours();

            for (int i = 0; i < neighbours.size(); i++) {  //update neighbors
                Edge edgeCheck = current.getEdge(i);
                Vertice verticeCheck = edgeCheck.getOther(current);



                int newDistance = current.getWeight() + edgeCheck.getWeight(); //find possible new distance

                if (newDistance <= verticeCheck.getWeight()) { //if new distance is shorter than current distance
                    verticeCheck.setWeight(newDistance);//sets distance to new distance
                    verticeCheck.setPath(current.getPathCopy());//copies the path of current to verticeCheck
                    verticeCheck.addToPath(current);//add current to the path
                }
            }
            frontier.remove(current);//remove current from frontier
        }

        return getVertice(end).getPathData(); //return explored;
    }


    /**
     * Test Case
     **/
    /*
    public static void main(String[] args) {
        Graph<Room> testGraph = new Graph<>();
        Group root = new Group();
        testGraph.add(new Room(1, 4, root, "room 1"));
        testGraph.add(new Room(1, 4, root, "room 2"));
        testGraph.add(new Room(1, 4, root, "room 3"));
        testGraph.add(new Room(1, 4, root, "room 4"));
        testGraph.add(new Room(1, 4, root, "room 5"));
        testGraph.add(new Room(1, 4, root, "room 6"));
        testGraph.add(new Room(1, 4, root, "room 7"));
        testGraph.add(new Room(1, 4, root, "room 8"));
        testGraph.link(1, 2, 4);
        testGraph.link(2, 3, 2);
        testGraph.link(3, 4, 1);
        testGraph.link(3, 5, 2);
        testGraph.link(5, 6, 4);
        testGraph.link(3, 7, 3);
        testGraph.link(7, 8, 5);
        testGraph.link(8, 6, 1);


        ArrayList<Room> path = testGraph.findPath(testGraph.getVerticeData(0), testGraph.getVerticeData(7));


        for (Room room: path) {
            System.out.println(room.getId());
        }

    }
    */


}
