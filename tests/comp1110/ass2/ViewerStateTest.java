package comp1110.ass2;
import comp1110.ass2.gui.Board;
import comp1110.ass2.gui.Viewer;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ViewerStateTest {
    @Test
    public void outOfBounds() {
        assertFalse(Board.inBoundary(11, 12));
        assertTrue(Board.inBoundary(3, 3));
        assertFalse(Board.inBoundary(6, 3));
        assertTrue(Board.inBoundary(5, 1));
        //assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 0, 23)).contains(Objective.newObjective(0)));
    }

    @Test
    public void repeatPieces() {
        //Tests for if in the normal encoding there are repeated normal pieces. Allowed to have repeat in wizards
        assertFalse(Board.testSameColour("r252y200g540Wr43o42i33"));
        assertTrue(Board.testSameColour("i000b222i123Wg22"));
    }
}
