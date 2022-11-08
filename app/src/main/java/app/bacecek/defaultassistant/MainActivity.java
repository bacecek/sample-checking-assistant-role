package app.bacecek.defaultassistant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ASSISTANT_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.check_assist_utils).setOnClickListener(ignore -> checkUsingAssistUtils());
        findViewById(R.id.check_role_manager).setOnClickListener(ignore -> checkUsingRoleManager());
        findViewById(R.id.request_role).setOnClickListener(ignore -> requestAssistantRole());
        findViewById(R.id.open_voice_input_settings).setOnClickListener(ignore -> openVoiceInputSettings());


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
        Log.d("kek", "lol");
    }

    private void checkUsingAssistUtils() {
        ComponentName currentAssistant = getCurrentAssistWithReflection(this);
        if (currentAssistant == null) {
            showMessage("Something goes wrong :(");
            return;
        }
        boolean isItMe = currentAssistant.getPackageName().equals(BuildConfig.APPLICATION_ID);
        showMessage(String.format("Assistant package=%s\nIs it me? %s!",
                currentAssistant.getPackageName(), (isItMe ? "Yes" : "No")));
    }

    private void checkUsingRoleManager() {
        RoleManager roleManager = getRoleManager();
        boolean isAvailable = roleManager.isRoleAvailable(RoleManager.ROLE_ASSISTANT);
        boolean isHeld = roleManager.isRoleHeld(RoleManager.ROLE_ASSISTANT);

        showMessage(String.format("isRoleAvailable=%s, isRoleHeld=%s", isAvailable, isHeld));
    }

    private void requestAssistantRole() {
        RoleManager roleManager = getRoleManager();
        Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_ASSISTANT);
        startActivityForResult(intent, REQUEST_ASSISTANT_CODE);
    }

    private void openVoiceInputSettings() {
        Intent intent = new Intent(Settings.ACTION_VOICE_INPUT_SETTINGS);
        startActivity(intent);
    }

    private RoleManager getRoleManager() {
        return (RoleManager) getSystemService(Context.ROLE_SERVICE);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ASSISTANT_CODE) {
            showMessage(String.format("Result of requesting assistant role:\n resultCode=%s, data=%s", resultCode, data));
        }
    }

    @Nullable
    private static ComponentName getCurrentAssistWithReflection(Context context) {
        try {
            Method myUserIdMethod = UserHandle.class.getDeclaredMethod("myUserId");
            myUserIdMethod.setAccessible(true);
            Integer userId = (Integer) myUserIdMethod.invoke(null);

            if (userId != null) {
                Constructor constructor = Class.forName("com.android.internal.app.AssistUtils").getConstructor(Context.class);
                Object assistUtils = constructor.newInstance(context);

                Method getAssistComponentForUserMethod = assistUtils.getClass().getDeclaredMethod("getAssistComponentForUser", int.class);
                getAssistComponentForUserMethod.setAccessible(true);
                return (ComponentName) getAssistComponentForUserMethod.invoke(assistUtils, userId);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}