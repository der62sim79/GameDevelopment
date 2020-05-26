package at.ta.games.firstgame;

import at.ta.games.firstgame.Movement.LeftMoveStrategy;
import at.ta.games.firstgame.Movement.MoveStrategy;
import at.ta.games.firstgame.Movement.RightMoveStrategy;
import at.ta.games.firstgame.actors.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Actor> actors;


    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        //actors ArrayList werden alle Objekte/Class hinzugefügt
        this.actors = new ArrayList<>();

        //objekt wird initiert für den Start
        Random random = new Random();

        /*
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(500),
                    random.nextInt(50), ObjectDirectionRectangle.LEFT);
            this.actors.add(rectangle);
        }
        */
        for (int i = 0; i < 4; i++) {
            Circle circle = new Circle();
            this.actors.add(circle);
        }

        RightCircle rightCircle1 = new RightCircle();
        this.actors.add(rightCircle1);

        LeftCircle leftCircle1 = new LeftCircle();
        this.actors.add(leftCircle1);

        MoveStrategy mor = new RightMoveStrategy(50,50,5);
        MoveStrategy mor1 = new RightMoveStrategy(500,500,5);
        MoveStrategy mol = new LeftMoveStrategy(400,400,5);
        MoveStrategy mol2 = new LeftMoveStrategy(300,300,5);

        Ellipse ellipse = new Ellipse(mor);
        this.actors.add(ellipse);

        Ellipse ellipse1 = new Ellipse(mol);
        this.actors.add(ellipse1);


        Ellipse ellipse2 = new Ellipse(mor1);
        this.actors.add(ellipse2);

        Rectangle rectangle = new Rectangle(mol2);
        this.actors.add(rectangle);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //mit actor for each Schleife werden alle Classen angesprochen
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
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangels"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
