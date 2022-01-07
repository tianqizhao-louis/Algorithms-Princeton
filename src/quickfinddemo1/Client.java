package src.quickfinddemo1;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner readFile = new Scanner(new File("src/quickfinddemo1/test.txt"));

        int N = readFile.nextInt();
        QuickFindUF uf = new QuickFindUF(N);

        while (readFile.hasNextLine()){
            int p = readFile.nextInt();
            int q = readFile.nextInt();

            if(!uf.connected(p, q)){
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }

        System.out.println("-----------");

        readFile = new Scanner(new File("src/quickfinddemo1/test.txt"));

        N = readFile.nextInt();
        QuickUnionUF quuf = new QuickUnionUF(N);

        while (readFile.hasNextLine()){
            int p = readFile.nextInt();
            int q = readFile.nextInt();

            if(!quuf.connected(p, q)){
                quuf.union(p, q);
                System.out.println(p + " " + q);
            }
        }

        System.out.println("-----------");
        readFile = new Scanner(new File("src/quickfinddemo1/test.txt"));
        N = readFile.nextInt();

        WeightedQuickUnionUF wqf = new WeightedQuickUnionUF(N);

        while (readFile.hasNextLine()){
            int p = readFile.nextInt();
            int q = readFile.nextInt();

            if(!wqf.connected(p, q)){
                wqf.union(p, q);
                System.out.println(p + " " + q);
            }
        }

        System.out.println("-----------");
        readFile = new Scanner(new File("src/quickfinddemo1/test.txt"));
        N = readFile.nextInt();

        PathCompressionUF pcf = new PathCompressionUF(N);

        while (readFile.hasNextLine()){
            int p = readFile.nextInt();
            int q = readFile.nextInt();

            if(!pcf.connected(p, q)){
                pcf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
