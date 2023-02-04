package prep.ds.algo.graphs.union.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveMaxStonesFromQuarryTest {

    private RemoveMaxStonesFromQuarry removeMaxStonesFromQuarry;

    @BeforeEach
    public void setup() {
        removeMaxStonesFromQuarry = new RemoveMaxStonesFromQuarry();
    }

    @Test
    void testRemoveStones_1() {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};

        int maxStones = removeMaxStonesFromQuarry.removeStones(stones);

        Assertions.assertEquals(5, maxStones);
    }

    @Test
    void testRemoveStones_2() {
        int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};

        int maxStones = removeMaxStonesFromQuarry.removeStones(stones);

        Assertions.assertEquals(3, maxStones);
    }

    @Test
    void testRemoveStones_3() {
        int[][] stones = {{13,22},{2,29},{19,12},{17,27},{3,0},{3,11},{25,11},{3,21},{27,17},{18,19},{23,12},{5,1},{27,2},{24,0},{8,5},{13,21},{29,27},{16,17},{10,8},{19,18},{20,12},{18,27},{12,24},{2,23},{28,29},{17,24},{24,6},{12,10},{4,0},{6,15},{15,15},{12,3},{14,2},{2,6},{7,12},{26,26},{4,5},{20,26},{11,9},{15,10},{14,15},{18,28},{29,4},{6,12},{3,26},{0,8},{6,5},{15,24},{4,15},{15,21},{5,20},{20,28},{23,0},{5,27},{2,3},{8,27},{2,4}};

        int maxStones = removeMaxStonesFromQuarry.removeStones(stones);

        System.out.println(maxStones);
    }
}