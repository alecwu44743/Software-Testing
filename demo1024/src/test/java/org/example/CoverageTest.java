package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoverageTest {

    @Test
    void funcTest1() { // statement coverage 100
        Coverage coverage = new Coverage();
        assertEquals(1, coverage.func(11, 1));
        assertEquals(10, coverage.func(10, 8));
        assertEquals(3, coverage.func(10, 11));
    }

    @Test
    void funcTest2() { // 設計一測試案例達到百分百條件涵蓋度 (CC100)，但非百分百分支涵蓋度
        Coverage coverage = new Coverage();
        assertEquals(2, coverage.func(9, 8));
    }

    @Test
    void funcTest3() { // 設計一測試案例達到百分百分支涵蓋度 (BC100)，但非百分百條件涵蓋度 (!CC100)
        Coverage coverage = new Coverage();
        assertEquals(2, coverage.func(9, 9));
    }

}