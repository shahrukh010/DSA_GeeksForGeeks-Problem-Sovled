
public class Array{

        
        final static private int capacity;
        static{
            capacity=10;
              }

        final private int[] array;
        private  int size;

        public Array(){
            array = new int[capacity];
        }

        public Array(int capacity){

            array = new int[capacity];
        }

        public int getSize(){
            return size;
        }

    
// Integer array find subarray sum which is equilivent to given sum -ve,+ve both cases works

//it takes o(n2)
       java.util.function.BiFunction<int[],Integer,Boolean> isEqual = (input,max)->{

            
               int n = input.length;
            for(int i=0;i<n;i++){
                    
                    int current_sum = input[i];
                for(int j=i+1;j<n;j++){

                    if(current_sum == max)return true;//for if user single value available inside array

                    current_sum +=input[j];

                    if(current_sum == max)return true;
                }
            }
            return false;
       };
//optimize solution of maxsubarray is equal or not//this solution work only poisitve number 

        java.util.function.BiFunction<int[],Integer,Boolean>isequal = (input,max)->{

                int n = input.length;
                int current_sum = input[0];
            for(int i=1;i<n;i++){

                if(input[i] !=max){
               if(current_sum<max){
                    current_sum +=input[i];
                }
                }
                else{
                    current_sum=input[i];
                    break;
                }
            }
            
            for(int j=0;j<n;j++){
                
                if(current_sum > max){
                    
                    current_sum -=input[j];
                }

                if(current_sum<max)return false;
                if(current_sum ==max)return true;
            }
            return false;
        };


//it takes O(n2)
      static java.util.function.BiFunction<int[],Integer,Integer>maxSumKth=(input,k)->{

            int n = input.length;
            int result = 0;
            int current_max = 0;
            for(int i=0;i+k-1<n;i++){

                    int current_sum = 0;
                for(int j=0;j<k;j++){

                    current_sum +=input[j+i];
                    current_max = Math.max(current_sum,result);
                }
                result = Math.max(current_max,result);
            }
            return result;
          };
//optimize solution of maxSubsum

    java.util.function.BiFunction<int[],Integer,Integer>maxsumSubarray = (input,k)->{

            int current_sum = 0;
            int result = input[0];
            int n = input.length;
        for(int i=0;i<k;i++){

            current_sum +=input[i];
        }

        for(int j=k;j<n;j++){

            current_sum +=input[j] - input[j-k];
            result = Math.max(current_sum,result);
        }
        return result;
    };
    
       static java.util.function.Consumer<int[]> flips =(input)->{

        int n = input.length;

        for(int i=1;i<n;i++){

            if(input[i] !=input[i-1]){

                if(input[i] !=input[0]){
                    System.out.print(i+",");
                }
                else{
                    System.out.println(i-1+",");
                }
            }

        }
            if(input[n-1] !=input[0])System.out.println(n-1);

       };

        static java.util.function.Function<int[],Integer> me = (input)->{

                int n = input.length;
                int count = 0;
            for(int i=0;i<n;i++){

                for(int j=i+1;j<n;j++){

                    if(input[i] == input[j])
                        count++;
                }

                if(count>n/2)return i;
                }
                return -1;
        };

//it takes 2n==O(n)optimize solution
    static java.util.function.Function<int[],Integer> majority = (input)->{

        int n = input.length;
        int result = 0;
        int count  = 1;

        //find candidate element

        for(int i=1;i<n;i++){

            if(input[result] == input[i]){
                count++;
            }
            else{
                count--;
            }

            if(count==0){
                count=1;
                result=i;
            }

        }

            count =0;
        for(int i=0;i<n;i++){
            if(input[result] == input[i])
                count++;
        }
        if(count<=n/2)return -1;
        return result;
    };

