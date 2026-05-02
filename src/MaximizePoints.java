import java.util.*;
import java.io.*;

public class MaximizePoints {
    public long maxPoints(String input){
        Scanner scnr = new Scanner(input);
        int n = scnr.nextInt();
        int m = scnr.nextInt();
        int maxPts = 0;
        ArrayList<Integer> bags = new ArrayList<Integer>();
        int indexOfBiggest = 0;

        while (n != 0) {
            bags.add(scnr.nextInt());
            n--;
        }

        while (m != 0) {
            for (int i = 0; i < bags.size(); i++) {
                if (bags.get(i) > indexOfBiggest) {indexOfBiggest = i;}
            }
            if (bags.get(indexOfBiggest) > 0) {
                maxPts += bags.get(indexOfBiggest);
                bags.set(indexOfBiggest, bags.get(indexOfBiggest) - 1);
            }
            m--;
            indexOfBiggest = 0;
        }

        return maxPts;
    }
}
