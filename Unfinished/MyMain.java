package com.e.serveraccesstest2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MyMain {
//TODO finalize formatter class to merge the arraylists into a list of maps

    public static void main(String args[]) throws IOException {
        ArrayList<HashMap> qResult = new ArrayList<HashMap>();
        ArrayList<HashMap> tableList = new ArrayList<>();
        SQLQuerier querier = new SQLQuerier("24.127.67.134", 55556);
        qResult = querier.query("SELECT", "*", "film", "8");
         for (HashMap x:qResult) {
             System.out.println(x);

         }

    }
}
