package at.ta.games.firstgame.actors;

public class LeftCircle extends Circle {

    @Override
    public void update(int delta) {
        this.x -= (float) delta / this.speed;
        if (this.x > 800) {
            this.x = 0;
            this.diameter = 10;
            this.y = this.random.nextInt(600);
        }
        this.diameter += 0.009;
        if (this.diameter > 100) {
            this.diameter = 10;
        }
    }

}
