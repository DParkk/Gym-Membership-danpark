package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Testing for methods in 'Member' class.
class MemberTest {
    private Member sampleMember;
    private Member sampleMember1;
    private Member sampleMember2;
    private Member sampleMember3;

    @BeforeEach
     void runBefore() {
        sampleMember = new Member("Daniel",178,70);
        sampleMember1 = new Member("Paul", 180, 40);
        sampleMember2 = new Member("Tom", 165, 120);
        sampleMember3 = new Member("Jack", 178, 85);
    }

    @Test
    void testConstructor() {
        assertEquals("Daniel", sampleMember.getName());
        assertEquals(178, sampleMember.getHeight());
        assertEquals(70, sampleMember.getWeight());
    }
    @Test
    void bmiCalculateTest() {
        assertEquals(22.093170054286073, sampleMember.bmiCalculator());
    }

    @Test
    void bmiConvertTest() {
        assertEquals(22.1, sampleMember.bmiConverter());
    }

    @Test
    void adviserTest() {
        assertEquals(1, sampleMember.adviser());
        assertEquals(0, sampleMember1.adviser());
        assertEquals(3, sampleMember2.adviser());
        assertEquals(2, sampleMember3.adviser());




    }

    @Test
    void addDistanceTest() {
        ArrayList runDistance = new ArrayList<Integer>();

        sampleMember.addDistance(1);
        sampleMember.addDistance(2);
        runDistance.add(1);
        runDistance.add(15);

        assertEquals(1, runDistance.get(0));
        assertEquals(15,runDistance.get(1));
        assertEquals(2,runDistance.size());



    }

    @Test
    void getTotalDistanceTest() {

        sampleMember.addDistance(1);
        sampleMember.addDistance(2);

        assertEquals(3,sampleMember.getTotalDistance());
    }
}