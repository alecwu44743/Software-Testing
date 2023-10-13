package org.example;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    public void printPassOrFail_name(String expectedValue, String actualValue, int caseNumber){
        if (expectedValue == actualValue) { // if the test passes, print pass
            System.out.println("Case #" + caseNumber + ": pass");
        } else { // if the test fails, print fail
            System.out.println("Case #" + caseNumber + ": fail");
        }

        System.out.println("Expected: " + expectedValue + ", Actual: " + actualValue);
        System.out.println();
    }

    Person person = new Person();
    Person personA = new Person();
    Person personB = new Person();
    Person personC = new Person();
    Person personD = new Person();
    Person personE = new Person();

    @BeforeEach
        // To initialize the test
    void init() {
        person = new Person("Nguyen Van A", 2000, 12, 31, 170, 60);
        personA = new Person("Alec Wu", 2023, 1, 21, 170, 60);
        personB = new Person("", 2000, 12, 31, 170, 60);
        personC = new Person("Emily Chen", 1991, 5, 32, 169, 50);
        personD = new Person("Elle CX", 1993, 2, 29, 168, 50);
        personE = new Person("Ashley CA", 1992, 2, 29, 168, 50);

//        System.out.println("init");
        System.out.println("[>] Init MainTest\n");
    }

    @Test
    void getName() {
        System.out.println("[+] Here is getName test");
        System.out.println("This test initially bypasses judgment and solely assesses whether someone can retrieve the name");
        assertEquals("Nguyen Van A", person.getName());
        assertEquals("Alec Wu", personA.getName());
        assertEquals("", personB.getName());
        assertEquals("Emily Chen", personC.getName());
        assertEquals("Elle CX", personD.getName());
        assertEquals("Ashley CA", personE.getName());

        System.out.println("[v] getName test passed");
    }

    @Test
    void getAge() {
        System.out.println("[+] Here is getAge test");
        System.out.println("This test initially bypasses judgment and solely assesses whether someone can retrieve the age");

        LocalDate currentDate = LocalDate.now();
        assertEquals(currentDate.getYear() - 2000, person.getAge());
        assertEquals(currentDate.getYear() - 2023, personA.getAge());
        assertEquals(currentDate.getYear() - 2000, personB.getAge());
        assertEquals(currentDate.getYear() - 1991, personC.getAge());
        assertEquals(currentDate.getYear() - 1993, personD.getAge());
        assertEquals(currentDate.getYear() - 1992, personE.getAge());

        System.out.println("[v] getAge test passed");
    }

    @Test
    void getBMI() {
        System.out.println("[+] Here is getBMI test");
        System.out.println("This test initially bypasses judgment and solely assesses whether someone can retrieve the BMI");

        assertEquals(20.761245674740486, person.getBMI());
        assertEquals(20.761245674740486, personA.getBMI());
        assertEquals(20.761245674740486, personB.getBMI());
        assertEquals(17.506389832288786, personC.getBMI());
        assertEquals(17.71541950113379, personD.getBMI());
        assertEquals(17.71541950113379, personE.getBMI());

        System.out.println("[v] getBMI test passed");
    }

    @Test
    void getBirthDate() {
        System.out.println("[+] Here is getBirthDate test");
        System.out.println("This test initially bypasses judgment and solely assesses whether someone can retrieve the birth date");

        assertEquals("12/31/2000", person.getBirthDate());
        assertEquals("1/21/2023", personA.getBirthDate());
        assertEquals("12/31/2000", personB.getBirthDate());
        assertEquals("5/32/1991", personC.getBirthDate());
        assertEquals("2/29/1993", personD.getBirthDate());
        assertEquals("2/29/1992", personE.getBirthDate());

        System.out.println("[v] getBirthDate test passed");
    }

    @Test
    void showMyInfo() {
        System.out.println("[+] Here is showMyInfo test");
        System.out.println("This test initially bypasses judgment and solely assesses whether someone can retrieve the information");

        assertEquals("\nName: Nguyen Van A\n" +
                "Age: 23\n" +
                "Height: 170.00 cm\n" +
                "Weight: 60.00 kg\n" +
                "BMI: 20.76\n" +
                "Birth date: 12/31/2000", person.showMyInfo());
        assertEquals("\nName: Alec Wu\n" +
                "Age: 0\n" +
                "Height: 170.00 cm\n" +
                "Weight: 60.00 kg\n" +
                "BMI: 20.76\n" +
                "Birth date: 1/21/2023", personA.showMyInfo());
        assertEquals("\nName: \n" +
                "Age: 23\n" +
                "Height: 170.00 cm\n" +
                "Weight: 60.00 kg\n" +
                "BMI: 20.76\n" +
                "Birth date: 12/31/2000", personB.showMyInfo());
        assertEquals("\nName: Emily Chen\n" +
                "Age: 32\n" +
                "Height: 169.00 cm\n" +
                "Weight: 50.00 kg\n" +
                "BMI: 17.51\n" +
                "Birth date: 5/32/1991", personC.showMyInfo());
        assertEquals("\nName: Elle CX\n" +
                "Age: 30\n" +
                "Height: 168.00 cm\n" +
                "Weight: 50.00 kg\n" +
                "BMI: 17.72\n" +
                "Birth date: 2/29/1993", personD.showMyInfo());
        assertEquals("\nName: Ashley CA\n" +
                "Age: 31\n" +
                "Height: 168.00 cm\n" +
                "Weight: 50.00 kg\n" +
                "BMI: 17.72\n" +
                "Birth date: 2/29/1992", personE.showMyInfo());

        System.out.println("[v] showMyInfo test passed");
    }

    @Test
    void nameCheck() {
        System.out.println("[+] Here is nameCheck test");
        System.out.println("To testing the nameCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.nameCheck("");
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is empty, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] nameCheck test passed");
    }

    @Test
    void yearCheck() {
        System.out.println("[+] Here is yearCheck test");
        System.out.println("To testing the yearCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.yearCheck(1849);
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is 1849, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.yearCheck(2027);
        });
        System.out.println("Case #2: pass");
        System.out.println("Input is 2027, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] yearCheck test passed");
    }

    @Test
    void monthCheck() {
        System.out.println("[+] Here is monthCheck test");
        System.out.println("To testing the monthCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.monthCheck(0, 2000);
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is 0, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.monthCheck(13, 2000);
        });
        System.out.println("Case #2: pass");
        System.out.println("Input is 13, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] monthCheck test passed");
    }

    @Test
    void isLeapYear() {
        System.out.println("[+] Here is isLeapYear test");
        System.out.println("To testing the isLeapYear function");

        assertEquals(false, person.isLeapYear(2001));
        assertEquals(true, person.isLeapYear(2000));
        assertEquals(false, person.isLeapYear(1900));
        assertEquals(true, person.isLeapYear(2004));
        assertEquals(false, person.isLeapYear(2005));

        assertEquals(false, personD.isLeapYear(personD.yearOfBirth));
        assertEquals(true, personE.isLeapYear(personE.yearOfBirth));

        System.out.println("[v] isLeapYear test passed");
    }

    @Test
    void dayCheck() {
        System.out.println("[+] Here is dayCheck test");
        System.out.println("To testing the dayCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.dayCheck(1, 0, 2000);
        });
        System.out.println("Case #1: pass");
        System.out.println("Date: " + person.getBirthDate());
        System.out.println("Input is 0, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.dayCheck(1, 32, 2000);
        });
        System.out.println("Case #2: pass");
        System.out.println("Date: " + person.getBirthDate());
        System.out.println("Input is 32, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.dayCheck(2, 29, 2001);
        });
        System.out.println("Case #3: pass");
        System.out.println("Date: " + person.getBirthDate());
        System.out.println("Input is 29, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.dayCheck(2, 30, 2000);
        });
        System.out.println("Case #4: pass");
        System.out.println("Date: " + person.getBirthDate());
        System.out.println("Input is 30, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] dayCheck test passed");
    }

    @Test
    void heightCheck() {
        System.out.println("[+] Here is heightCheck test");
        System.out.println("To testing the heightCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.heightCheck(0);
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is 0, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.heightCheck(1.68);
        });
        System.out.println("Case #2: pass");
        System.out.println("Input is 1.68, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] heightCheck test passed");
    }

    @Test
    void weightCheck() {
        System.out.println("[+] Here is weightCheck test");
        System.out.println("To testing the weightCheck function");

        Exception exception = assertThrows(Exception.class, () -> {
            person.weightCheck(0);
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is 0, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            person.weightCheck(900);
        });
        System.out.println("Case #2: pass");
        System.out.println("Input is 900, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] weightCheck test passed");
    }

    @Test
    void main() {
    }
}