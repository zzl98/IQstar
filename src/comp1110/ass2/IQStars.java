package comp1110.ass2;

import comp1110.ass2.gui.Board;
import comp1110.ass2.gui.Viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//import static sun.swing.MenuItemLayoutHelper.max;

public class IQStars {

    private static final int[] SPECIAL_ROW = {0,0,0,3,3};
    private static final int[] SPECIAL_COL = {0,3,6,1,4};
    private static final int[] BOARD_ROW = {0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3};
    private static final int[] BOARD_COL = {1,2,4,5,0,1,2,3,4,5,0,1,2,3,4,5,6,0,2,3,5};


    /**
     * Determine whether a game string describing either a wizard or a piece
     * is well-formed according to the following criteria:
     * - It consists of exactly three or four characters
     * - If it consists of three characters, it is a well-formed wizard string:
     * - the first character is a valid colour character (r,o,y,g,b,i,p)
     * - the second character is a valid column number
     * - (0 .. 6) if the row number is 0 or 2
     * - (0 .. 5) otherwise
     * - the third character is a valid row number (0 .. 3)
     * - If it consists of four characters, it is a well-formed piece string:
     * - the first character is a valid colour character (r,o,y,g,b,i,p)
     * - the second character is a valid rotation value
     * - (0 .. 2) if the colour is r or i
     * - (0 .. 5) otherwise
     * - the third character is a valid column number
     * - (0 .. 6) if the row number is 0 or 2
     * - (0 .. 5) otherwise
     * - the fourth character is a valid row number (0 .. 3)
     *
     * @param gameString A string describing either a piece or a wizard
     * @return True if the string is well-formed
     */
    static boolean isGameStringWellFormed(String gameString) {
        //To judge whether the gameString is a piece or a wizard
        if (gameString.length() != 3 && gameString.length() != 4) {
            return false;
        }
        //If the string is a wizard
        if (gameString.length() == 3) {
            //get char at different index of string
            char a = gameString.charAt(0);
            char b = gameString.charAt(1);
            char c = gameString.charAt(2);
            //make sure that the colour is right
            if (a != 'r' && a != 'o' && a != 'y' && a != 'g' && a != 'b' && a != 'i' && a != 'p') {
                return false;
            } else if (c != '0' && c != '1' && c != '2' && c != '3') {
                return false;
            } else if (c == '0' || c == '2') {
                //make sure the number is right
                if (b - 48 > 6 || b - 48 < 0) {
                    return false;
                }
            } else {
                if (b - 48 > 5 || b - 48 < 0) {
                    return false;
                }
            }
        } else {
            //do the same things as a piece
            char a = gameString.charAt(0);
            char b = gameString.charAt(1);
            char c = gameString.charAt(2);
            char d = gameString.charAt(3);
            if (a != 'r' && a != 'o' && a != 'y' && a != 'g' && a != 'b' && a != 'i' && a != 'p') {
                return false;
            } else if (a == 'r' || a == 'i') {
                if (b - 48 > 2 || b - 48 < 0) {
                    return false;
                } else if (d != '0' && d != '1' && d != '2' && d != '3') {
                    return false;
                } else if (d == '0' || d == '2') {
                    if (c - 48 > 6 || c - 48 < 0) {
                        return false;
                    }
                } else {
                    if (c - 48 > 5 || c - 48 < 0) {
                        return false;
                    }
                }
            } else {
                if (b - 48 > 5 || b - 48 < 0) {
                    return false;
                } else if (d != '0' && d != '1' && d != '2' && d != '3') {
                    return false;
                } else if (d == '0' || d == '2') {
                    if (c - 48 > 6 || c - 48 < 0) {
                        return false;
                    }
                } else {
                    if (c - 48 > 5 || c - 48 < 0) {
                        return false;
                    }
                }
            }
        }


        return true;
    }

    /**
     * Determine whether a game state string is well-formed:
     * - The string is of the form [piecePlacement]W[wizardPlacement],
     * where [piecePlacement] and [wizardPlacement] are replaced by the
     * corresponding strings below
     * - [piecePlacement] string specification:
     * - it consists of exactly n four-character piece strings (where n = 0 .. 7);
     * - each piece string is well-formed
     * - no piece appears more than once in the string
     * - the pieces are ordered correctly within the string (r,o,y,g,b,i,p)
     * - [wizardPlacement] string specification:
     * - it consists of exactly n three-character wizard strings (where n is some non-negative integer)
     * - each wizard string is well-formed
     * - the strings are ordered correctly within the string (r,o,y,g,b,i,p)
     * - if there is more than one wizard of a single colour these wizards are ordered first by
     * row and then by column in ascending order (note that this does not prevent two
     * wizards of the same colour being placed in the same location - we will check for this
     * in a later task).
     *
     * @param gameStateString A string describing a game state
     * @return True if the game state string is well-formed
     */


