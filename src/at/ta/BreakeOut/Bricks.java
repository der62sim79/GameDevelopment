package at.ta.BreakeOut;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bricks implements Actor, CollisionActor {
    private float x, y;
    private Shape collisionShape;
    Random random;
    private List<CollisionActor> collisionActors;
    private int hitCount;


    public Bricks(int x, int y) {
        Random random = new Random();
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 50, 10);
        this.collisionActors = new ArrayList<>();


    }


    @Override
    public void render(Graphics graphics) throws SlickException {
        if(!isDestroyed()) {
            graphics.setColor(Color.darkGray);
            graphics.fillRect(this.x, this.y, 50, 10);
            graphics.draw(this.collisionShape);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        
    }

    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void hit() {
        this.hitCount++;
    }

    public boolean isDestroyed(){
        return this.hitCount >= 3;
    }

}
