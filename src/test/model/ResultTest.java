package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
//Testing for Result
public class ResultTest {

    private Result result;

    @BeforeEach
    void runBefore() {

        result = new Result(false, new Member("Daniel", 180 ,80));

    }

    @Test
    void constructorTest() {


        assertFalse(result.isTie());
        assertEquals("Daniel", result.getMostDist().getName());
        assertEquals(180, result.getMostDist().getHeight());
        assertEquals(80, result.getMostDist().getWeight());
    }
}
