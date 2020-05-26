package at.ta.games.firstgame.actors;

import at.ta.games.firstgame.Movement.MoveStrategy;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public abstract class AbstractMoveableActor implements CollisionActor{

    protected MoveStrategy moveStrategy;

    public AbstractMoveableActor(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        this.moveStrategy.uptade(delta);
    }
}
