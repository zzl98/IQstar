package comp1110.ass2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class objectivetest {

    @Test
    public void test1() {
        assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 0, 23)).contains(Objective.newObj(0)));


        assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 25, 48)).contains(Objective.newObj(1)));


        assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 49, 72)).contains(Objective.newObj(2)));


        assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 73, 96)).contains(Objective.newObj(3)));


        assertEquals(true, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 97, 120)).contains(Objective.newObj(4)));


        assertEquals(false, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 0, 23)).contains(Objective.newObj(3)));


        assertEquals(false, Arrays.asList(Arrays.copyOfRange(Games.ALL_CHALLENGES, 97, 120)).contains(Objective.newObj(2)));


    }
}