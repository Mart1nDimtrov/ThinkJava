/**
 * Exercise 7-3.
In  Exercise 6-9we wrote a recursive version of power, which takes a double  xand an
integer  nand returns x
n
. Now write an iterative method to perform the same calcula?
tion.
 */


import java.util.Scanner;
public class FindPower{
    public static void findPower (int number, int power){
        int numberRaised = number;
        for(int i = 0; i < power - 1; i++){
            numberRaised *= number;
        }
    System.out.println(number + " raised to the power of " + power + " is:");
    System.out.println(numberRaised);
    }
    
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter your number:");
    int number = in.nextInt();
    System.out.println("Please enter the power:");
    int power = in.nextInt();
    findPower(number, power);
    
}
}