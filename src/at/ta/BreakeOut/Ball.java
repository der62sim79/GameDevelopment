package at.ta.BreakeOut;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.lang.reflect.Array;
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
    private List<Bricks> bricks;
    private GameAds gameAds;
    private Paddle paddle;

    public int score;
    public int lives;


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
        this.bricks = new ArrayList<>();
        this.score = 0;
        this.lives = 3;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        ball.draw(this.x, this.y);
        graphics.draw(this.collisionShape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        //for schleife für damit der Ball alle Akteure erkennt.
        for (CollisionActor collisionActor : collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getCollisionShape())) {
                this.velocityY = -this.velocityY;
                float distance = collisionActor.getX() - this.x;
                float distanceY = collisionActor.getY() - this.y;
                distance = Math.abs(distance);
                if (distance < 10) {
                    // link getroffen
                    this.velocityX = -this.velocityX;
                }
                if (distance > 125) {
                    this.velocityX = -this.velocityX;
                }
                System.out.println(distanceY);

            }
        }


        //hier wird eine ArrayList erstellt dammit die Bricks danach herausgelöscht werden können ohne absturz.
        ArrayList<Bricks> destroyedBricks = new ArrayList<>();
        //for schleife damit der ball nur die bricks erkennt.
        for (Bricks brick : bricks) {
            if (this.collisionShape.intersects(brick.getCollisionShape())) {
                brick.hit();
                score++;
                if (brick.isDestroyed()) {
                    destroyedBricks.add(brick);
                }
            }
        }

        for (Bricks brick : destroyedBricks) {
            bricks.remove(brick);
            collisionActors.remove(brick);

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
            lives--;
            this.x = 200;
            this.y = 219;
        }
    }

    //hier die methode für die Ateurer hinzufügen (Array List-CollisonActor)
    public void addCollisionPartner(CollisionActor collisionActor) {
        this.collisionActors.add(collisionActor);
    }

    //hier die methode für die Brick einfügen (Array List-Brick)
    public void addBricks(Bricks bricks) {
        this.bricks.add(bricks);
    }

    public Shape getCollisionShape() {
        return collisionShape;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }
}
