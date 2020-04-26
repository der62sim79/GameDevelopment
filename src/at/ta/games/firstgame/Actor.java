package at.ta.games.firstgame;

import org.newdawn.slick.Graphics;

public interface Actor {
    //im actor in ein Interface die methoden enthalten die Alle Class brauchen
    public void render(Graphics graphics);
    public void update (int delta);
}
