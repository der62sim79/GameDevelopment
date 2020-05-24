package at.ta.SnakeWorld;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;


public class Snake implements Actor, CollisionActor {

    private int x, y;
    private Snake next;
    private Shape collisionShape;
    private List<Food> foods;


    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        this.collisionShape = new Rectangle(this.x * Field.GRID_SIZE, this.y * Field.GRID_SIZE,
                Field.GRID_SIZE - 4, Field.GRID_SIZE - 4);
        this.foods = new ArrayList<>();
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.fillRect(this.x * Field.GRID_SIZE, this.y * Field.GRID_SIZE, Field.GRID_SIZE - 4,
                Field.GRID_SIZE - 4);
        graphics.setColor(Color.yellow);
        graphics.draw(collisionShape);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Food food : foods) {
            if (this.collisionShape.intersects(food.getCollisionShape())) {
                food.randomFood();
            }
        }

        this.collisionShape.setCenterX((this.x * Field.GRID_SIZE) + 14);
        this.collisionShape.setCenterY((this.y * Field.GRID_SIZE) + 14);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
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


    @Override
    public Shape getCollisionShape() {
        return collisionShape;
    }


    public void addCollisionPartner(Food food) {
        this.foods.add(food);
    }


}
