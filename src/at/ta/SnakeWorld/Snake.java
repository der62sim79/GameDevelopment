package at.ta.SnakeWorld;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Snake implements Actor{

    private int x, y;
    private Snake next;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x * Field.GRID_SIZE, this.y * Field.GRID_SIZE, Field.GRID_SIZE - 4, Field.GRID_SIZE - 4);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Snake getNext() {
        return next;
    }

    public void setNext(Snake next) {
        this.next = next;
    }




}
