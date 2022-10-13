package graph;

import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {
    private int numberOfVertices;
    private int numberOfEdges;
    private final LinkedList<Integer>[] connections;

    public DirectedGraph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        connections = (LinkedList<Integer>[]) new LinkedList[numberOfVertices];
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            connections[vertex] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        numberOfEdges++;
        connections[vertex1].add(vertex2);
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


    public DirectedGraph getReversedGraph() {
        DirectedGraph reversedGraph = new DirectedGraph(numberOfVertices);
        for (int ver = 0; ver < numberOfVertices; ver++) {
            for (Integer conVer : getConnectionsFor(ver)) {
                reversedGraph.addEdge(conVer, ver);
            }
        }
        return reversedGraph;
    }
}
