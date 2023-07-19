package comp1110.ass2;


import java.util.ArrayList;
import java.util.List;

/**
 * x&y represent row and column number
 * a&b represent piece and wizard string
 * m&n represent piece and wizard number
 */
public class Location {
    private int row;
    private int column;

    public Location(int row,int column) {
        this.row = row;
        this.column = column;
    }
    private static String[] possibleMoves(ArrayList<List<String>> permutations) {
        int permSize = permutations.size();

        String[] out = new String[permSize];
        for (int i = 0; i < permSize; i++) {
            out[i] = permutations.get(i).get(0);
        }
        return out;
    }


}
