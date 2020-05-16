package at.ta.SnakeWorld;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Snake implements Actor {
    private float x;
    private float y;
    private Shape collisionShape;
    private float speed;
    private SnakeProperties snakeProperties;
    private List<CollisionActor> collisionActors;



    public Snake(int xRec, int yRec, float speed) {
        this.x = xRec;
        this.y = yRec;
        this.collisionShape = new Rectangle(this.x, this.y, 12, 12);
        this.speed = speed;
        this.snakeProperties = new SnakeProperties("RIGHT");
        this.collisionActors = new ArrayList<CollisionActor>();


    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x, this.y, 11, 11);
        graphics.draw(collisionShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (this.x > 800){
            this.x = 0;
        }else if (this.x < 0){
            this.x = 800;
        }else if (this.y > 600){
            this.y = 0;
        }else if (this.y < 0){
            this.y = 600;
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.snakeProperties.setDirection("RIGHT");
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.snakeProperties.setDirection("LEFT");
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.snakeProperties.setDirection("UP");
        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.snakeProperties.setDirection("DOWN");
        }

        switch (snakeProperties.getDirection()) {
            case "UP":
                this.y -= (float) delta / this.speed;
                break;
            case "DOWN":
                this.y += (float) delta / this.speed;
                break;
            case "LEFT":
                this.x -= (float) delta / this.speed;
                break;
            case "RIGHT":
                this.x += (float) delta / this.speed;
                break;
        }

        for (CollisionActor collisionActor : this.collisionActors) {
            if (this.collisionShape.intersects(collisionActor.getCollisionShape())) {
                System.out.println("boo");
            }

        }

        this.collisionShape.setCenterX(this.x + 6);
        this.collisionShape.setCenterY(this.y + 6);
    }

    public void addColisionPartner(Apple apple) {
        this.collisionActors.add(apple);
    }


}
