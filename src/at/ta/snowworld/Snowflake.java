package at.ta.snowworld;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Actor {
    public enum SIZE {BIG, MEDIUMS, SMALL}

    private int size;
    private float speed;
    private float x;
    private float y;
    private Random random;

    public Snowflake(SIZE size) {

        if (size == SIZE.BIG) {
            this.size = 10;
            this.speed = 2;
        }
        if (size == SIZE.MEDIUMS) {
            this.size = 6;
            this.speed = 4;
        }
        if (size == SIZE.SMALL) {
            this.size = 3;
            this.speed = 6;
        }
        setRandomPosition();
    }


    private void setRandomPosition() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600) - 600;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x,this.y,this.size,this.size);

    }

    @Override
    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            setRandomPosition();
        }
    }
}
