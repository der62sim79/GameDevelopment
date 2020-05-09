package at.ta.BreakeOut;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class GameAds implements Actor {

    private int lives;
    private int score;
    private AngelCodeFont font;


    public GameAds() throws SlickException {
        this.lives = 3;
        this.score = 0;
        this.font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
    }

    public String getLives() {
        return "Lives: " + Integer.toString(lives);
    }

    public String getScore() {
        return "Score: " + Integer.toString(score);
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        font.drawString(10, 550, getScore());
        font.drawString(600, 550, getLives());
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

    }


}
