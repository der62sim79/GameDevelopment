package at.ta.BreakeOut;

import org.newdawn.slick.*;

public class YourLoseScreen implements Actor {
    private Image lose;


    public YourLoseScreen() throws SlickException {
        Image tmp = new Image("testdata/youLose.png");
        this.lose = tmp.getScaledCopy(800, 600);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        lose.draw();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }
}
