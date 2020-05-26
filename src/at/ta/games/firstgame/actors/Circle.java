package at.ta.games.firstgame.actors;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor {
    protected float x, y;
    protected float speed;
    protected float diameter;
    Random random;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = 0;
        this.speed = random.nextInt(40) + 10;
        this.diameter = 10;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    public void update(int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            this.y = 0;
            this.diameter = 10;
            this.x = this.random.nextInt(800);
        }
        this.diameter += 0.009;
        if (this.diameter > 100) {
            this.diameter = 10;
        }
    }
}
