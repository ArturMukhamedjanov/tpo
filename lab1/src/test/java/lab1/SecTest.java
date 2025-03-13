package lab1;

import org.junit.Test;
import static org.junit.Assert.*;

public class SecTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testCos() {
        assertEquals(1.0, Sec.cos(0, 10), DELTA);
        assertEquals(0.0, Sec.cos(Math.PI / 2, 10), DELTA);
        assertEquals(-1.0, Sec.cos(Math.PI, 10), DELTA);
        assertEquals(0.0, Sec.cos(3 * Math.PI / 2, 10), DELTA);
        assertEquals(1.0, Sec.cos(2 * Math.PI, 10), DELTA);
        assertEquals(Math.sqrt(2) / 2, Sec.cos(Math.PI / 4, 10), DELTA);
    }

    @Test
    public void testSec() {
        assertEquals(1.0, Sec.sec(0, 10), DELTA);
        assertEquals(-1.0, Sec.sec(Math.PI, 10), DELTA);
        assertEquals(2.0, Sec.sec(Math.PI / 3, 10), DELTA);
        assertEquals(-2.0, Sec.sec(2 * Math.PI / 3, 10), DELTA);
        assertTrue(Double.isInfinite(Sec.sec(Math.PI / 2, 10)));
        assertTrue(Double.isInfinite(Sec.sec(3 * Math.PI / 2, 10)));
    }

    @Test
    public void testEdgeCases() {
        assertEquals(1.0, Sec.sec(1e-10, 10), DELTA);
        assertEquals(Sec.sec(100 * Math.PI, 10), Sec.sec(0, 10), DELTA);
        assertEquals(Sec.sec(-Math.PI / 4, 10), Sec.sec(7 * Math.PI / 4, 10), DELTA);
    }

    @Test
    public void testPrecision() {
        double x = Math.PI / 4;
        assertEquals(1 / Math.cos(x), Sec.sec(x, 5), 1e-2);
        assertEquals(1 / Math.cos(x), Sec.sec(x, 10), 1e-6);
    }
}