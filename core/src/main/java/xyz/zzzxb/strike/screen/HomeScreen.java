package xyz.zzzxb.strike.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import xyz.zzzxb.strike.AssertManage;
import xyz.zzzxb.strike.component.*;
import xyz.zzzxb.strike.input.KeyboardInput;
import xyz.zzzxb.strike.system.MoveSystem;
import xyz.zzzxb.strike.system.RenderSystem;

public class HomeScreen implements Screen {
    SpriteBatch batch;
    Camera camera;
    Engine engine;
    FitViewport viewport;
    AssertManage am;
    KeyboardInput keyboardInput;


    @Override
    public void show() {
        batch = new SpriteBatch();
        engine = new PooledEngine();
//        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        keyboardInput = new KeyboardInput(engine);

        am = new AssertManage();
        am.load("Green", "Background/Green.png");
        am.load("Blue", "Background/Blue.png");

        engine.addSystem(new MoveSystem());
        engine.addSystem(new RenderSystem(batch, viewport, am));

        Entity entity = engine.createEntity();
        entity.add(new PositionComponent(100, 100, 0));
        entity.add(new RenderableComponent(am.getTexture("Green")));
        entity.add(new VelocityComponent(100));
        entity.add(EntityTag.PLAYER.takeObj());
        engine.addEntity(entity);

        Gdx.input.setInputProcessor(keyboardInput);
    }

    @Override
    public void render(float delta) {
        engine.update(delta);
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        batch.dispose();
        am.dispose();
    }
}
