package at.ta.games.firstgame;

import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics);
    public void update (int delta);
}
