package com.hfad.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listView;
    SeekBar seekBar ;
    public void generateTimesTable(int timesTableNumber){
        ArrayList<String>timesTableContent = new ArrayList<String>();
        for(int j = 1; j <=10; j++){
            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
         listView =findViewById(R.id.listView);//ll
        seekBar.setMax(20);
        seekBar.setProgress(10);
        generateTimesTable(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min = 1;
                int timesTableNumber;

                if(i<min){
                   timesTableNumber=min;
                   seekBar.setProgress(min);
                }else{
                    timesTableNumber=i;
                }
                Log.i("seekbar",Integer.toString(timesTableNumber));
               generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}