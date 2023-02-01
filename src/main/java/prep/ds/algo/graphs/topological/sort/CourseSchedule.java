package prep.ds.algo.graphs.topological.sort;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule {


    /**
     * We have solved this question using Kuhn's algorithm for Topological sorting.
     *
     * The algorithm is as follows:
     *  1. Create an adjacency list using the prerequisites.
     *  2. Create an in-degree array that stores the count of all the incoming edges for each vertex/node
     *  3. Every node with an in-degree count of 0 is then added to a queue.
     *  4. We iterate over the queue and add every such node in the topological order array while also decreasing the in-degree
     *     of all adjacent nodes.
     *  5. If the in-degree of any adjacent node becomes 0, it is added to the queue.
     *  6. Once the queue is empty, we check all the courses have been visited and have their in-degrees 0. If so, then
     *     we return topological order array; else we return an empty array.
     *
     * @param numCourses Number of courses that must be taken
     * @param prerequisites
     * @return Nodes sorted in topological order if no-cycles present. Empty array otherwise
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int destination = prerequisites[i][0];

            adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            inDegree[destination]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int visitedNodesCount = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            topologicalOrder[visitedNodesCount++] = node;

            if (adjacencyList.containsKey(node)) {
                for (int adjacentNode : adjacencyList.get(node)) {
                    inDegree[adjacentNode]--;
                    if (inDegree[adjacentNode] == 0) {
                        queue.addLast(adjacentNode);
                    }
                }
            }
        }

        if (visitedNodesCount == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

}
