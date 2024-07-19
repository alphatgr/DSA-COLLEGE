import java.util.Scanner;

public class pattern_two {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows you want the pattern to be printed :");
        int rows=sc.nextInt();
        int number=1;
        for(int r=1;r<=rows;r++)
        {
            for(int space=rows;space>=r;space--) //REMEMBER THIS LOOP FOR SPACING, HERE WE WILL TAKE SPACE=NO OF ROWS AND WE WILL RUN IT UNTILL THE NO ROWS ARE COMPLETED
            {
                System.out.print(" ");
            }
            int start = number + r - 1;   //Calculate the starting number for the row
            for(int c=1;c<=r;c++)
            {
                System.out.print(start-- +"");
            }   
            System.out.println("");
            number+=r;
        }
        sc.close();
    }
}