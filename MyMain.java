import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class MyMain {
//TODO finalize formatter class to merge the arraylists into a list of maps

    public static void main(String args[]) throws IOException {
        ArrayList<HashMap> qResult = new ArrayList<HashMap>();
        SQLQuerier querier = new SQLQuerier("192.168.1.125", 55556);
        qResult = querier.query("SELECT", "*", "customer", "10");





    }
}
