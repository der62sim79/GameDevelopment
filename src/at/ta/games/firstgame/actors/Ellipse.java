package at.ta.games.firstgame.actors;

import at.ta.games.firstgame.Movement.LeftMoveStrategy;
import at.ta.games.firstgame.Movement.MoveStrategy;
import at.ta.games.firstgame.Movement.RightMoveStrategy;
import org.newdawn.slick.Graphics;

//mit implements werden die methoden vom Interface hinzugefügt
public class Ellipse implements Actor {

    private MoveStrategy moveStrategy;

    public Ellipse(MoveStrategy moveStrategy) {

        this.moveStrategy = moveStrategy;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(moveStrategy.getX(), moveStrategy.getY(), 50, 20);

    }

    @Override
    public void update(int delta) {
        this.moveStrategy.uptade(delta);

    }
}