    public static boolean isGameStateStringWellFormed(String gameStateString) {
        if (gameStateString.length() == 1 && gameStateString.equals("W")) return true;
        String a = gameStateString.substring(0, gameStateString.indexOf("W"));
        String b = gameStateString.substring(gameStateString.indexOf("W") + 1);
        String[] checkoradd1 = new String[7];
        String[] av = new String[b.length() / 3];
        Character[] s = new Character[b.length() / 3];
        Character[] rowcheck = new Character[b.length() / 3];
        Character[] colcheck = new Character[b.length() / 3];
        int j = 0;
        int first_char = 0;
        int z = 0;
        int d = 0;
        int[] arr2 = new int[a.length() / 4]; // it stores the pieces.
        if (a.length() != 0) {
            // to check it consists of exactly n four-character piece strings
            if ((a.length() % 4 != 0 || a.length() > 28)) return false;
            for (int i = 0; i < a.length(); i += 4) {
                //to check each piece string is well-formed.
                if (!(isGameStringWellFormed(a.substring(i, i + 4)))) return false;
                //to check if the array already contains the piece string if it does not it adds it to the array.
                if (Arrays.asList(checkoradd1).contains(a.substring(i, i + 4))) return false;
                else {
                    checkoradd1[j] = a.substring(i, i + 4);
                    j++;
                }
                // to order the color of the pieces
                switch (a.charAt(i)) {
                    case 'r':
                        arr2[first_char] = 0;
                        break;
                    case 'o':
                        arr2[first_char] = 1;
                        break;
                    case 'y':
                        arr2[first_char] = 2;
                        break;
                    case 'g':
                        arr2[first_char] = 3;
                        break;
                    case 'b':
                        arr2[first_char] = 4;
                        break;
                    case 'i':
                        arr2[first_char] = 5;
                        break;
                    case 'p':
                        arr2[first_char] = 6;
                        break;
                    default:
                        break;
                }
                first_char++;
            }
            //to check if the pieces are ordered correctly within the string (r,o,y,g,b,i,p).
            for (int y = 0; y < arr2.length - 1; y = y + 1) {
                if (arr2[y] >= arr2[y + 1]) return false;
            }
        }
        // to check that it consists of exactly n three-character wizard strings
        if (b.length() != 0) {
            if ((b.length() % 3 != 0)) {
                return false;
            }

            // array to check sequence of colors.
            int[] arr1 = new int[b.length() / 3];

            //array to check the column and row sequence
            int[] arrr = new int[b.length() / 3];
            int[] arro = new int[b.length() / 3];
            int[] arry = new int[b.length() / 3];
            int[] arrg = new int[b.length() / 3];
            int[] arrb = new int[b.length() / 3];
            int[] arri = new int[b.length() / 3];
            int[] arrp = new int[b.length() / 3];

            //to check if each wizard string is well-formed
            for (int x = 0; x < b.length(); x += 3) {
                if (!(isGameStringWellFormed(b.substring(x, x + 3)))) return false;
                else {
                    av[z] = b.substring(x, x + 3);
                    z++;
                }

                s[d] = b.charAt(x);
                rowcheck[d] = b.charAt(x + 2);
                colcheck[d] = b.charAt(x + 1);
                // int i orders wizard first by row and then by column in ascending order
                int i = 10 * (b.charAt(x + 2) - 48) + b.charAt(x + 1) - 48 + 1;

                switch (b.charAt(x)) {
                    case 'r':
                        arr1[d] = 0;
                        arrr[d] = i;
                        break;
                    case 'o':
                        arr1[d] = 1;
                        arro[d] = i;
                        break;
                    case 'y':
                        arr1[d] = 2;
                        arry[d] = i;
                        break;
                    case 'g':
                        arr1[d] = 3;
                        arrg[d] = i;
                        break;
                    case 'b':
                        arr1[d] = 4;
                        arrb[d] = i;
                        break;
                    case 'i':
                        arr1[d] = 5;
                        arri[d] = i;
                        break;
                    case 'p':
                        arr1[d] = 6;
                        arrp[d] = i;
                        break;
                    default:
                        break;
                }
                d++;

            }
            // to check that the strings are ordered correctly within the string (r,o,y,g,b,i,p).
            for (int e = 0; e < arr1.length - 1; e = e + 1) {
                if (arr1[e] > arr1[e + 1]) return false;
                if (arrr[e] != 0 && arrr[e + 1] != 0) {
                    if (arrr[e] > arrr[e + 1]) return false;
                }
                if (arro[e] != 0 && arro[e + 1] != 0) {
                    if (arro[e] > arro[e + 1]) return false;
                }
                if (arry[e] != 0 && arry[e + 1] != 0) {
                    if (arry[e] > arry[e + 1]) return false;
                }
                if (arrg[e] != 0 && arrg[e + 1] != 0) {
                    if (arrg[e] > arrg[e + 1]) return false;
                }
                if (arrb[e] != 0 && arrb[e + 1] != 0) {
                    if (arrb[e] > arrb[e + 1]) return false;
                }
                if (arri[e] != 0 && arri[e + 1] != 0) {
                    if (arri[e] > arri[e + 1]) return false;
                }
                if (arrp[e] != 0 && arrp[e + 1] != 0) {
                    if (arrp[e] > arrp[e + 1]) return false;
                }
            }
        }
        return true; // FIXME Task 4 (P): determine whether a game state string is well-formed
    }

