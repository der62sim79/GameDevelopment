package at.ta.rocket;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Rocket implements Actor {
    private Image rocketImage;
    private float x, y;
    private Shape collisonShape; // schablone die über den bild gestülpt wird, kollisionserkennenung
    private List<CollisionActor> collisionShapes;

    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        this.rocketImage = tmp.getScaledCopy(40, 100);
        this.x = 100;
        this.y = 100;
        this.collisonShape = new Rectangle(this.x, this.y, 43, 85);
        this.collisionShapes = new ArrayList<>();
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x, this.y);
//        graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (CollisionActor shape: this.collisionShapes) {
            if (this.collisonShape.intersects(shape.getCollisionShape())) {
                System.out.println("boom");
            }
        }

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x++;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y--;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y++;
        }

        //schablone wandert mit
        this.collisonShape.setCenterX(this.x + 20);
        this.collisonShape.setCenterY(this.y + 45);
    }



    public float getX() {
        return x + 15;
    }

    public float getY() {
        return y - 10;
    }

    //add methode für die spacecircle
    public void addCollisionsPartner(SpaceCircle spaceCircle) {
        this.collisionShapes.add(spaceCircle);
    }
}
