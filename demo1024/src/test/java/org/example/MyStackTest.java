package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @Test
    void easyTest() throws Exception {
        MyStack s = new MyStack(3);
        s.push(100);
        assertFalse(s.isFull());
        s.push(200);
        s.push(300);
        assertTrue(s.isFull());
    }

    @Test
    void mediumTest() throws Exception {
        MyStack s = new MyStack(3);
        s.push(100);
        s.push(100);
        s.pop();
        s.pop();
        assertTrue(s.isEmpty());
    }

    @Test
    void hardTest() throws Exception {
        MyStack s = new MyStack(3);
        s.push(100);
        s.push(200);
        s.push(300);
        assertEquals(300, s.top());
        s.pop();
        assertEquals(200, s.top());
        s.pop();
        assertEquals(100, s.top());
        s.pop();
        assertTrue(s.isEmpty());
    }

    @Test
    void except_getTest() throws Exception {
        MyStack s = new MyStack(3);
        assertThrows(Exception.class, () -> {
            s.top();
        });

        s.push(100);
        assertEquals(100, s.top());

        s.push(200);
        assertEquals(200, s.top());

        s.push(300);
        assertEquals(300, s.top());

        assertThrows(Exception.class, () -> {
            s.push(400);
        });

        s.pop();
        assertEquals(200, s.top());

        s.pop();
        assertEquals(100, s.top());

        s.pop();
        assertThrows(Exception.class, () -> {
            s.pop();
        });

        assertEquals(0, s.getSize());
    }
}