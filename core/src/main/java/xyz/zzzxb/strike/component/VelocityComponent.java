package xyz.zzzxb.strike.component;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public class VelocityComponent implements Component {
    public float moveSpeed = 0;

    public VelocityComponent(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
