import java.util.*;
import java.io.*;

public class MergeSort {
    public static void main(String[] args) {
        
        //Check for valid arguments
        if (args.length != 2) {
            System.out.println("Please enter valid arguments with dataset followed by output filename");
            return;
        }

        String dataset = args[0];
        String outputFile = args[1];
        List<Student> students = new ArrayList<>();

        // Read data coming from dataset file and stores them as an object in a list.
        try{
            String studentdata;
            FileReader filereader = new FileReader(dataset);
            BufferedReader reader = new BufferedReader(filereader);
            while ((studentdata = reader.readLine()) != null) {
                String[] parts = studentdata.split(",");
                students.add(new Student(
                    Integer.parseInt(parts[0].trim()),
                    Integer.parseInt(parts[1].trim()),
                    Integer.parseInt(parts[2].trim()),
                    Integer.parseInt(parts[3].trim())
                ));
            }
            reader.close();
        }
        catch (Exception e) {
            System.out.println("An error occured while reading the file: " + e.getMessage());
            return;
        }

        // Converts list to array 
        Student[] A = students.toArray(new Student[0]);

        // Sorting of an array and Measure time taken to sort the array
        long startTime = System.nanoTime();
        mergeSort(A,0, A.length - 1);
        long endTime = System.nanoTime();
        long totalDuration = (endTime - startTime)/1000; 
        System.out.println("Time taken to sort: " + totalDuration + " microseconds");
        
        // Write the sorted data to an output file
        try {
            FileWriter filewriter = new FileWriter(outputFile);
            BufferedWriter writer = new BufferedWriter(filewriter);
            for (Student s : A) {
                writer.write(s.studentId + "," + s.course1 + "," + s.course2 + "," + s.course3 + "," + s.average + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

    }
    
    //Merge sort method implementation that divides the array into subarrays
    public static void mergeSort(Student[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    //Merge method implementation that sorts and merges the divided subarrays
    public static void merge (Student[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        Student[] L = new Student[n1 + 1];
        Student[] R = new Student[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        // Sentinel values
        L[n1] = new Student(Integer.MAX_VALUE,0,0,0); 
        R[n2] = new Student(Integer.MAX_VALUE,0,0,0);

        int i = 0 , j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i].studentId <= R[j].studentId) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}

class Student {
    int studentId;
    int course1, course2, course3;
    double average;

    // Constructor to initialize student data and calculate average
    public Student(int studentId, int course1, int course2, int course3) {
        this.studentId = studentId;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.average = Math.round((course1 + course2 + course3) / 3.0 * 100.0) / 100.0;
    }
}
