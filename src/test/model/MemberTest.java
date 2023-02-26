package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberTest {
    private Member sampleMember;

    @BeforeEach
     void runBefore() {
        sampleMember = new Member("Daniel",178,70);
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
        sampleMember.adviser();

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