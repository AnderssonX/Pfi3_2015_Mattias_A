
package com.example.mattias.assignment_3;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

// changed stuff!!!!
/**
 * A simple {@link Fragment} subclass.
 */
public class Travels extends Fragment implements AdapterView.OnItemSelectedListener {
    private ArrayList<Journey> myItems = new ArrayList<Journey>();
    private Adapter myAdapter;

    public Travels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_travels,
                container, false);

        ExpandableListView ev = (ExpandableListView) view.findViewById(R.id.expandableListView);
        myAdapter = new Adapter(getActivity(), myItems);
        ev.setAdapter(myAdapter);

        Spinner sp = (Spinner) view.findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        return view;
    }

    public void onClick(View v) {

    }

    private void searchFinished() {
        TextView tw = (TextView) getView().findViewById(R.id.boo);
        tw.setText("search_finished" + myItems.size());
        for (Journey j : myItems) {
            tw.append("From" + j.getStartStation().getStationName()
                    + " To: " + j.getEndStation()
                    + " leaves : " + j.getTimeToDeparture() + "\n");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] courses = getActivity().getResources().getStringArray(R.array.stationNumbers);
        String course = courses[position];
        Log.i("ExpFragment", "Course. " + course);
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(course);

        String searchURL = Constants.getURL("80000", "93070", 10); //Malmö C = 80000,  Malmö GAtorg 80100, Hässleholm C 93070
        new MyAsyncTask().execute(searchURL);

        TextView tw = (TextView) getView().findViewById(R.id.boo);
        tw.append(
                "Booyeah motherfucker!");


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private class MyAsyncTask extends AsyncTask<String, Void, Long> {

        @Override
        protected Long doInBackground(String... params) {
            Journeys journeys = Parser.getJourneys(params[0]); //There can be many in the params Array
            String param1 = params[0];
            myItems.clear();
            myItems.addAll(journeys.getJourneys());
            return null;
        }


        protected void onPostExecute(Long result) { //Called when the AsyncTask is all done
            searchFinished();
        }
    }
}