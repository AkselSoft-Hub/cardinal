package tool.attributes.tool_code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToolCodeTest {
    @Test
    public void testChnsProperties() {
        assertEquals("CHNS", TOOL_CODE.CHNS.code);
    }

    @Test
    public void testLadwProperties() {
        assertEquals("LADW", TOOL_CODE.LADW.code);
    }

    @Test
    public void testJakdProperties() {
        assertEquals("JAKD", TOOL_CODE.JAKD.code);
    }

    @Test
    public void testJakrProperties() {
        assertEquals("JAKR", TOOL_CODE.JAKR.code);
    }

    @Test
    public void testEnumConstants() {
        assertNotNull(TOOL_CODE.valueOf("CHNS"));
        assertNotNull(TOOL_CODE.valueOf("LADW"));
        assertNotNull(TOOL_CODE.valueOf("JAKD"));
        assertNotNull(TOOL_CODE.valueOf("JAKR"));

        TOOL_CODE[] values = TOOL_CODE.values();
        assertEquals(4, values.length);
    }
}
