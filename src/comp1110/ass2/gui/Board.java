package comp1110.ass2.gui;

import comp1110.ass2.Objective;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import comp1110.ass2.gui.Viewer;

import java.util.Arrays;

public class Board extends Application {
    Viewer myViewer = new Viewer();


    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;

    private final Group root = new Group();
    //Handler for setting the initial start state of the viewer. Change dif to adjust the difficulty.
    public static String getStartState(String dif) {
        int difficultyFind = Integer.parseInt(dif);
        return Objective.newObj(difficultyFind);
    }
    //Helper functions to ensure that two of the same piece cannot be placed Checks for two or more of same colour

    private static Boolean hasTwo(String gameState, char colour) {
        return gameState.indexOf(colour, gameState.indexOf(colour) + 1) > -1;
    }
    public static boolean testSameColour(String gameStateString) {
        String normalEncoding = gameStateString.substring(0, gameStateString.indexOf("W"));
        return hasTwo(normalEncoding, 'r') || hasTwo(normalEncoding, 'o') || hasTwo(normalEncoding, 'y') || hasTwo(normalEncoding, 'g') || hasTwo(normalEncoding, 'b') || hasTwo(normalEncoding, 'i') || hasTwo(normalEncoding, 'p');
    }

    public static String allColoursOn(String gameStateString) {
        //Checks the given colours already on the board to find out which ones were missing by constructing a string
        //String normalEncoding = gameStateString.substring(0,gameStateString.indexOf("W"));
        String missingC = "";
        String possiblePieces = "bgiopry";
        if (!gameStateString.contains("b")) {
            missingC = missingC + "b";
        }
        if (!gameStateString.contains("g")) {
            missingC = missingC + "g";
        }
        if (!gameStateString.contains("i")) {
            missingC = missingC + "i";
        }
        if (!gameStateString.contains("o")) {
            missingC = missingC + "o";
        }
        if (!gameStateString.contains("p")) {
            missingC = missingC + "p";
        }
        if (!gameStateString.contains("r")) {
            missingC = missingC + "r";
        }
        if (!gameStateString.contains("y")) {
            missingC = missingC + "y";
        }
        if (gameStateString.contains(possiblePieces)) {
            return "";
        }

        return missingC;

    }

    public static boolean inBoundary(int x, int y) {
        if (y == 2 || y == 0) {
            return x >= 0 && x <= 6;
        } else if (y == 1 || y == 3) {
            return x >= 0 && x <= 5;
        } return false;
    }

    // FIXME Task 8 (CR): Implement a basic playable IQ Stars game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 9 (D): Implement challenges (you may use the set of challenges in the Games class)

    // FIXME Task 11 (HD): Implement hints (should become visible when the user presses '/' -- see gitlab issue for details)

    // FIXME Task 12 (HD): Generate interesting challenges (each challenge must have exactly one solution)



    /* board layout */
    private static final int VIEWER_WIDTH = 933;
    private static final int VIEWER_HEIGHT = 700;
    public static final int PLAY_AREA_X = 933;
    public static final int PLAY_AREA_Y = 500;
    public static final int NODE_SIZE = 20;
    public int spin = 0;

    private final Group controls = new Group();
    private final Group difChoice = new Group();
    private final Group textPlacement = new Group();
    private final Group board = new Group();
    private final Group mpiece = new Group();

    private TextField textField;
    private TextField textDif;
    private static DropShadow dropShadow;  {
        dropShadow = new DropShadow();
        dropShadow.setOffsetX(4.0);
        dropShadow.setOffsetY(4.0);
        dropShadow.setColor(Color.color(0, 0, 0, .4));
    }

    private static final String URI_BASE = "assets/";
    private static final String BLANKBOARD_URI = Viewer.class.getResource(URI_BASE + "blankBoard.png").toString();

