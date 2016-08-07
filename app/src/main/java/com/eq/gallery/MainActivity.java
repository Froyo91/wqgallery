package com.eq.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click1(View view) {
        startActivity(new Intent(this, FromActivityActivity.class));
    }

    public void click2(View view) {
        startActivity(new Intent(this, FromFragmentActivity.class));
    }
}
