import java.lang.Math;
import java.util.Scanner;

public class Primitives {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Demonstration of constant
    final int a = 1;
    float b = 1.5f;
    char c = 'x';
    short d = 50;
    long e = 1000000000;
    double f = 1.25;
    boolean g = true;
    byte h = 8;
    // Demonstration of literal
    System.out.printf("Literal: " + /*Literal*/ (4 + 5) + "\nInteger: " + (a) +
                      "\nFloat: " + (b) + "\nChar: " + (c) + "\nShort: " + (d) +
                      "\nLong: " + (e) + "\nDouble: " + (f) +
                      "\nBoolean: " + (g) + "\nByte: " + (h) + "\n");

    // Narrowing
    int z = 12345678;
    h = (byte)z;
    System.out.printf("Narrowed value in bytes: " + (z));
    System.out.println(h);
    // Widening
    int w = 1;
    int x = 2;
    double y = (double)a / b;
    System.out.printf("Widened value in double: " + (y) + "\n");

    System.out.printf("Enter integer: ");
    int userInt = input.nextInt();
    System.out.printf("The square of " + userInt +
                      " is: " + Math.pow(userInt, 2) + "\nThe cube of " +
                      userInt + " is: " + Math.pow(userInt, 3) +
                      "\nThe fourth power is: " + Math.pow(userInt, 4));

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    System.out.printf("Min: " + (min) + "\nMax: " + (max) + "\n");
    System.out.printf("Signed compare method result: ");
    System.out.println(Integer.compare(min, max));
    // UNSIGNED ONLY SUPPORTS POSITIVE NUMBERS!!!
    // This is because it is using all bits to represent its value
    System.out.printf("Unsigned compare method result: ");
    System.out.println(Integer.compareUnsigned(min, max));

    System.out.println("Enter float 1: ");
    float userFloat = input.nextFloat();
    System.out.println("Enter float 2: ");
    float userFloat2 = input.nextFloat();
    boolean result1 = Float.isFinite(0 / userFloat);
    boolean result2 = Float.isFinite(0 / userFloat2);

    System.out.println("Enter integer dividend: ");
    int dividend = input.nextInt();
    System.out.println("Enter integer divisor: ");
    int divisor = input.nextInt();
    double result3 = Math.floor(dividend / divisor);
    double result4 = Math.floor(dividend % divisor);
    System.out.printf("Result of floor division using /: " + result3 +
                      "\nResult of floor division using modulus: " + result4 +
                      "\n");
  }
}
