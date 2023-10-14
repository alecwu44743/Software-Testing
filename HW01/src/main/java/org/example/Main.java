package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void numberCheck(double num) throws Exception {
        if (num < 0) {
            throw new Exception("Side a cannot be negative");
        }
        else if (num == 0) {
            throw new Exception("Side a cannot be zero");
        }
    }

    // check if a triangle is equilateral, isosceles, or scalene
    int checkTriangle(double a, double b, double c) {
        if (a + b <= c || b + c <= a || a + c <= b) {
            return 0; // not a triangle
        }
        else if (a == b && b == c) {
            return 1; // equilateral triangle
        } else if (a == b || b == c || a == c) {
            return 2; // isosceles triangle
        } else {
            return 3; // scalene triangle
        }
    }

    public static void main(String[] args) {
        // input three side lengths of a triangle
        double a = 0, b = 0, c = 0;

        boolean isValid = true;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Triangle Checker\n");

        // input side a
        while (true) {
            System.out.print("Enter side a: ");
            try {
                a = Double.parseDouble(scanner.next());
                numberCheck(a); // check if a is valid
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e){
                isValid = false;
                System.out.println(e.getMessage());
            }
        }

        // input side b
        while (true) {
            System.out.print("Enter side b: ");
            try {
                b = Double.parseDouble(scanner.next());
                numberCheck(b); // check if b is valid
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e){
                isValid = false;
                System.out.println(e.getMessage());
            }
        }

        // input side c
        while (true) {
            System.out.print("Enter side c: ");
            try {
                c = Double.parseDouble(scanner.next());
                numberCheck(c); // check if c is valid
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e){
                isValid = false;
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The three sides of the triangle are " + a + ", " + b + ", and " + c);

        // check the type of triangle, and print the result
        Main main = new Main();
        int result = main.checkTriangle(a, b, c);
        if (result == 0) {
            System.out.println("This is not a triangle");
        } // not a triangle (sum of two sides <= third side)
        else if (result == 1) {
            System.out.println("This is an equilateral triangle");
        } else if (result == 2) {
            System.out.println("This is an isosceles triangle");
        } else {
            System.out.println("This is a scalene triangle");
        }
    }
}