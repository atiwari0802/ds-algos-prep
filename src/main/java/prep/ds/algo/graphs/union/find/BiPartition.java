package prep.ds.algo.graphs.union.find;

import java.util.*;

public class BiPartition {

    public static class UnionFind {
        int[] rank;
        int[] parent;

        public UnionFind(int n) {
            this.rank = new int[n];
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (node != parent[node]) {
                return find(parent[node]);
            }

            return node;
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            if (xParent == yParent) {
                return;
            }
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
            } else if (rank[yParent] > rank[xParent]) {
                parent[xParent] = yParent;
            } else {
                parent[xParent] = yParent;
                rank[yParent]++;
            }
        }
    }

    /**
     * - Create Adjacency List of all the nodes.
     * - For every node in the adjacency list, try to put all its neighbors in the other set. This is done by Union-ing all the neighbors.
     * - If that is not possible, return false. It can be checked by 'find-ing' the parents of the node and its neighbor. Their parent
     *   must not be the same.
     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < dislikes.length; i++) {
            int src = dislikes[i][0];
            int dest = dislikes[i][1];
            adjacencyList.computeIfAbsent(src, num -> new ArrayList<>()).add(dest);
            adjacencyList.computeIfAbsent(dest, num -> new ArrayList<>()).add(src);
        }

        UnionFind unionFind = new UnionFind(n + 1);

        for (int node = 1; node < n + 1; node++) {
            if (adjacencyList.containsKey(node)) {
                for (int neighbor : adjacencyList.get(node)) {
                    int nodeParent = unionFind.find(node);
                    int neighborParent = unionFind.find(neighbor);

                    if (nodeParent == neighborParent) {
                        return false;
                    }

                    unionFind.union(adjacencyList.get(node).get(0), neighbor);
                }
            }
        }
        return true;
    }
}
