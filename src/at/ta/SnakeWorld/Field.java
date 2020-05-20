package at.ta.SnakeWorld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Field extends BasicGame {

    public static final int menu = 0;
    public static final int GRID_SIZE = 30;
    private Snake first, last, snakeBody;
    private int timeRun = 0;
    private Image background;
    private List<Actor> actors;
    private Snake snake;

    public Field(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Image tmp = new Image("testdata/myPicture/images.jpg");
        this.background = tmp.getScaledCopy(800, 600);

        this.actors = new ArrayList<>();
        this.first = new Snake(4, 4);
        this.snakeBody = new Snake(4, 5);
        this.last = new Snake(4, 6);


        this.actors.add(first);
        this.actors.add(last);
        this.actors.add(snakeBody);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(gameContainer, delta);
        }
        timeRun += delta;
        if (timeRun > 500) {
            timeRun = 0;

            int newX, newY;
            if (1 == 1) {
                newY = this.first.getY() - 1;
                newX = this.first.getX();
            }


            Snake oldLast = this.last;
            this.last = this.first.getNext();

            this.first.setNext(this.last);
            oldLast.setNext(null);
            this.first = oldLast;

            this.first.setY(newY);
            this.first.setX(newX);

        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        background.draw();

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }

    @Override
    public void keyPressed(int key, char c) {

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Field("Snake"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static int getGridSize() {
        return GRID_SIZE;
    }

    public Snake getFirst() {
        return first;
    }

    public void setFirst(Snake first) {
        this.first = first;
    }

    public Snake getLast() {
        return last;
    }

    public void setLast(Snake last) {
        this.last = last;
    }

    public int getTimeRun() {
        return timeRun;
    }

    public void setTimeRun(int timeRun) {
        this.timeRun = timeRun;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
