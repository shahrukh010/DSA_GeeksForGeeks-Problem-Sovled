package com.list;
import java.util.ArrayList;
import java.util.Arrays;

interface  List {
    //below is our requirement//
    public  int size();
    public  void addLast(int item);
    public  void  addFirst(int item);
    public  boolean contains(int item);
    public  int indexOf(int item);
    public  void removeFirst();
//    public  void removeLast();
    public  int[] toArray();
    public  Linkedlist.Node reverse();//Linkedlist.Node[because of we are returning Node object

    public int getKthFromLast(int k);
    public abstract int middle();
}

public class Linkedlist implements List{

    class Node {

        private int data;
        private Node next;

        public Node(int item){
            this.data = item;
            this.next = null;
        }
        public int getData(){
            return data;
        }
        public Node getNext(){
            return next;
        }
    }
    public static  Node first;
    public static Node  last;
    public int size;
    public  void addLast(int item){

        Node node = new Node(item);
        if(first == null){
            first = node;
            last  = first;
        }
        else{
            last.next = node;
            last = node;
        }
        size++;
    }
/*toString overriding here because of we want contain of our list*/
    public String toString(){
        Node current = first;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(current !=null){
            al.add(current.data);
            current = current.next;
        }
        return al+"";

    }

    public void addFirst(int item){

        Node node = new Node(item);
        node.next = first;
        first = node;
        size++;
    }


    public int indexOf(int item){

        Node current = first;
        int index = 0;
        while(current !=null){
                
                if(current.data == item)return index;
                current =current.next;
                index++;
        }
        return -1;
    }
    public boolean contains(int item){
        /** constant time o(1)**/
        if(isEmpty())
            throw new IllegalStateException();

        return (indexOf(item) !=-1);

        
/* //complexity o(n) not good

        Node current = first;
        while(current !=null){
            if(current.data == item)return true;
            current = current.next;
        }
            return false;
*/
    }

    public void removeFirst(){

        try{
        Node second = first.next;
        first = null;
        first = second;
        size--;
        }
        catch(NullPointerException e){
            //System.out.println("no element");
        }
    }

    public void removeLast(){

       try{
        Node previous = getPrevious();
        if(previous == null){size--;return;}//after blow line not executed either this block or other block}
        previous.next = null;
        last = previous;
        size--;
    }
       catch(NullPointerException e){
       }
}
    private Node getPrevious(){

        Node current = first;
        while(current.next !=last){
            current = current.next;
        }
        return current;
    }

    public boolean isEmpty(){

        return first == null;
    }

    public int size(){
            //constnt time o(1)
        return size;

        //iterating is wrost case o(n)
    }

    public int[] toArray(){

        int[] array = new int[size()];
        Node current = first;
        int index = 0;
        while(current !=null) {

            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    public Node reverse(){

        Node head = first;
        Node r = null;
        Node q = null;
        Node p = head;
        while(p !=null){

            r=q;
            q=p;
            p=p.next;
            q.next = r;
        }
        head = q;
        return head;
    }

    public int getKthFromLast(int k){

        Node slow = first;
        Node fast = first;

        for(int i = 0; i<k-1;i++){
            fast = fast.next;
        }
        while(fast !=last){
                
                slow = slow.next;
                fast = fast.next;
        }

        return slow.data;

        }

        public int middle(){

            Node a = first;
            Node b = first;
                             //[b.next casue if element have even number then b.next.next is become null at last postion
                             //[so please overcome this problem also.
            while(b !=last && b.next !=last){

                b =b.next.next;
                a =a.next;
            }

            if(b==last)
                return a.data;
            else
                return a.next.data;
                       //a.next.data if odd number element present.
        }

    
}

