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
    private GameAds gameAds;


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

        int space = 0;
        for (int i = 0; i < 11; i++) {
            space += 5;
            for (int j = 0; j < 3; j++) {
                Bricks bricks = new Bricks(((80) + i * 50) + space, ((80) + j * 20));
                this.bricks = bricks;
                this.collisionActors.add(bricks);
                this.actors.add(bricks);
                this.ball.addCollisionPartner(bricks);
                this.ball.addBricks(bricks);
            }
        }

        this.gameAds = new GameAds();
        this.actors.add(gameAds);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        int gamescore = ball.getScore();
        gameAds.setScore(gamescore);

        int lives = ball.getLives();
        gameAds.setLives(lives);
        if (lives == 0) {
            System.out.println("Edne");
            System.exit(0);
        }


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
