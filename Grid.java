import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class Grid extends JFrame{

    JPanel panel = new JPanel();

    public static void main(String args[]){
        new Grid();
    }

    public Grid(){

        super("Money and Banana");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(50,50));
        add(panel);

        setVisible(true);

    }

}
