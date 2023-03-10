package persistence;

import model.Member;
import model.Gym;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Gym wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            Gym wr = reader.read();
            assertEquals("Daniel", wr.getGymName());
            assertEquals(0, wr.numThingies());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            Gym wr = reader.read();
            assertEquals("My work room", wr.getGymName());
            List<Member> memberList = wr.getMemberList();
            assertEquals(2, memberList.size());
            
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
