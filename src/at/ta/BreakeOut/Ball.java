package at.ta.BreakeOut;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;


public class Ball implements Actor {
    private Image ball;
    private float x, y;
    private Shape collisionShape;
    private float diameter;
    private List<CollisionActor> collisionActors;
    private float velocityX;
    private float velocityY;
    private float speed;


    public Ball() throws SlickException {
        Image tmp = new Image("testdata/basketball.png");
        this.ball = tmp.getScaledCopy(35, 35);
        this.x = 300;
        this.y = 419;
        this.diameter = 18;
        this.collisionShape = new Circle(this.x, this.y, diameter);
        this.velocityX = 6;
        this.velocityY = 7;
        this.collisionActors = new ArrayList<CollisionActor>();

    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        ball.draw(this.x, this.y);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (CollisionActor collisionActor : collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getCollisionShape())) {
                this.velocityY = -this.velocityY;
            }
        }
        moveBall(delta);


        this.collisionShape.setCenterX(this.x + 19);
        this.collisionShape.setCenterY(this.y + 18);

    }

    private void moveBall(float delta) {
        this.x += delta / this.velocityX;
        this.y += delta / this.velocityY;


        if (this.x < 5) {
            this.velocityX = -this.velocityX;
        }
        if (this.x > 765) {
            this.velocityX = -this.velocityX;
        }
        if (this.y < 5) {
            this.velocityY = -this.velocityY;
        }
        if (this.y > 590) {
            this.x = 200;
            this.y = 219;
        }
    }

    public void addCollisionPartner(Paddle paddle) {
        this.collisionActors.add(paddle);
    }

}
