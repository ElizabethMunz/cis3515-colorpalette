package edu.temple.munz.colorpalette;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {


    Spinner spinner;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final String colors[] = { "", "Blue", "Red", "Green", "Yellow", "Magenta"};

        spinner = findViewById(R.id.spinner);
        layout = findViewById(R.id.layoutPalette);


        //instantiate PaletteAdapter and apply it to the spinner
        PaletteAdapter adapter = new PaletteAdapter(this, colors);
        spinner.setAdapter(adapter);

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //when a color is selected, open a new view with that color as the background
                //only open new view if the user has selected something other than the default/first element
                if(!adapterView.getItemAtPosition(i).equals("")) {
                    //layout.setBackgroundColor(Color.parseColor(colors[i]));
                    Intent startCanvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    startCanvasIntent.putExtra("bgColor", colors[i]);
                    startActivityForResult(startCanvasIntent, 117);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
