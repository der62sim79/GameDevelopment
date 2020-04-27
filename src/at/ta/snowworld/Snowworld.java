package at.ta.snowworld;

import at.ta.games.firstgame.ObjectsGame;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Snowworld extends BasicGame {
    private List<Actor> snowfalkes;

    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.snowfalkes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            this.snowfalkes.add(new Snowflake(Snowflake.SIZE.BIG));
            this.snowfalkes.add(new Snowflake(Snowflake.SIZE.MEDIUMS));
            this.snowfalkes.add(new Snowflake(Snowflake.SIZE.SMALL));
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.snowfalkes) {
            actor.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.snowfalkes) {
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