    /**
     * Draw a game state in the window, removing any previously drawn one
     *
     * @param gameStateString A valid game state string
     */
    void makeGameState(String gameStateString) {

        String totalC = "";

        mpiece.getChildren().clear();

        makeBoard();
        textPlacement.getChildren().clear();

        if (gameStateString.indexOf("W") + 1 == gameStateString.length()) {
            //For gamestates with no wizard and empty
            int timer = 4;
            int k = gameStateString.length();
            int ss = 0;
            while (k >= timer) {
                String pName;
                String noWizCheck = gameStateString.substring(ss, (ss + 4));
                char col = noWizCheck.charAt(0);
                int y = Integer.parseInt(String.valueOf(noWizCheck.charAt(3)));
                int x = Integer.parseInt(String.valueOf(noWizCheck.charAt(2)));
                int orientation = Integer.parseInt(String.valueOf(noWizCheck.charAt(1)));

                pName = switch (col) {
                    case 'r' -> "redPiece";
                    case 'o' -> "orangePiece";
                    case 'y' -> "yellowPiece";
                    case 'g' -> "greenPiece";
                    case 'b' -> "bluePiece";
                    case 'i' -> "indigoPiece";
                    case 'p' -> "pinkPiece";
                    default -> throw new IllegalStateException("Unexpected value: " + col);
                };
                if (y == 0 || y == 2) {
                    x = (x * 124) + 35;
                } else {
                    x = (124 * x + 100);
                }
                y = (y * 105) + 40;

                totalC = totalC + col;
                mpiece.getChildren().add(new GUIPiece(pName, x, y, orientation));

                ss = ss + 4;
                timer = timer + 4;
            }
        } else {
            //For when the w separates a filled wizard and normal.
            String[] parts = gameStateString.split("W");
            String normalEncoding = parts[0];
            String wizardArea = parts[1];

            int i = normalEncoding.length();
            int nEss = 0;
            int normalTimer = 4;
            if (i > 0) {
                while (i >= normalTimer) {
                    String nEName;
                    String pieceCheck = normalEncoding.substring(nEss, (nEss + 4));
                    char nEColour = pieceCheck.charAt(0);
                    int nEY = Integer.parseInt(String.valueOf(pieceCheck.charAt(3)));
                    int nEX = Integer.parseInt(String.valueOf(pieceCheck.charAt(2)));
                    boolean inside = Board.inBoundary(nEX,nEY);
                    int nEO = Integer.parseInt(String.valueOf(pieceCheck.charAt(1)));
                    nEName = switch (nEColour) {
                        case 'r' -> "redPiece";
                        case 'o' -> "orangePiece";
                        case 'y' -> "yellowPiece";
                        case 'g' -> "greenPiece";
                        case 'b' -> "bluePiece";
                        case 'i' -> "indigoPiece";
                        case 'p' -> "pinkPiece";
                        default -> throw new IllegalStateException("Unexpected value: " + nEColour);
                    };
                    if (nEY == 0 || nEY == 2) {
                        nEX = (nEX * 124) + 38;
                    } else {
                        nEX = (124 * nEX + 100);
                    }
                    nEY = (nEY * 105) + 40;
                    //If same colour not true add the new piece. This is not working anymore.
                    totalC = totalC + nEColour;
                    if (!Board.testSameColour(gameStateString) && inside) {

                        mpiece.getChildren().add(new GUIPiece(nEName, nEX, nEY, nEO));
                    }
                    nEss = nEss + 4;
                    normalTimer = normalTimer + 4;
                }
            }

            int j = wizardArea.length();
            int wizardTimer = 3;
            int wizSS=0;
            while (j >= wizardTimer) {
                String wName;
                String wPieceCheck = wizardArea.substring(wizSS,(wizSS+3));
                char wizColour = wPieceCheck.charAt(0);
                int wY = Integer.parseInt(String.valueOf(wPieceCheck.charAt(2)));
                int wX = Integer.parseInt(String.valueOf(wPieceCheck.charAt(1)));
                wName = switch (wizColour) {
                    case 'r' -> "redW";
                    case 'o' -> "orangeW";
                    case 'y' -> "yellowW";
                    case 'g' -> "greenW";
                    case 'b' -> "blueW";
                    case 'i' -> "indigoW";
                    case 'p' -> "pinkW";
                    default -> throw new IllegalStateException("Unexpected value: " + wizColour);
                };
                if (wY == 0 || wY == 2) {
                    wX = (wX * 125) + 32;
                } else {
                    wX = (125*wX + 100);
                }
                wY = (wY * 105) +35;
                //Not included because we want to be able to move pieces over their wizards
                //totalC = totalC + wizColour;
                mpiece.getChildren().add(new WIZARDPiece(wName, wX, wY));
                wizSS = wizSS + 3;
                wizardTimer = wizardTimer +3;
            }
        }
        String missingColours = Board.allColoursOn(totalC);
        int i = 0;
        int xCo = 5;
        while (i < missingColours.length()) {
            char j = missingColours.charAt(i);
            String missingPName;
            missingPName = switch (j) {
                case 'r' -> "redPiece";
                case 'o' -> "orangePiece";
                case 'y' -> "yellowPiece";
                case 'g' -> "greenPiece";
                case 'b' -> "bluePiece";
                case 'i' -> "indigoPiece";
                case 'p' -> "pinkPiece";
                default -> throw new IllegalStateException("Unexpected value: " + j);
            };
            //Creates the bank pieces at orientation 0

            DragPiece piece = new DragPiece(missingPName,xCo,510,0);
            mpiece.getChildren().add(piece);
            xCo = xCo + 200;
            i++;
        }
        mpiece.toFront();
    }

