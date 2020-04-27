package at.ta.snowworld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Snowworld extends BasicGame {
    private List<Actor> actors;

    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {


        this.actors = new ArrayList<>();
        Yeti yeti = new Yeti();
        this.actors.add(yeti);
        for (int i = 0; i < 50; i++) {
            this.actors.add(new Snowflake(Snowflake.SIZE.BIG));
            this.actors.add(new Snowflake(Snowflake.SIZE.MEDIUMS));
            this.actors.add(new Snowflake(Snowflake.SIZE.SMALL));
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
