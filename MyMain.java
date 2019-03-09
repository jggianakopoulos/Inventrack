import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyMain {


    public static void main(String args[]) throws IOException {


        Socket testSock = new Socket();
        SQLQuerier querier = new SQLQuerier(testSock, "192.168.1.125", 55556);
        querier.query("SELECT", "*", "film");

    }
}