    static java.util.function.Function<int[],Integer>maxSumCircularArray = (input)->{

        int n = input.length;
        int current_max = input[0];
        int result = 0;
        for(int i=0;i<n;i++){

            int current_sum = input[i];
            for(int j=1;j<n;j++){

                int index = (i+j)%n;

                current_sum = current_sum + input[index];
                current_max = Math.max(current_sum,current_max);
            }

             result = Math.max(result,current_max);
        }
        return result;
    };

//it takes O(n2)
    java.util.function.Function<int[],Integer> lenOfOddEven = (input)->{

            int n = input.length;
            int result = 1;
            int current=1;

            for(int i=0;i<n-1;i++){

                    current = 1;
               for(int j=i+1;j<n;j++){
                if(input[j]%2==0 && input[j-1]%2!=0||
                   input[j]%2!=0 && input[j-1]%2==0){
                    current++;
                }
                else
                    break;
            }
            result = Math.max(current,result);
            }
            return result;
    };


    //optimze solution of lenOfOddEven

    java.util.function.Function<int[],Integer> lenOfEvenOdd = (input)->{

            
            int n = input.length;
            int result = 0;
            int current=1;

            for(int i=1;i<n;i++){
                
                if(input[i]%2==0 && input[i-1]%2!=0||input[i]%2 !=0 && input[i-1]%2==0){

                    current++;
                    result = Math.max(result,current);
                }
                else
                current = 1;
            }
            return result;
    };

//it takes O(n2)
        java.util.function.Function<int[],Integer> maxSubarray = (input)->{

                int n=input.length;
                int current = 0;
                int result  = 0;
            for(int i=0;i<n;i++){

                current = 0;

                for(int j=i;j<n;j++){

                    current = current+input[j];
                    result  = Math.max(current,result);
                }
            }
            return result;
        };
//optimize of subarraysum

    java.util.function.Function<int[],Integer>subarraymaxsum = (input)->{

            
                int n = input.length;
            int maxending = input[0];
            int result    = input[0];

            for(int i=1;i<n;i++){

                maxending  = Math.max(maxending + input[i],input[i]);
                result     = Math.max(maxending, result);
            }
            return result;
    };


//it takes O(n2)
        java.util.function.Function<int[],Integer> maximumwater = (input)->{

            int n = input.length;
            int leftMax  = 0;
            int rightMax = 0;
            int result   = 0;
            
            for(int i=1;i<n-1;i++){

                leftMax = input[i];
                for(int j=0;j<i;j++){
                    
                    leftMax = Math.max(leftMax,input[j]);
                }

                rightMax = input[i];
                for(int j=i;j<n;j++){

                    rightMax = Math.max(rightMax,input[j]);
                }

                result = result+(Math.min(leftMax,rightMax)-input[i]);
                
            }
            return result;

        };

        java.util.function.Function<int[],Integer>maxWaterContained = (input)->{


                    int n = input.length;
                    int result = 0;

                  int leftMax[] = new int[n]; 
                  int rightMax[]= new int[n];

                  leftMax[0] = input[0];

                  for(int i=1;i<n;i++){

                      leftMax[i] = Math.max(leftMax[i-1],input[i]);
                  }

                  rightMax[n-1] = input[n-1];

                  for(int i=n-2;i>=0;i--){

                      rightMax[i] = Math.max(input[i],rightMax[i+1]);
                  }

                  for(int i=1;i<n-1;i++){

                    result = result+(Math.min(leftMax[i],rightMax[i])-input[i]);
                  }
                  return result;
        };

        java.util.function.Function<int[],Integer> byStockSell = (stock)->{

            int profit = 0;
            for(int i=1;i<stock.length;i++){

                      if(stock[i] > stock[i-1])
                 profit +=stock[i]  - stock[i-1];
            }
            return profit;
        };


        //given input must be sorted//forunsorted better to use hashmap
        java.util.function.Consumer<int[]>frequence = (input)->{

                int freq=0;
            for(int i=0;i<input.length;i++){

                int j=i;
                while(j<input.length && input[i] == input[j]){
                    j++;
                    freq++;
                }
                System.out.println(input[i]+"--->"+freq);
                i=j-1;
                freq=0;
            }
        };

