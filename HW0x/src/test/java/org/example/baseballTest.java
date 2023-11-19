package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {
    @Test
    public void testValidateArray() throws Exception {
        Baseball game = new Baseball();

        // Add test cases to achieve high coverage
        // ...

        // Example: Test for "局數小於九局" exception
        int[] inningA = {1, 2, 3};
        int[] inningB = {3, 4, 5};
        int[] playerA = {1, 2, 3};
        int[] playerB = {3, 4, 5};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test
    public void testCalculateArray() {
        Baseball game = new Baseball();

        // Add test cases to achieve high coverage
        // ...

        // Example: Test for calculateArray()
        int[] input = {1, 2, 3};
        int expected = 6;
        int actual = game.calculateArray(input);
        assertEquals(expected, actual);
    }

    // for score()
    @Test // Example: Test for "局數小於九局" exception
    public void testScore_1() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1,1,1,1,1,1,1,1};
        int[] inningB = {1,1,1,1,1,1,1,2};
        int[] playerA = {2,0,1,1,1,1,0,2};
        int[] playerB = {1,1,3,0,0,1,1,2};

        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "局數不一致" exception
    public void testScore_2() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1,1,1,1,1,1,1,1,0};
        int[] inningB = {1,1,1,1,1,1,1,2,0,1,1};
        int[] playerA = {2,0,1,1,1,1,0,2,0};
        int[] playerB = {1,1,3,0,0,1,1,2,0};

        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "總分不一致" exception
    public void testScore_3() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1,1,1,1,1,1,1,1,0};
        int[] inningB = {1,1,1,1,1,1,1,2,0};
        int[] playerA = {2,0,1,1,1,1,0,3,0};
        int[] playerB = {1,1,3,0,0,1,1,8,1};

        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "不可以和局" exception
    public void testScore_4() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1,1,1,1,1,1,1,1,0};
        int[] inningB = {1,1,1,1,1,1,1,1,0};
        int[] playerA = {2,0,1,1,1,1,0,2,0};
        int[] playerB = {1,1,1,1,1,1,1,1,0};

        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "不合理的提前結束" exception
    public void testScore_5() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1,1,1,1,1,1,2,-1,0};
        int[] inningB = {1,1,1,1,1,1,1,0,0};
        int[] playerA = {1,1,1,1,1,1,2,0,0};
        int[] playerB = {1,1,1,1,1,1,1,0,0};

        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "不合理的提前結束" exception
    public void testScore_6() throws Exception {
        Baseball game = new Baseball();

        // Test case where inningA[7] is -1, and the total score of the first 7 innings is less than or equal to the total score of the first 8 innings of inningB
        int[] inningA = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] inningB = {1, 1, 1, 1, 1, 1, 1, -1, 0};
        int[] playerA = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] playerB = {1, 1, 1, 1, 1, 1, 1, 1};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "不合理的提前結束" exception
    public void testScore_7() throws Exception {
        Baseball game = new Baseball();

        // Test case where inningA[7] is -1, and the total score of the first 7 innings is greater than the total score of the first 8 innings of inningB
        int[] inningA = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] inningB = {1, 1, 1, 1, 1, 1, 1, -1}; // 注意最後一局是提前結束的標記
        int[] playerA = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] playerB = {1, 1, 1, 1, 1, 1, 1, 1};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "不合理的提前結束" exception
    public void testScore_8() throws Exception {
        Baseball game = new Baseball();

        int[] inningA = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] inningB = {1, 1, 1, 1, 1, 1, 1, 1, -1}; // 注意最後一局是提前結束的標記
        int[] playerA = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] playerB = {1, 1, 1, 1, 1, 1, 1, 1, 0};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "沒有必要的延長局" exception
    public void testScore_9() throws Exception {
        Baseball game = new Baseball();

        // Test case where inningA[7] is -1, inningB[7] is 'X', and the total score of the first 7 innings of inningA is equal to the total score of the first 7 innings of inningB
        int[] inningA = {1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1};
        int[] inningB = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
        int[] playerA = {1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1};
        int[] playerB = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test // Example: Test for "提前結束只可能出現在九下" exception
    public void testScore_10() throws Exception {
        Baseball game = new Baseball();

        // Test case where inningA[7] is -1, and inningB[6] is -1
        int[] inningA = {1, 1, 1, 1, 1, 1, 1, 0, 0};
        int[] inningB = {1, 1, 1, 1, 1, 1, -1, 0, 0};
        int[] playerA = {0, 1, 1, 1, 1, 1, 1, 1};
        int[] playerB = {1, 1, 1, 1, 1, 1, 0, 0};

        assertThrows(Exception.class, () -> game.validateArray(inningA, inningB, playerA, playerB));
    }

    @Test
    public void testScore_lose_win() throws Exception {
        Baseball game = new Baseball();


        // Example: Test for "局數小於九局" exception
        int[] inningA = {1,1,1,1,1,1,1,1,0};
        int[] inningB = {1,1,1,1,1,1,1,2,0};
        int[] playerA = {2,0,1,1,1,1,0,2,0};
        int[] playerB = {1,1,3,0,0,1,1,2,0};

//        assertThrows(Exception.class, () -> game.score(inningA, inningB, playerA, playerB));
        assertEquals(-1, game.score(inningA, inningB, playerA, playerB));
    }



}