    /**
     * Determine whether a game state is valid.
     * <p>
     * To be valid, the game state must satisfy the following requirements:
     * - string must be well-formed
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     * - wizards must be on the board
     * - each location may have at most one wizard
     * - each piece must cover all wizards of the same colour
     * - each piece must not cover any wizards of a different colour
     *
     * @param gameStateString A game state string
     * @return True if the game state represented by the string is valid
     */
    public static boolean isGameStateValid(String gameStateString) {
        /**
         * This method call some functions in "Location" class.
         * In "Location" class, I defined arrays for each different piece.
         */
        if (!isGameStateStringWellFormed(gameStateString)) {
            return false;
        }
        String a = gameStateString.substring(0, gameStateString.indexOf("W"));
        String b = gameStateString.substring(gameStateString.indexOf("W") + 1);
        Demical s = new Demical(gameStateString);
        //pieceArr1 transfer the number of row and column to a decimal number
        int[] pieceArr1 = (int[]) Arrays.copyOf(s.toPieceArr(), 28);
        //pieceColorArr1 is like pieceArr1, but this array also take color into considerration
        int[] pieceColorArr1 = (int[]) Arrays.copyOf(s.toPieceColorArr(), 28);
        int[] wizardArr1 = (int[]) Arrays.copyOf(s.toWizardArr(), 28);
        int[] wizardColorArr1 = (int[]) Arrays.copyOf(s.toWizardColorArr(), 28);
        if (a.length() != 0 && b.length() != 0) {
            //check whether piece is on board
            for (int i = 0; i < 28; i++) {
                if (pieceArr1[i] < 0) {
                    return false;
                }
                if (pieceArr1[i] > 7 && pieceArr1[i] < 11) {
                    return false;
                }
                if (pieceArr1[i] > 16 && pieceArr1[i] < 21) {
                    return false;
                }
                if (pieceArr1[i] > 27 && pieceArr1[i] < 31) {
                    return false;
                }
                if (pieceArr1[i] > 36) {
                    return false;
                }
                //check whether pieces and wizards are overlap
                for (int j = 0; j < i; j++) {
                    if (pieceArr1[i] == pieceArr1[j] && pieceArr1[i] != 0) {
                        return false;
                    }
                    if (wizardArr1[i] == wizardArr1[j] && wizardArr1[i] != 0) {
                        return false;
                    }
                }
            }
            //check whether same color
            for (int i = 0; i < 7; i++) {
                int[] pArr = new int[28];
                int[] wArr = new int[28];
                boolean p = false;
                boolean w = false;
                int mm = 0;
                int nn = 0;
                for (int j = 0; j < 28; j++) {
                    if (pieceColorArr1[j] != 0 && pieceColorArr1[j] / 100 == i) {
                        pArr[mm] = pieceColorArr1[j];
                        mm++;
                        p = true;
                    }
                    if (wizardColorArr1[j] != 0 && wizardColorArr1[j] / 100 == i) {
                        wArr[nn] = wizardColorArr1[j];
                        nn++;
                        w = true;
                    }
                }
                if (p && w) {
                    for (int k = 0; k < nn; k++) {
                        boolean f = false;
                        for (int l = 0; l < mm; l++) {
                            if (wArr[k] == pArr[l]) {
                                f = true;
                            }
                        }
                        if (!f) {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 28; j++) {
                    if (wizardColorArr1[i] != 0 && pieceColorArr1[j] != 0 && wizardColorArr1[i] % 100 == pieceColorArr1[j] % 100 && wizardColorArr1[i] / 100 != pieceColorArr1[j] / 100) {
                        return false;
                    }
                }
            }
        }
        if (a.length() == 0 && b.length() != 0) {
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < i; j++) {
                    if (wizardArr1[i] == wizardArr1[j] && wizardArr1[i] != 0) {
                        return false;
                    }
                }
            }
        }
        if (a.length() != 0 && b.length() == 0) {
            for (int i = 0; i < 28; i++) {
                if (pieceArr1[i] < 0) {
                    return false;
                }
                if (pieceArr1[i] > 7 && pieceArr1[i] < 11) {
                    return false;
                }
                if (pieceArr1[i] > 16 && pieceArr1[i] < 21) {
                    return false;
                }
                if (pieceArr1[i] > 27 && pieceArr1[i] < 31) {
                    return false;
                }
                if (pieceArr1[i] > 36) {
                    return false;
                }
                for (int j = 0; j < i; j++) {
                    if (pieceArr1[i] == pieceArr1[j] && pieceArr1[i] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
        // FIXME Task 6 (D): determine whether a game state is valid
    }

    /**
     * Given a string describing a game state, and a location
     * that must be covered by the next move, return a set of all
     * possible viable piece strings which cover the location.
     *
     * For a piece string to be viable it must:
     *  - be a well formed piece string
     *  - be a piece that is not already placed
     *  - not overlap a piece that is already placed
     *  - cover the given location
     *  - cover all wizards of the same colour
     *  - not cover any wizards of a different colour
     *
     * @param gameStateString A starting game state string
     * @param col      The location's column.
     * @param row      The location's row.
     * @return A set of all viable piece strings, or null if there are none.
     */

    static Set<String> getViablePieceStrings(String gameStateString, int col, int row) {
        Set<String> set = new HashSet<String>();
        boolean b = true;
        String ss = gameStateString.substring(0, gameStateString.indexOf("W"));
        for (String v:Pieces.allStartPoint()
             ) {
            String s = ss + v;
            //Test on board
            Pieces p = new Pieces(v);
            int lengthv = p.piecesToArr().length;
            for (int i = 0 ; i < lengthv ; i++) {
                if (!Board.inBoundary(p.piecesToArr()[i].col,p.piecesToArr()[i].row)) {
                    b = false;
                }
            }
            //Test same colour
            if (Pieces.sameColour(s)) {
                b = false;
            }
            //Test overlap
            for (int i = 0 ; i < ss.length() ; i += 4) {
                String sss = gameStateString.substring(i , i + 4);
                if (Pieces.overlap(sss,v)) {
                    b = false;
                }
            }
            //Test cover
            boolean bb = false;
            int lv = p.piecesToArr().length;
            for (int i = 0 ; i < lv ; i++) {
                if (p.piecesToArr()[i].row == row && p.piecesToArr()[i].col == col) {
                    bb = true;
                }
            }
            if (!bb) {
                b =false;
            }
            //Test wizard same
            String wiz = gameStateString.substring(gameStateString.indexOf("W") + 1);
            for (int i = 0 ; i < wiz.length() ; i += 3) {
                if (wiz.charAt(i) == p.color) {
                    boolean bbb = false;
                    for (int j = 0 ; j < lv ; j++) {
                        if (wiz.charAt(i + 1) - 48 == p.piecesToArr()[j].col && wiz.charAt(i + 2) - 48 == p.piecesToArr()[j].row) {
                            bbb = true;
                        }
                    }
                    if (!bbb) {
                        b = false;
                    }
                }
            }
            //Test wizard dif
            for (int i = 0 ; i < wiz.length() ; i += 3) {
                if (wiz.charAt(i) != p.color) {
                    for (int j = 0 ; j < lv ; j++) {
                        if (wiz.charAt(i + 1) - 48 == p.piecesToArr()[j].col && wiz.charAt(i + 2) - 48 == p.piecesToArr()[j].row) {
                            b = false;
                        }
                    }
                }
            }
            if (b) {
                set.add(v);
            }
            b = true;
        }

        if (set.size() == 0) return null;
        return set;
        // FIXME Task 7 (P): determine the set of all viable piece strings given an existing game state
    }

    /**
     * Implement a solver for this game that can return the solution to a
     * particular challenge.
     *
     * This task is at the heart of the assignment and requires you to write
     * solver, similar to the boggle solver presented as part of the J14 lecture.
     *
     * NOTE: Simply looking up the provided answers does not constitute a general
     * solver.  Such an implementation is not a solution to this task, and
     * will not receive marks.
     *
     * @param challenge A game state string describing the starting game state.
     * @return A game state string describing the encoding of the solution to
     * the challenge.
     */
    public static String getSolution(String challenge) {//accepts string
        String s = getSolution3(challenge);
        return s;
        // FIXME Task 10 (CR): determine the solution to the game, given a particular challenge
    }

    /**
     * #author Zhilin Zhang
     * @param challenge challenge string
     * @return a solution to this challenge
     * a simple use of recursion
     */
    public static String getSolution1(String challenge) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        if (a.length() == 28) return challenge;
        Pieces newEmpty = Pieces.getFirstEmpty(challenge);
        if (newEmpty == null) return challenge;
        Set<String> via = getViablePieceStrings(challenge, newEmpty.col, newEmpty.row);
        if (via == null) return null;
        for (String s:via
        ) {
            String ss = Pieces.mergeString(challenge,s);
            if (getSolution1(ss) == null) continue;
            else return getSolution1(ss);
        }
        return null;
    }

    /**
     * @author Zhilin Zhang
     * @param challenge a challenge string
     * @param gameStateString a placed string
     * @return a solution to this challenge
     * try to deal with the challenge in a coordinate way
     */
    public static String getSolution2 (String challenge, String gameStateString) {
        String a = gameStateString.substring(0, gameStateString.indexOf("W"));
        char[][] colourBoard = {
                {'e', 'e', 'e', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'e', 'e', 'e'},
                {'e', 'e', 'e', 'e', 'e', 'e'}
        };
        for (int i = 0 ; i < a.length() ; i += 4) {
            String pie = a.substring(i , i + 4);
            Pieces p = new Pieces(pie);
            int lp = p.piecesToArr().length;
            for (int j = 0 ; j < lp ; j++) {
                colourBoard[p.piecesToArr()[j].row][p.piecesToArr()[j].col] = p.piecesToArr()[j].color;
            }
        }

        int rowNumber = -1;
        int colNumber = -1;
        //judge whether one of the five points is empty
        boolean bb = true;

        for (int i = 0 ; i < SPECIAL_ROW.length ; i++) {
            if (colourBoard[SPECIAL_ROW[i]][SPECIAL_COL[i]] == 'e') {
                rowNumber = SPECIAL_ROW[i];
                colNumber = SPECIAL_COL[i];
                bb = false;
                break;
            }
        }

        if (bb) {
            for (int i = 0; i < BOARD_ROW.length; i++) {
                if (colourBoard[BOARD_ROW[i]][BOARD_COL[i]] == 'e') {
                    rowNumber = BOARD_ROW[i];
                    colNumber = BOARD_COL[i];
                    break;
                }
            }
        }

        if (rowNumber == -1 && colNumber == -1) {
            return gameStateString;
        }

        Set<String> via = getViablePieceStrings(gameStateString,colNumber,rowNumber);
        if (via == null) {
            return null;
        }
        for (String vias:via
             ) {
            String newSol = getSolution2(challenge, Pieces.mergeString(gameStateString,vias));
            if (newSol == null) {
                continue;
            } else {
                return newSol;
            }
        }
        return null;

    }

    /**
     * @author Zhilin Zhang
     * @param challenge a challenge
     * @return a solution to this challenge
     * a way to optimize solution1 but just gey 1/10 time lesser
     */
    public static String getSolution3(String challenge) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        if (a.length() == 28) return challenge;
        if (Pieces.isEmpty(challenge,0,1)) {
            Set<String> via = getViablePieceStrings(challenge, 1, 0);
            if (via == null) return null;
            Set<String> z = Pieces.oneZero();
            for (String s:z
                 ) {
                via.remove(s);
            }
            for (String s:via
            ) {
                String ss = Pieces.mergeString(challenge,s);
                if (getSolution3(ss) == null) continue;
                else return getSolution3(ss);
            }
        }

        if (Pieces.isEmpty(challenge,0,5)) {
            Set<String> via = getViablePieceStrings(challenge, 5, 0);
            if (via == null) return null;
            Set<String> z = Pieces.fiveZero();
            for (String s:z
            ) {
                via.remove(s);
            }
            for (String s:via
            ) {
                String ss = Pieces.mergeString(challenge,s);
                if (getSolution3(ss) == null) continue;
                else return getSolution3(ss);
            }
        }


        Pieces newEmpty = Pieces.getFirstEmpty(challenge);
        if (newEmpty == null) return challenge;
        Set<String> via = getViablePieceStrings(challenge, newEmpty.col, newEmpty.row);
        if (via == null) return null;
        for (String s:via
        ) {
            String ss = Pieces.mergeString(challenge,s);
            if (getSolution1(ss) == null) continue;
            else return getSolution3(ss);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = getSolution1("r001Wy32");
        System.out.println(s);
    } 


}
