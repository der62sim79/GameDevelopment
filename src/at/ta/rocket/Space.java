package at.ta.rocket;

import at.ta.snowworld.Snowworld;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Space extends BasicGame {
    private List<Actor> actors;
    private Rocket rocket;
    private List<CollisionActor> collisionActors;
    private Canonball canonball;



    public Space(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.collisionActors = new ArrayList<>();
        this.actors = new ArrayList<>();

        Rocket rocket = new Rocket();
        this.rocket = rocket;
        this.actors.add(rocket);





        for (int i = 0; i < 4; i++) {
            SpaceCircle spaceCircle = new SpaceCircle();
            this.actors.add(spaceCircle);
            this.rocket.addCollisionsPartner(spaceCircle);
            this.collisionActors.add(spaceCircle);


        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            Canonball canonball = new Canonball(this.rocket.getX(), this.rocket.getY());
            this.actors.add(canonball);
            for (CollisionActor actor: this.collisionActors) {
                canonball.addCollisionsMissle(actor);
            }
            this.collisionActors.add(canonball);


        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Space("Space"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
