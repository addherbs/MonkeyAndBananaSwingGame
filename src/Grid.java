//import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Grid extends JPanel{

    private JPanel gameStats;
    private JFrame gameScreen;
    private JPanel panel;

    GridBagConstraints gbc = new GridBagConstraints();

    public static String start;
    public static String end;

    public JLabel totalBananasAte, totalBanana, elapsedTime, timeLeft, totalTime, totalScore;

    public static JLabel totalBananasAteText, totalBananaText, elapsedTimeText, timeLeftText, totalTimeText, totalScoreText;

    public static int totalBananasAteCount, totalBananas, sumOfScores;

    private Grid(){

//        super("Money and Banana");

        setLayout(new GridBagLayout());

//        JFrame obj = new JFrame("This will display");
//        obj.setBounds(10, 10, 800, 600);
//        obj.setBackground(Color.DARK_GRAY);
//        obj.setVisible(true);
//        obj.setResizable(true);
//        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setBounds(10, 10, 800, 600);
        setBackground(Color.DARK_GRAY);
        setVisible(true);


//        setResizable(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeGameStats();
//        gameScreen = new JFrame();
//        gameScreen.setLayout(new GridLayout(50,50));
//        obj.add(gameScreen);
//        obj.add(gameStats);

        add(gameStats, gbc);
        setVisible(true);
    }

    private void initializeGameStats() {

        gameStats = new JPanel();
        gameStats.setSize(400,100);
        gameStats.setBorder(new EmptyBorder(5, 5, 5, 5));

        totalBananasAte = new JLabel("Total Bananas Ate: ");
        totalBananasAte.setBounds(20, 20, 120, 23);
        totalBananasAteText = new JLabel();
        totalBananasAteText.setText("5");
        totalBananasAteText.setBounds(130, 20, 25, 23);
//        totalBananasAteText.setLineWrap(true);
        gameStats.add(totalBananasAteText);
        gameStats.add(totalBananasAte);

        totalBanana = new JLabel("Total Bananas: ");
        totalBanana.setBounds(20, 45, 90, 23);
        totalBananaText = new JLabel();
        totalBananaText.setText("5");
        totalBananaText.setBounds(130, 45, 25, 23);
        gameStats.add(totalBananaText);
        gameStats.add(totalBanana);

        elapsedTime = new JLabel("Elapsed Time: ");
        elapsedTime.setBounds(250, 20, 90, 23);
        elapsedTimeText = new JLabel();
        elapsedTimeText.setText("5");
        elapsedTimeText.setBounds(340, 20, 25, 23);
        gameStats.add(elapsedTimeText);
        gameStats.add(elapsedTime);

        timeLeft = new JLabel("Time Left: ");
        timeLeft.setBounds(250, 45, 90, 23);
        timeLeftText = new JLabel();
        timeLeftText.setText("5");
        timeLeftText.setBounds(340, 45, 25, 23);
        gameStats.add(timeLeftText);
        gameStats.add(timeLeft);

        totalScore = new JLabel("Total Score: ");
        totalScore.setBounds(250, 70, 90, 23);
        totalScoreText = new JLabel();
        totalScoreText.setText("5");
        totalScoreText.setBounds(340, 70, 25, 23);
        gameStats.add(totalScoreText);
        gameStats.add(totalScore);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,1,1));
        JButton component= new JButton("Component");
        panel.add(component, 0,0 );

        gameStats.add(panel);

//        gameStats.setVisible(true);
//        gameStats.setLayout(null);

    }

//    public static void main(String args[]){
//        new Grid();
//    }


}
