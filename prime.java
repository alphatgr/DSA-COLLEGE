import  java.util.*;
public class prime {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked : ");
        int n= sc.nextInt();
        int check=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                check++;
            }
        }
        if (check==2)
        {
            System.out.println("It is a Prime Number");
        }
        else{
            System.out.println("It is not a Prime Number");
        }
    }
}