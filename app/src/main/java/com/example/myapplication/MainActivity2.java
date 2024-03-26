package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image);
        Drawable drawable = AppCompatResources.getDrawable(this,R.drawable.test);
        imageView.setImageDrawable(drawable);
//        Log.d("liukun", "onCreate: "+drawable.getState());
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        findViewById(R.id.test).setOnClickListener(view -> {
            int[] state = drawable.getState();
            for (int i : state) {
                Log.i("liukun", "onCreate: "+ i+"|"+getResources().getResourceName(i));

            }

            drawable.setState(new int[]{android.R.attr.state_checked,android.R.attr.state_pressed});
            imageView.setImageDrawable(drawable.getCurrent());
        });
    }
}