package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeightedGraphTest {

    @Test
    void shouldReturnEdgesToIterate() {
        WeightedGraph weightedGraph = new WeightedGraph(3);
        weightedGraph.addEdge(new Edge(0, 1, 0.1));
        weightedGraph.addEdge(new Edge(1, 2, 0.2));
        weightedGraph.addEdge(new Edge(2, 0, 0.3));


        List<Edge> allEdges = weightedGraph.getAllEdges();
        assertEquals(3, allEdges.size());
    }
}