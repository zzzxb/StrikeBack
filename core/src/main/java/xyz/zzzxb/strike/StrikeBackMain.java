package xyz.zzzxb.strike;

import com.badlogic.gdx.Game;
import xyz.zzzxb.strike.screen.HomeScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class StrikeBackMain extends Game {
    @Override
    public void create() {
        setScreen(new HomeScreen());
    }
}
