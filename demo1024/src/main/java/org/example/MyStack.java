package org.example;

public class MyStack {
    private int[] data;
    private int size;
    private int index;
    public MyStack(int n){
        this.size = n;
        this.index = 0;
        this.data = new int[n];
    }

    public int pop() throws Exception{
        if(index == 0){
            throw new Exception("Stack is empty");
        }
        else{
            index--;
            return data[index];
        }
    }

    public void push(int n) throws Exception{
        if(index == size){
            throw new Exception("Stack is full");
        }
        else{
            data[index] = n;
            index++;
        }
    }

    public int top() throws Exception{
        if(index == 0){
            throw new Exception("Stack is empty");
        }
        else{
            return data[index-1];
        }
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return index == size;
    }

    public int getSize(){
        return index;
    }
}
