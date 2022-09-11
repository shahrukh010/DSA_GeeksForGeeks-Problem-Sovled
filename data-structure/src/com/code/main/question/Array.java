package com.sunday.array;
import java.util.Arrays;

interface List{

    public void insert(int item);
    public int delete(int item);
//  public int search(int[]input,int value);
    
    //aux operation
    public void  missing(int[]input);
    public void arrange(int[]input);
    public void rotate(String input,int times);
}

public class Array implements List {
    
    private int[] array;
    private static int nElemns;

    public Array(int capacity){

        array = new int[capacity];
    }

    private int binarySearch(int[]input,int value){

        int left=0;
        int right=nElemns-1;
        int mid = 0;

        while(left <= right){

            mid = ((left + right)/2);

            if(input[mid] == value)
                return mid;
            else if(input[mid] < value)
                left = mid+1;
            else if(input[mid] > value)
                right = mid-1;
        }
        return -1;
    }

    public static int size(){
        return nElemns;
    }

    public void insert(int value){
            int i=0;
            int j=0;
        for(i=0; i<nElemns;i++){
            if(array[i] > value)
                break;
         }

        for(j=nElemns+1;j>i;j--){
            array[j] = array[j-1];
        }

        array[i] = value;
        nElemns++;
    }

    public int delete(int value){

        int found = binarySearch(array,value);
        int deleted = 0;
        try{
        deleted = array[found];
        }catch(IndexOutOfBoundsException e){
            System.out.println("IllegalArgumentException");
            System.exit(1);
        }

        for(int i = found; i < size(); i++)
                array[i] = array[i+1];
           array[size()-1] = 0;
           nElemns--;

       return deleted;
    }



    public String toString(){
        
        int[] item = Arrays.copyOfRange(array,0,nElemns);
        return Arrays.toString(item);
    }
    public void  missing(int[]input){

        int diff = input[0];
        boolean flag = false;

        for(int index = 1; index < input.length; index++)
        {
            if(input[index] - index !=diff){

                while(diff < input[index]-index){
                    System.out.print(diff + index+" ");
                    diff++;
                    flag = false;
                }
                if(flag)
                    System.out.println(diff + index);
            }
        }
    }

    public void arrange(int[]input){

        int left = 0;
        int right= input.length-1;

    while(left < right) {
        while(input[left] < 0)
            left++;
        while(input[right]>0)
            right--;

        if(left < right){
            int tmp = input[left];
            input[left++] = input[right];
            input[right--]= tmp;
        }
    }

       for(int e : input)
           System.out.print(e+" ");

       System.out.println();
    }
    private int[] swap(int[]input,int left,int right){

        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
        return input;
    }

    public void rotate(String input,int times){

        char[] character = input.toCharArray();

            for(int i=0;i<times; i++)
                rotateCharacter(character,0/**0 passing each time because of rotateing each character from 0 onward**/);

        for(int i =0;i<input.length();i++)
            System.out.print(character[i]+" ");

            System.out.println();

    }
    private static void rotateCharacter(char[]input,int move){

        int i = 0;
        char ch = input[move];

        for(i = 0; i < input.length-1;i++)
            input[i] = input[i+1];

          input[i] = ch;
    }


}
