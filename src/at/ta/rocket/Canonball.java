package at.ta.rocket;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;


public class Canonball implements CollisionActor {

    private float x, y;
    private Shape collisionShape;
    private float diameter;
    private List<CollisionActor> collisionActors;


    public Canonball(float x, float y) {
        this.x = x;
        this.y = y;
        this.diameter = 7;
        this.collisionShape = new Circle(this.x, this.y, diameter);
        this.collisionActors = new ArrayList<CollisionActor>();
    }

    @Override
    public void render(Graphics graphics) {

        graphics.fillOval(this.x, this.y, 10, 10);
//        graphics.draw(this.collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getCollisionShape())){
                System.out.println("getroffen");
            }
        }

        this.y--;
        this.collisionShape.setCenterX(this.x + 5);
        this.collisionShape.setCenterY(this.y + 5);
    }


    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public void addCollisionsMissle(CollisionActor collisionActor) {
        this.collisionActors.add(collisionActor);
    }
}
