package cmars.dagger2scopes.ui.activity;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;

import cmars.dagger2scopes.BuildConfig;

/**
 * Created by Constantine Mars on 28/02/16.
 */
public class DaggerRobolectricTestRunner extends RobolectricGradleTestRunner {
    public static final int SDK_EMULATE_LEVEL = 21;

    public DaggerRobolectricTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    public Config getConfig(Method method) {
        final Config defaultConfig = super.getConfig(method);
        return new Config.Implementation(
                new int[]{SDK_EMULATE_LEVEL},
                defaultConfig.manifest(),
                defaultConfig.qualifiers(),
                defaultConfig.packageName(),
                defaultConfig.resourceDir(),
                defaultConfig.assetDir(),
                defaultConfig.shadows(),
                TestApp.class,
                defaultConfig.libraries(),
                defaultConfig.constants() == Void.class ? BuildConfig.class : defaultConfig.constants()
        );
    }
}