    private void makeBoard() {
        board.getChildren().clear();
        ImageView blankBoard = new ImageView();
        blankBoard.setImage(new Image(BLANKBOARD_URI));
        blankBoard.setFitHeight(500);
        blankBoard.setFitWidth(933);



        board.getChildren().add(blankBoard);
        board.toBack();
    }

    class GUIPiece extends ImageView {


        GUIPiece(String name, int x, int y, int orientation) {

            Image image = new Image(Viewer.class.getResource(URI_BASE + name + ".png").toString());
            setPreserveRatio(true);
            if (name.equals("indigoPiece") || name.equals("greenPiece") || name.equals("yellowPiece") || name.equals("bluePiece")) {
                setFitWidth(375);
                setFitHeight(380);
                x = x - 2;
            } else if (name.equals("pinkPiece")) {
                setFitWidth(320);
                setFitHeight(320);
                x = x + 2;
            } else {
                setFitWidth(300);
                setFitHeight(300);
            }
            setLayoutX(x);
            setLayoutY(y);

            if (orientation != 0) {
                int findX;
                findX = switch (name) {
                    case "redPiece" -> (redOrientX(orientation, x));
                    case "orangePiece" -> (orangeOrientX(orientation, x));
                    case "yellowPiece" -> (yellowOrientX(orientation, x));
                    case "greenPiece" -> (greenOrientX(orientation, x));
                    case "bluePiece" -> (blueOrientX(orientation, x));
                    case "indigoPiece" -> (indigoOrientX(orientation, x));
                    case "pinkPiece" -> (pinkOrientX(orientation, x));
                    default -> throw new IllegalStateException("Unexpected value: " + name);
                };
                int findY;
                findY = switch(name) {
                    case "redPiece" -> (redOrientY(orientation, y));
                    case "orangePiece" -> (orangeOrientY(orientation, y));
                    case "yellowPiece" -> (yellowOrientY(orientation, y));
                    case "greenPiece" -> (greenOrientY(orientation, y));
                    case "bluePiece" -> (blueOrientY(orientation, y));
                    case "indigoPiece" -> (indigoOrientY(orientation, y));
                    case "pinkPiece" -> (pinkOrientY(orientation, y));
                    default -> throw new IllegalStateException("Unexpected value: " + name);
                };
                setRotate(getRotate() + cOrientation(orientation));
                setLayoutX(findX);
                setLayoutY(findY);
            }
            else {
                setLayoutX(x);
                setLayoutY(y);
            }
            setImage(image);
        }
    }

