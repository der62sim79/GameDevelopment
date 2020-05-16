package at.ta.SnakeWorld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Field extends BasicGame {

    private Image background;
    private List<Actor> actors;
    private Apple apple;
    private Snake snake;

    public Field(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Image tmp = new Image("testdata/myPicture/images.jpg");
        this.background = tmp.getScaledCopy(800, 600);


        this.actors = new ArrayList<>();

        Snake snake = new Snake(200,200,10);
        this.snake = snake;
        this.actors.add(snake);

        Apple apple = new Apple();
        this.apple = apple;
        this.actors.add(apple);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {


        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        background.draw();


        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
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
}
