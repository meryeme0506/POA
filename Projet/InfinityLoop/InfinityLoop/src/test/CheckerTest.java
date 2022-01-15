import org.junit.*;
import static org.junit.Assert.*;
import fr.dauphine.JavaAvance.*;
import java.io.*;

public class CheckerTest {

  @Before
  public void init() {
    // produit une grid minimale qui est une solution
    File f = new File("check.txt");
    f.write("1\n");
    f.write("2\n");
    f.write("\u257A");
    f.write("\u2578");
  }

  @Test
  public void isSolutionTest() {
    boolean b = Checker.isSolution("check.txt");
    assertTrue(b);
  }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CheckerTest.class);
    }

}
