package com.example.shortcutsandroid;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager=getSystemService(ShortcutManager.class);
            ShortcutInfo shortcutInfo=new ShortcutInfo.Builder(this,"id1")
                    .setShortLabel("Web site")
                    .setLongLabel("Open this web site")
                    .setIcon(Icon.createWithResource(this,R.mipmap.ic_launcher))
                    .setIntents(new Intent[]{new Intent(Intent.ACTION_MAIN, Uri.EMPTY, this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mysite.example.com/"))})
                    .build();
            shortcutManager.addDynamicShortcuts(Arrays.asList(shortcutInfo));

        }

    }
}
