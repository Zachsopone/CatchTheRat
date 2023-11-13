
package apdujan.laboratory4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Apdujan_CatchingGame extends JFrame{
    JLabel rat;
    Random r;
    int x;
    public Apdujan_CatchingGame(int ms){
    setTitle("Catch the rat");
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    rat=new JLabel(new ImageIcon("rat.png"));
    getContentPane().add(rat);
    r=new Random();
    Timer ratMoves=new Timer(ms, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        rat.setLocation(r.nextInt(getWidth()+10),r.nextInt(getHeight()+10));
        }
    });
    ratMoves.start();
    x=0;
    rat.addMouseListener(new MouseAdapter(){
    public void mousePressed(MouseEvent m){
    Toolkit.getDefaultToolkit().beep();
    x++;
    System.out.println("Rat has been caught "+ x +" times!");
    }
    });
    setExtendedState(MAXIMIZED_BOTH);
    }
    public static void main(String[] args) {
    String diff=JOptionPane.showInputDialog("How fast is your rat?");
    new Apdujan_CatchingGame(Integer.valueOf(diff));
    }
    
}
