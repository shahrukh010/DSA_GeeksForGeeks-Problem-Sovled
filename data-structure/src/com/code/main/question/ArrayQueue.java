package com.queue;
import java.util.Arrays;
import com.astract.AbstractQueue;

 public abstract class ArrayQueue  implements Queue{

    public int[] queue;
    private int front; 
    private int rear;  
    private int size;
    public static  int capacity;
    private static final int CAPACITY = 16;
    
    public int[] getQueue(){
        return queue;
    }
    public int getFront(){
        return front;
    }

    public ArrayQueue(){

        queue = new int[CAPACITY];
        front = 0;
        rear  = 0;
        size  = 0;

    }

    public ArrayQueue(int capacity){

        queue = new int[capacity];
        front = 0;
        rear  = 0;
        size  = 0;
        this.capacity = capacity;
    }

    public void enqueue(int value){

       if(size == capacity)
           resizeArray();//throw new IllegalStateException("queue overflow");

       else{

        size++;
        queue[rear] = value;

        rear = (rear+1)%CAPACITY;
       }
    }

    public int deQueue(){

        if(size == 0)
            throw new IllegalStateException("NoSuchElementException");
        else{
            int dq = queue[front];
            queue[front] = Integer.MIN_VALUE;
            size--;

            front = (front+1)%capacity;

            return dq;
        }

    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){

        return size==capacity;
    }

    public void resizeArray(){

        int[] newQueue = new int[capacity<<2];

        for(int i = front; i<size;i++){

            newQueue[i-front] = queue[(front+i)%capacity];
        }
    }

/*
    public String toString(){
      // int[] output = Arrays.copyOfRange(queue,0,size);
       //return Arrays.toString(output);

    //below logic of copyOfRange()method
       String result = "[-- ";

       for(int i = 0; i < size; i++){

           result =result.concat(Integer.toString(queue[(front+i)%capacity])+",");
        }

        return result+"]";
    }*/
}
