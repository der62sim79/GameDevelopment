package at.ta.BreakeOut;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Screen extends BasicGame {
    private List<CollisionActor> collisionActors;
    private Paddle paddle;
    private Ball ball;
    private List<Actor> actors;
    private Image backgraund;
    private Bricks bricks;


    public Screen(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        Image tmp = new Image("testdata/wallpaper/paper1.png");
        this.backgraund = tmp.getScaledCopy(800, 600);

        this.collisionActors = new ArrayList<>();
        this.actors = new ArrayList<>();

        Paddle paddle = new Paddle();
        this.paddle = paddle;
        this.actors.add(paddle);
        this.collisionActors.add(paddle);

        Ball ball = new Ball();
        this.ball = ball;
        this.actors.add(ball);
        this.ball.addCollisionPartner(paddle);

        for (int i = 0; i < 10; i++) {
            Bricks bricks = new Bricks((i * 50) , 100);
            this.bricks = bricks;
            this.collisionActors.add(bricks);
            this.actors.add(bricks);
            this.ball.addCollisionPartner(bricks);
            this.ball.addBricks(bricks);

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

        backgraund.draw();
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Screen("Breake Out"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
