package sample;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Controller implements Initializable{
    private final Random random = new Random();
    int a,b,c,d,e,f,g,h,k;
    boolean flag;
    int basyo[][]={
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void start(){
        basyo=Thirdfield(basyo);
        for(int i=0;i<2;i++) {
          basyo=secondfield(basyo);
        }
        for (int i=0;i<3;i++) {
            basyo = firstfield(basyo);
        }
        print(basyo);
    }


    private int[][] Thirdfield(int[][] basyo){
        a=random.nextInt(7)+1;
        b=random.nextInt(7)+1;
        c=3;
        basyo=Replace(a,b,c,basyo);
        return basyo;
    }
    private int[][] secondfield(int[][] basyo){
        do {
            d = random.nextInt(8)+1;
            e = random.nextInt(8)+1;
            f = 2;
            flag=check(d,e,f);
        }while(!flag);
        basyo = Replace(d, e, f, basyo);
        return basyo;
    }
    private int[][] firstfield(int[][] basyo){
        do {
            d = random.nextInt(10)+1;
            e = random.nextInt(10)+1;
            f = 1;
            flag=check(d,e,f);
        }while(!flag);
        basyo = Replace(d, e, f, basyo);
        return basyo;
    }

    private int[][] Replace(int a,int b,int c,int[][] basyo){
        if(c==1) {
            basyo[a][b] = 2;
            return basyo;
        }else if(c==2) {
            for (int i = a; i <a+ 2; i++) {
                for (int j = b; j <b+ 2; j++) {
                    basyo[i][j] = 3;
                }
            }
            basyo[a - 1][b - 1] = 5;
            basyo[a - 1][b] = 5;
            basyo[a - 1][b + 1] = 5;
            basyo[a - 1][b + 2] = 5;
            basyo[a][b - 1] = 5;
            basyo[a][b + 2] = 5;
            basyo[a + 1][b - 1] = 5;
            basyo[a + 1][b + 2] = 5;
            basyo[a + 2][b - 1] = 5;
            basyo[a + 2][b] = 5;
            basyo[a + 2][b + 1] = 5;
            basyo[a + 2][b + 2] = 5;
            return basyo;
        }else if(c==3) {
            for (int i = a; i <a+ 3; i++) {
                for (int j = b; j <b+ 3; j++) {
                    basyo[i][j] = 4;
                }
            }
            basyo[a - 1][b - 1] = 5;
            basyo[a - 1][b] = 5;
            basyo[a - 1][b + 1] = 5;
            basyo[a - 1][b + 2] = 5;
            basyo[a - 1][b + 3] = 5;
            basyo[a][b - 1] = 5;
            basyo[a][b + 3] = 5;
            basyo[a + 1][b - 1] = 5;
            basyo[a + 1][b + 3] = 5;
            basyo[a + 2][b - 1] = 5;
            basyo[a + 2][b + 3] = 5;
            basyo[a + 3][b - 1] = 5;
            basyo[a + 3][b] = 5;
            basyo[a + 3][b + 1] = 5;
            basyo[a + 3][b + 2] = 5;
            basyo[a + 3][b + 3] = 5;
            return basyo;
        }else{
                System.out.println("値が正しくありません");
        }
        return basyo;
    }

    private void print(int[][] basyo){
        for (int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                System.out.print(basyo[i][j]);
            }
            System.out.println("");
        }
    }

    private boolean check(int x,int y,int n){
        for(int i=x-1;i<n+x;i++){
            for(int j=y-1;j<n+y;j++){
                if(basyo[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
}

