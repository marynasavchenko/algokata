package graph;

public class Edge implements Comparable<Edge> {

    private final int oneVertex;
    private final int theOtherVertex;
    private final double weight;

    public Edge(int vertex, int theOtherVertex, double weight) {
        this.oneVertex = vertex;
        this.theOtherVertex = theOtherVertex;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getOneVertex() {
        return oneVertex;
    }

    public int getOtherVertex(int vertex) {
        if (vertex == oneVertex) return theOtherVertex;
        if (vertex == theOtherVertex) return oneVertex;
        else throw new RuntimeException("Edge is not consistent");
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", oneVertex, theOtherVertex, weight);

    }
}
