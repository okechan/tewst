package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.Random;

public class Controller implements Initializable {
    private final Random random = new Random();
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

    private void place(int basyo){
        
    }
    private void doJanken(int myHand) {
        updateLabels(myHand, getCpuHand());
    }

    private int getCpuHand() {
        return random.nextInt(3);
    }

    private String getResult(int myHand, int cpuHand) {
        int r = (myHand - cpuHand + 3) % 3;
        return (r == 2) ? "あなたの勝ち！" : ((r == 1) ? "あなたの負け！" : "あいこ！");
    }

    private void updateLabels(int myHand, int cpuHand) {
        cpuHandLabel.setText("コンピュータの手: " + hands[cpuHand]);
        myHandLabel.setText("あなたの手: " + hands[myHand]);
        resultLabel.setText("結果: " + getResult(myHand, cpuHand));
    }
}

