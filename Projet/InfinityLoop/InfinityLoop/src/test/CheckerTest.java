import org.junit.*;
import static org.junit.Assert.*;
import fr.dauphine.JavaAvance.*;
import java.io.*;

public class CheckerTest {

  @Before
  public void init() {
    // produit une grid minimale qui est une solution
    File f = new File("checkTrue.txt");
    f.write("1\n");
    f.write("2\n");
    f.write("\u257A");
    f.write("\u2578");
    File f = new File("checkFalse.txt");
    f.write("1\n");
    f.write("2\n");
    f.write("\u257A");
    f.write("\u2502");
  }

  @Test
  public void isSolutionTest() {
    boolean b = Checker.isSolution("checkTrue.txt");
    assertTrue(b);
    boolean a = Checker.isSolution("checkFalse.txt");
    assertFalse(a);
  }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CheckerTest.class);
    }

}
