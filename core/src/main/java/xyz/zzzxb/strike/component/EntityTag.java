package xyz.zzzxb.strike.component;

import com.badlogic.ashley.core.Component;

import java.util.function.Supplier;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public enum EntityTag {
    PLAYER(Player::new);

    private final Component component;

    EntityTag(Supplier<Component> supplier) {
        this.component = supplier.get();
    }

    public Component takeObj() {
        return component;
    }

    public Class<? extends Component> takeClass() {
        return component.getClass();
    }
}

class Player implements Component {}
