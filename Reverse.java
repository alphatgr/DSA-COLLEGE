import  java.util.*;
public class Reverse {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be reversed : ");
        long n= sc.nextLong(); long r, rev=0;
        while (n!=0)
        {
            r = n%10;
            rev = (rev*10)+r;
            n=n/10;
        }
        System.out.println("Reverse of the number is : "+rev);
    }
}