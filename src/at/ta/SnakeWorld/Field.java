package at.ta.SnakeWorld;

import org.newdawn.slick.*;


import java.util.ArrayList;
import java.util.List;


public class Field extends BasicGame {

    public static final int GRID_SIZE = 30;
    private Snake head, tail;
    private int timeRun = 0;
    private Image background;
    private List<Actor> actors;
    public static final int SPEED = 500;
    private String direction;

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 420;




    public Field(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        Image tmp = new Image("testdata/myPicture/images.jpg");
        this.background = tmp.getScaledCopy(800, 600);


        this.actors = new ArrayList<>();
        Snake s1 = new Snake(9, 8);
        Snake s2 = new Snake(10, 8);
        Snake s3 = new Snake(11, 8);


        s1.setNext(s2);
        s2.setNext(s3);
        this.tail = s1;
        this.head = s3;
        this.actors.add(s1);
        this.actors.add(s2);
        this.actors.add(s3);

        this.direction = "right";

        Food food = new Food();
        this.actors.add(food);


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(gameContainer, delta);
        }


        this.timeRun += delta;
        if (this.timeRun > SPEED) {

            Snake old = this.tail;
            this.tail = old.getNext();
            old.setNext(null);
            head.setNext(old);


            int newX = this.head.getX();
            int newY = this.head.getY();

            //Move
            switch (direction) {
                case "right":
                    newX++;
                    if (newX > 26) {
                        newX = 0;
                    }
                    break;
                case "left":
                    newX--;
                    if (newX < 0) {
                        newX = 26;
                    }
                    break;
                case "up":
                    newY--;
                    if (newY < 0) {
                        newY = 14;
                    }
                    break;
                case "down":
                    newY++;
                    if (newY > 14) {
                        newY = 0;
                    }
                    break;
            }
            old.setX(newX);
            old.setY(newY);

            this.head = old;
            this.timeRun = 0;
        }



    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        background.draw();

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

    }

    @Override
    public void keyPressed(int key, char c) {
        if ((key == Input.KEY_RIGHT) && (direction != "left")) {
            direction = "right";
        }
        if (key == Input.KEY_LEFT && (direction != "right")) {
            direction = "left";
        }
        if (key == Input.KEY_UP && (direction != "down")) {
            direction = "up";
        }
        if (key == Input.KEY_DOWN && (direction != "up")) {
            direction = "down";
        }

    }


    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Field("Snake"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}