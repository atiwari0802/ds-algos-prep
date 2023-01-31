package prep.ds.algo.graphs;

import java.util.*;

public class Graph {

    private int totalVertices;

    private List<List<Integer>> adjacencyList;

    private boolean[] visited;

    public Graph(int n) {
        this.totalVertices = n;
        this.visited = new boolean[totalVertices];
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < totalVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList.get(source).add(destination);
    }

    public void visit(int node) {
        this.visited[node] = true;
    }

    public boolean isVisited(int node) {
        return visited[node];
    }

    public List<Integer> getEdges(int node) {
        return adjacencyList.get(node);
    }
}
