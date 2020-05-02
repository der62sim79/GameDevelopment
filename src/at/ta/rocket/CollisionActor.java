package at.ta.rocket;

import org.newdawn.slick.geom.Shape;

public interface CollisionActor extends Actor {
    public Shape getCollisionShape();
}
