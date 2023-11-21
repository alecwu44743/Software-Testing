package org.example;

public class Coverage {
    public int func(int x, int y){
        if((x > 10) && (y==1)){
            x = 1;
        }
        else if((x-y) < 2){
            x = 2;
        }

        if(y > 10){
            x = 3;
        }

        return x;
    }
}
