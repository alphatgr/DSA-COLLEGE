import java.util.Scanner;

public class binary_search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Array : ");
        int size=sc.nextInt();
        int[] arr=new int [size];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("The original array is : { ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();

        //BUBBLE SORT TO PERFORM BINARY SEARCH AS IT WORKS ONLY ON SORTED ARRAY
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
        System.out.print("The array is : { ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();
        

        //BINARY SEARCH TO FIND THE ELEMENT

        System.out.println("Enter the element to be searched : ");
        int search = sc.nextInt();
        int left = 0;
        int right = size - 1;
        boolean found = false;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == search) {
                position = mid;
                found = true;
                break;
            }
            if (arr[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (found==true) {
            System.out.println("Element " + search + " found at position: " + (position + 1));
        } else {
            System.out.println("Element " + search + " is not found in the array.");
        }
        sc.close();
    }
}