    public int redOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 95;
            case 2 -> x = x - 65;
        }
        return x;
    }
    public int redOrientY(int o, int y) {
        if (o == 1) {
            y = y + 50;
        }
        return y;
    }
    public int orangeOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 95;
            case 2 -> x = x - 185;
            case 3 -> x = x;
            case 4 -> x = x - 95;
            case 5 -> x = x - 60;
        }
        return x;
    }
    public int orangeOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 50;
            case 2 -> y = y;
            case 3 -> y = y;
            case 4 -> y = y + 50;
            case 5 -> y = y;
        }
        return y;
    }
    public int yellowOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 110;
            case 2 -> x = x - 110;
            case 3 -> x = x - 190;
            case 4 -> x = x - 17;
            case 5 -> x = x - 140;
        }
        return x;
    }
    public int yellowOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 75;
            case 2 -> y = y + 20;
            case 3 -> y = y;
            case 4 -> y = y + 20;
            case 5 -> y = y + 75;
        }
        return y;
    }
    public int greenOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 160;
            case 2 -> x = x - 283;
            case 3 -> x = x;
            case 4 -> x = x - 155;
            case 5 -> x = x - 35;
        }
        return x;
    }
    public int greenOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 50;
            case 2 -> y = y - 55;
            case 3 -> y = y;
            case 4 -> y = y + 50;
            case 5 -> y = y - 55;
        }
        return y;
    }
    public int blueOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 110;
            case 2 -> x = x - 235;
            case 3 -> x = x - 65;
            case 4 -> x = x - 17;
            case 5 -> x = x - 145;
        }
        return x;
    }
    public int blueOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 75;
            case 2 -> y = y + 25;
            case 3 -> y = y;
            case 4 -> y = y + 25;
            case 5 -> y = y + 75;
        }
        return y;
    }
    public int indigoOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 65;
            case 2 -> x = x - 190;
        }
        return x;
    }
    public int indigoOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 105;
            case 2 -> y = y + 105;
        }
        return y;
    }

    public int pinkOrientX(int o, int x) {
        switch (o) {
            case 1 -> x = x - 135;
            case 2 -> x = x+20;
            case 3 -> x = x - 60;
            case 4 -> x = x - 50;
            case 5 -> x = x - 20;
        }
        return x;
    }
    public int pinkOrientY(int o, int y) {
        switch (o) {
            case 1 -> y = y + 25;
            case 2 -> y = y - 80;
            case 3 -> y = y;
            case 4 -> y = y - 30;
            case 5 -> y = y - 30;
        }
        return y;
    }

    public int cOrientation(int num) {
        return switch (num) {
            case 1 -> 60;
            case 2 -> 120;
            case 3 -> 180;
            case 4 -> 240;
            case 5 -> 300;
            default -> 0;
        };
    }

    class WIZARDPiece extends ImageView {

        WIZARDPiece(String name, int x, int y) {
            setPreserveRatio(true);
            setFitWidth(300);
            setFitHeight(300);
            Image image = new Image(Viewer.class.getResource(URI_BASE + name + ".png").toString());
            setLayoutX(x);
            setLayoutY(y);
            setImage(image);
        }
    }
    //Trying to create a snap / drag thing. Mainly adjusted from assignment 1.
    class DragPiece extends GUIPiece {
        double mouseOffsetX, mouseOffsetY;
        String name;
        int x;
        int y;
        int orientation;

        DragPiece(String name, int x, int y, int orientation) {
            super(name, x, y, orientation);
            this.name = name;
            this.x = x;
            this.y = y;
            this.orientation = orientation;

            setOnMousePressed(event -> {      // mouse press indicates begin of drag
                requestFocus(); // Listen to key presses
                mouseOffsetX = this.getLayoutX() - event.getSceneX();
                mouseOffsetY = this.getLayoutY() - event.getSceneY();

            });
            setOnMouseDragged(event -> {
                this.setLayoutX(event.getSceneX() + mouseOffsetX);
                this.setLayoutY(event.getSceneY() + mouseOffsetY);
                event.consume();
            });
            setOnMouseReleased(event -> {     // drag is complete
                this.snapToBoard();
            });

            setOnScroll(event -> {
                if(event.getDeltaY() != 0.0)
                    scroll(event.getDeltaY() > 0.0);
            });

            setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.PAGE_UP)
                    scroll(true);

                if (event.getCode() == KeyCode.PAGE_DOWN)
                    scroll(false);
            });
        }

        public boolean onlyThreeCheck (String name) {
            if (name.equals("bluePiece") || name.equals("redPiece")) {
                return true;
            } else {
                return false;
            }
        }

        public void scroll(boolean clockwise) {
            boolean scrolled = true;
            orientation++;
            if (onlyThreeCheck(name) && orientation > 2) {
                orientation = 0;
            }
            if (orientation > 5 && !onlyThreeCheck(name)) {
                orientation = 0;
            }
            this.toFront();
            // if (scrolled) {
            System.out.println(orientation);
            setRotate(cOrientation(orientation));
            System.out.println(getBoardPosition(getLayoutX(),getLayoutY()));
            // }
            spin = spin + 1;

        }

        public int checkOrientation(int spin) {
            if (spin <=4) {
                return orientation = orientation + 1;
            } else {
                spin = 0;
                return spin;
            }
        }

        public String getBoardPosition(double x, double y) {
            int x2 = (snapXtoGrid(x, 0) - PLAY_AREA_X) / NODE_SIZE;
            int y2 = (snapYtoGrid(y) - PLAY_AREA_Y) / NODE_SIZE;
            return new String(x2 + ", " + y2);
        }

        private int snapXtoGrid(double layoutX, double layoutY) {
            int n = (int) (layoutY - PLAY_AREA_Y + NODE_SIZE/2 + 10*NODE_SIZE)/NODE_SIZE;
            int k = adjustSnapY(n);
            int i = (int) (layoutX - VIEWER_WIDTH+NODE_SIZE/2 + 10*NODE_SIZE)/NODE_SIZE;
            System.out.println(i);
            int j = adjustSnapX(i);
            if (k == 0 || k == 2) {
                return 124*j + 38;
            } else {
                i = i -1;
                j = adjustSnapX(i);
                return (124*j + 100);
            }
        }

        private int findXPosOnBoard(double layoutX) {
            int i = (int) (layoutX - VIEWER_WIDTH+NODE_SIZE/2 + 10*NODE_SIZE)/NODE_SIZE;
            return adjustSnapX(i);//Returns the X pos coordinate on board
        }
        private int findYPosOnBoard(double layoutY) {
            int n = (int) (layoutY - PLAY_AREA_Y + NODE_SIZE / 2 + 10 * NODE_SIZE) / NODE_SIZE;
            return adjustSnapY(n);
        }
        public int findCoordinateOnBoard () {
            int x = findXPosOnBoard(getLayoutX());
            int y = findYPosOnBoard(getLayoutY());
            return (x*10 + y);
        }

        public int adjustSnapX(int num) {
            int i = 0;
            if (num > -36 && num < -31) {
                i = 0;
            } else if (num >= -31 && num <-25) {
                i = 1;
            } else if (num >=-25 && num< -18) {
                i = 2;
            } else if (num >=-18 && num < -12) {
                i = 3;
            } else if (num >=-12 && num < -7) {
                i = 4;
            } else if (num >=-7 && num < 0) {
                i = 5;
            } else if (num >=0 && num < 8) {
                i = 6;
            }
            return i;
        }
        private int snapYtoGrid(double layoutY) {
            int n = (int) (layoutY - PLAY_AREA_Y + NODE_SIZE/2 + 10*NODE_SIZE)/NODE_SIZE;
            return (adjustSnapY(n)*105) + 40;
        }
        public int adjustSnapY(int num) {
            int i = 0;
            if (num > -16 && num < -10) {
                i = 0;
            } else if (num >= -10 && num <-5) {
                i = 1;
            } else if (num >=-5 && num< 0) {
                i = 2;
            } else if (num >=0 && num < 10) {
                i = 3;
            }
            return i;
        }

        private void snapLayoutToGrid(double layoutX, double layoutY) {
            setLayoutX(layoutX);
            setLayoutY(layoutY);
        }

        private void snapToBoard() {
            Viewer.DragPiece piece;
            System.out.println(findCoordinateOnBoard());
            int gridX = snapXtoGrid(getLayoutX(), getLayoutY());
            int gridY = snapYtoGrid(getLayoutY());
            //May have to manually correct all the offsets in snapping for every single stage again
            switch(name) {
                case "redPiece":
                    gridX = redOrientX(orientation, gridX);
                    gridY = redOrientY(orientation, gridY);
                    break;
                case "orangePiece":
                    gridX = orangeOrientX(orientation, gridX);
                    gridY = orangeOrientY(orientation, gridY);
                    break;
                case "yellowPiece":
                    gridX = yellowOrientX(orientation, gridX);
                    gridY = yellowOrientY(orientation, gridY);
                    break;
                case "greenPiece":
                    gridX = greenOrientX(orientation, gridX);
                    gridY = greenOrientY(orientation, gridY);
                    break;
                case "bluePiece":
                    gridX = blueOrientX(orientation, gridX);
                    gridY = blueOrientY(orientation, gridY);
                    break;
                case "indigoPiece":
                    gridX = indigoOrientX(orientation, gridX);
                    gridY = indigoOrientY(orientation, gridY);
                    break;
                case "pinkPiece":
                    gridX = pinkOrientX(orientation, gridX);
                    gridY = pinkOrientY(orientation, gridY);
                    break;
            }
            //if (Board.inBoundary(findXPosOnBoard(getLayoutX()),findYPosOnBoard(getLayoutY())))
            snapLayoutToGrid(gridX, gridY);
            setEffect(null);
        }
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Game State:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makeGameState(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }


    private void getDif() {
        difChoice.getChildren().clear();
        Label labela = new Label("difficulty");
        textDif = new TextField();
        textDif.setPrefWidth(10);
        Button button = new Button ("choose");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent f) {
                makeGameState(Board.getStartState(textDif.getText()));
                textDif.clear();
            }
        });
        HBox check = new HBox();
        check.getChildren().addAll(labela,textDif,button);
        check.setSpacing(3);
        check.setLayoutX(200);
        check.setLayoutX(VIEWER_HEIGHT - 50);
        difChoice.getChildren().add(check);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("IQ Stars Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(controls);
        root.getChildren().add(difChoice);
        root.getChildren().add(textPlacement);
        root.getChildren().add(board);
        root.getChildren().add(mpiece);
        makeControls();
        getDif();
        makeGameState(Board.getStartState("1"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
