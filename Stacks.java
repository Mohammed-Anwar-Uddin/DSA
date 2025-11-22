import java.util.*;
public class Stacks {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
        return;
    }
    public static void print(Stack<Integer> s){
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static String reverseString(String s){
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            stack.push(s.charAt(idx));
            idx++;
        }
        StringBuilder reverse = new StringBuilder("");
        while (!stack.empty()) {
            reverse.append(stack.pop());
        }
        return reverse.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currentHeight = stocks[i];
            while (!s.isEmpty() && currentHeight > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i+1;
            }else{
                int top = s.peek();
                span[i] = i - top;
            }
            s.push(i);
        }
    }
    public static void nextGreater(int arr[], int greaterElems[]){
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                greaterElems[i] = -1;
            }else{
                greaterElems[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static Boolean validParentheses(String s){
        Stack<Character> st = new Stack<>(); 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek() == '(' && ch != ')' || st.peek() == '{' && ch != '}' || st.peek() == '[' && ch != ']'){
                    return false;
                }
                st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static Boolean duplicateParentheses(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count = count+1;
                }
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) { 
        // System.out.println(validParentheses("[({()})"));
        System.out.println(duplicateParentheses("((a+b))"));
        
        
        // int allElems[] = {6,8,0,1,3};
        // int greaterElems[] = new int[allElems.length];
        // nextGreater(allElems, greaterElems);
        // for(int i=0;i<greaterElems.length;i++){
        //     System.out.println(greaterElems[i]);
        // }
        
        // System.out.println(reverseString("car"));
        // int stocks[] = {100, 80, 60,70,60,85,100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0;i<span.length;i++){
        //     System.out.println(span[i]);
        // }
        // Stack<Integer> s = new Stack<>();
        // s.push(10);
        // s.push(11);
        // s.push(12);
        // s.push(13);
        // // pushAtBottom(s, 15);
        // print(s);
        // reverseStack(s);
    }
}
