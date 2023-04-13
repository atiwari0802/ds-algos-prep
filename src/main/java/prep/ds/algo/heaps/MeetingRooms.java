package prep.ds.algo.heaps;

import java.util.*;

public class MeetingRooms {

    /**
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference
     * rooms required.src/main/java/prep/ds/algo/heaps/MeetingRooms.java 
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> meetingRooms = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        meetingRooms.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (meetingRooms.peek() <= intervals[i][0]) {
                meetingRooms.poll();
            }
            meetingRooms.offer(intervals[i][1]);
        }

        return meetingRooms.size();
    }
}
