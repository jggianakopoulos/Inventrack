package com.e.serveraccesstest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    TextView title1, title2, title3, title4, title5, title6, title7, title8,
            rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8,
            length1, length2, length3, length4, length5, length6, length7, length8,
            rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8,
            stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title1= (TextView)findViewById(R.id.title1); title2 = (TextView)findViewById(R.id.title2); title3 = (TextView)findViewById(R.id.title3); title4 = (TextView)findViewById(R.id.title4); title5 = (TextView)findViewById(R.id.title5); title6 = (TextView)findViewById(R.id.title6); title7= (TextView)findViewById(R.id.title7);  title8 = (TextView)findViewById(R.id.title8);
        rating1 = (TextView)findViewById(R.id.rating1); rating2 = (TextView)findViewById(R.id.rating2); rating3 = (TextView)findViewById(R.id.rating3); rating4 = (TextView)findViewById(R.id.rating4); rating5 = (TextView)findViewById(R.id.rating5); rating6 = (TextView)findViewById(R.id.rating6); rating7 = (TextView)findViewById(R.id.rating7); rating8 = (TextView)findViewById(R.id.rating8);
        length1 = (TextView)findViewById(R.id.length1); length2 = (TextView)findViewById(R.id.length2); length3 = (TextView)findViewById(R.id.length3); length4 = (TextView)findViewById(R.id.length4); length5 = (TextView)findViewById(R.id.length5); length6 = (TextView)findViewById(R.id.length6); length7 = (TextView)findViewById(R.id.length7); length8 = (TextView)findViewById(R.id.length8);
        rate1 = (TextView)findViewById(R.id.rate1); rate2 = (TextView)findViewById(R.id.rate2); rate3 = (TextView)findViewById(R.id.rate3); rate4 = (TextView)findViewById(R.id.rate4); rate5 = (TextView)findViewById(R.id.rate5); rate6 = (TextView)findViewById(R.id.rate6); rate7 = (TextView)findViewById(R.id.rate7); rate8 = (TextView)findViewById(R.id.rate8);
        stock1 = (TextView)findViewById(R.id.stock1);stock2 = (TextView)findViewById(R.id.stock2); stock3 = (TextView)findViewById(R.id.stock3); stock4 = (TextView)findViewById(R.id.stock4); stock5 = (TextView)findViewById(R.id.stock5); stock6 = (TextView)findViewById(R.id.stock6); stock7 = (TextView)findViewById(R.id.stock7); stock8 = (TextView)findViewById(R.id.stock8);

        TextView[] title = {title1, title2, title3, title4, title5, title6, title7, title8,};
        TextView[] rating = {rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8};
        TextView[] length = {length1, length2, length3, length4, length5, length6, length7, length8};
        TextView[] rate = {rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8};
        TextView[] stock = {stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8};

        ArrayList<HashMap> tester= new ArrayList<HashMap>();
        HashMap<Integer, String> test = new HashMap<Integer, String>();

        test.put(0, "Lion King");
        test.put(1, "Finding Nemo");
        test.put(2, "Lord of the Rings");

        tester.add(test);

        for(int i = 0; i< 3; i++){
            title[i].setText(test.get(i));
        }
    }
}
