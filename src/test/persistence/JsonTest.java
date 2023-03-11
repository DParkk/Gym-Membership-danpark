package persistence;



import model.Member;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(String name, Member member) {
        assertEquals(name, member.getName());

    }
}


