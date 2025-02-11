package xyz.zzzxb.strike;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public class AssertManage {
    Map<String, Sprite> textureMap = new HashMap<>();

    public void load(String name, String path) {
        textureMap.put(name, new Sprite(new Texture(path)));
    }

    public Sprite getTexture(String name) {
        return textureMap.get(name);
    }

    public void dispose() {
        for (Map.Entry<String, Sprite> stringTextureEntry : textureMap.entrySet()) {
            stringTextureEntry.getValue().getTexture().dispose();
        }
    }
}
