package at.ta.rocket;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Actor {
    //im actor in ein Interface die methoden enthalten die Alle Class brauchen
    public void render(Graphics graphics);

    //die update methode wird um GameContainer erweitert
    public void update(GameContainer gameContainer, int delta) throws SlickException;
}
