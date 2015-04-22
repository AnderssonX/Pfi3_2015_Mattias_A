package com.example.mattias.assignment4;

/**
 * Created by Mattias on 15-04-22.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentList extends Fragment {
    public static ArrayList<Book> books = new ArrayList<Book>();

    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        books.clear();
        Drawable d = getResources().getDrawable(R.drawable.img1);
        books.add(new Book("In the process","44535345",d));
        d = getResources().getDrawable(R.drawable.img2);
        books.add(new Book("In the doing","44535346",d));
        d = getResources().getDrawable(R.drawable.img3);
        books.add(new Book("In the adding","44535348",d));
        d = getResources().getDrawable(R.drawable.img4);
        books.add(new Book("In the moving","44535349",d));
        d = getResources().getDrawable(R.drawable.img5);
        books.add(new Book("In the storing","44535350",d));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_with_list, container, false);
        Log.i("FragmentWithList", "NumberOfBooks: " + books.size());
        MyListAdapter la = new MyListAdapter(getActivity(),books);
        ListView lv = (ListView) v.findViewById(R.id.listView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("FragmentWithList", "Clicked on position: " + position);
                FragmentManager fm = getFragmentManager();
                FragmentDialog fd = new FragmentDialog();
                Bundle b = new Bundle();
                b.putSerializable("book",books.get(position));
                fd.setArguments(b);
                fd.show(fm,"Dialog");
            }
        });
        return v;
    }


}
