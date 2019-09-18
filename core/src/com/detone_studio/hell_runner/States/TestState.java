package com.detone_studio.hell_runner.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.detone_studio.hell_runner.GameStateManager;




public class TestState extends State {

    private Sprite car,potion;


    public TestState(GameStateManager gsm) {
        super(gsm);

        car = new Sprite(new Texture(Gdx.files.internal("data/static_1.png")));
        car.setCenter(10,10);
        potion = new Sprite(new Texture("data/heal_potion_2.png"));
        potion.setCenter(800,400);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
      handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
            car.draw(sb);
            potion.draw(sb);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
