package prep.ds.algo.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeetingRoomsTest {

    private MeetingRooms meetingRooms;

    @BeforeEach
    public void before() {
        meetingRooms = new MeetingRooms();
    }

    @Test
    void minMeetingRooms() {
        int[][] schedule = {{0, 30}, {5, 10}, {15, 20}};

        int minRooms = meetingRooms.minMeetingRooms(schedule);

        Assertions.assertEquals(2, minRooms);
    }
}