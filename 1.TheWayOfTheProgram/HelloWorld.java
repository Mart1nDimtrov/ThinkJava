/**
 * Exercise 1-2.
 Before you do anything else, find out how to compile and run a Java program. Some
 environments provide sample programs similar to the example in  “The Hello World
 Program” on page 4.
 1. Type in the hello world program, then compile and run it.
 2. Add a print statement that displays a second message after the “Hello, World!”.
 Say something witty like, “How are you?” Compile and run the program again.
 3. Add a comment to the program (anywhere), recompile, and run it again. The
 new comment should not affect the result.
 This exercise may seem trivial, but it is the starting place for many of the programs
 we will work with. To debug with confidence, you will need to have confidence in
 your programming environment.
 In some environments, it is easy to lose track of which program is executing. You
 might find yourself trying to debug one program while you are accidentally running
 another. Adding (and changing) print statements is a simple way to be sure that the
 program you are looking at is the program you are running.

 Exercise 1-3.
 It is a good idea to commit as many errors as you can think of, so that you see what
 error messages the compiler produces. Sometimes the compiler tells you exactly what
 is wrong, and all you have to do is fix it. But sometimes the error messages are mis‐
 leading. Over time you will develop a sense for when you can trust the compiler and
 when you have to figure things out yourself.
 Starting with the hello world program, try out each of the following errors. After you
 make each change, compile the program, read the error message (if there is one), and
 then fix the error.
 1. Remove one of the open squiggly braces.
 2. Remove one of the close squiggly braces.
 3. Instead of main, write mian.
 4. Remove the word static.
 5. Remove the word public.
 6. Remove the word System.
 7. Replace printlnwith Println.
 8. Replace printlnwith print.
 9. Delete one of the parentheses. Add an extra one.
 * Created by martin on 27.10.2016 г..
 */
public class HelloWorld {
    public static void main(String[] args) {
        // System.out.println prints the message in the parentheses on a new line
        System.out.println("Hello World");
        System.out.println("How are you?");
    }
}
