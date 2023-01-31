package prep.ds.algo.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllPathsFromSourceToTargetTest {

    private AllPathsFromSourceToTarget allPathsFromSourceToTarget;

    @BeforeEach
    public void setup() {
        allPathsFromSourceToTarget = new AllPathsFromSourceToTarget();
    }

    @Test
    public void testAllPaths() {
        int[][] graph = {{1,2}, {3}, {3}, {}};

        List<List<Integer>> paths = allPathsFromSourceToTarget.allPathsSourceTarget(graph);

        for (List<Integer> path : paths) {
            path.forEach(node -> System.out.printf(" -> %d", node));
            System.out.println();
        }
    }
}
