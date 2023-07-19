package comp1110.ass2;

/**
 *
 */
public class Demical {
    int x;
    int y;
    String a;
    String b;
    int m;
    int n;
    int[] pieceArr = new int[28];
    int[] wizardArr = new int[28];
    int[] pieceColorArr = new int[28];
    int[] wizardColorArr = new int[28];

    public Demical(String gameStateString){
        this.a = gameStateString.substring(0, gameStateString.indexOf("W"));
        this.b = gameStateString.substring(gameStateString.indexOf("W") + 1);
        a = a.replaceAll("r","0");
        a = a.replaceAll("o","1");
        a = a.replaceAll("y","2");
        a = a.replaceAll("g","3");
        a = a.replaceAll("b","4");
        a = a.replaceAll("i","5");
        a = a.replaceAll("p","6");
        b = b.replaceAll("r","0");
        b = b.replaceAll("o","1");
        b = b.replaceAll("y","2");
        b = b.replaceAll("g","3");
        b = b.replaceAll("b","4");
        b = b.replaceAll("i","5");
        b = b.replaceAll("p","6");
        this.m = a.length() / 4;
        this.n = b.length() / 3;
    }

    /**
     * The array is defined by 10 * row number + 1 * column number with some mathematical properties of this game
     */
    public int[] toPieceArr(){
        for (int i = 0 ; i < m ; i++) {
            String s = a.substring(4*i, 4*i + 4);
            if (s.charAt(0) == '0') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + + 1 + 10 - 1 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '1') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '5') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '2') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '3') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '5') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
            }
            if (s.charAt(0) == '3') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 22;
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 29 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 7 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 22;
                }
                if (s.charAt(1) == '4') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 29 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '5') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '4') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
                if (s.charAt(1) == '3') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '5') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
            }
            if (s.charAt(0) == '5') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
            }
            if (s.charAt(0) == '6') {
                if (s.charAt(1) == '0') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '1') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '4') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '5') {
                    pieceArr[4*i] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceArr[4*i + 1] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceArr[4*i + 2] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceArr[4*i + 3] = 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
            }
        }
        return pieceArr;
    }

    /**
     * The array is defined by 100 * color number + 10 * row number + 1 * column number with
     * some mathematical properties of this game
     */
    public int[] toPieceColorArr() {
        for (int i = 0 ; i < m ; i++) {
            String s = a.substring(4*i, 4*i + 4);
            if (s.charAt(0) == '0') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + + 1 + 10 - 1 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '1') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '5') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '2') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '3') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '5') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
            }
            if (s.charAt(0) == '3') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 22;
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 29 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 7 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 22;
                }
                if (s.charAt(1) == '4') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 29 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '5') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                }
            }
            if (s.charAt(0) == '4') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 8 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
                if (s.charAt(1) == '3') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '4') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '5') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
            }
            if (s.charAt(0) == '5') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                }
            }
            if (s.charAt(0) == '6') {
                if (s.charAt(1) == '0') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '1') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 19;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '2') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 2;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 10 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
                if (s.charAt(1) == '3') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 21;
                }
                if (s.charAt(1) == '4') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 20;
                }
                if (s.charAt(1) == '5') {
                    pieceColorArr[4*i] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1;
                    pieceColorArr[4*i + 1] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 1;
                    pieceColorArr[4*i + 2] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 9 + ((s.charAt(3) - 48) % 2);
                    pieceColorArr[4*i + 3] = 100 * (s.charAt(0) - 48) + 10 * (s.charAt(3) - 48) + s.charAt(2) - 48 + 1 + 11 + ((s.charAt(3) - 48) % 2);
                }
            }
        }
        return pieceColorArr;
    }

    public int[] toWizardArr(){
        int nn = 0;
        for (int j = 0 ; j < b.length() ; j += 3) {
            String k = b.substring(j, j + 3);
            wizardArr[nn] = 10 * (k.charAt(2) - 48) + k.charAt(1) - 48 + 1;
            nn++;
        }
        return wizardArr;
    }

    public int[] toWizardColorArr(){
        int mm = 0;
        for (int j = 0 ; j < b.length() ; j += 3) {
            String k = b.substring(j, j + 3);
            wizardColorArr[mm] = 100 * (k.charAt(0) - 48) + 10 * (k.charAt(2) - 48) + k.charAt(1) - 48 + 1;
            mm++;
        }
        return wizardColorArr;
    }

    //getter and setter of coordinate x and y
    public void getX(String onePeace){
        this.x = onePeace.charAt(1) - 48;
    }
    public void setX(){

    }
    public void getY(String onePeace){
        this.y = onePeace.charAt(1) - 48;
    }
    public void setY(){

    }

}
