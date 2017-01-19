/**
 * Exercise 6-3.
If you are given three sticks, you may or may not be able to arrange them in a trian?
gle. For example, if one of the sticks is 12 inches long and the other two are one inch
long, you will not be able to get the short sticks to meet in the middle. For any three
lengths, there is a simple test to see if it is possible to form a triangle:
If any of the three lengths is greater than the sum of the other two, you cannot form a
triangle.
Write a method named  isTrianglethat takes three integers as arguments and
returns either  trueor false, depending on whether you can or cannot form a trian?
gle from sticks with the given lengths. The point of this exercise is to use conditional
statements to write a value method.
 */
import java.util.Scanner;

public class CheckTriangle{
    public static boolean isTriangle(int first, int second, int third){
        if(first + second < third){
            return false;
        }
        else if (second + third < first){
            return false;
        }
        else if (third + first < second){
            return false;
        }
        else {
             return true;
        }
       
    }
    public static void main(String[] args){
        System.out.println("Enter three lenths on seperate line to check if they form a triangle:");
        Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        int third = in.nextInt();
        if(isTriangle(first, second, third)){
             System.out.println("The lengths form a triangle");
        }
        else {
            System.out.println("The lengths don't form a triangle");
          }
    }
}
