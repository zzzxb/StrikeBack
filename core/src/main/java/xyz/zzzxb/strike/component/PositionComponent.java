package xyz.zzzxb.strike.component;

import com.badlogic.ashley.core.Component;
import xyz.zzzxb.strike.enums.MoveDirection;

/**
 *
 * @author zzzxb
 * 2025/2/10
 */
public class PositionComponent implements Component {
    public MoveDirection direction = MoveDirection.NONE;
    public float x = 0;
    public float y = 0;
    public float z = 0;
    public int zIndex = 0;

    public PositionComponent(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PositionComponent(float x, float y, float z, int zIndex) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.zIndex = zIndex;
    }
}
