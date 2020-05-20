package at.ta.SnakeWorld;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;


public class Snake implements Actor {
    private int x, y;
    private Snake next;
    private List<Actor> actors;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        this.actors = new ArrayList<>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x * Field.GRID_SIZE, this.y * Field.GRID_SIZE, Field.GRID_SIZE - 10, Field.GRID_SIZE - 4);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

//        moveSnake(gameContainer, delta);
//
////        ArrayList<Apple> apples = new ArrayList<>();
////        for (Apple apple : apples) {
////            if (this.collisionShape.intersects(apple.getCollisionShape())) {
////                apple.hit();
////                if (apple.isDestroyed()) {
////                    apples.add(apple);
////                }
////            }
////        }
////
////        for (Apple apple : apples) {
////            apples.remove(apple);
////            collisionActors.remove(apple);
////        }
//
//
////        this.collisionShape.setCenterX(this.x + 6);
////        this.collisionShape.setCenterY(this.y + 6);
    }

//    private void moveSnake(GameContainer gameContainer, float delta) {
//        if (this.x > 800) {
//            this.x = 0;
//        } else if (this.x < 0) {
//            this.x = 800;
//        } else if (this.y > 495) {
//            this.y = 0;
//        } else if (this.y < 0) {
//            this.y = 495;
//        }
//
//        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
//            this.snakeProperties.setDirection("RIGHT");
//        } else if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
//            this.snakeProperties.setDirection("LEFT");
//        } else if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
//            this.snakeProperties.setDirection("UP");
//        } else if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
//            this.snakeProperties.setDirection("DOWN");
//        }
//
//        switch (snakeProperties.getDirection()) {
//            case "UP":
//                this.y -= delta / this.speed;
//                break;
//            case "DOWN":
//                this.y += delta / this.speed;
//                break;
//            case "LEFT":
//                this.x -= delta / this.speed;
//                break;
//            case "RIGHT":
//                this.x += delta / this.speed;
//                break;
//        }
//    }
//
////    public void addColisionPartner(Apple apple) {
////        this.collisionActors.add(apple);
////    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Snake getNext() {
        return next;
    }

    public void setNext(Snake next) {
        this.next = next;
    }
}
