
import java.util.Scanner;

// Java Program to implement
// Basic Approach to check if
// string is a Palindrome
class StringPalindrome {
    // main function
    public static void isPalindrome(String str)
    {
        // Initializing an empty string to store the reverse
        // of the original str
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        // Checking if both the strings are equal
        if (str.equals(rev)) {
            System.out.println("The string is Palindrome :" + str);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Input string
        System.out.println("Enter the String to be checked");
        String str = sc.next();

        // Convert the string to lowercase
        str = str.toLowerCase();
        isPalindrome(str);
    }
}
