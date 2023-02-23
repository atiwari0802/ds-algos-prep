package prep.ds.algo.graphs.topological.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

    private AlienDictionary alienDictionary;

    @BeforeEach
    void setUp() {
        alienDictionary = new AlienDictionary();
    }

    @Test
    void testAlienOrder_1() {
        String[] words = {"wrt","wrf","er","ett","rftt"};

        String answer = alienDictionary.alienOrder(words);
        System.out.println(answer);
        Assertions.assertEquals("wertf", answer);
    }

    @Test
    void testAlienOrder_2() {
        String[] words = {"z","x","z"};

        String answer = alienDictionary.alienOrder(words);
        Assertions.assertEquals("", answer);
    }
}