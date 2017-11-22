package com.example.akaash.assignment11_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView txt;
    DbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DbHandler(MainActivity.this);

        List<String> pnames=new ArrayList<String>();
        pnames=db.display();
        if(pnames.size()==0)
        {
            db.insert();
            pnames=db.display();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,pnames);
        txt=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        txt.setThreshold(1);
        txt.setAdapter(adapter);
        txt.setTextColor(Color.RED);
    }
}
