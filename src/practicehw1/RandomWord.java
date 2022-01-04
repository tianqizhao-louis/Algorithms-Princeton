package src.practicehw1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {
    public static void main(String[] args) {
        int i = 0;
        String champ = "EMPTY";
        while(!StdIn.isEmpty()){
            String thisString = StdIn.readString();
            StdOut.println(thisString);

            if (i == 0){
                champ = thisString;
            }else if (StdRandom.bernoulli(1 / i)){
                champ = thisString;
            }

            i++;
        }

        StdOut.println(champ);
    }
}
