# Rod-Cutting Overview

This project implements the price-generation, recursive top-down approach, dynamic-programming extended bottom-up approach, and memoized approach for the rod-cutting problem.

## PriceGenerator.java
- It asks for the last two digits of the student ID and uses that value as the random-number seed.
- For each required rod length (5, 10, 20, 30), produces a monotonic price with values between 1 and 30.
- Writes four files `price5.txt`, `price10.txt`, `price20.txt`, and `price30.txt` - each containing the rod length on the first line followed by the price list.

## Algorithms for cutting a rod
- Each algorithm reads every `price*.txt` file produced by the price generator.
- Executes recursive top-down approach,extended bottom-up approach and memoized approach to compute maximum revenue and cuts.
- It gives output for each rod length: file name, rod length, maximum revenue, optimal cuts, and execution time in milliseconds.


# Environment Setup
## Requirements
- Java 25 (latest recommanded)
- JDK installed 
- Any IDE (e.g., Eclipse, VS Code, etc.) 

## How to Compile and Run

1. Choose the correct path for the program in the terminal
2. Compile each java program using : javac `<filename.java>`
3. Run the java programs using : java `<filename>`
4. Example for compile: javac PriceGenerator.java
5. Example for Run : java PriceGenerator

