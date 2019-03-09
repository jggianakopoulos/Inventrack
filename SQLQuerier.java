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

    public SQLQuerier(Socket qSock, String host, int port) throws IOException{
        this.host = host;
        this.port = port;
        try {
            this.connect();
        }
        catch (IOException e){
            System.out.print("IOException");
        }
    }

    private void connect() throws IOException {
        this.qSock = new Socket(this.host, this.port);
        System.out.print("Socket connected");
        }

    protected void query(String command, String number, String table) throws IOException {
        //query selected table for # of columns returned, then query the server for all data requested, using querySort to create a hashmap
        PrintWriter sockOut = new PrintWriter(this.qSock.getOutputStream(), true);
        BufferedReader sockIn = new BufferedReader(new InputStreamReader(this.qSock.getInputStream())); // instantiates the printwriter and buffered reader used to send data through a socket

        String response = "";
        ArrayList<String> respList = new ArrayList<String>();

        int count = getColumnCount(sockOut, sockIn, table);

        query = command + " " + number + " from " + table + " LIMIT 1;";
        System.out.print(query);
        sockOut.println(query);

        while(true){ //this shit is wonky, it doesn't seem to like when I run a check, it seems to miss part of the stream when I try to do a comparison

                response = sockIn.readLine();
                if(response.equals("TERMINATE"))
                    break;

                respList.add(response);
                System.out.print(response + "\n");

            }


            //filterQuery(count, respList);


    }

    private int getColumnCount(PrintWriter sockOut, BufferedReader sockIn, String table) throws IOException{
        try {
            sockOut.println("SELECT COUNT(*) from information_schema.columns WHERE table_name = '" + table + "' ");
            return Integer.parseInt(sockIn.readLine());
        }
        catch (Exception e){
            return 5;
        }
    }

     public HashMap filterQuery(int columns, ArrayList<String> qResult){
        //take the array of strings from the hashmap and using the number of columns from the table, break down the table with the first entry as the key and every other
        // entry as the value in an array
        return qData;
    }
}
