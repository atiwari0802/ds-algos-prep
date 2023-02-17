package prep.ds.algo.graphs.union.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SatisfiabilityOfEquationTest {

    private SatisfiabilityOfEquation satisfiabilityOfEquation;

    @BeforeEach
    void setUp() {
        satisfiabilityOfEquation = new SatisfiabilityOfEquation();
    }

    @Test
    void testEquationsPossible_1() {
        String[] equations = {"a==b", "b!=a"};

        Assertions.assertFalse(satisfiabilityOfEquation.equationsPossible(equations));
    }

    @Test
    void testEquationsPossible_2() {
        String[] equations = {"a==b", "b==a"};

        Assertions.assertTrue(satisfiabilityOfEquation.equationsPossible(equations));
    }
}