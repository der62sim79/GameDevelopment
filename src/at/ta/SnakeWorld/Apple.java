package at.ta.SnakeWorld;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

import java.util.Random;


public class Apple implements Actor, CollisionActor {

    private Shape collisionShape;
    private float x, y;
    private float speed;
    private float diameter;
    Random random;


    public Apple() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.diameter = 10;

    }


    @Override
    public void render(Graphics graphics) throws SlickException {

        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

}
