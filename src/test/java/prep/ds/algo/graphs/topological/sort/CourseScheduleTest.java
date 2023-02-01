package prep.ds.algo.graphs.topological.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CourseScheduleTest {

    private CourseSchedule courseSchedule;

    @BeforeEach
    public void setup() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    public void testCourseSchedule_1() {
        int numCourses = 2;
        int[][] preReq = {{1, 0}};

        int[] topologicalOrder = courseSchedule.findOrder(numCourses, preReq);

        Assertions.assertTrue(topologicalOrder.length > 0);

        Arrays.stream(topologicalOrder)
                .forEach(i -> System.out.printf(" --> %d ", i));
    }

    @Test
    public void testCourseSchedule_2() {
        int numCourses = 4;
        int[][] preReq = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] topologicalOrder = courseSchedule.findOrder(numCourses, preReq);

        Assertions.assertTrue(topologicalOrder.length > 0);

        Arrays.stream(topologicalOrder)
                .forEach(i -> System.out.printf(" --> %d ", i));
    }
}
