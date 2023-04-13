package prep.ds.algo.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeetingScheduleTest {

    private MeetingSchedule meetingSchedule;

    @BeforeEach
    void setUp() {

        meetingSchedule = new MeetingSchedule();
    }

    @Test
    void canAttendMeetings() {
        int[][] schedule = {{0, 30}, {5, 10}, {15, 20}};

        boolean canAttend = meetingSchedule.canAttendMeetings(schedule);

        Assertions.assertFalse(canAttend);
    }
}