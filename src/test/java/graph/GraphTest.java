package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void shouldCreateGraph() {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);

        assertEquals(3, graph.getConnectionsFor(3).size());

        assertEquals(2, graph.getConnectionsFor(3).get(0));
        assertEquals(4, graph.getConnectionsFor(3).get(1));
        assertEquals(5, graph.getConnectionsFor(3).get(2));
    }
}