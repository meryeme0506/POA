import Code.Components.Orientation;
import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertSame;

public class OrientationTest {
    @Test
    void testTurn90WhenOK() {
        assertSame(Orientation.NORTH.turn90(), Orientation.EAST);
        assertSame(Orientation.EAST.turn90(), Orientation.SOUTH);
        assertSame(Orientation.SOUTH.turn90(), Orientation.WEST);
        assertSame(Orientation.WEST.turn90(), Orientation.NORTH);
    }
    @Test
    void testOpposedPieceOrientationWhenOK() {
        assertSame(Orientation.WEST.getOpposedOrientation(), Orientation.EAST);
        assertSame(Orientation.EAST.getOpposedOrientation(), Orientation.WEST);
        assertSame(Orientation.NORTH.getOpposedOrientation(), Orientation.SOUTH);
        assertSame(Orientation.SOUTH.getOpposedOrientation(), Orientation.NORTH);

    }


}
