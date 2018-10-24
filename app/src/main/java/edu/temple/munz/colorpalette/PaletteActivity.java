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

public class PaletteActivity extends AppCompatActivity implements PickerFragment.GetColorInterface {

    final public String COLOR_IDS = "ci";

    FragmentManager fm;
    PickerFragment pf;
    CanvasFragment cf;
    boolean singlePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //find out if it's in single-pane (small screen, vertical) or
        // double-pane (large screen or horizontal) mode by checking for 2nd fragment frame
        singlePane = findViewById(R.id.frameCanvas) == null;

        //create fragment manager
        fm = getSupportFragmentManager();

        //instantiate the picker (spinner) fragment and add it to fm
        pf = new PickerFragment();
        fm.beginTransaction()
                .replace(R.id.frameSpinner, pf)
                .commit();



        //instantiate the canvas fragment


    }

    //implement the GetColorInterface from the PickerFragment class
    @Override
    public void colorSelected(String color) {
        cf = (new CanvasFragment()).newInstance(color);
        if(singlePane) {
            fm.beginTransaction().replace(R.id.frameSpinner, cf).addToBackStack(null).commit();
        }
        else {
            fm.beginTransaction()
                    .replace(R.id.frameCanvas, cf)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
