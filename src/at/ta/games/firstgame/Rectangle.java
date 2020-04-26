package at.ta.games.firstgame;

import org.newdawn.slick.Graphics;


public class Rectangle implements Actor {
    private float x;
    private float y;
    private float speed;
    private ObjectDirectionRectangle objectDirectionRectangle;


    public Rectangle(int xRec, int yRec, float speed, ObjectDirectionRectangle objectDirectionRectangle) {
        this.x = xRec;
        this.y = yRec;
        this.speed = speed;
        this.objectDirectionRectangle = objectDirectionRectangle;

    }

    // es wird ein render sowie update methode  angelegt mit Graphics und delta, diese methode wir überall verwenden
    // und beim game dann als for each Schleife zusammen gefasst.
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 10, 10);
    }

    public void update(int delta) {
        switch (this.objectDirectionRectangle) {
            case RIGHT:
                this.x += (float) delta / this.speed;
                if (this.x > 800) {
                    this.x = 0;
                }
                break;
            case LEFT:
                this.x -= (float) delta / this.speed;

                if (this.x < 0) {
                    this.x = 800;
                }
        }
    }
}

