package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}