        static java.util.function.Function<int[],Integer> maxDiff = (input)->{

               int curr_max = Integer.MIN_VALUE; 
               int prev_max = Integer.MIN_VALUE;
            for(int i=0;i<input.length-2;i++){

                for(int j=i+1;j<i+3;j++){

                    curr_max = Math.max(curr_max,input[j] - input[i]);
                    if(curr_max>prev_max)prev_max = curr_max;
                }
            }
            return prev_max;

        };

       static java.util.function.Function<int[],Integer> maxdiff = (input)->{

                int max = Integer.MIN_VALUE;
           for(int i=0;i<input.length-1;i++){

               for(int j=i+1;j<input.length;j++){
                
                 max = Math.max(max,input[j] - input[i]);
                    
               }
           }
           
               return max;
           };


//other approach to do it rotate problem
        private void leftRotateByOne(int[]input){

            int length = input.length;
            int tmp = input[0];

            for(int i=1;i<length;i++){
                input[i-1] = input[i];
            }
            input[length-1] = tmp;
        }

    java.util.function.BiConsumer<int[],Integer>leftRotateByD = (input,d)->{

            for(int i=0;i<d;i++){
                leftRotateByOne(input);
            }
    };

        public void leader(int[]input){

            for(int i=0;i<input.length;i++){
                boolean flag = false;

                for(int j=i+1;j<input.length-1;j++){

                    if(input[i] <=input[j]){
                        flag = true;
                        break;
                    }
                }
                if(flag == false)System.out.println(input[i]+",");
            }
        }
//optimize solution of leader problem

    public void showLeader(int[]input){

            System.out.println(input[input.length-1]);
            int current_leader = input[input.length-1];

            for(int i=input.length-2;i>=0;i--){

                    if(input[i] > current_leader){
                        current_leader = input[i];
                        System.out.println(current_leader);
                    }
            }
    }
                        

        public void leftShift(int[]input,int d){

            for(int i=0;i<d;i++){

                rotate(input,input[0]);
            }
        }

        private void rotate(int[]input,int value){

                
                    int i=0;
                for(i=0;i<input.length-1;i++){
                    input[i] = input[i+1];
                }
                input[i] = value;

        }


//optimize rotate O(n)space O(n)

        public void leftRotate(int[]input,int d){

            int tmp[] = new int[d];
            int n = input.length;

            for(int i=0;i<d;i++){
                tmp[i] = input[i];
            }

            for(int i=d;i<n;i++){
                input[i-d] = input[i];
            }
            for(int i=0;i<d;i++){
                input[n-d+i] = tmp[i];
            }
        }


       java.util.function.Function<int[],int[]>movezero = (input)->{

           for(int i=0;i<input.length;i++){

               if(input[i] == 0){
                   int j=i;
                   while(j<input.length-1 && input[j] == 0)j++;

                   int tmp=input[i];
                       input[i] = input[j];
                       input[j] = tmp;
               }
           }
           return input;
       };



//optimize solution O(n)
        java.util.function.Function<int[],int[]>moveZero = (input)->{

                    int count=0;
            for(int i=0;i<input.length;i++){

                if(input[i] !=0){

                    int tmp = input[i];
                        input[i] = input[count];
                        input[count] = tmp;
                    count++;
                }
            }
            return input;
        };

        java.util.function.Function<int[],int[]>remove = (input)->{

            int result = 1;

            for(int i=1;i<input.length;i++){

                if(input[i] !=input[result-1])
                    input[result++] = input[i];
            }
            return input;
        };

        java.util.function.Function<int[],int[]> reverse = (input)->{

            int j = input.length-1;
            int i = 0;

            while(i<j){

                int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                    i++;
                    j--;
            }

            return input;

        };

        java.util.function.Function<int[],Boolean> isSort = (input)->{

            for(int i=0;i<input.length-1;i++){

                if(input[i] > input[i+1])return false;
            }
            return true;
        };

