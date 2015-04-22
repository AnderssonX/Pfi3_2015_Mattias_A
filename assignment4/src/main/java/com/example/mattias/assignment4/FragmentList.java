package com.example.mattias.assignment4;

/**
 * Created by Mattias on 15-04-22.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentList extends Fragment {
    public static ArrayList<Planet> planets = new ArrayList<Planet>();
public static int currentPlanet;
    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planets.clear();
        Drawable d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är den fjärde planeten från solen och solsystemets näst minsta planet. Den har fått sitt namn efter den romerska krigsguden Mars och kallas ibland för \"den röda planeten\" på grund av sitt rödaktiga utseende. Den röda färgen beror på stora mängder järnoxid (rost) som finns fördelat över ytan och i atmosfären. Mars är en av de fyra stenplaneterna och har en tunn atmosfär som till största delen består av koldioxid. Ytan är täckt av kratrar av olika storlekar likt månen, men Mars har precis som jorden även många vulkaner, dalgångar, vidsträckta slätter och iskalotter vid polerna.", "3376", "227", d));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är en planet", "3376", "227", d));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är en planet", "3376", "227", d));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är en planet", "3376", "227", d));
        d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är en planet", "3376", "227", d));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_with_list, container, false);
        Log.i("FragmentWithList", "NumberOfBooks: " + planets.size());
        MyListAdapter la = new MyListAdapter(getActivity(),planets);
        GridView lv = (GridView) v.findViewById(R.id.gridView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);
                // ORIGINAL CODE FROM EXAMPLE

           /*      FragmentManager fm = getFragmentManager();
                FragmentDialog fd = new FragmentDialog();
                Bundle b = new Bundle();
                b.putSerializable("book",books.get(position));
                fd.setArguments(b);
                fd.show(fm,"Dialog"); */

currentPlanet = position;
                Bundle b = new Bundle();
                b.putSerializable("book",planets.get(position));
                FragmentPlanet fp = new FragmentPlanet();
                fp.setArguments(b);

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentPlanet bf = new FragmentPlanet();
                // byt layout till fragment2
                ft.replace(R.id.main_layout,bf);
                ft.commit();

            }

        });
        return v;
    }

    public String getName(){
        return planets.get(currentPlanet).getName();
    }

    public String getFacts(){
        return planets.get(currentPlanet).getInfo();

}
    public String getStats(){
        return planets.get(currentPlanet).getSummary();

    }
}
