import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PriceGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last two digits of your student ID: ");
        int seed = scanner.nextInt();
        scanner.close();
        //rod sizes
        int[] rodLengths = {5, 10, 20, 30}; 

        // Random price generator seeded from student ID digits
        Random rand = new Random(seed); 

        for (int n : rodLengths) {
            int[] prices = generateMonotonicPrices(n, rand);
            writeToFile(n, prices);
        }
        System.out.println("Files generated successfully using seed = " + seed);
    }

    public static int[] generateMonotonicPrices(int n, Random rand) {
        int[] prices = new int[n];
        
        // first entry anywhere in [1,30]
        prices[0] = rand.nextInt(30) + 1; 

        for (int i = 1; i < n; i++) {
            // gentle increment random values
            int bump = rand.nextInt(4); 
            prices[i] = Math.min(30, prices[i - 1] + bump);
        }

        return prices;
    }

    public static void writeToFile(int n, int[] prices) {
        // file name format: priceN.txt
        String fileName = "price" + n + ".txt"; 

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(n + "\n");
            for (int p : prices) {
                writer.write(p + " ");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing file: " + fileName);
        }
    }
}
