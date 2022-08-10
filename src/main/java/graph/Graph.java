package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numberOfVertices;
    private int numberOfEdges;
    private final LinkedList<Integer>[] connections;
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        connections = (LinkedList<Integer>[]) new LinkedList[numberOfVertices];
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            connections[vertex] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        numberOfEdges++;
        connections[vertex1].add(vertex2);
        connections[vertex2].add(vertex1);
    }

    public List<Integer> getConnectionsFor(int vertex) {
        return connections[vertex];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }
}
