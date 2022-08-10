package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void allVerticesShouldBeVisited() {
        Graph graph = createGraph();
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);

        assertTrue(dfs.isVisited(1));
        assertTrue(dfs.isVisited(2));
        assertTrue(dfs.isVisited(3));
        assertTrue(dfs.isVisited(4));
        assertTrue(dfs.isVisited(5));
    }

    private Graph createGraph() {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(0,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        return graph;
    }
}