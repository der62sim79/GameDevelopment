package at.ta.games.firstgame.Movement;

public class LeftMoveStrategy implements MoveStrategy{

    private float x, y;
    private float speed;


    public LeftMoveStrategy(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void uptade(int delta) {
        this.x -= (float) delta / this.speed;
        if (this.x < 0){
            this.x = 800;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}

