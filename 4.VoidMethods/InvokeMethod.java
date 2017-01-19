/**
* Exercise 4-2.
* The point of this exercise is to make sure you understand how to write and invoke
* methods that take parameters.
* 1. Write the first line of a method named zool that takes three parameters: an  int
* and two Strings.
* 2. Write a line of code that calls zool, passing as arguments the value  11, the name
* of your first pet, and the name of the street you grew up on.
 */
public class InvokeMethod {
 public static void zool (int age, String pet, String street){
  System.out.println("I'm " + age + " years old.");
  System.out.println("My first pet's name was " + pet);
  System.out.println("The name of the street I live on is " + street + ".");
 }
    public static void main(String[] args) {
     int age = 28;
     String pet = "Cherry";
     String street = "Golden Nugget";
     zool(age, pet, street);
        }
}