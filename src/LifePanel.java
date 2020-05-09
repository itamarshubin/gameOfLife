import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LifePanel extends JPanel implements MouseListener {
    private boolean isAlive;
    static boolean isPainting = false;
    static boolean makeAlive = false;
    public LifePanel(){
        this.isAlive=false;
        this.addMouseListener(this);
        this.setSize(100,100);
        this.setBackground(Color.BLUE);

        //set the border
        this.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(0.5f)));
    }


    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
            isPainting=true;
            if (!this.isAlive)
                makeAlive = true;
            else
                makeAlive = false;
            paint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        isPainting=false;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        paint();
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void paint(){
        if (isPainting){
            if (makeAlive) {
                this.setBackground(Color.orange);
                this.isAlive = true;
            }
            else {
                this.setBackground(Color.BLUE);
                this.isAlive=false;
            }
        }
    }
}
