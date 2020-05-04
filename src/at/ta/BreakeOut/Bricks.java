package at.ta.BreakeOut;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

public class Bricks implements Actor, CollisionActor {
    private float x, y;
    private Shape collisionShape;
    Random random;
    private List<CollisionActor> collisionShapes;

    public Bricks() {
        Random random = new Random();
        this.x = random.nextInt(755);
        this.y = random.nextInt(250);
        this.collisionShape = new Rectangle(this.x, this.y, 50, 10);
        this.collisionShapes = new ArrayList<>();

    }

    private void setRandomPosition() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(250);
    }


    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.drawRect(this.x,this.y,50,10);
        graphics.draw(this.collisionShape);
        graphics.setColor(Color.darkGray);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }
}
