import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StartThatShit {
    static int[][] makeAliveList = new int[1000][2];
    static int[][] killList = new int[1000][2];
    static int makeAliveCount = 0;
    static int killCount = 0;
    static boolean[][] helpArray = new boolean[Window.lp.length][Window.lp[0].length];

    public static void checkAround(int row, int col) {
     if (Window.lp[row][col].isAlive()){
        int neighborsCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1))
                        if (!helpArray[row - 1 + i][col - 1 + j])
                            if (!Window.lp[row - 1 + i][col - 1 + j].isAlive()) {
                                if (howManyNeighbors(row - 1 + i, col - 1 + j) == 3) {
                                    makeAliveList[makeAliveCount][0] = row+i-1;
                                    makeAliveList[makeAliveCount][1] = col+j-1;
                                    makeAliveCount++;
                                }
                                    helpArray[row - 1 + i][col - 1 + j] = true;
                            } else
                                neighborsCount++;
            }
        }
        if (neighborsCount > 3 || neighborsCount < 2) {
            killList[killCount][0] = row;
            killList[killCount][1] = col;
            killCount++;
        }
    }

}
    public static int howManyNeighbors(int row,int col){
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                if (!(i==1&&j==1))
                    if (Window.lp[row - 1 + i][col-1+j].isAlive())
                        count++;
            }
        }
        return count;
    }

    public static void finishRound(){
        //kill who we need to kill
        for (int i = 0; i <killCount ; i++) {
            Window.lp[killList[i][0]][killList[i][1]].setAlive(false);
            Window.lp[killList[i][0]][killList[i][1]].setBackground(Color.BLUE);
            killList[i][0]=-1;
            killList[i][1]=-1;
        }
            killCount=0;
        //make alive who we need to make alive
        for (int i = 0; i < makeAliveCount; i++) {
            Window.lp[makeAliveList[i][0]][makeAliveList[i][1]].setAlive(true);
            Window.lp[makeAliveList[i][0]][makeAliveList[i][1]].setBackground(Color.orange);
            makeAliveList[i][0]=-1;
            makeAliveList[i][1]=-1;
        }
            makeAliveCount=0;
        for (int i = 0; i < helpArray.length; i++) {
            for (int j = 0; j < helpArray[0].length; j++) {
                helpArray[i][j]=false;
            }
        }
    }

}
