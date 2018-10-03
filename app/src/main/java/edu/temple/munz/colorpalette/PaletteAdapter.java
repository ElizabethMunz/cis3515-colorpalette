package edu.temple.munz.colorpalette;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PaletteAdapter extends BaseAdapter {

    Context context;
    String colorList[];


    public PaletteAdapter(Context context, String colorList[]) {
        this.context = context;
        this.colorList = colorList;
    }


    @Override
    public int getCount() {
        return colorList.length;
    }

    @Override
    public Object getItem(int i) {
        return colorList[i];
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
        if(colorList[i].equals("")) {
           textView.setText("Select a color");
        }
        else {
            textView.setText(colorList[i]);
            textView.setBackgroundColor(Color.parseColor(colorList[i]));
        }
        return textView;
    }
}
