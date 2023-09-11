package flik;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: FlikTest
 * @Author: LiQi
 * @Date: 2023-09-11 9:24
 * @Version: V1.0
 * @Description:
 */
public class FlikTest {

    @Test
    public void testSameNumber() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(128, 128));
    }

    @Test
    public void testSameNumberWithNull() {
        assertFalse(Flik.isSameNumber(1, null));
        assertFalse(Flik.isSameNumber(null, 1));
        assertTrue(Flik.isSameNumber(null, null));
    }
}
