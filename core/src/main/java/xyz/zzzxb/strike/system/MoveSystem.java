package xyz.zzzxb.strike.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import xyz.zzzxb.strike.component.Mapper;
import xyz.zzzxb.strike.component.PositionComponent;
import xyz.zzzxb.strike.component.VelocityComponent;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public class MoveSystem extends IteratingSystem {

    public MoveSystem() {
        super(Family.all(VelocityComponent.class, PositionComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float delta) {
        PositionComponent pm = Mapper.pm.get(entity);
        VelocityComponent vm = Mapper.vm.get(entity);

        if (pm.direction.isLeftOrRight()) {
            float walk = pm.direction.x * delta * vm.moveSpeed;
            pm.x += walk;
//            Gdx.app.log("move", "x: " + pm.x + ", walk: " + walk);
        }
        if (pm.direction.isUpOrDown()) {
            float walk = pm.direction.y * delta * vm.moveSpeed;
            pm.y += walk;
//            Gdx.app.log("move", "y: " + pm.y + ", walk: " + walk);
        }
    }
}
