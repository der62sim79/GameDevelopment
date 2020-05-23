package at.ta.SnakeWorld;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Food implements Actor {

    private int x, y;
    private Random random;

    public Food() {

        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(400);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, Field.GRID_SIZE - 4, Field.GRID_SIZE - 4);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }
}
