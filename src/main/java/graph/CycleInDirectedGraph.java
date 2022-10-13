package graph;

import java.util.Stack;

public class CycleInDirectedGraph {
    private boolean[] visited;

    private int[] pathTo;

    private Stack<Integer> cycle = new Stack<>();

    private boolean[] onStack;


    public boolean hasCycle(int numberOfCourses, int prerequisites[][]) {
        DirectedGraph graph = buildGraph(numberOfCourses, prerequisites);
        int numberOfVer = graph.getNumberOfVertices();
        this.visited = new boolean[numberOfVer];
        this.onStack = new boolean[numberOfVer];
        this.pathTo = new int[numberOfVer];
        for (int vertex = 0; vertex < numberOfVer; vertex++) {
            dfs(graph, vertex);
        }
        return hasNoCycle();
    }

    private void dfs(DirectedGraph graph, int vertex) {
        onStack[vertex] = true;
        visited[vertex] = true;
        for (int connectedVertex : graph.getConnectionsFor(vertex)) {
            if (hasNoCycle()) return;
            //add path for unvisited vertex
            if (!visited[connectedVertex]) {
                pathTo[connectedVertex] = vertex;
                dfs(graph, connectedVertex);
            } else if (onStack[connectedVertex]) {
                trackBackCycle(vertex, connectedVertex);
            }
        }
        onStack[vertex] = false;
    }

    private void trackBackCycle(int vertex, int connectedVertex) {
        for (int nextVertex = vertex; nextVertex != connectedVertex; nextVertex = pathTo[nextVertex]) {
            cycle.push(nextVertex);
        }
        cycle.push(connectedVertex);
        cycle.push(vertex);
    }

    private static DirectedGraph buildGraph(int numberOfCourses, int[][] prerequisites) {
        DirectedGraph directedGraph = new DirectedGraph(numberOfCourses);
        for (int i = 0; i < prerequisites.length; i++) {
            directedGraph.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        return directedGraph;
    }

    public boolean hasNoCycle() {
        return cycle.isEmpty();
    }
}
