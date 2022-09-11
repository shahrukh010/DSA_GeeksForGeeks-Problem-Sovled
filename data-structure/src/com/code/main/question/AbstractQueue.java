package com.astract;
import java.util.Arrays;

import com.queue.ArrayQueue;

public class AbstractQueue extends ArrayQueue{

    //Hash-A-relation
    private ArrayQueue aq;
    private int[] q = aq.getQueue();
    private int capacity = aq.capacity;
    private int front    = aq.getFront();
    private int size     = aq.getSize();

    public void resizeArray(){

        int[] newQueue = new int[capacity<<2];

        for(int i = front; i<size;i++){

            newQueue[i-front] = aq.queue[(front+i)%capacity];
        }
        System.out.println(Arrays.toString(newQueue));
    }
    

}
