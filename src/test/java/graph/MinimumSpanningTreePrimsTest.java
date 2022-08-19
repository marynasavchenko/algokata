package graph;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSpanningTreePrimsTest {
    @Test
    void shouldReturnMSTEdges() {
        WeightedGraph weightedGraph = createWeightedGraph();

        MinimumSpanningTreePrims mst = new MinimumSpanningTreePrims(weightedGraph);
        Queue<Edge> mstEdges = mst.getMstEdges();

        assertEquals(7, mstEdges.size());
    }

    @Test
    void shouldReturnRightMSTWeight() {
        WeightedGraph weightedGraph = createWeightedGraph();

        MinimumSpanningTreePrims mst = new MinimumSpanningTreePrims(weightedGraph);
        double epsilon = 0.000001d;

        assertEquals(1.80, mst.getWeight(), epsilon);
    }

    private static WeightedGraph createWeightedGraph() {
        WeightedGraph weightedGraph = new WeightedGraph(8);
        weightedGraph.addEdge(new Edge(4, 5, 0.35));
        weightedGraph.addEdge(new Edge(4, 7, 0.37));
        weightedGraph.addEdge(new Edge(5, 7, 0.28));
        weightedGraph.addEdge(new Edge(0, 7, 0.16));
        weightedGraph.addEdge(new Edge(1, 5, 0.32));
        weightedGraph.addEdge(new Edge(0, 4, 0.38));
        weightedGraph.addEdge(new Edge(2, 3, 0.17));
        weightedGraph.addEdge(new Edge(1, 7, 0.19));
        weightedGraph.addEdge(new Edge(0, 2, 0.26));
        weightedGraph.addEdge(new Edge(1, 2, 0.36));
        weightedGraph.addEdge(new Edge(1, 3, 0.29));
        weightedGraph.addEdge(new Edge(2, 4, 0.34));
        weightedGraph.addEdge(new Edge(6, 2, 0.40));
        weightedGraph.addEdge(new Edge(3, 6, 0.52));
        weightedGraph.addEdge(new Edge(6, 0, 0.58));
        weightedGraph.addEdge(new Edge(6, 4, 0.93));
        return weightedGraph;
    }
}