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
        else if (Double.isNaN(num)) {
            throw new NumberFormatException("Not a valid number");
        }
    }

    // check if a triangle is equilateral, isosceles, or scalene
    int checkTriangle(double a, double b, double c) {
        if (a == b && b == c) {
            return 1;
        } else if (a == b || b == c || a == c) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        // input three side lengths of a triangle
        double a = 0, b = 0, c = 0;

        boolean isValid = true;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Triangle Checker\n");
        try{
            System.out.print("Enter side a: "); a = scanner.nextDouble();
            numberCheck(a); // check if a is valid

            System.out.print("Enter side b: "); b = scanner.nextDouble();
            numberCheck(b); // check if b is valid

            System.out.print("Enter side c: "); c = scanner.nextDouble();
            numberCheck(c); // check if c is valid

            int res = new Main().checkTriangle(a, b, c);
        }catch (Exception e){
            isValid = false;
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }

        if (isValid) {
            System.out.println("The three sides of the triangle are " + a + ", " + b + ", and " + c);
        }
    }
}