package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GymTest {

    private Gym gym1;

    @BeforeEach
    void runBefore() {
        gym1 = new Gym();
        Member mem1 = new Member("Daniel", 180, 80);
        Member mem2 = new Member("Paul", 170, 70);

    }

    @Test
    void testConstructor() {

    }
}
