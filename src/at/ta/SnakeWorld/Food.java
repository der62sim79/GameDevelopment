package at.ta.SnakeWorld;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Food implements Actor, CollisionActor {

    int randomX;
    int randomY;
    private Random random;
    private Shape collisionShape;


    public Food() {
        this.collisionShape = new Rectangle(randomX, randomY, Field.GRID_SIZE - 5, Field.GRID_SIZE - 5);
        randomFood();


    }

    public void randomFood() {
        Random random = new Random();


        randomX = random.nextInt(Field.WINDOW_WIDTH) + Field.GRID_SIZE;
        randomY = random.nextInt(Field.WINDOW_HEIGHT) + Field.GRID_SIZE;

        // round to the blocksize
        randomX = Math.round(randomX / Field.GRID_SIZE) * Field.GRID_SIZE;
        randomY = Math.round(randomY / Field.GRID_SIZE) * Field.GRID_SIZE;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(Color.red);
        graphics.fillRect(this.randomX, this.randomY, Field.GRID_SIZE - 4, Field.GRID_SIZE - 4);
        graphics.setColor(Color.green);
        graphics.draw(collisionShape);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {


        this.collisionShape.setCenterX(randomX + 13);
        this.collisionShape.setCenterY(randomY + 13);
    }




    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }

    public int getRandomX() {
        return randomX;
    }

    public int getRandomY() {
        return randomY;
    }

}
