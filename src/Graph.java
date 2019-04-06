import java.util.ArrayList;

public class Graph<T> {

    private ArrayList<Vertice> vertices = new ArrayList<>();
    private class Vertice {
        private T data;
        private ArrayList<Edge> edges = new ArrayList<>();
        public Vertice(T value) {
            data = value;
        }
        public void addEdge(Edge edge) {
            edges.add(edge);
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
    }

}
