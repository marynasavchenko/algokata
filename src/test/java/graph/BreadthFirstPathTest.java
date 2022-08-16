package graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreadthFirstPathTest {

    @Test
    void shouldReturnShortestPath() {
        Graph graph = createGraph();
        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);

        List<Integer> path = bfp.getPathTo(6);

        assertEquals(6, path.get(0));
        assertEquals(5, path.get(1));
        assertEquals(0, path.get(2));
    }

    private Graph createGraph() {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(5, 6);
        return graph;
    }
}