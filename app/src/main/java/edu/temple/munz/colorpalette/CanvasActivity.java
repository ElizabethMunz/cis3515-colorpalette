package edu.temple.munz.colorpalette;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {


    ConstraintLayout layoutCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);


        layoutCanvas = findViewById(R.id.layoutCanvas);


        //get color choice from paletteActivity
        Intent paletteIntent = getIntent();
        String bgColor = paletteIntent.getStringExtra("bgColor");

        //set the layout's background to the chosen color
        layoutCanvas.setBackgroundColor(Color.parseColor(bgColor));


    }
}
