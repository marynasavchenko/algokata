package graph;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    private int numberOfVertices;
    private int numberOfEdges;
    private final LinkedList<Edge>[] connections;

    public WeightedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        connections = (LinkedList<Edge>[]) new LinkedList[numberOfVertices];
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            connections[vertex] = new LinkedList<>();
        }
    }

    public void addEdge(Edge edge) {
        int oneVertex = edge.getOneVertex();
        int otherVertex = edge.getOtherVertex(oneVertex);

        numberOfEdges++;
        connections[oneVertex].add(edge);
        connections[otherVertex].add(edge);
    }

    public List<Edge> getEdgesFor(int vertex) {
        return connections[vertex];
    }

    public List<Edge> getAllEdges() {
        List<Edge> edges = new LinkedList<>();
        for (int ver = 0; ver < numberOfVertices; ver++) {
            for (Edge edge : connections[ver]) {
                if (edge.getOtherVertex(ver) > ver) edges.add(edge);
            }
        }
        return edges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }
}
