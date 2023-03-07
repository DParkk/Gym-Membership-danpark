package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void getMostDistantRunnerTest() throws Exception {
        Member mem1 = new Member("Daniel", 180, 80);
        Member mem2 = new Member("Paul", 170, 70);
        Member mem3 = new Member("Jack", 160, 60);
        mem1.addDistance(12);
        mem2.addDistance(14);

        gym1.addMember(mem1);
        gym1.addMember(mem2);

        assertEquals(mem2, gym1.getMostDistantRunner().getMostDist());

        gym1.getMemberList().remove(0);

        gym1.addMember(mem3);

        mem3.addDistance(14);

        assertTrue(gym1.getMostDistantRunner().isTie());




    }

}
