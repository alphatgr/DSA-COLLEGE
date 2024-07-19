import java.util.Scanner;

public class linear_search {
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
        System.out.println("Enter the element to be searched : ");
        boolean found=false;
        int search=sc.nextInt();
        for (int i=0;i<size;i++)
        {
            if(arr[i]==search)
            {
                System.out.println("Element " +search +" found at position : " + (i+1));
                found=true;
                break;
            }
        }
        if(found!=true){
            System.out.println("Element " +search+" is not found in the array.");  
        }
        sc.close();
    }
}
