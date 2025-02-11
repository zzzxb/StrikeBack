package xyz.zzzxb.strike.component;

import com.badlogic.ashley.core.ComponentMapper;

/**
 *
 * @author zzzxb
 * 2025/2/10
 */
public class Mapper {
    public static final ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);
    public static final ComponentMapper<RenderableComponent> rm = ComponentMapper.getFor(RenderableComponent.class);
}
