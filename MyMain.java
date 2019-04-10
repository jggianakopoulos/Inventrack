import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MyMain {
//TODO finalize formatter class to merge the arraylists into a list of maps

        public static void main(String args[]) throws IOException {
            ArrayList<HashMap> qResult = new ArrayList<HashMap>();
            ArrayList<HashMap> tableList = new ArrayList<>();
            SQLQuerier querier = new SQLQuerier("192.168.1.125", 55556);
            qResult = querier.query("SELECT", "*", "film", "10");
            for (HashMap x:qResult) {
                System.out.println(x);
            }
            String quantity = qResult.get(0).get("quantity").toString();
            String id = qResult.get(0).get("film_id").toString();
            querier.IncDec(id,  quantity ,1, false);

        }
    }

