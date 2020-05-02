package at.ta.rocket;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class SpaceCircle implements CollisionActor {
    private float x, y;
    private float speed;
    private float diameter;
    Random random;
    private Shape collisonShape;

    public SpaceCircle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = 0;
        this.speed = random.nextInt(90);
        this.diameter = 30;
        this.collisonShape = new Circle(this.x, this.y, this.diameter - 13);
    }

    private void setRandomPosition() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600) - 600;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
        graphics.setColor(new Color(20, 40, 257));
//        graphics.draw(this.collisonShape);
//        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta / this.speed;
        if (this.y > 600) {
            setRandomPosition();
        }
        this.collisonShape.setCenterY(this.y + 15);
        this.collisonShape.setCenterX(this.x + 15);
    }


    @Override
    public Shape getCollisionShape() {
        return collisonShape;
    }
}
