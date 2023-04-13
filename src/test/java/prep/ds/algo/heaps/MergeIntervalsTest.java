package prep.ds.algo.heaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @BeforeEach
    void setUp() {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    void testMerge() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] merged = mergeIntervals.merge(intervals);

        for (int[] interval : merged) {
            System.out.println(interval[0] + "--->" + interval[1]);
        }
    }
}