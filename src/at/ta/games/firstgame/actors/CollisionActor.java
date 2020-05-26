package at.ta.games.firstgame.actors;

import at.ta.rocket.Actor;
import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getCollisionShape();

}
