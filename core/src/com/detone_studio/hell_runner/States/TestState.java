package com.detone_studio.hell_runner.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.detone_studio.hell_runner.GameStateManager;




public class TestState extends State {

    Vector3 position,velosity;
    Vector2 AB,AC;
    double degr;

    private Sprite car,potion;


    public TestState(GameStateManager gsm) {
        super(gsm);

        AB = new Vector2();
        AC = new Vector2();

        car = new Sprite(new Texture(Gdx.files.internal("data/static_1.png")));
        car.setCenter(10,200);

        position = new Vector3(10,200,0);
        velosity= new Vector3(5,5,0);

        potion = new Sprite(new Texture("data/heal_potion_2.png"));
        potion.setCenter(800,400);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()){
            velosity.x+=10;
            velosity.y+=5;
            //car.rotate(1);


            AB.x=potion.getOriginX()-position.x;
            AB.y=potion.getOriginY()-position.y;

            AC.x=AB.x;
            AC.y=0;



            //int ax=0,10];
            //int b=(4,6);
            //int c=(-6,4);

            //a*b=|a|*|b|*cos(x)
            //cos(x) = (a*b)/(|a|*|b|);




            degr = Math.toDegrees(Math.acos(((AB.x*AC.x) + (AB.y*AC.y))/(Math.sqrt((AB.x*AB.x)+(AC.x*AC.x))*(Math.sqrt((AB.y*AB.y)+(AC.y*AC.y))))));

            System.out.println(degr);
            car.setRotation((float)degr);
        }
        else
        {
            velosity.x=0;
            velosity.y=0;
        }
    }

    @Override
    public void update(float dt) {
      handleInput();


       velosity.scl(dt);
       position.add(velosity.x, velosity.y, 0);
       car.setCenter(position.x,position.y);
       velosity.scl(1 / dt);


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
