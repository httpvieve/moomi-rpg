package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

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
    }
    public void update () {
        if (keyHandler.up) { y -= speed; } else
        if (keyHandler.down) { y += speed; } else
        if (keyHandler.left) { x -= speed; } else
        if (keyHandler.right) { x += speed; }
    }
    public void draw (Graphics2D temp) {
        temp.setColor(Color.white);
        temp.fillRect(x, y, game.tileSize, game.tileSize);
    }

 }