        public int secondLargest(int[]input){

            int max=input[0];
            int min=-1;

            for(int i=0;i<input.length;i++){

                if(input[i]>max)max=input[i];
            }

            for(int i=0;i<input.length;i++){

                if(input[i]<max && min < input[i])
                    min = input[i];
            }
            return min;
        }
        //optimize solution of second largest

        public int secondLarge(int[]input){

           int result=-1;
           int largest=0;

           for(int i=1;i<input.length;i++){

               if(input[i] > input[largest]){
                   result = largest;
                   largest=i;
               }
               else if(input[i] !=input[largest]){

                   if(result==-1 || input[i]>input[result])
                       result = i;
               }
           }
           return input[result];
        }
        public String maxMin(int[]input){

            int min = input[0];
            int max = input[0];
            int[] minmax = new int[2];
            for(int i=1;i<input.length;i++){

                if(input[i] > max)
                    max = input[i];
                else if(min>input[i])
                    min = input[i];
            }
            return max+","+min;
        }

        public int remove(int value){

                int i=0;
            for(i=0;i<size;i++){
                if(array[i] == value)
                    break;
            }
            if(i==size)return -1;

            for(int j=i;j<size;j++){

                array[j] = array[j+1];
            }
            array[size-1]=0;
            size--;
            return value;

        }


        public void addAt(int value,int pos){

               int index = pos-1;
            for(int i=size;i>=pos;i--){

                array[i] = array[i-1];
            }
            array[index] = value;
            size++;
        }


        public void addAsc(int value){
                
                int i=0;
            for(i=0;i<size;i++){

                if(array[i]>value)
                    break;
            }

            for(int j=size;j>i;j--){
                array[j] = array[j-1];
            }
            array[i] = value;
            size++;
        }

        public void add(int value){

            array[size++] = value;
        }

        public String toString(){

            int[] item = java.util.Arrays.copyOfRange(array,0,size);
            return java.util.Arrays.toString(item)+"";
        }

