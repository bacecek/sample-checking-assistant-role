package app.bacecek.defaultassistant;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup androidContent = findViewById(android.R.id.content);
        ViewGroup content = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_main, androidContent, false);
        setContentView(content);

        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        findViewById(R.id.enter).setOnClickListener(v -> {
            controller.hide(WindowInsetsCompat.Type.systemBars());
            controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        });
        findViewById(R.id.exit).setOnClickListener(v -> {
            controller.show(WindowInsetsCompat.Type.systemBars());
        });

        ViewCompat.setOnApplyWindowInsetsListener(androidContent, (v, insets) -> {
            Insets navbar = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            content.setPadding(navbar.left, navbar.top, navbar.right, navbar.bottom);
            android.util.Log.d("kek", "navbar: " + insets.getInsets(WindowInsetsCompat.Type.navigationBars()));
            android.util.Log.d("kek", "systemBars: " + insets.getInsets(WindowInsetsCompat.Type.systemBars()));
            android.util.Log.d("kek", "getRootWindowInsets().getSystemWindowInsetBottom(): " + v.getRootWindowInsets().getSystemWindowInsetBottom());
            return insets;
        });

        content.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                ViewCompat.requestApplyInsets(content);
            }

            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });
    }



}