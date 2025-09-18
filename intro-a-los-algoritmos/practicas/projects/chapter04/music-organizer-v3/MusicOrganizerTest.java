

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MusicOrganizerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MusicOrganizerTest
{
    /**
     * Default constructor for test class MusicOrganizerTest
     */
    public MusicOrganizerTest()
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
    public void removeFilestest()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        System.out.println("");
        System.out.println("Nuevo test");
        System.out.println("");
        musicOrg1.addFile("f1");
        musicOrg1.addFile("g2");
        musicOrg1.addFile("g4");
        musicOrg1.addFile("f3");
        musicOrg1.addFile("f17");
        musicOrg1.listAllFiles();
        musicOrg1.removeFilesBackwards("g");
        System.out.println("Listando la lista modificada");
        musicOrg1.listAllFiles();
    }
}

