import java.util.Scanner;

public class Palindrome_using_functions {
    public static int palindrome(int num)
    {
        int rev=0; int copy=num;
        while(copy!=0)
        {
            int r=copy%10;
            rev=(rev*10)+r;
            copy=copy/10;
        }
        if(rev==num)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n=sc.nextInt();
        int check = palindrome(n);
        if (check==1)
        {
            System.out.println("Palindrome Number");
        }
        else{
            System.out.println("Not a Palindrome Number");
        }
        sc.close();
    }
}
