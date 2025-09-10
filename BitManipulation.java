// import java.util.*;
public class BitManipulation {
    public static void binaryToDec(int n){
        int dec = 0;
        int pow = 0;
       while (n >0) {
        int lastDgt = n %10;
        dec = dec + ( lastDgt * (int)Math.pow(2, pow));
        pow++;
        n/=10;
       }
        System.out.println("rev String is " + dec);
    }
    public static void main(String[] args) {
        System.out.println(6 & 7);
    }
}
