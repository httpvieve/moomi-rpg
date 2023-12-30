package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    GamePanel game;
    KeyHandler keyHandler;

    public Player (GamePanel game, KeyHandler keyHandler) {
        this.game = game;
        this.keyHandler = keyHandler;
        setDefaultData();
    }
    public void setDefaultData () {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage () {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/UP_1.png")));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UP_2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/UP_3.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DOWN_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DOWN_2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/DOWN_3.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LEFT_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LEFT_2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/LEFT_3.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RIGHT_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RIGHT_2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/RIGHT_3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update () {

        if (keyHandler.up) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.down) {
            direction = "down";
            y += speed;
        } else if (keyHandler.left) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.right) {
            direction = "right";
            x += speed;
        }
    }
    public void draw (Graphics2D temp) {
//        temp.setColor(Color.white);
//        temp.fillRect(x, y, game.tileSize, game.tileSize);
        ///\setDefaultData();
        getPlayerImage();
        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        temp.drawImage (image, x, y, game.tileSize, game.tileSize, null);
    }

 }
