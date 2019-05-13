
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Graph<T> {

    private ArrayList<Vertice> vertices = new ArrayList<>();

    private ArrayList<Edge> edges = new ArrayList<>();

    public boolean add(T data) {
        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).getData() == data) {
                return false;
            }
        }
        vertices.add(new Vertice(data));
        return true;
    }

    public boolean link (T object1, T object2, int weight) {
        int vertice1index = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getData() == object1) {
                vertice1index = i;
                break;
            }
            if (i == vertices.size()-1) {
                return false;
            }
        }


        int vertice2index = 0;
        for (int i = 0; i < vertices.size(); i++) {
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

    public boolean link (int i1, int i2, int weight) {
        return link(vertices.get(i1-1).getData(), vertices.get(i2-1).getData(), weight);
    }

    public boolean link (T object1, int i2, int weight) {
        return link(object1, vertices.get(i2-1).getData(), weight);
    }

    public boolean link (int i1, T object2, int weight) {
        return link(vertices.get(i1-1).getData(), object2, weight);
    }

    private class Vertice implements Comparable <Vertice> {
        private T data;
        private int Weight;
        private ArrayList<Edge> edges = new ArrayList<>();
        private ArrayList<Vertice> path = new ArrayList<>();
        public Vertice(T value) {
            data = value;
        }
        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public T getData() {
            return data;
        }
        public int edgeNumbers() {
            return edges.size();
        }
        public Edge getEdge(int i) {
            return edges.get(i);
        }

        public int getWeight() {
            return Weight;
        }

        public void setWeight(int weight) {
            Weight = weight;
        }
        public ArrayList<Vertice> getNeighbours() {
            ArrayList<Vertice> neighbours = new ArrayList<>();
            for (Edge edge:edges) {
                neighbours.add(edge.getOther(this));
            }
            return neighbours;
        }

        public void printPath () {
            System.out.print("path to " + (vertices.indexOf(this) + 1) + ": ");
            for (Vertice vertice: path) {
                System.out.print(vertices.indexOf(vertice) + 1);
                System.out.print(" ");
            }
            System.out.println();
        }

        public ArrayList<Edge> getEdges() {
            return edges;
        }

        public ArrayList<Vertice> getPath() {
            return path;
        }

        public void setPath(ArrayList<Vertice> path) {
            this.path = path;
        }

        public void addToPath(Vertice vertice) {
            path.add(vertice);
        }

        @Override
        public int compareTo(Vertice other) {
            return getWeight() - other.getWeight();
        }

        public ArrayList<T> getPathData() {
            ArrayList<T> pathData = new ArrayList<>();
            for (Vertice vertice: path) {
                pathData.add(vertice.getData());
            }
            return pathData;
        }

        public void unExploreEdges() {
            for (Edge edge: edges) {
                edge.unExplore();
            }
        }

        public ArrayList<Vertice> getPathCopy () {
            ArrayList<Vertice> pathCopy = new ArrayList<>();
            pathCopy.addAll(path);
            return pathCopy;
        }

    }

    private class Edge {
        private Vertice vertice1;
        private Vertice vertice2;
        private int weight;
        private boolean explored = false;
        public Edge(Vertice vertice1, Vertice vertice2, int weight) {
            this.vertice1 = vertice1;
            vertice1.addEdge(this);
            this.vertice2 = vertice2;
            vertice2.addEdge(this);
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public Vertice getOther(Vertice verticeCheck) {
            if (verticeCheck.equals(vertice1)) {
                return vertice2;
            } else {
                return vertice1;
            }

        }
        public void markExplored() {
            explored = true;
        }
        public void unExplore() {
            explored = false;
        }
        public Vertice getVertice1() {
            return vertice1;
        }
        public Vertice getVertice2() {
            return vertice2;
        }
        public boolean isExplored() {
            return explored;
        }
    }

    public void runThrough() {
        runThrough(vertices.get(0), new ArrayList<Edge>(), true);
        System.out.println("end");
    }

    private boolean runThrough(Vertice checker, ArrayList<Edge> checked, boolean first) {

        //System.out.println(checker.edgeNumbers());
        if (checker.edgeNumbers() == 0 && first) {
            return true;
        }
        if (checker.edgeNumbers() == 1) {
            if(!first) {
                return true;
            }
        }

        for (int i = 0; i < checker.edgeNumbers(); i++) {
            if (!checked.contains(checker.getEdge(i))) {
                System.out.println(checker.getData() + " connected to "
                        + checker.getEdge(i).getOther(checker).getData() + " with weight of "
                        + checker.getEdge(i).getWeight());
                checked.add(checker.getEdge(i));
                runThrough(checker.getEdge(i).getOther(checker), checked, false);
            }
        }
        return true;


    }

    public T getVerticeData(int i){
        return vertices.get(i).getData();
    }

    public int size() {
        return vertices.size();
    }

    public ArrayList<T> getVerticesData() {
        ArrayList<T> data = new ArrayList<>();
        for(Vertice vertice: vertices) {
            data.add(vertice.getData());
        }
        return data;

    }

    /*

        public static void main(String[] args) {
            Graph<String> strings = new Graph<>();
            strings.add("1");
            strings.add("2");
            strings.add("3");
            strings.link("1", "3", 1);
            strings.link("2", "3", 2);
            strings.link("1", "2", 400);
            strings.add("50");
            strings.link("50", "2", 3);
            strings.runThrough();
        }
        */

    public ArrayList<ArrayList<T>> getEdges() {
        ArrayList<ArrayList<T>> allData = new ArrayList<>();
        for (Edge edge:edges) {
            ArrayList<T> edgeData = new ArrayList<>();
            edgeData.add(edge.getVertice1().getData());
            edgeData.add(edge.getVertice2().getData());
            allData.add(edgeData);
        }
        return allData;
    }

    public Vertice getVertice (T data) {
        for (int i = 0; i < vertices.size(); i ++) {
            if (vertices.get(i).getData() == data) {
                return vertices.get(i);
            }
        }
        return null;
    }

    public ArrayList<T> findPath(T start, T end) { //Dijkstra
        ArrayList<Vertice> frontier = new ArrayList<>();
        frontier.add(getVertice(start));
        for (Vertice vertice: vertices) {
            vertice.unExploreEdges();
            if (vertice.getData() == start) {
                vertice.setWeight(0);
                //vertice.addToPath(vertice);
            } else {
                vertice.setWeight(1000000);
                frontier.add(vertice);
            }

        }
        ArrayList<T> explored = new ArrayList<>();
        explored.add(start);
        Vertice current = frontier.get(0);

        while (frontier.size() != 0) {


            Collections.sort(frontier);
            System.out.println("path weight: " + frontier.get(0).getWeight());

            current = frontier.get(0);




            if(current.getData() == end){
                explored.add(end);
                current.addToPath(current);
                current.printPath();
                break;
            }
            ArrayList<Vertice> neighbours = current.getNeighbours();
            //update neighbors
            for (int i = 0; i < neighbours.size(); i++) {
                //int newDistance = current.getWeight() + edges.get(i).getWeight();
                Edge edgeCheck = current.getEdge(i);
                Vertice verticeCheck = edgeCheck.getOther(current);

                if (edgeCheck.isExplored()) {
                    continue;
                }

                int newDistance = current.getWeight() + edgeCheck.getWeight();

                if (newDistance <= verticeCheck.getWeight()) {
                    verticeCheck.setWeight(newDistance);
                    verticeCheck.setPath(current.getPathCopy());
                    verticeCheck.addToPath(current);
                    verticeCheck.printPath();
                    //explored.add(verticeCheck.getData());
                    //current = verticeCheck;
                }
            }
            explored.add(current.getData());
            frontier.remove(current);
        }

        System.out.println("path found");
        return getVertice(end).getPathData();
        //return explored;
    }


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
