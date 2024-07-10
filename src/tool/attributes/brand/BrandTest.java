package tool.attributes.brand;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BrandTest {
    @Test
    public void testStihlProperties() {
        assertEquals("Stihl", BRAND.STIHL.brand);
    }

    @Test
    public void testWernerProperties() {
        assertEquals("Werner", BRAND.WERNER.brand);
    }

    @Test
    public void testDewaltProperties() {
        assertEquals("DeWalt", BRAND.DEWALT.brand);
    }

    @Test
    public void testRidgidProperties() {
        assertEquals("Ridgid", BRAND.RIDGID.brand);
    }

    @Test
    public void testEnumConstants() {
        assertNotNull(BRAND.valueOf("STIHL"));
        assertNotNull(BRAND.valueOf("WERNER"));
        assertNotNull(BRAND.valueOf("DEWALT"));
        assertNotNull(BRAND.valueOf("RIDGID"));

        BRAND[] values = BRAND.values();
        assertEquals(4, values.length);
    }
}
