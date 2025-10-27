import java.util.*;
public class ArrayListClass {

    public static void printReverse(ArrayList<String> arr){
         for(int i=arr.size() -1;i>=0;i--){
            System.out.print(arr.get(i) + " ");
        }
    }
    public static int arrListMax(ArrayList<Integer> arr){
        int maxNum = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            if(maxNum <= arr.get(i)){
                maxNum = arr.get(i);
            }
        }
        return maxNum;
    }
    public static void swapTwoNum(ArrayList<Integer> arr, int idx1,int idx2){
        if(idx1 > arr.size()-1 ||  idx2 > arr.size()-1){
            System.out.println("Invalid index values");
            return;
        }
        int temp = arr.get(idx1);
        arr.set(idx1, idx2);
        arr.set(idx2, temp);
    }
    public static int trapRainWater(ArrayList<Integer> arr){
        int maxWater = Integer.MIN_VALUE;
        for(int i=0; i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                int minH = Math.min(arr.get(i), arr.get(j));
                int wid = j-i;
                int waterlevel = minH * wid;
                if(waterlevel > maxWater){
                    maxWater = waterlevel;
                }
            }
        }
        return maxWater;
    }

    public static int rainWaterOptimized(ArrayList<Integer> height){
        int pt1 = 0; int pt2 = height.size()-1;
        int maxWater = Integer.MIN_VALUE;
        while (pt1 <= pt2) {
            int minH = Math.min(height.get(pt1), height.get(pt2));
            int wid = pt2 - pt1;
            int waterlevel = minH * wid;
            maxWater = Math.max(maxWater, waterlevel);
            if(height.get(pt1) > height.get(pt2)){
                pt2 = pt2-1;
            }else{
                pt1 = pt1+1;
            }
        }   
        return maxWater;
    }
    public static Boolean brutePairSum(ArrayList<Integer> list, int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if((list.get(i) + list.get(j)) == target){
                    return true;
                }
            }
        }
        return false;
    }
    public static Boolean optimizedPairSum(ArrayList<Integer> list, int target){
        int pt1 = 0; int pt2 = list.size()-1;
        while (pt1<pt2) {
            int leftVal = list.get(pt1); 
            int rightVal = list.get(pt2);
            if((leftVal + rightVal) == target){
                return true;
            }if((leftVal + rightVal) > target){
                pt2 = pt2-1;
            }else{
                pt1 = pt1+1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<Integer> newArr = new ArrayList<>();


        newArr.add(1);
        newArr.add(2);
        newArr.add(3);
        newArr.add(4);
        newArr.add(5);
        newArr.add(6);
        newArr.add(7);
        newArr.add(8);
        // newArr.get(0);
        // int start = 0; int end = newArr.size()-1;
        // while (start < end) {
        //     int temp = newArr.get(start);
        //     newArr.set(start,newArr.get(end));
        //     newArr.set(end,temp);
        //     start++;
        //     end--;
        // }
        

        // System.out.println(newArr.remove(2));
        // swapTwoNum(newArr, 1, 3);
        // System.out.println((newArr));
        // Collections.sort(newArr);
        // System.out.println((newArr));
        // Collections.sort(newArr, Collections.reverseOrder());
        System.out.println(optimizedPairSum(newArr, 16));
    }
}
