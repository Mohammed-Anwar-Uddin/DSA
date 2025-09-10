// import java.util.*;

public class Strings {
    public static boolean palindrome(String str){
        for (int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length() - 1-i)){
                return false;
            }
        }
        return true;
    }
    public static float shortestPath(String path){
        int y=0,x=0;
        for (int i=0;i<path.length();i++){
            char dir = path.charAt(i);
            if(dir == 'S'){
                y--;
            }
            else if(dir == 'N'){
                y++;
            }
            else if(dir == 'W'){
                x--;
            }else{
                x++;
            }
        }
        int Y2 = y*y;
        int X2 = x*x;
        return (float)Math.sqrt(X2 + Y2);
    }
    public static void largestString(String str[]){
        String largest = str[0];
        for(int i=0;i<str.length;i++){
            if(largest.compareTo(str[i]) < 0){
                largest = str[i];
            }
        }
        System.out.println("Largest String is " + largest);
    }
    public static String strUpperCase(String str){
        String str2[] = str.split(" ");
        String newStr = "";
        for(int i=0;i<str2.length;i++){
            char firstChar = Character.toUpperCase(str2[i].charAt(0));
            newStr += firstChar + str2[i].substring(1)+" ";
        }
        return newStr;
    }
    public static StringBuilder stringCompression(StringBuilder str){
        StringBuilder newStr = new StringBuilder("");
        for(int i=0;i<str.length();i++){
            int count = 1;
            while (i < str.length()-1 && str.charAt(i) == str.charAt(i + 1))  {
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(count > 1){
                newStr.append(count);
            }
        }
        return newStr;
    }
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // String str1 = new String("Hello worlddddd");
        // String str = sc.nextLine();
        // System.out.println(str);
        // System.out.println(str1.length());
        // char ch = sc.next();

        // String str[] = {"apple", "mango", "banana", "watermelon"};
        StringBuilder str = new StringBuilder("abbbccddd");
        System.out.println(stringCompression(str));
    }
}
