package csi2999.inventrack;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class IncrementDecrement extends AsyncTask<Void, Void, Void> {
    private int row = 0;
    private boolean way = false;

    protected Void doInBackground(Void... params){
        ArrayList<HashMap> qResult = new ArrayList<HashMap>();
        SQLQuerier querier = null;
        int stock = 0;

        try {
            querier = new SQLQuerier("24.127.67.134", 55556);
            qResult = querier.query("SELECT", "*", "film", "9");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String quantity = qResult.get(row).get("quantity").toString();
        String id = qResult.get(row).get("film_id").toString();

        try {
            stock = querier.IncDec(id,  quantity ,1, way);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stock);
        return null;
    }

    public void setRow(int row){
        this.row = row;
    }
    public void setWay(boolean way){
        this.way = way;
    }
}