import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Aadhitya Kumar 1001918897

public class insertionsort {

    public static void Insertionsort(int[][] a) {
        int[] key;
        int i;

        for(int j = 1; j < a.length; j++){
            key = a[j]; //Increment key
            i = j - 1;  //i is the index before j
            while(i >= 0 && a[i][0] > key[0]) {
                a[i + 1] = a[i];    //Move up value if greater than key
                i = i - 1;          //Move i backwards
            }
            a[i + 1] = key;     //Place key in its appropriate position.
        }

    }

    public static void main(String[] args) {

        int lineCount = 0; 
        int[][] data; //Array to be sorted
        int di = 0;

        try(BufferedReader myreader = new BufferedReader(new FileReader(args[0]))) {

            while(myreader.readLine() != null) {
                lineCount++; //Get size of array
            }

        } catch(IOException e) {
            System.err.println("An error occured while reading the file: " + e.getMessage());
        }

        data = new int[lineCount][4]; //Initialize array


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

        Insertionsort(data); //Sorting Algorithm
        
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
                lib.write(data[x][0] + "," + data[x][1] + "," + data[x][2] + "," + data[x][3]  + "," + avrg + "\n"); //Write sorted array to output file
            }
            lib.close();
        }
        catch (Exception e) 
        {
            System.err.println("Failed to write: " + e);
        }


    }
}
