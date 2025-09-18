

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class NumberUtilsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumberUtilsTest
{
    /**
     * Default constructor for test class NumberUtilsTest
     */
    public NumberUtilsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void mcm()
    {
        NumberUtils numberUt2 = new NumberUtils();
        assertEquals(12, numberUt2.minimoComunMultiplo(3, 4));
        assertEquals(35, numberUt2.minimoComunMultiplo(5, 7));
        assertEquals(90, numberUt2.minimoComunMultiplo(9, 10));
        assertEquals(12, numberUt2.minimoComunMultiplo(4, 6));
        assertEquals(36, numberUt2.minimoComunMultiplo(12, 18));
    }
}

