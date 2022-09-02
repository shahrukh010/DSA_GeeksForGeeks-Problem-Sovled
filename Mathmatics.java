
public class Mathmatics {

    public static int power(int x,int n){

        if(n==0)return 1;

        int tmp = power(x,n/2);
            tmp = tmp*tmp;

            if(n%2==0)return tmp;
            else
                return tmp*x;
    }

    public static int factorial(int n){

        if(n==0)return 1;

        return n*(factorial(n-1));
    }

static    java.util.function.Predicate<Integer> palindrome = (number)->{

        int input = number;

        int result = 0;
        while(input !=0){

            result = result*10+input%10;
            input = input/10;
        }
       return result==number;
    };


       


    //trailing zero;
    static java.util.function.Function<Integer,Integer>trail = (number)->{

        if(number<=19){

        int input = factorial(number);
        int count = 0;

        while(input%10==0){
            count++;
            input = input/10;
        }
       return count;
        }

        int result=0;
        for(int i=5;i<=number;i=i*5){

            result = result+number/i;
        }
        return result;
    };




    //GCD

    static java.util.function.BiFunction<Integer,Integer,Integer>gcd = (a,b)->{

        while(a!=b){

            if(a>b)
                a=a-b;
            else
                b = b-a;
        }
        return a;
    };


    //LCM
    static java.util.function.BiFunction<Integer,Integer,Integer>lcm=(a,b)->{

            int result = Math.max(a,b);

            while(true){

                if(result%a==0 && result %b==0)
                    return result;
                result++;
            }
    };

    static java.util.function.Predicate<Integer> isprime = (n)->{


/*
        for(int i=2;i*i<=n;i++){

            if(n%i ==0)return false;
        }
 */

        //more efficent

        if(n==2 || n==3)return true;

        if(n%2==0 || n%3==0)return false;

        for(int i=5;i*i<=n;i=i+6){

            if(n%i==0 || (n%(i+2))==0)return false;
        }
        return true;
    };

    static java.util.function.Consumer<Integer> sieve = (n)->{

        boolean[] b = new boolean[n+1];
        for(int i=2;i<=n/2;i++){

            if(isprime.test(i)){

                for(int j=2*i;j<=n;j=j+i){

                    b[j] = true;
                }
            }
        }
        for(int i=2;i<=n;i++){

            if(b[i] == false)System.out.println(i);
        }
    };


    static java.util.function.Consumer<Integer> allDivisor = (input)->{
        
            int i=0;
        for(i=1;i*i<input;i++){

            if(input %i==0)System.out.print(i+",");
        }
        for(;i>=1;i--)if(input%i==0)System.out.print(input/i+",");
        System.out.println();
    };


    static java.util.function.Consumer<Integer> primefactor = (input)->{

        for(int i=2;i*i<=input;i++){

            if(isprime.test(i)){

                int x = i;
                while(input%x==0){
                    System.out.print(i+",");
                    x = x*i;
                }
            }
        }
        System.out.println();
    };





    public static void main(String...strings){

        System.out.println(power(3,5));
        System.out.println("---------------");
        System.out.println(isprime.test(2));
        System.out.println("---------------");
                sieve.accept(10);
        System.out.println("---------------");
                sieve.accept(23);
        System.out.println("---------------");
                allDivisor.accept(15);
                allDivisor.accept(100);
        System.out.println("---------------");
                primefactor.accept(12);
                primefactor.accept(315);
                primefactor.accept(450);
        System.out.println("---------------");
        System.out.println(lcm.apply(4,6));
        System.out.println(lcm.apply(12,15));
        System.out.println("---------------");
        System.out.println(gcd.apply(12,15));
        System.out.println(gcd.apply(100,200));
        System.out.println("---------------");
        System.out.println(factorial(19));
        System.out.println("---------------");
        System.out.println(trail.apply(29));
        System.out.println(trail.apply(251));
        System.out.println("---------------");
        System.out.println(palindrome.test(121));
        System.out.println(palindrome.test(4553));

       

    }
}
