package graph;

public class DepthFirstSearch {

    private final boolean[] visited;

    public DepthFirstSearch(Graph graph, int sourceVertex) {
        this.visited = new boolean[graph.getNumberOfVertices()];
        dfs(graph, sourceVertex);
    }

    private void dfs(Graph graph, int vertex) {
        visited[vertex] = true;
        for (int connectedVertex : graph.getConnectionsFor(vertex)) {
            if (!visited[connectedVertex]) {
                dfs(graph, connectedVertex);
            }
        }
    }

    public boolean isVisited(int vertex) {
        return visited[vertex];
    }
}
