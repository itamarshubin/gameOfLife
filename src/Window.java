import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    static LifePanel[][] lp = new LifePanel[100][100];
    public Window(){
        //define the JFrame
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("game of life");

        //add all the life pannels
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(lp.length,lp[0].length));
        for (int i = 0; i < lp.length; i++) {
            for (int j = 0; j < lp[0].length; j++) {
                lp[i][j] = new LifePanel();
                gamePanel.add(lp[i][j]);
            }
        }
        this.add(gamePanel,BorderLayout.CENTER);

        //add all the buttons
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton clearButton = new JButton("Clear");
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1,3));
        ButtonPanel.add(startButton);
        ButtonPanel.add(stopButton);
        ButtonPanel.add(clearButton);
        this.add(ButtonPanel,BorderLayout.SOUTH);
        ButtonPanel.setPreferredSize(new Dimension(20,50));

        //set the buttons actions
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < lp.length; i++) {
                    for (int j = 0; j < lp[0].length; j++) {
                        lp[i][j].setBackground(Color.BLUE);
                        lp[i][j].setAlive(false);
                    }
                }
            }
        });
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lp.length; i++) {
                    for (int j = 0; j < lp[0].length; j++) {
                        StartThatShit.checkAround(i,j);
                    }
                }
                StartThatShit.finishRound();
                System.out.println("done");
            }
        });
        this.setVisible(true);
    }


}
