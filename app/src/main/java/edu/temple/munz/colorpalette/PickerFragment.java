package edu.temple.munz.colorpalette;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Console;


/**
 * Contains the spinner with color choices
 */
public class PickerFragment extends Fragment {


    Spinner spinner;
    Context parent;


    public PickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.parent = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_picker, container, false);
        v.setBackgroundColor(Color.WHITE);

        //get reference to the spinner
        spinner = v.findViewById(R.id.spinner);
        spinner.setAdapter(new PaletteAdapter(parent, parent.getResources().getStringArray(R.array.color_names_array), parent.getResources().getStringArray(R.array.colorIDs)));

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //set the selection to the first item so when we hit the back button on single-frame view, the item won't still be selected (triggering this onItemSelected method again instantly)
                spinner.setSelection(0);

                //when a color is selected, open a new view with that color as the background
                //only open new view if the user has selected something other than the default/first element
                if(!adapterView.getItemAtPosition(i).equals("")) {
                    String color = (String)adapterView.getItemAtPosition(i);
                    ((GetColorInterface)parent).colorSelected(color);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return v;
    }


    interface GetColorInterface {
        void colorSelected(String color);
    }

}
