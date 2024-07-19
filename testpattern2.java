import java.util.Scanner;

public class testpattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows you want the pattern to be printed :");
        int n=sc.nextInt();
        int value=0;
        for(int i=1;i<=n;i++)
        {
            for(int k=1;k<=n-i;k++) //REMEMBER THIS LOOP FOR SPACING, HERE WE WILL TAKE SPACE=NO OF ROWS AND WE WILL RUN IT UNTILL THE NO ROWS ARE COMPLETED
            {
                System.out.print(" ");
            }
            value=value+i;
            int data=value;
            for(int j=1;j<=i;j++)
            {
                System.out.print(data);
                data-- ;
            }   
            System.out.println("");
        }
        sc.close();
    }
}