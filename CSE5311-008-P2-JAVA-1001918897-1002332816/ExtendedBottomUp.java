import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExtendedBottomUp {

    // price files that needs to be solved
    private static final int[] TARGET_LENGTHS = {5, 10, 20, 30}; 
    public static void main(String[] args) {
        for (int length : TARGET_LENGTHS) {
            solveRod("price" + length + ".txt"); 
            System.out.println();
        }
    }

    private static void solveRod(String filename) {
        // load prices for the rod length
        int[] prices = readPricesFromFile(filename); 
        if (prices == null) {
            System.out.println("Unable to read prices from " + filename);
            return;
        }
        int n = prices.length;
        int[] maxRevenue = new int[n + 1]; 
        int[] firstCut = new int[n + 1]; 

        long startTime = System.nanoTime();
        extendedBottomUpCutRod(prices, n, maxRevenue, firstCut);
        long endTime = System.nanoTime() - startTime;
        
        System.out.println("File: " + filename);
        System.out.println("Rod length: " + n);
        System.out.println("Maximum revenue: " + maxRevenue[n]);
        System.out.println("Optimal cuts: " + getCuts(firstCut, n));
        System.out.printf("Execution time: %.3f ms%n", endTime / 1_000_000.0);
    }

    // Extended Bottom-Up Rod Cutting Algorithm
    public static void extendedBottomUpCutRod(int[] p, int n, int[] r, int[] s) {
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (q < (p[i - 1] + r[j - i])) {
                    q = p[i - 1] + r[j - i];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
    }

    // gives the sequence of cuts from the cuts array
    private static String getCuts(int[] cuts, int length) {
        String result = ""; 
        while (length > 0) {
            int firstPiece = cuts[length];
            result += firstPiece + " ";
            length -= firstPiece;
        }
        return result.trim();
    }

    // Reads prices from the specified file
    public static int[] readPricesFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));

            // first value stores the rod length n
            int length = sc.nextInt(); 
            int[] prices = new int[length];
            for (int i = 0; i < length; i++) {
                 // price for rod length i+1
                prices[i] = sc.nextInt();
            }
            sc.close();
            return prices;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        }
    }
}
