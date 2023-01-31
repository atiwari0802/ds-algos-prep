package prep.ds.algo.graphs;

import java.util.*;

public class DepthFirstSearch {

    /**
     * Takes in a Graph and prints the Depth First Search.
     * Steps:
     *  - Take the source node
     *  - Add it to the path if not visited
     *  - Mark it as visited
     *  - Enumerate all the adjacent nodes
     *  - For each node, recursive call the DFS method
     *
     *  Time Complexity: O(V + E); Explanation: v1 + (incident edges) + v2 + (incident edges) + .... + vn + (incident edges)
     *  Space Complexity: O(V), as that is maximum depth of the recursion stack. It cannot be more than the number of vertices
     *
     * @param graph 
     * @param startNode source node
     * @return List of nodes traversed in DFS order
     */
    public List<Integer> depthFirstSearch(Graph graph, int startNode) {
        List<Integer> path = new ArrayList<>();

        depthFirstSearchHelper(graph, startNode, path);

        return path;
    }

    private void depthFirstSearchHelper(Graph graph, int node, List<Integer> path) {
        if (graph.isVisited(node)) {
            return;
        }

        graph.visit(node);
        path.add(node);

        for (int vertex : graph.getEdges(node)) {
            depthFirstSearchHelper(graph, vertex, path);
        }
    }
}
