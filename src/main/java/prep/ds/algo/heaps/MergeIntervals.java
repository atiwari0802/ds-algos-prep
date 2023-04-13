package prep.ds.algo.heaps;

import java.util.*;

public class MergeIntervals {

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedResults = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (mergedResults.isEmpty() || mergedResults.get(mergedResults.size() - 1)[1] < intervals[i][0]) {
                mergedResults.add(intervals[i]);
            } else {
                int endTime = mergedResults.get(mergedResults.size() - 1)[1];
                mergedResults.get(mergedResults.size() - 1)[1] = Math.max(intervals[i][1], endTime);
            }
        }

        return mergedResults.toArray(new int[mergedResults.size()][2]);
    }
}
