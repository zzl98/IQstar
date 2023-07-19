package comp1110.ass2;

import java.util.Random;

/**
 * Author: Sineeha Kodwani
 */

public class Objective {

    public static String newObj(int diff) {

        assert diff >= 0 && diff <= 4;

        Random rand = new Random();
        int objN = 0;
        int randomn = rand.nextInt(23-0);

        switch (diff) {
            case (0):
                objN = randomn + 0;
                break;
            case (1):
                objN = randomn + 24;
                break;
            case(2):
                objN = randomn + 48;
                break;
            case(3):
                objN = randomn + 72;
                break;
            case(4):
                objN = randomn + 96;
        }
        return Games.ALL_CHALLENGES[objN];
    }
}










//the class Objective defines the property of a challeng

//public class Objective {
  //  int difficulty;

    //judge whether the challenge is a wizard challenge
    //public boolean isWizard() {
      //  return false;
    //}

    //return the difficulty of a challenge
    //public int isDifficult() {
      //  return difficulty;
    //}
//}
