package xyz.zzzxb.strike.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public class RenderableComponent implements Component {
    Sprite[] sprites;
    int index = 0;

    public RenderableComponent(Sprite sp) {
        sprites = new Sprite[]{sp};
    }

    public Sprite nowTexture() {
        return sprites[index];
    }
}
