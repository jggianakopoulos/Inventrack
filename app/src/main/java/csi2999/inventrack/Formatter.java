package csi2999.inventrack;

import java.util.ArrayList;
import java.util.HashMap;

public class Formatter {  //utility class for converting an arraylist of all of our data into an arraylist of maps with the query column titles being the key and having a corresponding value
    protected ArrayList<String> rawData;



    protected ArrayList<HashMap> result;
    protected ArrayList<String> fieldNames;
    protected int qNum;

    public Formatter(ArrayList<String> rawData, ArrayList<String> fieldNames){
        this.rawData = rawData;
        this.fieldNames = fieldNames;
        this.qNum = rawData.size()/fieldNames.size();
        result = new ArrayList<>();

    }
    public HashMap<String, String> mapvalue(int multiplicand){
        HashMap<String, String> mappedData = new HashMap<String, String>();
        int startVal = multiplicand * fieldNames.size();
        for (int i = 0; i < fieldNames.size(); i++) {
            mappedData.put(fieldNames.get(i), rawData.get(startVal));
            //System.out.println(startVal);
            startVal++;
        }

        return  mappedData;
    }


    public ArrayList<HashMap> getResult() {
        HashMap<String, String> x = new HashMap<>();
        for(int i = 0; i < qNum - 1; i++) {
            x = mapvalue(i);
            result.add(x);
        }
        return result;
    }
}