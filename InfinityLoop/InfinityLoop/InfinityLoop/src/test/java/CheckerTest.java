
import Code.Components.PieceType;
import Code.GUI.Grid;
import Code.Solve.Checker;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;

public class CheckerTest {
    @Test
    void testReadGridFromFile() throws FileNotFoundException {
        Grid grid = Checker.buildGrid("../grids/grid1.txt");
        assertTrue( grid != null);
    }
    @Test
    public void isSolutionTest()  {
        Grid grid1= null;
        try {
            grid1 = Checker.buildGrid("../grids/grid1.txt");
            boolean b = Checker.check(grid1);
            assertTrue(b);
            Grid grid2=Checker.buildGrid("../grids/gridFalse.txt");
            boolean a = Checker.check(grid2);
            assertFalse(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
