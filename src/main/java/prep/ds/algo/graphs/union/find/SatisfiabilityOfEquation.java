package prep.ds.algo.graphs.union.find;

import java.util.*;

/**
 * You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.
 */
public class SatisfiabilityOfEquation {

    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int parentA = unionFind.find(equation.charAt(0) - 'a');
                int parentB = unionFind.find(equation.charAt(3) - 'a');

                if (parentA == parentB) {
                    return false;
                }
            }
        }

        return true;
    }

    static final class UnionFind {
        private int[] parent;
        private int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
        }

        int find(int node) {
            if (node != parent[node]) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int nodeA, int nodeB) {
            int parentA = find(nodeA);
            int parentB = find(nodeB);

            if (parentA == parentB) {
                return;
            }

            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
            } else if (rank[parentB] > rank[parentA]) {
                parent[parentA] = parentB;
            } else {
                rank[parentA]++;
                parent[parentB] = parentA;
            }
        }
    }
}
