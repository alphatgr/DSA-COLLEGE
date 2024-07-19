import java.util.Scanner;

public class aray1 {
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
        System.out.print("The array is : { ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("}");
        System.out.println();
        sc.close();
    }
}
