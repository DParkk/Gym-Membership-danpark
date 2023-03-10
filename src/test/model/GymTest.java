package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GymTest {

    private Gym gym1;

    @BeforeEach
    void runBefore() {
        gym1 = new Gym();


    }


    @Test
    void addMemberTest() {

        Member mem1 = new Member("Daniel", 180, 80);
        Member mem2 = new Member("Paul", 170, 70);

        gym1.addMember(mem1);
        gym1.addMember(mem2);

        assertEquals(2,gym1.getMemberList().size());
        assertEquals(mem1, gym1.getMemberList().get(0));
        assertEquals(mem2, gym1.getMemberList().get(1));

    }

    @Test
    void setNameTest() {
       gym1.setName("Daniel");

        assertEquals("Daniel", gym1.getGymName());
    }

    @Test
    void getMostDistantRunnerTest() {
        Member mem1 = new Member("Daniel", 180, 80);
        Member mem2 = new Member("Paul", 170, 70);
        Member mem3 = new Member("Jack", 160, 60);
        Member mem4 = new Member("Jason", 185,85);
        mem1.addDistance(12);
        mem2.addDistance(14);
        mem4.addDistance(10);

        try {
            Member mem = gym1.getMostDistantRunner().getMostDist();
            fail();
        } catch (Exception e) {
            // ignore; test passed
        }

        gym1.addMember(mem1);
        gym1.addMember(mem2);
        gym1.addMember(mem4);

        try {
            assertEquals(mem2, gym1.getMostDistantRunner().getMostDist());
        } catch (Exception e) {
            fail("Should've passed without exception");
        }

        gym1.getMemberList().remove(0);

        gym1.addMember(mem3);

        mem3.addDistance(14);

        try {
            assertTrue(gym1.getMostDistantRunner().isTie());
        } catch (Exception e) {
            fail("Should've passed without exception");
        }

    }





    @Test
    void numThingiesTest() {
        Member mem1 = new Member("Daniel", 180, 80);
        Member mem2 = new Member("Paul", 170, 70);
        Member mem3 = new Member("Jack", 160, 60);

        gym1.addMember(mem1);
        gym1.addMember(mem2);
        gym1.addMember(mem3);

        assertEquals(3,gym1.numThingies());
    }


}
