package edu.temple.munz.colorpalette;

// I had to manually change these imports because it was using android.app.Fragment,
// which is deprecated and was causing mismatch errors
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    final public String COLOR_IDS = "ci";

    Spinner spinner;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //this array is replaced in the strings.xml file
        ///final String colors[] = { "", "Blue", "Red", "Green", "Yellow", "Magenta"};

        Resources res = this.getResources();
        final String[] colorNames = res.getStringArray(R.array.color_names_array);

        spinner = findViewById(R.id.spinner);
        layout = findViewById(R.id.layoutPalette);

        final String[] colorIDs = res.getStringArray(R.array.colorIDs);


        //instantiate PaletteAdapter and apply it to the spinner
        PaletteAdapter adapter = new PaletteAdapter(this, colorNames, colorIDs);
        spinner.setAdapter(adapter);

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //when a color is selected, open a new view with that color as the background
                //only open new view if the user has selected something other than the default/first element
                if(!adapterView.getItemAtPosition(i).equals("")) {
                    //layout.setBackgroundColor(Color.parseColor(colors[i]));
                    //below 3 lines are to start a new activity; we are changing that to showing a new fragment
                    //Intent startCanvasIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    //startCanvasIntent.putExtra("bgColor", colorIDs[i]);
                    //startActivityForResult(startCanvasIntent, 117);


                    CanvasFragment canvasFragment = new CanvasFragment();
                    canvasFragment = canvasFragment.newInstance(colorIDs[i]);

                    //create the fragment
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentFrame, canvasFragment).addToBackStack(null).commit();



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
