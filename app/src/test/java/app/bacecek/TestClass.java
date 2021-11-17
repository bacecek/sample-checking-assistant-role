package app.bacecek;

import android.animation.ObjectAnimator;
import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.S, manifest = Config.NONE)
public class TestClass {

    @Test
    public void testAndroidAnimator() {
        ObjectAnimator mock = Mockito.mock(ObjectAnimator.class);
    }
}
