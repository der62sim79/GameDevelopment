package at.ta.BreakeOut;


import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Paddle implements Actor, CollisionActor {

    private Image paddle;
    private float x, y;
    private Shape collisionShape;
    private List<CollisionActor> collisionShapes;

    public Paddle() throws SlickException {
        Image tmp = new Image("testdata/paddle.png");
        this.paddle = tmp.getScaledCopy(140, 20);
        this.x = 300;
        this.y = 500;
        this.collisionShape = new Rectangle(this.x, this.y, 140, 1);
        this.collisionShapes = new ArrayList<>();
    }


    @Override
    public void render(Graphics graphics) {

        paddle.draw(this.x, this.y);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
            if (this.x < 5) {
                this.x = 5;
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
            if (this.x > 655) {
                this.x = 655;
            }
        }

        this.collisionShape.setCenterX(this.x + 70);
        this.collisionShape.setCenterY(this.y);
    }


    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }
}
