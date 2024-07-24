import java.util.Scanner;

public class FibonacciSeriesDynamicProgramming {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of terms in the Fibonacci series
        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = sc.nextInt();


        // Initializing the Fibonacci array using dynamic programming
        int[] fibonacciArray = new int[n];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;

        // Generating the Fibonacci series using dynamic programming
        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        // Printing the Fibonacci series
        System.out.println("The Fibonacci series is:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciArray[i] + " ");
        }
        System.out.println();
    }
}
