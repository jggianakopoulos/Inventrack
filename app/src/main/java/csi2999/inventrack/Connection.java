package csi2999.inventrack;


import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import android.app.ProgressDialog;
import android.content.Context;


public class Connection extends AsyncTask<Void, Void,ArrayList<HashMap>> {


    protected void onPreExecute(){
        super.onPreExecute();
        //System.out.println("Pre execution");
    }
    protected ArrayList<HashMap> doInBackground(Void... params){
        ArrayList<HashMap> qResult = new ArrayList<HashMap>();
        ArrayList<HashMap> tableList = new ArrayList<>();
        SQLQuerier querier = null;
        try {
            querier = new SQLQuerier("24.127.67.134", 55556);
            qResult = querier.query("SELECT", "*", "film", "9");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return qResult;
    }


}