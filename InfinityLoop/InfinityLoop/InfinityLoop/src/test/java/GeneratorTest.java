import Code.GUI.Grid;
import Code.Solve.Generator;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class GeneratorTest {

    private Grid g;

    @Before
    public void init() {
        g = new Grid(4,6);
    }

    @Test
    public void generateLevelTest() {
        try {
            Generator.generateLevel("test.txt", g);
            File f = new File("test.txt");
            assertTrue(f.exists());
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            int width = 0;

            width = new Integer(reader.readLine());
            int height = new Integer(reader.readLine());
            assertEquals(width, 4);
            assertEquals(height, 6);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}