package xyz.zzzxb.strike.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import xyz.zzzxb.strike.AssertManage;
import xyz.zzzxb.strike.component.Mapper;
import xyz.zzzxb.strike.component.PositionComponent;
import xyz.zzzxb.strike.component.RenderableComponent;

import java.util.Comparator;

/**
 * @author zzzxb
 * 2025/2/10
 */
public class RenderSystem extends SortedIteratingSystem {
    SpriteBatch batch;
    FitViewport viewport;
    AssertManage am;

    public RenderSystem(SpriteBatch batch, FitViewport viewport, AssertManage am) {
        super(Family.all(RenderableComponent.class, PositionComponent.class).get(), new ZComparator());
        this.batch = batch;
        this.viewport = viewport;
        this.am = am;
    }

    @Override
    public void update(float deltaTime) {
        ScreenUtils.clear(Color.WHITE);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        renderBackground();
        for (Entity entity : getEntities()) {
            PositionComponent positionComponent = Mapper.pm.get(entity);
            RenderableComponent renderableComponent = Mapper.rm.get(entity);
            Sprite sprite = renderableComponent.nowTexture();
            sprite.setPosition(positionComponent.x, positionComponent.y);
            sprite.draw(batch);
        }
        batch.end();
    }
    private void renderBackground() {
        Sprite sp = am.getTexture("Blue");
        int widthNum = (int)(viewport.getWorldWidth() / sp.getWidth()) + 1;
        int heightNum = (int)(viewport.getWorldHeight() / sp.getHeight()) + 1;
        for (int i = 0; i < widthNum; i++) {
            for (int i1 = 0; i1 < heightNum; i1++) {
                sp.setPosition(i * sp.getWidth(), i1 * sp.getHeight());
                sp.draw(batch);
            }
        }
    }


    @Override
    protected void processEntity(Entity entity, float v) {
    }

    private static class ZComparator implements Comparator<Entity> {

        @Override
        public int compare(Entity e1, Entity e2) {
            return (int)Math.signum(Mapper.pm.get(e1).z - Mapper.pm.get(e2).z);
        }
    }
}
