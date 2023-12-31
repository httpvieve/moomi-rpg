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
            up[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/UP_1.png")));
            up[1] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/UP_2.png")));
            up[2] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/UP_3.png")));
            down[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/DOWN_1.png")));
            down[1] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/DOWN_2.png")));
            down[2] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/DOWN_3.png")));
            left[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/LEFT_1.png")));
            left[1] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/LEFT_2.png")));
            left[2] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/LEFT_3.png")));
            right[0] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/RIGHT_1.png")));
            right[1] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/RIGHT_2.png")));
            right[2] = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/RIGHT_3.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update () {

        if (keyHandler.up || keyHandler.down||keyHandler.left||keyHandler.right) {
            if (keyHandler.up) {
                direction = "up";
                y -= speed;
            } else if (keyHandler.down) {
                direction = "down";
                y += speed;
            } else if (keyHandler.left) {
                direction = "left";
                x -= speed;
            } else {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter % 12 == 0 && spriteIndex < frames) spriteIndex++;
            if (spriteIndex == frames) spriteIndex = 0;
        }
    }
    public void draw (Graphics2D temp) {
//        temp.setColor(Color.white);
//        temp.fillRect(x, y, game.tileSize, game.tileSize);
        ///\setDefaultData();
        getPlayerImage();
        BufferedImage image = switch (direction) {
            case "up" -> up[spriteIndex];
            case "down" -> down[spriteIndex];
            case "left" -> left[spriteIndex];
            case "right" -> right[spriteIndex];
            default -> null;
        };
        temp.drawImage (image, x, y, game.tileSize, game.tileSize, null);
    }

 }
