package comp1110.ass2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OrangePieceWellDesignedTest {

    private void test(String in, int[] expected) {
        Pieces p = new Pieces(in);
        int row = p.piecesToArr()[2].row;
        int col = p.piecesToArr()[2].col;
        int[] a = new int[]{row,col};
        assertArrayEquals(expected,a, "Incorrect result for input '"+in+"'");
    }

    @Test
    public void evenLastInNextLine() {
        test("o000", new int[]{1,1});
        test("o010", new int[]{1,2});
        test("o020", new int[]{1,3});
        test("o220", new int[]{1,1});
    }

    @Test
    public void oddLastInNextLine() {
        test("o001", new int[]{2,2});
        test("o221", new int[]{2,2});
    }

    @Test
    public void doubleLine() {
        test("o100", new int[]{2,0});
    }

}
