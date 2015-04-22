package com.example.mattias.assignment4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mattias on 15-04-22.
 */
public class MyListAdapter extends ArrayAdapter<Planet> {
    ArrayList<Planet> booksList;
    Context c;

    public MyListAdapter(Context context, ArrayList<Planet> booksList) {
        super(context, 0, booksList);
        this.booksList = booksList;
        this.c = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("MyListAdapter", "Called for position: " + position);
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item,null);
        Planet b = booksList.get(position);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_title);
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_bookcover);
        tv.setText(b.getName());
        iv.setImageDrawable(b.getImage());
        return convertView;
    }
}
