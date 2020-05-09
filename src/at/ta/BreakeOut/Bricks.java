package at.ta.BreakeOut;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Bricks implements Actor, CollisionActor {
    private float x, y;
    private Shape collisionShape;
    private List<CollisionActor> collisionActors;
    private int hitCount;
    private Ball ball;


    public Bricks(int x, int y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x, this.y, 51, 10);
        this.collisionActors = new ArrayList<>();
    }


    @Override
    public void render(Graphics graphics) throws SlickException {
        if(!isDestroyed()) {
            Color color = Color.darkGray;
            if(this.hitCount == 1){
                color = Color.red;
            } else if(this.hitCount == 2){
                color = Color.green;
            }
            graphics.setColor(color);
            graphics.fillRect(this.x, this.y, 50, 10);
            graphics.draw(this.collisionShape);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        collisionShape.setCenterX(this.x + 25);
        collisionShape.setCenterY(this.y + 5);
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
