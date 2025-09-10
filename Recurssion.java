public class Recurssion {
    public static void printNNumbersDecreasing(int num){
        System.out.println(num);
        if(num == 1){
            return;
        }
        printNNumbersDecreasing(num - 1);

    }
    public static void printNNumbersIncreasing(int num){
        if(num == 1){
            System.out.println(num);
            return;
        }
        printNNumbersIncreasing(num-1);
        System.out.println(num);
    }
    public static int printfibbonaci(int num){
        if(num == 0){
            return 1;
        }
        int fnm1 = printfibbonaci(num -1);
        int fb = num * fnm1;
        return fb;
    }
    public static int printNaturalSum(int num){
        if (num == 1) {
            return 1;
        }
        int snm1 = printNaturalSum(num-1);
        int sum = num + snm1;
        return sum;
    }
    public static int printFibbonaciN(int num){
        if(num == 1 || num == 0){
            return num;
        }
        int fnm1 = printFibbonaciN(num -1); 
        int fnm2 = printFibbonaciN(num -2); 
        int fb = fnm1 + fnm2;
        return fb;
    }
    public static boolean arraySorted(int num[], int n){
        if(n==num.length -1){
            return true;
        }
        if(num[n]>num[n+1]){
            return false;
        }
        return arraySorted(num, n+1);
    }
    public static int firstOccurence(int num[], int key, int i){
        if(i == num.length-1){
            return -1;
        }
        if(num[i] == key){
            return i;
        }
        return firstOccurence(num, key, i+1);
    }
    public static int lastOccurence(int num[], int key, int i){
        if(i == num.length){
            return -1;
        }
        int isFound = lastOccurence(num, key, i+1);
        if(isFound == -1 && num[i]==key){
            return i;
        }
        return isFound;
    }
    public static int xPowerN(int x, int pow){
        if(pow == 0){
            return 1;
        }
        int xnm1 = xPowerN(x, pow -1);
        return x * xnm1;
    }
    public static int powerOptimise(int x, int pow){
        if(pow == 0){
            return 1;
        }
        int powSquare = powerOptimise(x, pow/2);
        int powSqrt = powSquare * powSquare;
        if(pow %2 != 0){
            powSqrt = x * powSqrt;
        }
        return powSqrt;
    }
    public static int tilingProblem(int n){
        if(n == 0 || n==1){
            return 1;
        }
        int tnm1 = tilingProblem(n -1);
        int tnm2 = tilingProblem(n -2);
        return tnm1 + tnm2;
    }
    public static void duplicateString(String str, int i, StringBuilder newStr, boolean map[]){
        if (i == str.length()-1) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(i);
        if(map[currChar -'a'] == true){
            duplicateString(str, i+1, newStr, map);
        }else{
            map[currChar -'a'] = true;
            duplicateString(str, i+1, newStr.append(currChar), map);
        }
    }
    public static int friendsParing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int fnm1 = friendsParing(n-1);
        int fnm2 = friendsParing(n-2);
        int pairWays = (n-1) * fnm2;
        return pairWays + fnm1;
    }
    public static void binaryStringPairs(int n, int lastPlace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binaryStringPairs(n-1, 0, str+"0");
        if(lastPlace == 0){
            binaryStringPairs(n-1, 1, str+"1");
        }
    }
    
    public static void main(String[] args) {
        binaryStringPairs(3,0,new String());
    }
}