import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TestGrid extends JPanel {

    private JButton b1,b2,b3,b4,b5;
    private GridBagConstraints gbc = new GridBagConstraints();
    private ImageIcon grass;

    public static void main(String args[]){


        TestGrid test = new TestGrid();
        JFrame jf = new JFrame();

        jf.setTitle("TEST");
        jf.setSize(600,600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.add(test);
    }


    private TestGrid(){

        setLayout(new GridBagLayout());
        b1 = new JButton("Button 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(b1,gbc);

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(checkCount == 0){
                paintBackground(g);
            }
            checkCount++;
            if (GAME_TIMER > 0 && BANANAS_REMAINING > 0) {
                displayBanana(g);
                g.drawImage(monkey.getMonkeyImage(), monkey.getX(), monkey.getY(), Constants.IMAGE_SIZE, Constants.IMAGE_SIZE, this);
            }
        }

        grass = new ImageIcon(this.getClass().getResource("bermuda.png"));

        for (int i = 0; i < 50 ; i ++) {
            for (int j = 0; j < 50; j++) {

//                grass.paintIcon(this, g,  );
//                b1 = new JButton("Button 1");
                gbc.gridx = i;
                gbc.gridy = j;
                add(b1,gbc);

            }
        }

    }

//    public void Paint(Graphics g) throws IOException {
//        setLayout(new GridBagLayout());
//
//        grass = new ImageIcon("/images/bermuda.png");
//
//        InputStream imageStream = this.getClass().getResourceAsStream("images/bermuda.jpeg");
//
//        System.out.println("YO");
//        System.out.println("\n" + imageStream+  "\n " +  this.getClass().getResourceAsStream("images/bermuda.jpeg"));
//        BufferedImage image = ImageIO.read(imageStream);
//        JLabel picLabel = new JLabel(new ImageIcon(image));
//
//        ImageIcon img = createImageIcon("img/photo.gif");
//
//
//
//
//        for (int i = 0; i < 50 ; i ++) {
//            for (int j = 0; j < 50; j++) {
//                grass.paintIcon(this, g,  i,j);
//                b1 = new JButton("Button 1");
//                gbc.gridx = i;
//                gbc.gridy = j;
//                add(picLabel,gbc);
//
//            }
//        }
//    }

}
