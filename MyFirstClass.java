import java.util.*;

public class MyFirstClass {

    public static int factorial(int n){
        int f = 1;
        for (int i=1;i<=n;i++){
            f *= i;
        }
        return f;
    }
    public static int binaryToDecimal(int binaryNum){
        int pow = 0;
        int dec = 0;
        while(binaryNum > 0){
            int lastDgt = binaryNum % 10;
            dec = dec + (lastDgt * (int)Math.pow(2, pow));
            pow++;
            binaryNum /= 10;
        }
        return dec;
    }
    public static int decimalToBinary(int n){
        int pow = 0;
        int decimal = 0;

        while (n > 0) {
            int remainder = n % 2;
            System.out.println(remainder);
            decimal = decimal + (remainder * (int)Math.pow(10, pow));
            pow++;
            n = n/2;
        }
        return decimal;
    }
    public static void printHollowRectangle(int rows, int cols){
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(i==1 || i == rows || j == 1 || j == cols){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void printInvertedHalfPyramid(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void printInvertedHalfpyramidwithNumbers(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void printFloydTraingle(int n){
        int count = 1;
        for(int i=1; i<=n; i++){
            if(count >= n) break;
            for (int j=1;j<=i;j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }
    public static void zeroOneTrainglePattern(int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                if((i+j) % 2 == 0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    public static void butterflyPattern(int n){
        for (int i=1;i<=n;i++){

          for (int row = 1; row <= 1; row++) {
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
            for(int k=1; k<=(n-i)*2;k++){
                System.out.print(" ");
            }
            for(int l=1; l<=i;l++){
                System.out.print("*");
            }
        }

         
                System.out.println();

        }
                for (int i=1;i<=n;i++){
                     for (int row = 1; row <= 1; row++) {
            for(int j=1; j<=n-i;j++){
                System.out.print("*");
            }
            for(int k=1; k<=(i-1)*2+2;k++){
                System.out.print(" ");
            }
            for(int l=1; l<=n-i;l++){
                System.out.print("*");
            }
        }
        System.out.println();
    }

    }
    public static void solidRhombus(int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=(n-i)+1;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || i ==n || j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void diamondPattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void numbersPyramid(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(" "+ i);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        butterflyPattern(7);

        

        sc.close();
    }
}



