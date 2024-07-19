import java.util.Scanner;

public class String_Operations {
    
    // Function to perform linear search
    public static int linearSearch(String str, char key) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == key) {
                return i;
            }
        }
        return -1;
    }
    
    // Function to sort the string using bubble sort
    public static char[] bubbleSort(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    
    // Function to perform binary search (after sorting the string)
    public static int binarySearch(char[] arr, char key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // Function to print the original and sorted string
    public static void printStrings(String original, char[] sorted) {
        System.out.println("Original String: " + original);
        System.out.println("Sorted String: " + new String(sorted));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        
        // Print original and sorted string
        char[] sorted = bubbleSort(input);
        printStrings(input, sorted);

        // Perform linear search
        System.out.println("Enter a character to search (linear): ");
        char key = sc.next().charAt(0);
        int linearIndex = linearSearch(input, key);
        if (linearIndex != -1) {
            System.out.println("Character '" + key + "' found at index (linear): " + linearIndex);
        } else {
            System.out.println("Character '" + key + "' not found (linear)");
        }

        // Perform binary search
        System.out.println("Enter a character to search (binary): ");
        key = sc.next().charAt(0);
        int binaryIndex = binarySearch(sorted, key);
        if (binaryIndex != -1) {
            System.out.println("Character '" + key + "' found at index (binary): " + binaryIndex);
        } else {
            System.out.println("Character '" + key + "' not found (binary)");
        }
        
        sc.close();
    }
}
