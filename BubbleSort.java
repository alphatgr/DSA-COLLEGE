import java.util.*;

public class BubbleSort {

    
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] array = new int[n];
    
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
    
        bubbleSort(array);
    
        System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(array));
    
        sc.close();
    }
}
