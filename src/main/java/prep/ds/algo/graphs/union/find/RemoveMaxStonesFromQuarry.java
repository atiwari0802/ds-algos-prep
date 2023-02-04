package prep.ds.algo.graphs.union.find;

import java.util.*;
/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 *
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 *
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 */
public class RemoveMaxStonesFromQuarry {

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int nodes) {
            this.parent = new int[nodes];
            this.rank = new int[nodes];
            for (int i = 0; i < nodes; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                return parent[node] = find(parent[node]);
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
                rank[xParent] += rank[yParent];
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
                rank[yParent] += rank[xParent];
            } else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
        }

        public int findUniqueGroupsCount() {
            Set<Integer> roots = new HashSet<>();

            for (int node : parent) {
                roots.add(node);
            }

            return roots.size();
        }
    }

    public int removeStones(int[][] stones) {
        int numberOfStones = stones.length;
        int totalGroups = 0;
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (isSameRowOrColumn(stones[i], stones[j])) {
                    adjacencyMap.computeIfAbsent(i, v -> new ArrayList<>()).add(j);
                    adjacencyMap.computeIfAbsent(j, v -> new ArrayList<>()).add(i);
                }
            }
        }

        UnionFind unionFind = new UnionFind(numberOfStones);

        for (int i = 0; i < numberOfStones; i++) {
            if (adjacencyMap.containsKey(i)) {
                for (int neighbor : adjacencyMap.get(i)) {
                        unionFind.union(i, neighbor);
                }
            }
        }

        totalGroups = unionFind.findUniqueGroupsCount();

        return numberOfStones - totalGroups;
    }

    boolean isSameRowOrColumn(int[] stoneA, int[] stoneB) {
        return (stoneA[0] == stoneB[0]) || (stoneA[1] == stoneB[1]);
    }

}
