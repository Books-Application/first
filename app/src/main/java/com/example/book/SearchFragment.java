package com.example.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class SearchFragment extends Fragment {


    // TODO: Rename and change types of parameters

    EditText textS;
    String message;
    TextView text;
    Button btnserach;


    public SearchFragment() {

    }


    public static Fragment newInstance(String selection) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        //recupere le message
        args.putString("filter",selection);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message =getArguments().getString("filter");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        text = view.findViewById(R.id.textfiltre);
        textS = view.findViewById(R.id.rechercher);
        btnserach = view.findViewById(R.id.btnrechercher);
        text.setText(String.format("Search using %s", message));
        textS.setText(message);
        btnserach.setOnClickListener(view1 -> {

            String resh =textS.getText().toString();
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.holder, resultFragment.newInstance(message,resh)).addToBackStack("fragment").commit();

        });
        return view;
    }
}