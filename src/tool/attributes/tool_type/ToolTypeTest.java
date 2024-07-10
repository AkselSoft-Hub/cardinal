package tool.attributes.tool_type;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToolTypeTest {
    @Test
    public void testLadderProperties() {
        assertEquals(new BigDecimal("1.99"), TOOL_TYPE.LADDER.dailyCharge);
        assertTrue(TOOL_TYPE.LADDER.weekdayCharge);
        assertTrue(TOOL_TYPE.LADDER.weekendCharge);
        assertFalse(TOOL_TYPE.LADDER.holidayCharge);
    }

    @Test
    public void testChainsawProperties() {
        assertEquals(new BigDecimal("1.49"), TOOL_TYPE.CHAINSAW.dailyCharge);
        assertTrue(TOOL_TYPE.CHAINSAW.weekdayCharge);
        assertFalse(TOOL_TYPE.CHAINSAW.weekendCharge);
        assertTrue(TOOL_TYPE.CHAINSAW.holidayCharge);
    }

    @Test
    public void testJackhammerProperties() {
        assertEquals(new BigDecimal("2.99"), TOOL_TYPE.JACKHAMMER.dailyCharge);
        assertTrue(TOOL_TYPE.JACKHAMMER.weekdayCharge);
        assertFalse(TOOL_TYPE.JACKHAMMER.weekendCharge);
        assertFalse(TOOL_TYPE.JACKHAMMER.holidayCharge);
    }

    @Test
    public void testEnumConstants() {
        assertNotNull(TOOL_TYPE.valueOf("LADDER"));
        assertNotNull(TOOL_TYPE.valueOf("CHAINSAW"));
        assertNotNull(TOOL_TYPE.valueOf("JACKHAMMER"));

        TOOL_TYPE[] values = TOOL_TYPE.values();
        assertEquals(3, values.length);
    }
}
