package org.example;

import java.time.LocalDate;
public class Person {
    String name;
    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;
    int age;
    double height;
    double weight;
    double bmi;

    public Person(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth, double height, double weight) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;

        LocalDate currentDate = LocalDate.now();
        this.age = currentDate.getYear() - yearOfBirth;

        this.height = height;
        this.weight = weight;
        this.bmi = calculateBMI();
    }

    private double calculateBMI() {
        return this.weight / ((this.height/100) * (this.height/100));
    }

    public static void main(String[] args) {
        // to do
    }
}
