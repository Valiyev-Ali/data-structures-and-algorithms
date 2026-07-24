import java.util.*;
import java.io.*;
//test
public class GraphSubsetCounter {
    public static int countConnectedComponents(String fileName){
        try {
            int a;
            int b;
            Scanner scnr = new Scanner(new FileReader(fileName));
            HashMap<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();
            while (scnr.hasNextLine()) {
                a = scnr.nextInt();
                b = scnr.nextInt();
                if (edges.get(a) != null) {
                    edges.get(scnr.nextInt()).add(b);
                }
            }

            for()

        } catch {

        }
    }
}