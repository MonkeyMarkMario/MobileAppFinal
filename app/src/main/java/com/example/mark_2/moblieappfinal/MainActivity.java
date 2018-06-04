package com.example.mark_2.moblieappfinal;

import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*spinner1 = (Spinner) findViewById(R.id.SideSpinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener1());

        spinner2 = (Spinner) findViewById(R.id.DiceSpinner);
        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener2());*/
    }

    public class MinMaxFilter implements InputFilter {

        private int mIntMin, mIntMax;

        public MinMaxFilter(int minValue, int maxValue) {
            this.mIntMin = minValue;
            this.mIntMax = maxValue;
        }

        public MinMaxFilter(String minValue, String maxValue) {
            this.mIntMin = Integer.parseInt(minValue);
            this.mIntMax = Integer.parseInt(maxValue);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try {
                int input = Integer.parseInt(dest.toString() + source.toString());
                if (isInRange(mIntMin, mIntMax, input))
                    return null;
            } catch (NumberFormatException nfe) { }
            return "";
        }

        private boolean isInRange(int a, int b, int c) {
            return b > a ? c >= a && c <= b : c >= b && c <= a;
        }
    }

    public void onClick(View view) {

        int die = 0;
        int Side = 0;

        EditText dice = (EditText) findViewById(R.id.Dice);
        dice.setFilters(new InputFilter[]{ new MinMaxFilter("1", "100")});

        EditText Sides = (EditText) findViewById(R.id.Sides);
        Sides.setFilters(new InputFilter[]{ new MinMaxFilter("1", "100")});

        int d = dice.length();
        if (d<=0){
            dice.setError(getText(R.string.Error));
        }
        else {die = Integer.parseInt(dice.getText().toString()); }

        int s = Sides.length();
        if (s<=0){
            Sides.setError(getText(R.string.Error));
        }
        else {Side = Integer.parseInt(Sides.getText().toString()); }

        Random rand = new Random(System.currentTimeMillis());
        String myString = "";

        for (int i = 1; i <= die; i++) {

            int n = rand.nextInt(Side) + 1;


            myString += String.valueOf(n) + ", ";
        }

        String[] Sayings ={ "aha", "ahem", "ahh", "ahoy", "alas", "arg", "aw", "bam", "bingo", "blah", "boo", "bravo", "brrr", "cheers", "congratulations", "dang", "drat", "darn", "duh", "eek", "eh", "encore", "eureka", "fiddlesticks", "gadzooks", "gee", "gee whiz", "golly", "goodbye", "goodness", "good grief", "gosh", "ha-ha", "hallelujah", "hello", "hey", "hmm", "hot dog", "huh", "humph", "hurray", "oh", "oh dear", "oh my", "oh well", "oops", "ouch", "ow", "hew", "phooey", "pooh", "pow", "rats", "shh", "shoo", "thanks", "there", "tut-tut", "uh-huh", "uh-oh", "ugh", "wahoo", "well", "whoa", "whoops", "wow", "yeah", "yes", "yikes", "yippee", "yo", "yuck"};
        Random r = new Random();
        String saying = Sayings[r.nextInt(Sayings.length)];

        TextView Words = (TextView) findViewById(R.id.Line);
        Words.setText(saying);

        TextView counter = (TextView) findViewById(R.id.Number);
        counter.setText(myString);


        TextView tv = (TextView) findViewById(R.id.Roll);
        tv.setText("Roll Again");
    }
}



    /*public class CustomOnItemSelectedListener1 implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                Side = Integer.parseInt(parent.getItemAtPosition(pos).toString());

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }

    public class CustomOnItemSelectedListener2 implements AdapterView.OnItemSelectedListener {

        String firstItem = String.valueOf(spinner2.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner2.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                die = Integer.parseInt(parent.getItemAtPosition(pos).toString());

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }
    }*/
//}