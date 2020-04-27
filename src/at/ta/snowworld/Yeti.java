package at.ta.snowworld;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Yeti implements Actor{

    private Image yetiIamge;
    private float x, y;
    private float speed;
    private String directionYeti = "right";


    public Yeti() throws SlickException {
        Image temp = new Image("testdata/yetineu.png");
        this.yetiIamge = temp.getScaledCopy(200,200);
        this.x = 10;
        this.y = 10;
        this.speed = 10f;
    }

    @Override
    public void render(Graphics graphics) {
        yetiIamge.draw(this.x,this.y);
    }

    @Override
    public void update(int delta) {
        switch (directionYeti) {
            case "right":
                this.x += (float) delta / speed;
                break;
            case "down":
                this.y += (float) delta / speed;
                break;
            case "left":
                this.x -= (float) delta / speed;
                break;
            case "up":
                this.y -= (float) delta / speed;
                break;
        }

        if (directionYeti == "right" && this.x > 590) {
            directionYeti = "down";
        } else if (directionYeti == "down" && this.y > 390) {
            directionYeti = "left";
        } else if (directionYeti == "left" && this.x < 100) {
            directionYeti = "up";
        } else if (directionYeti == "up" && this.y < 100) {
            directionYeti = "right";
        }
    }
}
