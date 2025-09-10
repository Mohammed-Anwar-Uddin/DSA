import java.util.*;

public class Arrays {
    public static int binarySearch(int num[], int key){
        int start=0, end=num.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if(num[mid]==key){
                return mid;
            }else if(key > num[mid]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
    public static void reverseArray(int num[]){
       int start=0, end=num.length-1;
       while (end > start) {
        int temp = num[start];
        num[start] = num[end];
        num[end] = temp;
        start++;
        end--;
       }
    }
    public static void arrayPairs(int num[]){
        for(int i=0;i<num.length;i++){
            for (int j=i+1;j<num.length;j++){
                System.out.println(num[i]+" "+ num[j]);
            }
        }
    }
    public static void printSubarrays(int num[]){
       for (int i=0;i<num.length;i++){
        for(int j=i;j<num.length;j++){
            for (int k=i;k<=j;k++){
                System.out.print(num[k] + " ");
            }
            System.out.println();
        }
        System.out.println();
       }
    }
    public static void printSubarraysprefixSum(int num[]){
        int prefix[] = new int[num.length];
        int maxsum = Integer.MIN_VALUE;
        prefix[0] = num[0];
        for(int i=1;i<num.length;i++){
            prefix[i] = prefix[i-1] + num[i];
        }
        for(int i=0;i<num.length;i++){
            int currentSum = 0;
            for(int j=i;j<num.length;j++){
                currentSum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
            }
            if(currentSum > maxsum){
                maxsum = currentSum;
            }
        }
        System.out.println("max sum is "+ maxsum);
    }
    public static void kadaneSubArraySum(int num[]){
        // int maxVal = Integer.MIN_VALUE;
        // for(int i=0;i<num.length;i++){
        //     if (num[i] < 0) {
        //         maxVal = Math.max(num[i], maxVal);
        //     }
        // }
        // if(maxVal < 0){
        //     System.out.println("max value from array is " + maxVal);
        //     return;
        // }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<num.length;i++){
            currentSum += num[i];
            if(currentSum <= 0){
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        
        System.out.println("Max sum is " + maxSum);
    }
    public static int calculateRainWater(int num[]){
        int trappedWater = 0;
        int leftMax[] = new int[num.length];
        leftMax[0] = num[0];
        for (int i=1;i<num.length;i++){
            leftMax[i] = Math.max(num[i], leftMax[i-1]);
        }
        int rightMax[] = new int[num.length];
        rightMax[num.length-1] = num[num.length-1];
        for(int i=num.length-2;i>=0;i--){
            rightMax[i] = Math.max(num[i], rightMax[i+1]);
        }

        for(int i=0;i<num.length;i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - num[i];
        }
        return trappedWater;
    }
    public static int calculateMaximunProfit(int num[]){
        int buyingPrice = num[0], maxProfit = 0;

        for(int i=1;i<num.length;i++){
            if (num[i] < buyingPrice) {
                buyingPrice = num[i];
            }
            if((num[i] - buyingPrice) > maxProfit){
                maxProfit = num[i] - buyingPrice;
            }
        }
        return maxProfit;
    }
    public static void bubbleSort(int num[]){
        for (int i=0;i<num.length-1;i++){
            for(int j=0;j<num.length-i-1;j++){
                if(num[j] < num[j+1] ){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int num[]){
        for (int i=0;i<num.length;i++){
            int minPos = i;
            for (int j=i+1;j<num.length;j++){
                if(num[minPos] < num[j]){
                    minPos = j;
                }
            }
            int temp = num[minPos];
            num[minPos] = num[i];
            num[i] = temp;
        }
    }
    public static void insertionSort(int num[]){
       for(int i=1;i<num.length;i++){
        int curr = num[i];
        int prev = i -1;
        while (prev >= 0 && num[prev] > curr) {
            num[prev+1] = num[prev];
            prev--;
        }
        num[prev+1] = curr;
       }
    }
    public static void countingSort(int num[]){
        int maxNum = Integer.MIN_VALUE;
        for (int i=0;i<num.length;i++){
            maxNum = Math.max(maxNum, num[i]);
        }
        int sumArr[] = new int[maxNum +1];
        for(int i=0;i<num.length;i++){
           sumArr[num[i]]++; 
        }
        int j=0;
        for(int i=0;i<sumArr.length;i++){
            while (sumArr[i] > 0) {
                num[j] = i;
                sumArr[i]--;
                j++;
            }
        }
    }
    public static void array2D() {
         Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        
        //print
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.println(matrix[i][j]); 
            }
        }
    }
    public static void spiralMatrix(int num[][]){
        int startRow=0,endRow=num.length,startCol=0,endCol=num[0].length -1;
        while (startRow <= endRow && startCol <=endCol) {
            for(int i=startRow;i<endCol;i++){
            System.out.println(num[startRow][i]);
            }

            for(int i=startRow;i<endRow;i++){
                System.out.println(num[i][endCol]);
            }

            for(int i=endCol -1;i>=startCol;i--){
                if(startRow == endRow){
                    break;
                }
                System.out.println(num[endRow -1][i]);
            }

            for(int i=endRow-2;i>startRow;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.println(num[i][startCol]);
            }
            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
        
     }
    public static void daignoalSum(int numm[][]){
        int maxSum = 0;
        // for(int i =0;i<numm.length;i++){
        //     for(int j=0;j<numm.length;j++){
        //         if(i == j){
        //             maxSum += numm[i][j];
        //         }
        //         else if( i+j == numm.length -1){
        //             maxSum += numm[i][j];
        //         }
        //     }
        // }
        for(int i=0;i<numm.length;i++){
            maxSum+=numm[i][i];
            if(i != numm[i][numm.length-i-1]) 
                maxSum+= numm[i][numm.length-i-1];
        }
        System.out.println("max sum is " + maxSum);
    }
    public static void sortedDaignolSum(int num[][], int key){
        int row = 0, col = num[0].length-1;
        while (row < num.length && col >= 0) {
            if(num[row][col] == key){
                System.out.println("Key found At (" + row +"," + col + ")");
                return;
            }
            else if(num[row][col] > key){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("key Not Found");
        return;
    }
    public static void reverseSortedDSum(int num[][], int key){
        int row = num.length -1, col=0;
        while (row>=0 && col<=num[0].length) {
            if(num[row][col] == key){
                System.out.println("key found at (" + row + "," + col + ")");
                return;
            }
            else if(num[row][col] > key){
                row--;
            }else{
                col++;
            }
        }
        System.out.println("key Not FOund");
        return;
    } 
    //Array Problems
    public static boolean valueRepeat(int num[]){
        // for(int i=0;i<num.length;i++){
        //     for(int j=i+1;j<num.length;j++){
        //         if(num[i]==num[j]){
        //             return true;
        //         }
        //     }
        // }
        int maxInterger = Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
            if(num[i] > maxInterger){
                maxInterger = num[i];
            }
        }
        int prefixArr[] = new int[maxInterger+1];
        for(int i=0;i<num.length;i++){
            prefixArr[num[i]]++;
        }
        for(int i=0;i<prefixArr.length;i++){
            if(prefixArr[i] == 2){
                return true;
            }
        }

        return false;
    }
    public static int halfSortBinarySearch(int num[], int key){
        int start=0, end = num.length-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if(num[mid]==key) return mid;
            if(num[start] <= num[mid]){
                if(key >= num[start] && key<num[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(key > num[mid] && key<num[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }

           
            }
        return -1;
    }
   
    public static void main(String[] args){
        int numbers[][] = {{10,20,30,40},
                           {15,25,35,45},        
                           {27,29,37,48},
                           {32,33,39,50}};
        int num[] = {4,5,6,7,0,1,2};
        System.out.println(halfSortBinarySearch(num, 1));
    // reverseSortedDSum(numbers, 10);
    
        //printing a array
        // for(int i=0;i<numbers.length;i++){
        //     System.out.print(numbers[i] + " ");
        // }
    }
}