        public static void main(String...strings){

            Array arr = new Array();
                  
/*
                  arr.add(5);
                  arr.add(7);
                  arr.add(9);
                  arr.addAt(2,2);
                  arr.addAt(8,3);
                  arr.addAt(10,5);
                  arr.addAt(1,1);
*/
                  arr.addAsc(3);
                  arr.addAsc(4);
                  arr.addAsc(2);
                  arr.addAsc(1);
                  arr.addAsc(5);
                  arr.addAsc(2);
           System.out.println(arr);

           //here println contain ternary operator if element present then removed print otherwise -1
           System.out.println(arr.remove(4)!=-1?4+" remove":-1);
           System.out.println(arr.remove(1)!=-1?1+" remove":-1);
           System.out.println(arr.remove(5)!=-1?5+" remove":-1);
           System.out.println(arr.remove(2)!=-1?2+" remove":-1);
           System.out.println(arr.remove(12)!=-1?2+" remove":-1);

           System.out.println("***************************************");
           System.out.println(arr);
           int[] a = {10,5,20,8,12,19};
           System.out.println(arr.getSize());
           System.out.println(arr.maxMin(a));
           System.out.println("***************************************");
           System.out.println(arr.secondLargest(a));
           System.out.println(arr.secondLarge(a));
           System.out.println("***************************************");
           System.out.println(arr.isSort.apply(a));
               //int[] b = {4,6,8,9,20,26};
               int[] b = {4};
           System.out.println(arr.isSort.apply(b));
           System.out.println("***************************************");
           int[] c = {10,5,7,30};
           for(int x:arr.reverse.apply(c)){
               System.out.print(x+",");
           }
           System.out.println();
           System.out.println("***************************************");

            int[] d = {10,20,20,30,30,40,50};
           for(int x:arr.remove.apply(d)){
               System.out.print(x+",");
           }
           System.out.println();
           System.out.println("***************************************");
           int[] e = {10,8,0,0,12,0,0,11};

           for(int x:arr.moveZero.apply(e))System.out.print(x+",");
           System.out.println();
           System.out.println("***************************************");
           for(int x:arr.movezero.apply(e))System.out.print(x+",");
           System.out.println();
           System.out.println("***************************************");

            int[] f = {1,2,3,4,5};
           arr.leftShift(f,4);
           System.out.println(java.util.Arrays.toString(f));
           System.out.println("***************************************");
           int[] g = {10,20,30,40,50};
           arr.leftRotate(g,2);
           System.out.println(java.util.Arrays.toString(g));
           System.out.println("***************************************");
           int[] h = {7,10,4,10,6,5,2};
                    arr.leader(h);
           System.out.println("***************************************");
                    arr.showLeader(h);
           System.out.println("***************************************");
           int[] i = {1,2,3,4,5,6,7,8};

                    arr.leftRotateByD.accept(i,3);
                    System.out.println(java.util.Arrays.toString(i));

           System.out.println("***************************************");
           int[] j={2,3,10,6,4,8,1};
           System.out.println(maxDiff.apply(j));
           int[] k={7,9,5,6,3,2};
           System.out.println(maxdiff.apply(k));
           System.out.println("***************************************");
           int[] l = {10,10,10,30,40,40,50,50};
           arr.frequence.accept(l);

           System.out.println("***************************************");
           int[] m = {1,5,3,8,12};
            System.out.println(arr.byStockSell.apply(m));


            int[] n = {3,0,2,0,4};
           System.out.println("***************************************");

            System.out.println(arr.maximumwater.apply(n));
            int[] o = {0,1,0,2,1,0,1,3,2,1,2,1};
            System.out.println(arr.maximumwater.apply(o));
            System.out.println(arr.maxWaterContained.apply(o));
            System.out.println(arr.maxWaterContained.apply(n));
//           int[] p = {1,-2,3,-1,2};
//           int[] p = {-2,1,-3,4,-1,2,1,-5,4};
             int[] p = {3,-4,5,6,-8,7};
           System.out.println("***************************************");
            System.out.println(arr.maxSubarray.apply(p)+"-->");
            System.out.println(arr.subarraymaxsum.apply(p));

            int[] q = {7,10,13,14};
           System.out.println("***************************************");
//            int[] r = {10,12,14,7,8};
//          int[] r = {5,10,20,6,3,8};
          int[] r = {5,-2,3,4};
            System.out.println(arr.lenOfOddEven.apply(q));
//            System.out.println(arr.lenOfOddEven.apply(r));
            System.out.println(arr.lenOfEvenOdd.apply(q));

            //int[] s = {3,-4,5,6,-8,7};
            //int[] s = {-8,7,6};
            int[] s = {2,3,-4};
           System.out.println("***************************************");
            System.out.println(maxSumCircularArray.apply(s));

            //int[] t = {6,8,7,6,6};
              int[]    t = {6,4,8,8,4};         
           System.out.println("***************************************");
                System.out.println(majority.apply(t)==-1?-1:"exists");
                System.out.println(me.apply(t)==-1?-1:"exists");
           System.out.println("***************************************");

           //int[] u = {0,0,1,1,0,0,1,1,0};
           int[] u = {0,0,1,1,0,0,1,1,0,1};
            flips.accept(u);
           System.out.println("***************************************");
           int[] v = {1,8,30,-5,20,7};
           System.out.println(maxSumKth.apply(v,1));
          System.out.println(arr.maxsumSubarray.apply(v,1));

     //       int[] w = {1,4,20,3,10,5};
            //int   w[] = {1, 4, 0, 0, 3, 10, 5}; 
            int   w[] = {1, 4};
           System.out.println("***************************************");
           System.out.println(arr.isEqual.apply(w,0)==true?true:false);
           System.out.println(arr.isequal.apply(w,0));
           

        }
}





