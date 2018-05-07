package com.example.mark_2.moblieappfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //String[] Sayings = {"Hi", "Bye", "Why are you still Here", "Please Leave"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if savedInstanceState !=null {

        //}
    }
    public void onClick(View view) {

        String[] Sayings = {"1)Hi", "2)Bye", "3)Why are you still Here", "4)Please Leave", "5)Just Stop", "6)Not again"};
        Random r = new Random();
        String saying = Sayings[r.nextInt(Sayings.length)];
        //int Die = rand.nextInt(limit 6) +1;

        TextView counter = (TextView) findViewById(R.id.Number);
        counter.setText(String.valueOf(saying));

        TextView tv = (TextView) findViewById(R.id.Roll);
        tv.setText("Roll Again");
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {


        super.onSaveInstanceState(savedInstanceState);
    }
}
