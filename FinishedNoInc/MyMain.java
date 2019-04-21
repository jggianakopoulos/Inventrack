package com.e.serveraccesstest2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Ryan-PC
 */
public class SortAlg {
    /**
     * @param args the command line arguments
     */
    static ArrayList<HashMap> qResult = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<HashMap> tableList = new ArrayList<>();
        SQLQuerier querier = new SQLQuerier("24.127.67.134", 55556);
        qResult = querier.query("SELECT", "*", "film", "9");
        for (int i = 0; i < 8; i++) {
            //toString(qResult.get(i).get("rental_rate"));            
        }
        sortByID();
        for (int i = 0; i < 8; i++) {
            //System.out.println(qResult.get(i));
        }
        
    }
    
    public static void sortByID() {
        Collections.sort(qResult, new Comparator<HashMap>() {
            @Override
            public int compare(HashMap o1, HashMap o2) {
                return Integer.parseInt((String) o1.get("film_id")) - 
                        Integer.parseInt((String) o2.get("film_id"));
            }
        });
    }
    
    public void sortByRating() {
        Collections.sort(qResult, new Comparator<HashMap>() {
            @Override
            public int compare(HashMap o1, HashMap o2) {
                
                return Integer.parseInt((String) o1.get("rating")) - 
                        Integer.parseInt((String) o2.get("rating"));
            }
        });
    }
}
