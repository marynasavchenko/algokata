package graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {

    @Test
    void shouldReturnPostOrder() {
        DirectedGraph directedGraph = new DirectedGraph(4);
        directedGraph.addEdge(1, 0);
        directedGraph.addEdge(0, 3);
        directedGraph.addEdge(1, 2);

        TopologicalSort topologicalSort = new TopologicalSort(directedGraph);
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(3, 0, 2, 1));

        assertEquals(expected, topologicalSort.getReversePostOrder());
    }
}