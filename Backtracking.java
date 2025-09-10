public class Backtracking {
    public static void changeArr(int arr[], int i, int value){
        if(i == arr.length){
            printArr(arr);
            return;
        }
        arr[i] = value;
        changeArr(arr, i+1, value+1);
        arr[i] = arr[i]-2;
    }
    public static void printArr(int arr[]){
        for (int i=0; i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void printSubStr(String str, int i, String newStr){
        if(i == str.length()){
            if(newStr.length()==0){
                System.out.println("null");
            }else{
                System.out.println(newStr);
            }
            return;
        }
        printSubStr(str, i+1, newStr+str.charAt(i));
        printSubStr(str, i+1, newStr);
    }
    
    
    public static void main(String[] args) {
        String str = new String("abc");
        printSubStr(str, 0, "");
    }
}
