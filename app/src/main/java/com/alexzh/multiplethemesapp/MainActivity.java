package com.alexzh.multiplethemesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.blue_theme_btn)).setOnClickListener(this);
        ((Button)findViewById(R.id.red_theme_btn)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blue_theme_btn:
                Utility.setTheme(getApplicationContext(), 1);
                recreateActivity();
                break;
            case R.id.red_theme_btn:
                Utility.setTheme(getApplicationContext(), 2);
                recreateActivity();
                break;
        }
    }

    public void recreateActivity() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}