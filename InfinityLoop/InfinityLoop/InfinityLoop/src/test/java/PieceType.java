import Code.Components.Orientation;
import Code.Components.Piece;
import org.junit.Test;
import static junit.framework.Assert.assertSame;


public class PieceType {
        @Test
        void testTurnWhenOk() {
            Piece piece = new Piece(0, 0, 1, 0);
            piece.turn();
            assertSame(piece.getOrientation(), Orientation.EAST);
            piece.turn();
            assertSame(piece.getOrientation(), Orientation.SOUTH);
            piece.turn();
            assertSame(piece.getOrientation(), Orientation.WEST);
            piece.turn();
            assertSame(piece.getOrientation(), Orientation.NORTH);
        }
}
