package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BMITest {

    @DisplayName("Test for BMI Calculation")
    @ParameterizedTest(name = "{index} => height={0}, weight={1}, res={2}")
    @CsvSource({
            "170, 60, 20.761245674740486",
            "180, 70, 21.604938271604937",
            "190, 80, 22.1606648199446",
            "160, 50, 19.531249999999996",
    })
    void test_calculateBMI(double height, double weight, double res) {
        BMI bmi = new BMI(height, weight);
        assertEquals(res, bmi.getBMI());
    }


    @DisplayName("Test for getHeight")
    @ParameterizedTest(name = "{index} => height={0}, res={1}")
    @CsvSource({
            "170, 170",
            "180, 180",
            "169.98, 169.98",
            "160, 160",
    })
    void test_getHeight(double height, double res) {
        BMI bmi = new BMI(height, 60);
        assertEquals(res, bmi.getHeight());
    }

    @DisplayName("Test for getWeight")
    @ParameterizedTest(name = "{index} => weight={0}, res={1}")
    @CsvSource({
            "60, 60",
            "70, 70",
            "80, 80",
            "50, 50",
            "49.99, 49.99",
    })
    void test_getWeight(double weight, double res) {
        BMI bmi = new BMI(170, weight);
        assertEquals(res, bmi.getWeight());
    }

    @DisplayName("Test for getBMI")
    @ParameterizedTest(name = "{index} => height={0}, weight={1}, res={2}")
    @CsvSource({
            "170, 60, 20.761245674740486",
            "180, 70, 21.604938271604937",
            "190, 80, 22.1606648199446",
            "160, 50, 19.531249999999996",
    })
    void test_getBMI(double height, double weight, double res) {
        BMI bmi = new BMI(height, weight);
        assertEquals(res, bmi.getBMI());
    }

    @DisplayName("Test for showMyInfo")
    @ParameterizedTest(name = "{index} => height={0}, weight={1}, res={2}")
    @CsvSource({
            "170.68, 68.04, Height: 170.68cm | Weight: 68.04kg | BMI: 23.36",
            "180.00, 70.00, Height: 180.00cm | Weight: 70.00kg | BMI: 21.60",
            "190.00, 80.00, Height: 190.00cm | Weight: 80.00kg | BMI: 22.16",
            "160.00, 50.00, Height: 160.00cm | Weight: 50.00kg | BMI: 19.53",

    })
    void showMyInfo(double height, double weight, String res) {
        BMI bmi = new BMI(height, weight);
        assertEquals(res, bmi.showMyInfo());
    }

    @DisplayName("Test for heightCheck")
    @ParameterizedTest(name = "{index} => height={0}")
    @ValueSource(doubles = { 5.0, 9.9, 300.1, 350.0})
    void test_invalid_heightCheck(double height) {
        assertThrows(Exception.class, () -> {
            BMI.heightCheck(height);
        });
    }

    @DisplayName("Test for heightCheck")
    @ParameterizedTest(name = "{index} => height={0}")
    @ValueSource(doubles = { 10.0, 150.0, 300.0 })
    void test_valid_heightCheck(double height) {
        assertDoesNotThrow(() -> {
            BMI.heightCheck(height);
        });
    }

    @DisplayName("Test for weightCheck")
    @ParameterizedTest(name = "{index} => weight={0}")
    @ValueSource(doubles = { -1.0, 0.0, 500.1, 600.0})
    void test_invalid_weightCheck(double weight) {
        assertThrows(Exception.class, () -> {
            BMI.weightCheck(weight);
        });
    }

    @DisplayName("Test for weightCheck")
    @ParameterizedTest(name = "{index} => weight={0}")
    @ValueSource(doubles = { 10, 15.0, 499.9, 500.0 })
    void test_valid_weightCheck(double weight) {
        assertDoesNotThrow(() -> {
            BMI.weightCheck(weight);
        });
    }
}