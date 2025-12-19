# Student Dataset Generator and Sorting the Datasets using different algorithms

## Overview
This project generates a dataset of students with:
- A unique 6-digit student ID (starting with `40XXXX`)
- Random scores for 3 courses (between 70 and 100)
- Sorts the datasets using the student ID using Insertion Sort, Merge Sort, and Quick Sort.

The generation of datasets program takes two command-line arguments:
1. filename : name of the output file  
2. n : number of students to generate  

The sorting algorithms take two command-line arguments:
1. dataset : dataset generated using generation of data program
2. output file : name of the output file where the sorted dataset needs to be stored.
---

# Environment Setup

## Requirements
- Java 25 (latest recommanded)
- JDK installed 
- Any IDE (e.g., Eclipse, VS Code, etc.) 

## How to Compile and Run

1. Choose the correct path for the program in the terminal
2. Compile the java program using : javac Generatedata.java
3. Run the java program using : java Generatedata `<filename>` `<n>`
4. Compile the three sorting algorithms one by one using : javac InsertionSort.java , javac MergeSort.java , javac QuickSort.java
5. Run any algorithms of the three to sort the dataset using : java `<algorithm>`,`<dataset>`,`<outputfile>`
6. Example run: java MergeSort arr40.csv arrMR_O_40.csv

