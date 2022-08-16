package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPath {
    private final boolean[] visited;
    public final int[] pathTo;

    private int[] numberOfEdges;

    public BreadthFirstPath(Graph graph, int sourceVertex) {
        int numberOfVertices = graph.getNumberOfVertices();
        visited = new boolean[numberOfVertices];
        pathTo = new int[numberOfVertices];
        numberOfEdges = new int[numberOfVertices];
        bfs(graph, sourceVertex);
    }

    private void bfs(Graph graph, int sourceVertex) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int ver = 0; ver < graph.getNumberOfVertices(); ver++)
            numberOfEdges[ver] = Integer.MAX_VALUE;
        numberOfEdges[sourceVertex] = 0;
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int connectedVertex : graph.getConnectionsFor(vertex)) {
                if (!visited[connectedVertex]) {
                    pathTo[connectedVertex] = vertex;
                    numberOfEdges[connectedVertex] = numberOfEdges[vertex] + 1;
                    visited[connectedVertex] = true;
                    queue.add(connectedVertex);
                }
            }
        }
    }

    public boolean hasPathTo(int vertex) {
        return visited[vertex];
    }

    public List<Integer> getPathTo(int vertex) {
        List<Integer> path = new LinkedList<>();
        int ver;
        for (ver = vertex; numberOfEdges[ver] != 0; ver = pathTo[ver])
            path.add(ver);
        path.add(ver);
        return path;
    }

}
