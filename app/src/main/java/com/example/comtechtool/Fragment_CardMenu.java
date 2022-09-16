package com.example.comtechtool;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class Fragment_CardMenu extends Fragment {



    //Attribute
    private Button button_Start;
    private Button button_Add;
    private Button button_Back;
    private TextView textView_List;


    public Fragment_CardMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__card_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button_Start = view.findViewById(R.id.buttonCard_Start);
        button_Add = view.findViewById(R.id.buttonCard_Add);
        button_Back = view.findViewById(R.id.buttonCard_Back);
        textView_List = view.findViewById(R.id.textView_CardList);

        //List
        SharedPreferences sharedPref = getContext().getSharedPreferences(getString(R.string.filekey_cards), Context.MODE_PRIVATE);
        if(!sharedPref.contains(getString(R.string.key_init))){
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(getString(R.string.key_init),true);
            editor.commit();
            Log.d("mytag","init pref");
        }else{
            Log.d("mytag","exist");
        }

        //Start Button
        button_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Add Button
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Pop_AddNew.class);
                startActivity(intent);
            }
        });

        //Back button
        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }
}