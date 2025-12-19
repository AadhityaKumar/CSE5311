import java.util.*;
import java.io.*;

public class Generatedata {
    public static void main(String[] args) {

        //Check for valid arguments
        if (args.length != 2) {
            System.out.println("Please enter valid arguments with filename followed by the number of students");
            return;
        }

        String filename = args[0];
        int n;
        
        // Check if the number of students is a valid integer
        try {
            n = Integer.parseInt(args[1]);
            if (n <= 0) {
                System.out.println("Number of students must be greater than 0.");
                return;
            }
        } 
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid number of students");
            return;
        }
        
        // Randomly generate studentID, scores of three courses and write to file
        try {
            Random random = new Random();
            FileWriter filewriter = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(filewriter);
            for (int i = 0; i < n ; i++) {
                int studentId = 400000 + random.nextInt(10000);
                int course1 = 70 + random.nextInt(31);
                int course2 = 70 + random.nextInt(31);
                int course3 = 70 + random.nextInt(31);
                writer.write(studentId + "," + course1 + "," + course2 + "," + course3 + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occured while writing the file: " + e.getMessage());
        }
    }
}
