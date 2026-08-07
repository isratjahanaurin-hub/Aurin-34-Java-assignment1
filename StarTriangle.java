//13. Star triangle

import java.util.Scanner;
public class StarTriangle {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number of rows: "); //taking input from user
        int rows = input.nextInt();

        for (int i=1; i<=rows; i++) // row
            {
            for(int j=1; j<=i; j++) // colum
                {
                System.out.print("*");
            }
            System.out.println(); // for new line (\n)
            input.close();
        }

    }
}
