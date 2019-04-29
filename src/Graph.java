
import java.util.ArrayList;

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



    private class Vertice {
        private T data;
        private ArrayList<Edge> edges = new ArrayList<>();
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
    }

    private class Edge {
        private Vertice vertice1;
        private Vertice vertice2;
        private int weight;
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

        public Vertice getVertice1() {
            return vertice1;
        }

        public Vertice getVertice2() {
            return vertice2;
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

    public ArrayList<T> pathFinding(T start, T finish) {
        ArrayList<T> path = new ArrayList<T>();

        return path;
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

}
