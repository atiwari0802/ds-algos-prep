package prep.ds.algo.graphs.union.find;

import java.util.*;
/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 */
public class EvaluateDivision {
    /**
     * The key aspect in this problem is to find the relative ratios. Relative ratios define each value in comparison to their parent node.
     * For example if a / b = 2; b / c = 3; if c is considered the root, then b = 3 * c and a = 2 * b = 2 * 3 * c = 6 * c;
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> index = new HashMap<>();
        double[] results = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            union(dividend, divisor, value, index);
        }

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!index.containsKey(dividend) || !index.containsKey(divisor)) {
                results[i] = -1d;
            } else {
                Node dividendGroup = find(dividend, index);
                Node divisorGroup = find(divisor, index);

                if (!dividendGroup.parent.equals(divisorGroup.parent)) {
                    results[i] = -1d;
                } else {
                    results[i] = dividendGroup.ratio / divisorGroup.ratio;
                }
            }
        }

        return results;
    }

    static class Node {
        private final String parent;

        private final double ratio;

        Node (String parent, double ratio) {
            this.parent = parent;
            this.ratio = ratio;
        }
    }

    private Node find(String node, Map<String, Node> index) {
        index.computeIfAbsent(node, n -> new Node(node, 1.0d));

        if (!index.get(node).parent.equals(node)) {
            double existingRatio = index.get(node).ratio;
            Node parentNode = find(index.get(node).parent, index);
            index.put(node, new Node(parentNode.parent, existingRatio * parentNode.ratio));
        }

        return index.get(node);
    }

    private void union(String dividend, String divisor, double value, Map<String, Node> index) {
         Node dividendNode = find(dividend, index);
         Node divisorNode = find(divisor, index);

         if (!dividendNode.parent.equals(divisorNode.parent)) {
             index.put(dividendNode.parent, new Node(divisorNode.parent, value / dividendNode.ratio * divisorNode.ratio));
         }
    }



}
