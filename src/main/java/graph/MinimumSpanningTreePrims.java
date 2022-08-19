package graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MinimumSpanningTreePrims {
    private final boolean[] visitedVertices;
    private final Queue<Edge> mstEdges;
    private final PriorityQueue<Edge> crossingEdges;

    public MinimumSpanningTreePrims(WeightedGraph graph) {
        crossingEdges = new PriorityQueue<>();
        visitedVertices = new boolean[graph.getNumberOfVertices()];
        mstEdges = new LinkedBlockingQueue<>();

        visit(graph, 0);
        while (!crossingEdges.isEmpty()) {
            Edge edge = crossingEdges.remove();
            int oneVertex = edge.getOneVertex();
            int otherVertex = edge.getOtherVertex(oneVertex);
            if (visitedVertices[oneVertex] && visitedVertices[otherVertex]) continue;
            mstEdges.add(edge);
            if (!visitedVertices[oneVertex]) visit(graph, oneVertex);
            if (!visitedVertices[otherVertex]) visit(graph, otherVertex);
        }

    }

    public Queue<Edge> getMstEdges() {
        return mstEdges;
    }

    public double getWeight() {
        double weight = 0.0;
        for (Edge edge : getMstEdges()) {
            weight += edge.getWeight();
        }
        return weight;
    }

    private void visit(WeightedGraph graph, int vertex) {
        visitedVertices[vertex] = true;
        for (Edge edge : graph.getEdgesFor(vertex)) {
            if (!isOtherVertexVisited(edge, vertex)) {
                crossingEdges.add(edge);
            }
        }
    }

    private boolean isOtherVertexVisited(Edge edge, int vertex) {
        int otherVertex = edge.getOtherVertex(vertex);
        return visitedVertices[otherVertex];
    }
}
