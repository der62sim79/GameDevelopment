package at.ta.snowworld;

import org.newdawn.slick.Graphics;

public interface Actor {
    //im actor in ein Interface die methoden enthalten die Alle Class brauchen
    public void render(Graphics graphics);
    public void update (int delta);
}
