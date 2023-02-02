package prep.ds.algo.graphs.union.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BiPartitionTest {

    private BiPartition biPartition;

    @BeforeEach
    void setUp() {
        biPartition = new BiPartition();
    }

    @Test
    public void testBiPartition_1() {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2,4}};

        Assertions.assertTrue(biPartition.possibleBipartition(n, dislikes));
    }

    @Test
    public void testBiPartition_2() {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};

        Assertions.assertFalse(biPartition.possibleBipartition(n, dislikes));
    }
}