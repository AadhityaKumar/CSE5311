import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Aadhitya Kumar 1001918897


public class quicksort {

    public static void swap(int[][] c, int d, int e) {

        int[] u = c[d];
        c[d] = c[e];
        c[e] = u;
    }


    public static void QuicksorT(int[][] a, int p, int r) {

        int q;
        if (p < r) {
            q = partition(a, p, r); //find pivot
            QuicksorT(a, p, q-1);   //Split (divide) arrays on both sides of pivot and sort (conquer)
            QuicksorT(a, q+1, r);
        }
        

    }

    public static int partition(int[][] b, int p, int r) {

        int x = b[r][0];
        int i = p - 1;
        
        for(int j = p; j <= r-1; j++){
            if (b[j][0] <= x) {
                i = i + 1;
                swap(b, i, j);                //swap b[i] and b[j]

            }
        }

        swap(b, i+1, r);    //swap b[i+1] and A[r]
        return i+1;         //return next pivot/start value location
    }

    public static void main(String[] args) {
        
        int lineCount = 0;
        int[][] data;   //Array to be sorted
        int di = 0;

        try(BufferedReader myreader = new BufferedReader(new FileReader(args[0]))) {

            while(myreader.readLine() != null) {
                lineCount ++;   //Get size of array
            }



        } catch(IOException e) {
            System.err.println("An error occured while reading the file: " + e.getMessage());
        }

        data = new int[lineCount][4];   //Initialize array


        try(BufferedReader myreader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            String[] attributes;

            while((line = myreader.readLine()) != null) {
                attributes = line.split(",");
                for(int i = 0; i < 4; i++) {data[di][i] = Integer.parseInt(attributes[i]);} //Get attributes for array
                di++;
            }
        }catch(IOException e) {
            System.err.println("An error occured while reading the file: " + e.getMessage());
        }
        
        long startTime = System.nanoTime(); //Start keeping track of time here

        QuicksorT(data, 0, data.length-1);       //Sorting algorithm

        long endTime = System.nanoTime(); //Stop time here

        long totalTime = endTime - startTime; //Calculate time it took to sort
        System.out.println("Time taken to sort: " + (totalTime/1000) + " microseconds");

        double avrg;

        try
        {
            FileWriter filewriter = new FileWriter(args[1]);
            BufferedWriter lib = new BufferedWriter(filewriter);

            for(int x = 0; x < lineCount; x++) 
            {
                avrg = Math.round((data[x][1] + data[x][2] + data[x][3])/3.0 * 100.0) / 100.0;
                lib.write(data[x][0] + "," + data[x][1] + "," + data[x][2] + "," + data[x][3]  + "," + avrg + "\n");    //Write sorted array to output file
            }
            lib.close();
        }
        catch (Exception e) 
        {
            System.err.println("Failed to write: " + e);
        }
    }
}


