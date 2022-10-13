package graph;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {
    private final boolean[] visited;

    List<Integer> postOrder;

    public TopologicalSort(DirectedGraph graph) {
        visited = new boolean[graph.getNumberOfVertices()];
        postOrder = new LinkedList<>();
        for (int ver = 0; ver < graph.getNumberOfVertices(); ver++) {
            if (!visited[ver]) {
                dfs(graph, ver);

            }

        }
    }

    private void dfs(DirectedGraph graph, int vertex) {
        visited[vertex] = true;
        for (int conVer : graph.getConnectionsFor(vertex)) {
            if (!visited[conVer]) {
                dfs(graph, conVer);
            }
        }
        postOrder.add(vertex);
    }

    public List<Integer> getReversePostOrder() {
        return postOrder;
    }
}
