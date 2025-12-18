import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Aadhitya Kumar 1001918897

public class RecursiveCutRod {

    private static final int[] TARGET_LENGTHS = {5, 10, 20, 30};

    public static int Cut_Rod(int[] p, int n, int[] s) {

        if (n == 0)
        {
            return 0; //Return 0 if rod length is 0
        }

        int q = Integer.MIN_VALUE;

        for (int i = 1; i < n+1; i++) {
            int val = p[i-1] + Cut_Rod(p, n-i, s); //Continue cutting rod into smaller pieces
            if (q < val)
            {
                q = val; //If calculated price is more, take it
                s[n] = i; //Keep track of cuts made
            }
        }
        
        return q;
    }

    public static List<Integer> getCuts(int[] s, int length)
    {
        List <Integer> cuts = new ArrayList<>();
        while(length > 0)
        {
            cuts.add(s[length]);
            length -= s[length]; //Get optimal cuts by subtracting lengths

        }
        return cuts;
    }


    public static int[] readPricesFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            int length = sc.nextInt();
            int[] prices = new int[length];
            for (int i = 0; i < length; i++) {
                prices[i] = sc.nextInt();
            }
            sc.close();
            return prices;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }

    public static void main(String[] args) {

        for (int length : TARGET_LENGTHS) {
            int[] s = new int[length + 1]; //To keep track of cuts made and calculate optimal cuts

            System.out.println("File: price" + length + ".txt");
            System.out.println("Rod Length: " + length);
            System.out.print("Maximum revenue: ");

            int[] g = readPricesFromFile("price" + length + ".txt");

            long startTime = System.nanoTime(); //Start keeping track of time here

            int t = Cut_Rod(g, length, s); //Enter main function

            long endTime = System.nanoTime(); //Stop time here
            System.out.printf("%d\n", t);



            System.out.print("Optimal cuts: ");
            List v = getCuts(s, length);
            for(int i = 0; i < v.size(); i++)
            {
                System.out.print(v.get(i));
                System.out.print(" ");
            }

            System.out.println();

            long totalTime = endTime - startTime; //Calculate time
            System.out.printf("Execution time: %.3f ms%n", totalTime / 1_000_000.0);


            System.out.println();

        }


        }
}