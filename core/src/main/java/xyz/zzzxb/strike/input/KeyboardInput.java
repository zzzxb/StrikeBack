package xyz.zzzxb.strike.input;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import xyz.zzzxb.strike.component.EntityTag;
import xyz.zzzxb.strike.component.Mapper;
import xyz.zzzxb.strike.component.PositionComponent;
import xyz.zzzxb.strike.enums.MoveDirection;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public class KeyboardInput extends InputAdapter {
    ImmutableArray<Entity> entities;

    public KeyboardInput(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(EntityTag.PLAYER.takeClass()).get());
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W: move(MoveDirection.UP); break;
            case Input.Keys.S: move(MoveDirection.DOWN); break;
            case Input.Keys.A: move(MoveDirection.LEFT); break;
            case Input.Keys.D: move(MoveDirection.RIGHT); break;
            case Input.Keys.Q: Gdx.app.exit();
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        move(MoveDirection.NONE);
        return false;
    }

    private void move(MoveDirection mv) {
        for (Entity entity : entities) {
            PositionComponent positionComponent = Mapper.pm.get(entity);
            positionComponent.direction = mv;
        }
    }
}
