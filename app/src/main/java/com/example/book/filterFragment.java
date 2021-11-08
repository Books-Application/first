package com.example.book;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class filterFragment extends Fragment {

    RadioButton booknames, Category, Author;
    RadioGroup filtre;
    Button btnfilter;

    public filterFragment() {

    }


    public static filterFragment newInstance() {
        filterFragment fragment = new filterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        booknames = (RadioButton) view.findViewById(R.id.book_name);
        Category = (RadioButton) view.findViewById(R.id.Category);
        Author = (RadioButton) view.findViewById(R.id.Author);
        btnfilter = view.findViewById(R.id.btnfilter);


        btnfilter.setOnClickListener(view1 -> {
            filtre = (RadioGroup) view.findViewById(R.id.filtre);
            String selection = "nothing";
            if (filtre.getCheckedRadioButtonId() != -1) {
                //get static id of button
                int id = filtre.getCheckedRadioButtonId();
                View radioButton = filtre.findViewById(id);
                //get real id of radio button
                int radioId = filtre.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) filtre.getChildAt(radioId);
                // value of radio button
                selection = (String) btn.getText();
               // System.out.println(selection);
            }
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.holder, SearchFragment.newInstance(selection)).addToBackStack("fragment").commit();

        });
        return view;
    }
}