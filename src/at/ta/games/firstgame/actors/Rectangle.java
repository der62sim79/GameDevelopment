package at.ta.games.firstgame.actors;

import at.ta.games.firstgame.Movement.MoveStrategy;
import at.ta.games.firstgame.ObjectDirectionRectangle;
import org.newdawn.slick.Graphics;


public class Rectangle implements Actor {
   private MoveStrategy moveStrategy;


    public Rectangle(MoveStrategy moveStrategy) {

        this.moveStrategy = moveStrategy;

    }

    // es wird ein render sowie update methode  angelegt mit Graphics und delta, diese methode wir überall verwenden
    // und beim game dann als for each Schleife zusammen gefasst.
    public void render(Graphics graphics) {
        graphics.drawRect(moveStrategy.getX(), moveStrategy.getY(), 10, 10);
    }

    public void update(int delta) {
        moveStrategy.uptade(delta);
//        switch (this.objectDirectionRectangle) {
//            case RIGHT:
//                this.x += (float) delta / this.speed;
//                if (this.x > 800) {
//                    this.x = 0;
//                }
//                break;
//            case LEFT:
//                this.x -= (float) delta / this.speed;
//
//                if (this.x < 0) {
//                    this.x = 800;
//                }
//        }
    }
}

