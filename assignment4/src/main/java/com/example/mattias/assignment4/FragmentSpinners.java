package com.example.mattias.assignment4;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Mattias on 15-04-22.
 */
public class FragmentSpinners extends Fragment implements AdapterView.OnItemSelectedListener{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_with_spinners, container, false);
        Spinner spinner = (Spinner)v.findViewById(R.id.spinner_book_names);
        spinner.setOnItemSelectedListener(this); //This class implements OnItemSelectedListenr
        Spinner spinner2 = (Spinner)v.findViewById(R.id.spinner_other_book_names);
        ArrayAdapter<Book> bookAdapter = new ArrayAdapter<Book>(this.getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                FragmentList.books);
        spinner2.setAdapter(bookAdapter);
        spinner2.setOnItemSelectedListener(this);
        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==R.id.spinner_book_names){
            String[] bookNames = getResources().getStringArray(R.array.books);
            Log.i("FragmentWithSpinners", "Selected position:  " + position + " and book item " + bookNames[position]);
            Toast.makeText(this.getActivity(), "Selected position:  " + position + " and book item " + bookNames[position], Toast.LENGTH_LONG).show();
        }

        if (parent.getId()==R.id.spinner_other_book_names){
            String[] isbn_numbers = getResources().getStringArray(R.array.books_isbn);
            Log.i("FragmentWithSpinners","Selected position:  "+position+" with title " +  FragmentList.books.get(position).getName());
            Toast.makeText(this.getActivity(),"Selected position:  "+position+" with title " +  FragmentList.books.get(position).getName(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}