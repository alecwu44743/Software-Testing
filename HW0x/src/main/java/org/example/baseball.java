package org.example;

import java.util.Arrays;

public class Baseball {
    public void validateArray(int inningA[], int inningB[], int playerA[], int playerB[]) throws Exception{
        if(inningA.length < 9 || inningB.length < 9) { // inning length shouldn't be less than 9
            throw new Exception("局數小於九局");
        }

        if(inningA.length != inningB.length) { // inning length should be equal
            throw new Exception("局數不一致");
        }

        // total score of inning should be equal to total score of player
        if((calculateArray(inningA) != calculateArray(playerA)) || (calculateArray(inningB) != calculateArray(playerB))) {
            throw new Exception("總分不一致");
        }

        if(calculateArray(inningA) == calculateArray(inningB)) { // total score of inning should not be equal
            throw new Exception("不可以和局");
        }

        // if inningB[8] is -1, 
        // the total score of the first 8 innings of inningB should be 
        // greater than the total score of the first 9 innings of inningA
        if(inningB[8] == -1 && !(calculateArray(Arrays.copyOfRange(inningA, 0, 9)) < calculateArray(Arrays.copyOfRange(inningB, 0, 8)))) {
            throw new Exception("不合理的提前結束");
        }

        for(int i=0; i<inningB.length; i++) {
            if((inningB[i] == -1 && i != 8) || inningA[i] == -1) { // inningB[8] should be the only -1 in inningB
                throw new Exception("提前結束只可能出現在九下");
            }
        }

        if ((calculateArray(Arrays.copyOfRange(inningA, 0, 9)) != calculateArray(Arrays.copyOfRange(inningB, 0, 9))) && (inningA.length > 9 || inningB.length > 9)) { // should not have extra innings
            throw new Exception("沒有必要的延長局");
        }

    }

    public int calculateArray(int input[]){ // calculate total score of an array
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == -1){
                continue;
            }
            sum += input[i];
        }
        return sum;
    }

    // calculate the score of the game
    public int score(int inningA[], int inningB[], int playerA[], int playerB[]) throws Exception {
        validateArray(inningA, inningB, playerA, playerB); // validate the input arrays

        // return the score of the game
        // positive number means playerA wins
        // negative number means playerB wins
        return calculateArray(inningA) - calculateArray(inningB);
    }
}
