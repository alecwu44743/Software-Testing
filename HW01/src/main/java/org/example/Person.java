package org.example;

import java.time.LocalDate;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Person {
    String name;
    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;
    int age;
    double height;
    double weight;
    double bmi;

    public Person(String _name, int _yearOfBirth, int _monthOfBirth, int _dayOfBirth, double _height, double _weight) {
        this.name = _name;
        this.yearOfBirth = _yearOfBirth;
        this.monthOfBirth = _monthOfBirth;
        this.dayOfBirth = _dayOfBirth;

        LocalDate currentDate = LocalDate.now();
        this.age = currentDate.getYear() - this.yearOfBirth;

        this.height = _height;
        this.weight = _weight;
        this.bmi = calculateBMI();
    }

    public Person(){

    }

    private double calculateBMI() {
        return this.weight / ((this.height/100) * (this.height/100));
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getBMI() {
        return this.bmi;
    }

    public String getBirthDate() {
        return this.monthOfBirth + "/" + this.dayOfBirth + "/" + this.yearOfBirth;
    }

    public String showMyInfo() {
        DecimalFormat df = new DecimalFormat("0.00");
        String correctBmi = df.format(this.bmi);
        String correctHeight = df.format(this.height);
        String correctWeight = df.format(this.weight);

        return "\nName: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                "Height: " + correctHeight + " cm\n" +
                "Weight: " + correctWeight + " kg\n" +
                "BMI: " + correctBmi + "\n" +
                "Birth date: " + this.monthOfBirth + "/" + this.dayOfBirth + "/" + this.yearOfBirth;
    }

    public static void nameCheck(String name) throws Exception {
        if (name.length() < 1 || name.length() > 100) {
            throw new Exception("Name cannot be less than 1 or greater than 100 characters");
        }
    }

    public static void yearCheck(int year) throws Exception {
        LocalDate currentDate = LocalDate.now();
        if (year < 1850 || year > currentDate.getYear()) {
            throw new Exception("Year of birth cannot be less than 1850 or greater than current year " + currentDate.getYear());
        }
    }

    public static void monthCheck(int month, int year) throws Exception {
        LocalDate currentDate = LocalDate.now();
        if (month < 1 || month > 12) {
            throw new Exception("Month of birth cannot be less than 1 or greater than 12");
        }
        else{
            if (year == currentDate.getYear()) {
                if (month > currentDate.getMonthValue()) {
                    throw new Exception("Month of birth cannot be greater than current month");
                }
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void dayCheck(int month, int day, int year) throws Exception {
        LocalDate currentDate = LocalDate.now();
        if (day < 1 || day > 31) {
            throw new Exception("Day of birth cannot be less than 1 or greater than 31");
        }
        else{
            if (year == currentDate.getYear()) { // check if year of birth is current year
                if (month == currentDate.getMonthValue()) {
                    if (day > currentDate.getDayOfMonth()) {
                        throw new Exception("Day of birth cannot be greater than current day");
                    }
                }
            }
            else{
                if (month == 2) { // check if month of birth is February
                    if (isLeapYear(year)) {
                        if (day > 29) { // if leap year
                            throw new Exception("Day of birth cannot be greater than 29");
                        }
                    }
                    else{
                        if (day > 28) { // if not leap year
                            throw new Exception("Day of birth cannot be greater than 28");
                        }
                    }
                }
                else if (month == 4 || month == 6 || month == 9 || month == 11) { // check if month of birth is April, June, September, or November
                    if (day > 30) {
                        throw new Exception("Day of birth cannot be greater than 30");
                    }
                }
            }
        }
    }

    public static void heightCheck(double height) throws Exception {
        if (height < 10 || height > 300) {
            throw new Exception("Height cannot be less than 0 or greater than 300\n" + "Please use cm");
        }
    }

    public static void weightCheck(double weight) throws Exception {
        if (weight <= 0 || weight > 500) {
            throw new Exception("Weight cannot be less than 0 or greater than 500\n" + "Please use kg");
        }
    }


    public static void main(String[] args) {
        String _name;
        int _yearOfBirth, _monthOfBirth, _dayOfBirth;
        double _height, _weight;

        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                System.out.print("Enter name: ");
                _name = scanner.nextLine();
                nameCheck(_name);
                break;
            } catch (Exception ignore) {
                System.out.println("Invalid input");
            }
        }

        while (true) {
            try {
                System.out.print("Enter year of birth: ");
                _yearOfBirth  = Integer.parseInt(scanner.nextLine());
                yearCheck(_yearOfBirth);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter month of birth: ");
                _monthOfBirth = Integer.parseInt(scanner.nextLine());
                monthCheck(_monthOfBirth, _yearOfBirth);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter day of birth: ");
                _dayOfBirth = Integer.parseInt(scanner.nextLine());
                dayCheck(_monthOfBirth, _dayOfBirth, _yearOfBirth);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter height(cm): ");
                _height = Double.parseDouble(scanner.next());
                heightCheck(_height);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter weight(kg): ");
                _weight = Double.parseDouble(scanner.next());
                weightCheck(_weight);
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Person person = new Person(_name, (int)_yearOfBirth, (int)_monthOfBirth, (int)_dayOfBirth, _height, _weight);

        System.out.println(person.showMyInfo());
    }
}
