package entity;
import java.awt.image.BufferedImage;
public class Entity {
    public int frames = 3;
    public int x;

    public int y;
    public int speed;
    public BufferedImage[] up = new BufferedImage[frames];
    public BufferedImage[] down = new BufferedImage[frames];
    public BufferedImage[] left = new BufferedImage[frames];
    public BufferedImage[] right = new BufferedImage[frames];
    public String direction;
    public int spriteCounter = 0;
    public int spriteIndex = 1;
}
