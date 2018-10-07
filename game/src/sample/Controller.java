package sample;

import java.util.Random;

public class Controller {
    private final Random random = new Random();
    int a,b,c;
    int basyo[][]={
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1}
    };

    public void threeplace(){
        a=random.nextInt(9);
        b=random.nextInt(9);
        c=3;
        basyo=Replace(a,b,c,basyo);
    }
    public int[][] Replace(int a,int b,int c,int[][] basyo){
        switch(c){
            case 1:
                basyo[a][b]=2;
                break;
            case 2:
                basyo[a][b]=2;
                basyo[a][b+1]=2;
                basyo[a+1][b]=2;
                basyo[a+1][b+1]=2;
                break;
            case 3:
                basyo[a][b]=2;
                basyo[a-1][b-1]=2;
                basyo[a-1][b]=2;
                basyo[a-1][b+1]=2;
                basyo[a][b-1]=2;
                basyo[a][b+1]=2;
                basyo[a+1][b-1]=2;
                basyo[a+1][b]=2;
                basyo[a+1][b+1]=2;
                break;
            default:
                System.out.println("値が正しくありません");
        }
    }
}

