package xyz.zzzxb.strike.enums;

/**
 *
 * @author zzzxb
 * 2025/2/11
 */
public enum MoveDirection {
    NONE(0, 0),
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    public final int x;
    public final int y;

    MoveDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isUpOrDown() {
        return this == MoveDirection.UP || this == MoveDirection.DOWN;
    }

    public boolean isLeftOrRight() {
        return this == MoveDirection.LEFT || this == MoveDirection.RIGHT;
    }
}
