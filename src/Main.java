public class Main {
    static Window board;
    public static void main(String[]args){
        board = new Window();


        for (int i = 0; i < StartThatShit.makeAliveList.length; i++) {
            StartThatShit.makeAliveList[i][0]=-1;
            StartThatShit.makeAliveList[i][1]=-1;
        }
        for (int i = 0; i < StartThatShit.killList.length; i++) {
            StartThatShit.killList[i][0]=-1;
            StartThatShit.killList[i][1]=-1;
        }
    }
}
