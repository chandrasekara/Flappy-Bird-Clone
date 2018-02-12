package com.mygdx.flappybird;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by dhila on 26/01/2018.
 *
 */

public class Bird {

    Texture[] sprites;
    public int x;
    public int y;
    public float velocity;


    SpriteBatch batch;

    int flapSpriteState;

    int frameCount;

    Circle boundingCircle;



    public Bird (SpriteBatch batch_in) {

        sprites = new Texture[2];

        sprites[0] = new Texture("bird.png");
        sprites[1] = new Texture("bird2.png");

        x = FlappyBird.screen_width/2;
        y = FlappyBird.screen_height/2;

        this.batch = batch_in;

        flapSpriteState = 0;

        velocity = 0;

        frameCount = 0;

        this.boundingCircle = new Circle(this.x,this.y,sprites[0].getWidth()/2);
        
    }

    public void start() {

        jump();
    }


    public void render() {

        frameCount += 1;


        if (frameCount > 5) {
            frameCount = 0;
            if (flapSpriteState == 0) {
                flapSpriteState = 1;
            } else {
                flapSpriteState = 0;
            }
        }


        batch.draw(sprites[flapSpriteState],x - sprites[0].getWidth()/2,y -
                sprites[0].getHeight()/2);



    }

    public void jump() {

        if (y < FlappyBird.screen_height) {
            velocity = 25;
        }

    }

    public void step() {

        if (y>0 || velocity >0) {
            velocity -= FlappyBird.gravity;

            y += velocity;

        }

        //this.boundingCircle.setX(this.x - sprites[0].getWidth() / 2);
        this.boundingCircle.setY(this.y);

    }



}
