import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

//Aadhitya Kumar 1001918897

public class MemoizedCutRod {

    private static final int[] TARGET_LENGTHS = {5, 10, 20, 30};

    public static int Memoized_Cut_Rod(int[] p, int n, int[] s) {
        int[] r = new int[n + 1]; //Memoization array
        for (int i = 0; i < n+1; i++) {
            r[i] = Integer.MIN_VALUE; //Initialize all to -infinity
        }
        
        return Memoized_Cut_Rod_Aux(p, n, r, s); //Enter main function
    }

    public static List<Integer> getCuts(int[] s, int length)
    {
        List <Integer> cuts = new ArrayList<>();
        while(length > 0)
        {
            cuts.add(s[length]);
            length -= s[length]; //Get optimal cuts by subtracting prices

        }
        return cuts;
    }

    public static int Memoized_Cut_Rod_Aux(int[] p, int n, int[] r, int[] s) {
        int q;
        if (r[n] >= 0)
        {
            return r[n]; //Return if we've been here before
        }
        if (n == 0)
        {
            q = 0; //Return 0 if n = 0
        }
        else
        {
            q = Integer.MIN_VALUE;
            for(int i = 1; i <= n; i++)
            {
                int val = p[i-1] + Memoized_Cut_Rod_Aux(p, n-i, r, s); //Continue cutting rod into smaller pieces
                if (q < val)
                {
                    q = val;
                    s[n] = i;
                }
            }
            
        }
        r[n] = q; //Add to memoization array
        return q;
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
            int[] s = new int[length + 1]; //To keep track of cuts

            System.out.println("File: price" + length + ".txt");
            System.out.println("Rod Length: " + length);
            System.out.print("Maximum revenue: ");


            int[] g = readPricesFromFile("price" + length + ".txt");
            long startTime = System.nanoTime(); //Start keeping track of time here

            int t = Memoized_Cut_Rod(g, length, s); //Call function

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
