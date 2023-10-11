package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
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
        double a, b, c;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three side lengths of a triangle: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        int result = new Main().checkTriangle(a, b, c);
        if (result == 1) {
            System.out.println("Equilateral triangle");
        } else if (result == 2) {
            System.out.println("Isosceles triangle");
        } else {
            System.out.println("Scalene triangle");
        }

    }
}