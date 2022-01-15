import org.junit.*;
import static org.junit.Assert.*;
import fr.dauphine.JavaAvance.*;
import java.io.*;

public class GeneratorTest {

  private Grid g;

  @Before
  public void init() {
    g = new Grid(4,6);
  }

  @Test
  public void generateLevelTest() {
    Generator.generateLevel("test.txt", g);
    File f = new File("test.txt");
    assertTrue(f.exists());
    BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
    int width = new Integer(reader.readLine());
		int height = new Integer(reader.readLine());
    assertEquals(width,4);
    assertEquals(height,6);
  }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GeneratorTest.class);
    }

}
