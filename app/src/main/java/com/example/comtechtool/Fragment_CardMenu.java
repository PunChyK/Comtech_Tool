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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_CardMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_CardMenu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //Attribute
    private Button button_Start;
    private Button button_Add;
    private Button button_Back;
    private TextView textView_List;


    public Fragment_CardMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_CardMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_CardMenu newInstance(String param1, String param2) {
        Fragment_CardMenu fragment = new Fragment_CardMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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