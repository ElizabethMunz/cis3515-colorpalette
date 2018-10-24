package edu.temple.munz.colorpalette;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PaletteAdapter extends BaseAdapter {



    Context context;
    String colorNames[];
    String colorIDs[];


    public PaletteAdapter(Context context, String colorNames[], String colors[]) {
        this.context = context;
        this.colorNames = colorNames;
        this.colorIDs = colors;
    }


    @Override
    public int getCount() {
        return colorNames.length;
    }

    @Override
    public Object getItem(int i) {
        return colorNames[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        //make text white and background the color
        textView.setTextColor(Color.rgb(0,0,0));
        textView.setPadding(5, 2, 0, 2);
        if(colorNames[i].equals("")) {
           textView.setText(R.string.select);
        }
        else {
            textView.setText(colorNames[i]);
            //parse the color from the color IDs, which will always be English, not the color Names that get translated
            textView.setBackgroundColor(Color.parseColor(colorIDs[i]));
        }
        return textView;
    }
}
