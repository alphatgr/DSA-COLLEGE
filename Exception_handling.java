import java.util.Scanner;
public class Exception_handling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            try{
                System.out.println("Enter the size of the array : ");
                int size = sc.nextInt();
                System.out.println("Enter the elements of the array : ");
                int[] arr=new int[size];
                for (int i=0;i<size;i++)
                {
                    arr[i]=sc.nextInt();
                }
                System.out.println("Enter the element to be checked : ");
                int check=sc.nextInt();
                boolean element_found=false;
                for(int i=0;i<size;i++)
                {
                    if (check==arr[i])
                    {
                        System.out.println("The element " + check + " is found at the index : " + i);
                        element_found=true;
                        break;
                    }
                }
                if (element_found==false)
                {
                    System.out.println("The element " + check + " is not found in the array.");
                }
            }
            catch(Exception e)     // THIS BLOCK IS IMPORTANT REMEMBER IT
            {
                sc.next();
                System.out.println("Something went wrong, Do you want to try again or want to quit?");
                System.out.println("Press Y to try again and Q for quitting");
                String str=sc.next();
                if(str.equalsIgnoreCase("Q"))  // THIS IS USED TO CHECK WHETHER THE INPUT IS Q OR q FROM THE USER
                {
                    break;
                }
                System.out.println(" ");
            }
        }
        sc.close();    // THIS IS USED TO CLOSE THE SCANNER CLASS 
    }
}
