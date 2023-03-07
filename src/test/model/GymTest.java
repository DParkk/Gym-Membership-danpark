package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}