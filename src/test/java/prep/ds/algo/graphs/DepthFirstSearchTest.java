package prep.ds.algo.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DepthFirstSearchTest {

    private DepthFirstSearch depthFirstSearch;

    @BeforeEach
    public void setup() {
        depthFirstSearch = new DepthFirstSearch();
    }

    @Test
    public void testDepthFirstSearch() {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);

        List<Integer> depthFirstSearchResults = depthFirstSearch.depthFirstSearch(graph, 0);

        Assertions.assertNotNull(depthFirstSearchResults);

        depthFirstSearchResults.forEach(i -> System.out.printf(" -> %d", i));
    }
}
