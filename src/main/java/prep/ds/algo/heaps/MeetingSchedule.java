package prep.ds.algo.heaps;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingSchedule {

    /**
     * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < intervals.length - 1; i++ ) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
