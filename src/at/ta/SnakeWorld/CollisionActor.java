package at.ta.SnakeWorld;

import at.ta.rocket.Actor;
import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getCollisionShape();

}
