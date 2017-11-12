package com.adipandey.monkeybanana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Game extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private Monkey monkey;
	private Banana banana;

	private static JFrame gameFrame;
	private static JPanel gamePanel;
	private static JLabel timeStatus, bananaStatus, timeShow;
    private static JLabel gameOverText, numberOfBananas, result;
	private Timer timer = new Timer(1000, this);

    private Bermuda br = new Bermuda();
    private BufferedImage bermudaImage = br.getBermudaImage();


    public static void main(String[] args) {
		initialize();
	}

	private static void initialize() {

		gameFrame = new JFrame("Monkey Banana");


		bananaStatus = new JLabel("10 Bananas Left");
		timeStatus = new JLabel("Time Left: 60");
		timeShow = new JLabel("Start: 0");

		initializePanel();
		initializeFrame();
	}

	private static void initializePanel() {
		gamePanel = new JPanel();
		gamePanel.add(timeStatus);
		gamePanel.add(bananaStatus);
		gamePanel.add(timeShow);
		gamePanel.setBounds(0, 0, 500, 50);
		gamePanel.setBackground(Color.WHITE);
	}


	private static void initializeFrame() {

		gameFrame.add(new Game());
		gameFrame.setBackground(Color.WHITE);
		gameFrame.setResizable(false);
		gameFrame.add(gamePanel, BorderLayout.NORTH);
		gameFrame.pack();
		gameFrame.setSize(Constants.WIDTH, Constants.HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);

	}

	public void actionPerformed(ActionEvent actionEvent) {
		if (Constants.ROUND_TIME > 0) {
			Constants.ROUND_TIME--;
			timeShow.setText(" Current Round Time: " + Constants.ROUND_TIME);
		}
		if (Constants.ROUND_TIME < 0) {
			updateBanana();
            updateMonkey();
		} else if (Constants.ROUND_TIME == 0) {
			updateBanana();
            updateMonkey();
			Constants.ROUND_TIME = 8;
			repaint();
		}
		if (Constants.TOTAL_TIME > 0) {
			Constants.TOTAL_TIME--;
			timeStatus.setText(" Hurry: " + Constants.TOTAL_TIME);
		} else {
			gameEnd();
		}
	}

	private void gameEnd() {
		timer.stop();

        timeStatus.setVisible(false);
        timeShow.setVisible(false);
        bananaStatus.setVisible(false);

        gameOverText = new JLabel();
        numberOfBananas= new JLabel();
        result = new JLabel();


        boolean yes = true;

        gameOverText.setText("Game is Over!!!");

		int numb = (Constants.TOTAL_BANANAS - Constants.REMAINING);
		if (numb > 1) {
            numberOfBananas.setText("You Ate: " + numb + " bananas!!!");
        }else{
            numberOfBananas.setText("You Ate: " + numb + " banana!!!");
        }


		if (Constants.REMAINING > 0) {
			result.setText("Loser!!");
		} else {
            result.setText("Winner!!!");
		}

		gameOverText.setBounds(10,10,50,10);
        numberOfBananas.setBounds(80,10,50,10);
        result.setBounds(10,30,50,10);


        gamePanel.add(gameOverText );
        gamePanel.add(numberOfBananas);
        gamePanel.add(result);


        repaint();
	}

	public Game() {
		timer.start();
		monkey = new Monkey();
		banana = new Banana();
		updateBanana();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void updateBanana() {

		banana.randomNumberGenerator();
	}

    private void updateMonkey()
    {
        monkey.randomNumberGeneratorMonkey();
    }

    private void paintBackground(Graphics g){
        for (int i =-20 ; i < 580; ){
            i = i+20;
            for(int j = 0; j < 540 ; ){
                g.drawImage(bermudaImage, i, j, Constants.IMAGE, Constants.IMAGE, this);
                j = j+20;
            }
        }
    }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        paintBackground(g);
//        if(checkCount == 0){
//            paintBackground(g);
//        }
//        checkCount++;
		if (Constants.TOTAL_TIME > 0 && Constants.REMAINING > 0) {
			paintBanana(g);
            BufferedImage staticMonkeyImage = monkey.getMonkeyImage();
			g.drawImage(staticMonkeyImage, monkey.getX(), monkey.getY(), Constants.IMAGE, Constants.IMAGE, this);
		}
	}

	private void paintBanana(Graphics g) {
        BufferedImage staticBananaImage = banana.getBananaImage();
		g.drawImage(staticBananaImage, banana.getX(), banana.getY(), Constants.IMAGE, Constants.IMAGE, this);
	}


	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            if (monkey.getX() < 20) {
                monkey.setX(20);
            }
            monkey.keyLeft(monkey);
        }

        if (code == KeyEvent.VK_RIGHT) {
            if (monkey.getX() > 540) {
                monkey.setX(540);
            }
            monkey.keyRight(monkey);
        }

        if (code == KeyEvent.VK_UP) {

			if (monkey.getY() < 20 ){
			    monkey.setY(20);
            }
			monkey.keyUp(monkey);
		}
		
		if (code == KeyEvent.VK_DOWN) {
			if (monkey.getY() > 500) {
				monkey.setY(500);
			}
			monkey.keyDown(monkey);
		}
		

        boolean collided = checkPositionOfBananaAndMonkey();

		if (collided && Constants.REMAINING >= 0) {
			bananaStatus.setText(" Bananas Left: " + Constants.REMAINING);
			updateBanana();
			updateMonkey();
			Constants.ROUND_TIME = 8;
		}
		
		if (Constants.REMAINING == 0)
			gameEnd();
		repaint();
	}



    public boolean checkPositionOfBananaAndMonkey() {
        if (monkey.getX() == banana.getX() && monkey.getY() == banana.getY()) {
            Constants.REMAINING--;

            new Thread(BackgroundMusicPlay::play).start();

            return true;
        }
        return false;
    }

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		monkey.keyReleased(monkey);
	}
}
