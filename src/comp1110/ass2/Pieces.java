package comp1110.ass2;

//This class deals with the state of a plastic piece

import comp1110.ass2.gui.Board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *@author Zhilin Zhang
 * This class includes a way to generate a piece
 * Also a lot of helping methods to solve tasks
 */
public class Pieces {
    String placement;
    Location loc;
    int rotation;
    char color;
    int row;
    int col;
    String type;

    public Pieces(String place) {
        if (place.length() == 3) {
            this.placement = place;
            this.color = placement.charAt(0);
            this.row = placement.charAt(2) - 48;
            this.col = placement.charAt(1) - 48;
        }
        if (place.length() == 4) {
            this.placement = place;
            this.color = placement.charAt(0);
            this.row = placement.charAt(3) - 48;
            this.col = placement.charAt(2) - 48;
            this.rotation = placement.charAt(1) - 48;
        }
    }

    public Pieces (char color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    /**
     * @return Arr
     * this method only works for placement who has a length of 4.
     */
    public Pieces[] piecesToArr() {
        if (color == 'o' || color == 'i') {
            Pieces[] arr = new Pieces[3];
            arr[0] = new Pieces(color, row, col);
            if (color == 'o') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row + 1, col - 2 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                }
                if (rotation == 3) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 4) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 2, col);
                }
                if (rotation == 5) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                }
            }
            if (color == 'i') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row, col + 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 2, col - 1);
                }
            }
            return arr;
        } else {
            Pieces[] arr = new Pieces[4];
            arr[0] = new Pieces(color, row, col);
            if (color == 'r') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 2, col);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + row % 2);
                }
            }
            if(color == 'y') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row, col + 2);
                    arr[3] = new Pieces(color, row + 1, col + row % 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 2, col);
                }
                if (rotation == 3) {
                    arr[1] = new Pieces(color, row + 1, col - 2 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + row % 2);
                }
                if (rotation == 4) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + 1 + row % 2);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 5) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 2, col - 1);
                    arr[3] = new Pieces(color, row + 2, col);
                }
            }
            if(color == 'g') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + 1 + row % 2);
                    arr[3] = new Pieces(color, row + 2, col + 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col);
                    arr[3] = new Pieces(color, row + 3, col - 1 + row % 2);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row + 1, col - 3 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col - 2 + row % 2);
                    arr[3] = new Pieces(color, row + 1, col - 1 + row % 2);
                }
                if (rotation == 3) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col + 1);
                    arr[3] = new Pieces(color, row + 2, col + 2);
                }
                if (rotation == 4) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 2, col - 1);
                    arr[3] = new Pieces(color, row + 3, col - 1 + row % 2);
                }
                if (rotation == 5) {
                    arr[1] = new Pieces(color, row , col + 1);
                    arr[2] = new Pieces(color, row, col + 2);
                    arr[3] = new Pieces(color, row + 1, col - 1 + row % 2);
                }
            }
            if(color == 'b') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row, col + 2);
                    arr[3] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row + 1, col - 2 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[3] = new Pieces(color, row + 2, col - 1);
                }
                if (rotation == 3) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 4) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 5) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 2, col - 1);
                }
            }
            if(color == 'p') {
                if (rotation == 0) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col + 1 + row % 2);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 1) {
                    arr[1] = new Pieces(color, row + 1, col + row % 2);
                    arr[2] = new Pieces(color, row + 2, col - 1);
                    arr[3] = new Pieces(color, row + 2, col);
                }
                if (rotation == 2) {
                    arr[1] = new Pieces(color, row, col + 2);
                    arr[2] = new Pieces(color, row + 1, col + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
                if (rotation == 3) {
                    arr[1] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[2] = new Pieces(color, row + 2, col);
                    arr[3] = new Pieces(color, row + 2, col + 1);
                }
                if (rotation == 4) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[3] = new Pieces(color, row + 2, col);
                }
                if (rotation == 5) {
                    arr[1] = new Pieces(color, row, col + 1);
                    arr[2] = new Pieces(color, row + 1, col - 1 + row % 2);
                    arr[3] = new Pieces(color, row + 1, col + 1 + row % 2);
                }
            }
            return arr;
        }


    }


    public static Set<String> allStartPoint() {
        Set<String> set = new HashSet<String>();


        //A set to contain col and row number
        Set<String> integer = new HashSet<String>();
        for (int i = 0 ; i < 4 ; i++) {
            if (i % 2 == 0) {
                for (int j = 0 ; j < 7 ; j++) {
                    String x = "" + j + i;
                    integer.add(x);
                }
            }
            if (i % 2 == 1) {
                for (int j = 0 ; j < 6 ; j++) {
                    String x = "" + j + i;
                    integer.add(x);
                }
            }
        }


        //A set to contain colours
        Set<String> colours = new HashSet<String>();
        colours.add("r");
        colours.add("o");
        colours.add("y");
        colours.add("g");
        colours.add("b");
        colours.add("i");
        colours.add("p");


        for (String c:colours
             ) {
            if (c == "r" || c == "i") {
                for (String i:integer
                     ) {
                    String x = c + "0" + i;
                    String y = c + "1" + i;
                    String z = c + "2" + i;
                    set.add(x);
                    set.add(y);
                    set.add(z);
                }
            } else {
                for (String i:integer
                ) {
                    String x = c + "0" + i;
                    String y = c + "1" + i;
                    String z = c + "2" + i;
                    String xx = c + "3" + i;
                    String yy = c + "4" + i;
                    String zz = c + "5" + i;
                    set.add(x);
                    set.add(y);
                    set.add(z);
                    set.add(xx);
                    set.add(yy);
                    set.add(zz);
                }
            }
        }

        return set;
    }

    /**
     *
     * @param a a string
     * @param b another string
     * @return a boolean value whether two pieces are overlapped
     */
    public static boolean overlap(String a, String b) {
        boolean bb = false;
        Pieces A = new Pieces(a);
        Pieces B = new Pieces(b);
        int la = A.piecesToArr().length;
        int lb = B.piecesToArr().length;
        for (int i = 0 ; i < la ; i++) {
            for (int j = 0 ; j < lb ; j++) {
                if (A.piecesToArr()[i].row == B.piecesToArr()[j].row && A.piecesToArr()[i].col == B.piecesToArr()[j].col) {
                    bb = true;
                }
            }
        }
        return bb;
    }

    //only valid for s.length() at least 8
    public static boolean sameColour(String s) {
        int l = s.length() / 4;
        Character[] cha = new Character[l];
        for (int i = 0 ; i < s.length() ; i += 4) {
            cha[i / 4] = s.charAt(i);
        }
        boolean b = false;
        for (int i = 1 ; i < l ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (cha[i].equals(cha[j])) {
                    b = true;
                }
            }
        }
        return b;
    }

    /**
     * @author Zhilin Zhang
     * @param challenge The challenge string
     * @return a Piece including row and column number
     * (0,0),(3,0),(6,0),(1,3),(4,3)
     * (col,row)
     */
    public static Pieces getFirstEmpty(String challenge) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        String b = challenge.substring(challenge.indexOf("W") + 1);
        for (int i = 0 ; i < 3 ; i += 2) {
            for (int j = 0 ; j < 7 ; j++) {
                boolean bb = false;
                for (int k = 0 ; k < a.length() ; k += 4) {
                    String s = a.substring(k , k + 4);
                    Pieces S = new Pieces(s);
                    int ls = S.piecesToArr().length;
                    for (int l = 0 ; l < ls ; l++) {
                        if (S.piecesToArr()[l].row == i && S.piecesToArr()[l].col == j) {
                            bb = true;
                        }
                    }
                }
                if (bb == false) return new Pieces('n',i,j);
            }
        }
        for (int i = 1 ; i < 4 ; i+=2) {
            for (int j = 0 ; j < 6 ; j++) {
                boolean bb = false;
                for (int k = 0 ; k < a.length() ; k += 4) {
                    String s = a.substring(k , k + 4);
                    Pieces S = new Pieces(s);
                    int ls = S.piecesToArr().length;
                    for (int l = 0 ; l < ls ; l++) {
                        if (S.piecesToArr()[l].row == i && S.piecesToArr()[l].col == j) {
                            bb = true;
                        }
                    }
                }
                if (bb == false) return new Pieces('n',i,j);
            }
        }
        return null;
    }

    /**
     *
     * @param challenge challenge string
     * @param s a piece that I want to merge
     * @return a string including challenge and a piece in a valid way
     */
    public static String mergeString(String challenge, String s) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        String b = challenge.substring(challenge.indexOf("W"));
        if (a.length() == 0) {
            return s + challenge;
        }
        int la = a.length();
        String ss = "roygbip";
        for (int i = 0 ; i < la ; i += 4) {
            if (ss.indexOf(s.substring(0,1)) < ss.indexOf(a.substring(i,i+1))) {
                String bef = a.substring(0,i);
                String aft = a.substring(i);
                return bef + s + aft + b;
            }
        }
        return a + s + b;
    }

    /**
    (col,row)
    (0,0),(3,0),(6,0),(1,3),(4,3)
     Sadly a failure to optimize task10
     */
    public static boolean fivePointsSameColour(String challenge) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        String b = challenge.substring(challenge.indexOf("W") + 1);
        int la = a.length();
        List<Integer> numlist = new ArrayList<>();
        List<Character> colorlist = new ArrayList<>();
        for (int i = 0 ; i < la ; i += 4) {
            String s = a.substring(i , i + 4);
            Pieces p = new Pieces(s);
            int ls = s.length();
            for (int j = 0 ; j < ls ; j++) {
                if (p.piecesToArr()[j].col == 0 && p.piecesToArr()[j].row == 0) {
                    colorlist.add(p.piecesToArr()[j].color);
                }
                if (p.piecesToArr()[j].col == 3 && p.piecesToArr()[j].row == 0) {
                    colorlist.add(p.piecesToArr()[j].color);
                }
                if (p.piecesToArr()[j].col == 6 && p.piecesToArr()[j].row == 0) {
                    colorlist.add(p.piecesToArr()[j].color);
                }
                if (p.piecesToArr()[j].col == 1 && p.piecesToArr()[j].row == 3) {
                    colorlist.add(p.piecesToArr()[j].color);
                }
                if (p.piecesToArr()[j].col == 4 && p.piecesToArr()[j].row == 3) {
                    colorlist.add(p.piecesToArr()[j].color);
                }
            }
        }
        int lnumlist = numlist.size();
        boolean bb = false;
        for (int i = 0 ; i < lnumlist ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (colorlist.get(i).equals(colorlist.get(j))) {
                    bb = true;
                }
            }
        }
        return bb;
    }

    /**
     *
     * @param challenge a challenge string
     * @param row row number
     * @param col column number
     * @return whether the point in a challenge is empty
     */
    public static boolean isEmpty(String challenge , int row , int col) {
        String a = challenge.substring(0, challenge.indexOf("W"));
        String b = challenge.substring(challenge.indexOf("W") + 1);
        int la = a.length();
        boolean bb = true;
        for (int i = 0 ; i < la ; i += 4) {
            String s = a.substring(i , i + 4);
            Pieces p = new Pieces(s);
            int lp = p.piecesToArr().length;
            for (int j = 0 ; j < lp ; j++) {
                if (p.piecesToArr()[j].row == row && p.piecesToArr()[j].col == col) {
                    bb = false;
                }
            }
        }
        return bb;
    }

    /**
     * @author Zhilin Zhang
     * @param challenge a parameter in task11
     * @return A set of string that helps solve the challenge
     */
    public static Set<String> hintPiece (String challenge) {
        String challengePiece = challenge.substring(0,challenge.indexOf("W"));
        String solution = IQStars.getSolution(challenge);
        String solutionPiece = solution.substring(0,solution.indexOf("W"));
        Set<String> hPiece = new HashSet<>();
        int lengthChallengePiece = challengePiece.length();
        int lengthSolutionPiece = solutionPiece.length();
        for (int i = 0 ; i < lengthSolutionPiece ; i += 4) {
            boolean isPieceInChallenge = false;
            String checkPiece = solutionPiece.substring(i,i+4);
            for (int j = 0 ; j < lengthChallengePiece ; j += 4) {
                if (checkPiece == challengePiece.substring(j,j+4)) isPieceInChallenge = true;
            }
            if (!isPieceInChallenge) hPiece.add(checkPiece);
        }
        return hPiece;
    }

    /**
     * @author Zhilin Zhang
     * @param gameStateString The gamestate print on the board
     * @param piece The piece player want to place
     * @return b Whether the piece is valid at that place
     */
    public static boolean isPieceValid(String gameStateString, String piece) {
        boolean b = true;
        String ss = gameStateString.substring(0, gameStateString.indexOf("W"));
        String v = piece;
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
        int lv = p.piecesToArr().length;
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
        return b;
    }

    /**
     * @author Zhilin
     * @return invalid string at (1,0)
     */
    public static Set<String> oneZero() {
        Set<String> z = new HashSet<>();
        z.add("r110");
        z.add("r210");
        z.add("o110");
        z.add("o410");
        z.add("y110");
        z.add("y510");
        z.add("g410");
        z.add("g510");
        z.add("b310");
        z.add("b510");
        z.add("i210");
        z.add("p110");
        z.add("p210");
        z.add("p310");
        z.add("p410");
        z.add("p510");
        return z;
    }

    /**
     * @author Zhilin
     * @return invalid string at (5,0)
     */
    public static Set<String> fiveZero() {
        Set<String> z = new HashSet<>();
        z.add("r040");
        z.add("r150");
        z.add("o040");
        z.add("o150");
        z.add("o450");
        z.add("y150");
        z.add("y350");
        z.add("g040");
        z.add("g150");
        z.add("b150");
        z.add("b550");
        z.add("i150");
        z.add("p040");
        z.add("p150");
        z.add("p230");
        z.add("p350");
        z.add("p540");
        return z;
    }



    public static void main(String[] args) {

    }




    public Pieces(char color, int row, int col, int rotation) {
        this.placement = "";

    }





    //return the Placement
    public String getPlacement(){
        return "";

    }

    //set the placement
    public void setPlacement(){

    }

    //set the piece
    public void piece(){

    }

    //remove the piece
    public void removePiece(){

    }





}
