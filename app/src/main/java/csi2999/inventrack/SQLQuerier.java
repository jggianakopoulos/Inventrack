package csi2999.inventrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLQuerier {

    protected String query; // the full query which will be concatanaed from command, number and table
    protected String command; //where SELECT or DROP would go in a query
    protected String table; //the table being queried
    protected String number; // the number of rows to request
    protected HashMap<String, String[]> qData;
    protected Socket qSock; //The socket that makes a connection to the server
    protected String host;
    protected int port;


    public SQLQuerier(String host, int port) throws IOException{
        this.host = host;
        this.port = port;
        try {
            this.connect();
        }
        catch (IOException e){
            System.out.print("IOException");
        }
        this.query = null;
    }



    protected ArrayList<HashMap> query(String command, String number, String table, String rowCount) throws IOException {
        //query selected table for # of columns returned, then query the server for all data requested, using querySort to create an arraylist
        ArrayList<String> respList = new ArrayList<String>();
        ArrayList<HashMap> result = new ArrayList<>();
        PrintWriter sockOut = new PrintWriter(this.qSock.getOutputStream(), true);
        BufferedReader sockIn = new BufferedReader(new InputStreamReader(this.qSock.getInputStream())); // instantiates the printwriter and buffered reader used to send data through a socket
        int count = getColumnCount(sockOut, sockIn, table);
        int respNum = count * Integer.parseInt(rowCount);

        //System.out.println(respNum);
        this.setQuery(command + " " + number + " from " + table + " LIMIT " + rowCount + ";");

        sockOut.println(this.query);
        respList = getResponse(sockIn, respNum);
        ArrayList<String> tableData = queryforTableData(sockOut, sockIn, table, count);
        result = getFormattedData(respList, tableData);
        return result;
    }

    protected ArrayList<String> queryforTableData(PrintWriter sockOut, BufferedReader sockIn, String table, int respNum) throws IOException{
        ArrayList<String> tableData = new ArrayList<String>();
        sockOut.println("SELECT column_name from information_schema.columns WHERE table_name = '" + table + "'");
        tableData = getResponse(sockIn, respNum);

        return tableData;

    }


    public ArrayList<String> getResponse(BufferedReader sockIn, int respNum) throws IOException{
        ArrayList<String> respList = new ArrayList<String>();
        String response;
        for(int i = 0; i < respNum; i++){
            response = sockIn.readLine();
            if(response.contains("TERMINATE"))
                continue;
            respList.add(response);

        }
        return  respList;
    }

    protected int getColumnCount(PrintWriter sockOut, BufferedReader sockIn, String table) throws IOException{ // returns the number of columns
        int count;
        try {
            sockOut.println("SELECT COUNT(*) from information_schema.columns WHERE table_name = '" + table + "' ");
            count = Integer.parseInt(sockIn.readLine());
            return count;

        }
        catch (Exception e){
            return 5;
        }
    }

    protected ArrayList<HashMap> getFormattedData(ArrayList<String> respList, ArrayList<String> tableData){
        ArrayList<HashMap> result = new ArrayList<>();
        Formatter formatter = new Formatter(respList, tableData);
        result = formatter.getResult();
        return result;

    }

    private void connect() throws IOException { //connects us to the remote host
        this.qSock = new Socket(this.host, this.port);
        //System.out.print("Socket connected");
    }


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int IncDec(String id, String curQuantity, int change, boolean sub) throws IOException{
        PrintWriter sockOut = new PrintWriter(this.qSock.getOutputStream(), true);
        BufferedReader sockIn = new BufferedReader(new InputStreamReader(this.qSock.getInputStream())); // instantiates the printwriter and buffered reader used to send data through a socket
        int x = 0;

        if(!sub){
            x = Integer.parseInt(curQuantity) + change;
        }
        else {
            x = Integer.parseInt(curQuantity) - change;
        }

        curQuantity = Integer.toString(x);
        String query = "UPDATE," + curQuantity + "," + change + "," + id + "," + sub;
        sockOut.println(query);

        return x;
    }

}