package main;

import javax.swing.JPanel;
import java.awt.*;
import java.sql.SQLOutput;

public class GamePanel extends JPanel implements Runnable {
    /* SCREEN SETTINGS */
    final int defaultTileSize = 16; // 16 x 16 tile
    final int scale = 3; // 48 x 48 tile
    final int tileSize = defaultTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    double gameFPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default positions
    int playerPositionX = 100;
    int playerPositionY= 100;
    int playerSpeed = 4;

    public GamePanel () {

        this.setPreferredSize (new Dimension(screenWidth, screenHeight));
        this.setBackground (Color.black);
        this.setDoubleBuffered (true);
        this.addKeyListener (keyHandler);
        this.setFocusable (true);

    }

    public void initializeThread () {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double delta = 0, interval = 1000000000 / gameFPS;
        long currentTime, previousTime = System.nanoTime();

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / interval;
            previousTime = currentTime;

            if (delta > 0) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update () {

        if (keyHandler.up) { playerPositionY -= playerSpeed; } else
        if (keyHandler.down) { playerPositionY += playerSpeed; } else
        if (keyHandler.left) { playerPositionX -= playerSpeed; } else
        if (keyHandler.right) { playerPositionX += playerSpeed; }

    }
    public void paintComponent (Graphics g) {

        super.paintComponent (g);

        Graphics2D temp = (Graphics2D) g;

        temp.setColor(Color.white);
        temp.fillRect(playerPositionX, playerPositionY, tileSize, tileSize);
        temp.dispose();

    }
}
