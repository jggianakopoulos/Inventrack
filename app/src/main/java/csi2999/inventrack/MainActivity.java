package csi2999.inventrack;


import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.Socket;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    TextView title1, title2, title3, title4, title5, title6, title7, title8,
            rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8,
            length1, length2, length3, length4, length5, length6, length7, length8,
            rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8,
            stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8;

    Button add1, add2, add3, add4, add5, add6, add7, add8,
            subtract1, subtract2, subtract3, subtract4, subtract5, subtract6, subtract7, subtract8, update;

    ArrayList<HashMap> values;

    IncrementDecrement change;

    int row = 0, in = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title1 = (TextView) findViewById(R.id.title1);
        title2 = (TextView) findViewById(R.id.title2);
        title3 = (TextView) findViewById(R.id.title3);
        title4 = (TextView) findViewById(R.id.title4);
        title5 = (TextView) findViewById(R.id.title5);
        title6 = (TextView) findViewById(R.id.title6);
        title7 = (TextView) findViewById(R.id.title7);
        title8 = (TextView) findViewById(R.id.title8);
        rating1 = (TextView) findViewById(R.id.rating1);
        rating2 = (TextView) findViewById(R.id.rating2);
        rating3 = (TextView) findViewById(R.id.rating3);
        rating4 = (TextView) findViewById(R.id.rating4);
        rating5 = (TextView) findViewById(R.id.rating5);
        rating6 = (TextView) findViewById(R.id.rating6);
        rating7 = (TextView) findViewById(R.id.rating7);
        rating8 = (TextView) findViewById(R.id.rating8);
        length1 = (TextView) findViewById(R.id.length1);
        length2 = (TextView) findViewById(R.id.length2);
        length3 = (TextView) findViewById(R.id.length3);
        length4 = (TextView) findViewById(R.id.length4);
        length5 = (TextView) findViewById(R.id.length5);
        length6 = (TextView) findViewById(R.id.length6);
        length7 = (TextView) findViewById(R.id.length7);
        length8 = (TextView) findViewById(R.id.length8);
        rate1 = (TextView) findViewById(R.id.rate1);
        rate2 = (TextView) findViewById(R.id.rate2);
        rate3 = (TextView) findViewById(R.id.rate3);
        rate4 = (TextView) findViewById(R.id.rate4);
        rate5 = (TextView) findViewById(R.id.rate5);
        rate6 = (TextView) findViewById(R.id.rate6);
        rate7 = (TextView) findViewById(R.id.rate7);
        rate8 = (TextView) findViewById(R.id.rate8);
        stock1 = (TextView) findViewById(R.id.stock1);
        stock2 = (TextView) findViewById(R.id.stock2);
        stock3 = (TextView) findViewById(R.id.stock3);
        stock4 = (TextView) findViewById(R.id.stock4);
        stock5 = (TextView) findViewById(R.id.stock5);
        stock6 = (TextView) findViewById(R.id.stock6);
        stock7 = (TextView) findViewById(R.id.stock7);
        stock8 = (TextView) findViewById(R.id.stock8);
        add1 = (Button) findViewById(R.id.add1);
        add2 = (Button) findViewById(R.id.add2);
        add3 = (Button) findViewById(R.id.add3);
        add4 = (Button) findViewById(R.id.add4);
        add5 = (Button) findViewById(R.id.add5);
        add6 = (Button) findViewById(R.id.add6);
        add7 = (Button) findViewById(R.id.add7);
        add8 = (Button) findViewById(R.id.add8);
        subtract1 = (Button) findViewById(R.id.subtract1);
        subtract2 = (Button) findViewById(R.id.subtract2);
        subtract3 = (Button) findViewById(R.id.subtract3);
        subtract4 = (Button) findViewById(R.id.subtract4);
        subtract5 = (Button) findViewById(R.id.subtract5);
        subtract6 = (Button) findViewById(R.id.subtract6);
        subtract7 = (Button) findViewById(R.id.subtract7);
        subtract8 = (Button) findViewById(R.id.subtract8);
        update = (Button) findViewById(R.id.update);

        final TextView[] title = {title1, title2, title3, title4, title5, title6, title7, title8};
        final TextView[] rating = {rating1, rating2, rating3, rating4, rating5, rating6, rating7, rating8};
        final TextView[] length = {length1, length2, length3, length4, length5, length6, length7, length8};
        final TextView[] rate = {rate1, rate2, rate3, rate4, rate5, rate6, rate7, rate8};
        final TextView[] stock = {stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8};

        try {
            values = new Connection().execute().get();
        } catch (ExecutionException e) {
            System.out.println("error");
        } catch (InterruptedException e) {
            System.out.println("error");
        }

        for(int i = 0; i< 8; i++ ){
            title[i].setText(((values.get(i).get("title"))).toString());
            rating[i].setText(((values.get(i).get("rating"))).toString());
            length[i].setText(((values.get(i).get("length"))).toString());
            rate[i].setText(((values.get(i).get("rental_rate"))).toString());
            stock[i].setText(((values.get(i).get("quantity"))).toString());


        }
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    values = new Connection().execute().get();
                } catch (ExecutionException e) {
                    System.out.println("error");
                } catch (InterruptedException e) {
                    System.out.println("error");
                }

                for(int i = 0; i< 8; i++ ){
                    title[i].setText(((values.get(i).get("title"))).toString());
                    rating[i].setText(((values.get(i).get("rating"))).toString());
                    length[i].setText(((values.get(i).get("length"))).toString());
                    rate[i].setText(((values.get(i).get("rental_rate"))).toString());
                    stock[i].setText(((values.get(i).get("quantity"))).toString());


                }

            }

        });

        add1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(0, false, stock);


            }


        });

        add2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(1, false, stock);


            }


        });

        add3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(2, false, stock);


            }


        });

        add4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(3, false, stock);

            }


        });

        add5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(4, false, stock);


            }


        });

        add6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(5, false, stock);


            }


        });

        add7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(6, false, stock);

            }


        });

        add8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(7, false, stock);

            }


        });


        subtract1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(0, true, stock);


            }


        });

        subtract2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(1, true, stock);


            }


        });

        subtract3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(2, true, stock);


            }


        });

        subtract4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(3, true, stock);

            }


        });

        subtract5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(4, true, stock);


            }


        });

        subtract6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(5, true, stock);


            }


        });

        subtract7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(6, true, stock);

            }


        });

        subtract8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                incDec(7, true, stock);

            }


        });
    }
    public void incDec(int row, boolean way, TextView[] t){
        change = new IncrementDecrement();
        change.setRow(row);
        change.setWay(way);
        change.execute();

        in = Integer.parseInt(t[row].getText().toString());

        if(way == true)
            in--;
        else
            in++;

        t[row].setText(Integer.toString(in));

    }
}
