package com.example.comtechtool;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class Pop_AddNew extends Activity {

    private Spinner spinner_Brand;
    private Spinner spinner_Type;
    private EditText editText_Brand;
    private Button button_back;
    private Button button_Add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_addnew);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.65));
        setResult(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //init
        spinner_Brand = findViewById(R.id.spinner_Brand);
        spinner_Type = findViewById(R.id.spinner_Type);
        editText_Brand = findViewById(R.id.editText_Brand);
        editText_Brand.setVisibility(View.INVISIBLE);
        button_Add = findViewById(R.id.buttonAdd_Add);
        button_back = findViewById(R.id.buttonAdd_Back);

        ArrayAdapter<CharSequence> adapter_Brand = ArrayAdapter.createFromResource(this, R.array.array_test, android.R.layout.simple_spinner_item);
        adapter_Brand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_Brand.setAdapter(adapter_Brand);
        spinner_Brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == adapterView.getCount()-1){
                    editText_Brand.setVisibility(View.VISIBLE);
                }else{
                    editText_Brand.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Add button
        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Back button
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
