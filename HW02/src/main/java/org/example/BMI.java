package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {
    double height;
    double weight;
    double bmi;

    public BMI(double _height, double _weight) {
        this.height = _height;
        this.weight = _weight;
        this.bmi = calculateBMI();
    }

    public double calculateBMI() {
        return this.weight / ((this.height/100) * (this.height/100));
    }

    public double getHeight() {
        return this.height;
    }
    public double getWeight() {
        return this.weight;
    }
    public double getBMI() {
        return this.bmi;
    }
    public String showMyInfo() {
        DecimalFormat df = new DecimalFormat("0.00");
        String correctBmi = df.format(this.bmi);
        String correctHeight = df.format(this.height);
        String correctWeight = df.format(this.weight);

        return "Height: " + correctHeight + "cm | " + "Weight: " + correctWeight + "kg | " + "BMI: " + correctBmi;
    }

    public static void heightCheck(double height) throws Exception {
        if (height < 10 || height > 300) {
            throw new Exception("Height cannot be less than 10 or greater than 300\n" + "Please use cm");
        }
    }

    public static void weightCheck(double weight) throws Exception {
        if (weight <= 0 || weight > 500) {
            throw new Exception("Weight cannot be less than 0 or greater than 500\n" + "Please use kg");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height;
        double weight;

        System.out.print("BMI Calculator\n");

        while (true){
            System.out.print("Enter your height in cm: ");
            try {
                height = Double.parseDouble(scanner.next());
                heightCheck(height);
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        while (true){
            System.out.print("Enter your weight in kg: ");
            try {
                weight = Double.parseDouble(scanner.next());
                weightCheck(weight);
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        BMI myBMI = new BMI(height, weight);
        System.out.println(myBMI.showMyInfo());
    }
}
