package sample;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Controller implements Initializable{
    private final Random random = new Random();
    int a,b,c,d,e,f,g,h,k;
    int flag=0;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void start(){
        basyo=Thirdfield(basyo);
        for(int i=0;i<2;i++) {
            basyo=secondfield(basyo);
        }
        for (int i=0;i<3;i++){
          basyo=firstfield(basyo);
        }
       // basyo=Cheaker(basyo);
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
            d = random.nextInt(7) + 1;
            e = random.nextInt(7) + 1;
            f = 2;

            //フラッグ作って2見たらダメな部分(d,e=1,8)の場合を考えて条件文を作成．疲れた

        }while(basyo[d-1][e-1]!=1&&basyo[d-1][e]!=1&&basyo[d-1][e+1]!=1&&basyo[d-1][e+2]!=1&&basyo[d][e-1]!=1&&basyo[d][e+2]!=1&&basyo[d+1][e-1]!=1&&basyo[d+1][e+2]!=1&&basyo[d+2][e-1]!=1&&basyo[d+2][e]!=1&&basyo[d+2][e+1]!=1&&basyo[d+2][e+2]!=1&&basyo[d][e]!=1&&basyo[d+1][e+1]!=1&&basyo[d][e+1]!=1&&basyo[d+1][e]!=1);
        basyo = Replace(d, e, f, basyo);
        return basyo;
    }
    private int[][] firstfield(int[][] basyo){
        do {
            d = random.nextInt(7) + 1;
            e = random.nextInt(7) + 1;
            f = 1;
        }while(basyo[d][e]!=1);
        basyo = Replace(d, e, f, basyo);
        return basyo;
    }

    private int[][] Replace(int a,int b,int c,int[][] basyo){
        switch(c){
            case 1:
                basyo[a][b]=2;
                return basyo;
            case 2:
                basyo[a][b]=3;
                basyo[a][b+1]=3;
                basyo[a+1][b]=3;
                basyo[a+1][b+1]=3;
                return basyo;
            case 3:
                basyo[a][b]=4;
                basyo[a-1][b-1]=4;
                basyo[a-1][b]=4;
                basyo[a-1][b+1]=4;
                basyo[a][b-1]=4;
                basyo[a][b+1]=4;
                basyo[a+1][b-1]=4;
                basyo[a+1][b]=4;
                basyo[a+1][b+1]=4;
                return basyo;
            default:
                System.out.println("値が正しくありません");
                break;
        }
        return basyo;
    }
    private void Reset(){
        a=0;b=0;c=0;d=0;e=0;f=0;g=0;h=0;k=0;
       for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
               basyo[i][j]=1;
           }
       }
       start();
    }

   private int[][] Cheaker(int[][] basyo){
        int vert_count=0,hori_count=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                hori_count+=Math.abs(basyo[i][j]-basyo[i][j+1]);
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<9;j++){
                vert_count+=Math.abs(basyo[i][j]-basyo[i+1][j]);
            }
        }
        if(hori_count!=40||vert_count!=39){
            hori_count=0;
            vert_count=0;
            Reset();
        }
        return basyo;
    }
    private void print(int[][] basyo){
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(basyo[i][j]);
            }
            System.out.println("");
        }
    }
}

