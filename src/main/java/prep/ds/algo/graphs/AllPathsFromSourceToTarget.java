package prep.ds.algo.graphs;

import java.util.*;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathsFromSourceToTarget {

    private List<List<Integer>> paths;

    /**
     * This solution is a variation of depth first search. We start with the source node
     * add it to the list of possible path. We then enumerate all the adjacent nodes.
     * For each node, we recursively (in depth-first approach) repeat the above approach.
     * If we get to the target,
     * then we add that solution to the list of possible paths.
     *
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * @param graph
     * @return List of all possible paths.
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> potentialPath = new ArrayList<>();
        int source = 0;
        int target = graph.length - 1;
        this.paths = new ArrayList<>();
        potentialPath.add(source);
        allPathsSourceToTargetHelper(graph, source, target, potentialPath);
        return this.paths;
    }

    private void allPathsSourceToTargetHelper(int[][] graph, int source, int target , List<Integer> potentialPath) {
        if (source == target) {
            paths.add(new ArrayList<>(potentialPath)) ;
            return;
        }

        for (int node : graph[source]) {
            potentialPath.add(node);
            allPathsSourceToTargetHelper(graph, node, target, potentialPath);
            potentialPath.remove(potentialPath.size() - 1);
        }
    }
}
