public class practice{
    public static int factorialRecurssive(int num){
        if(num < 0){
            return 0;
        }
        if(num == 0 || num == 1){
            return 1;
        }

        return num * factorialRecurssive(num-1);
    }
    public static int fibonacciRecurssive(int num){
        if(num == 1 || num == 0){
            return 1;
        }
        int nm1 =  fibonacciRecurssive( num -1);
        int nm2 = fibonacciRecurssive(num -2);
        return nm1 + nm2;
    }
    public static void reverseStingRecurssive(String str, int index){
        if(index < 0){
            return;
        }
        System.out.print(str.charAt(index));
        reverseStingRecurssive(str, index-1);
    }
    public static int sumRecurssive(int n){
        if(n == 0){
            return n;
        }
        return n + sumRecurssive(n-1);
    }
    
    public static void main(String args[]){
        System.out.println(sumRecurssive(3));
    }
}