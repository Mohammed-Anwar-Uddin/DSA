import java.util.*;
public class LinkedListTemp {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
    }
    public void add(int index, int data){
        if(size == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int idx = 0;
        while (idx < index) {
            temp = head.next;
            idx++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = head;
        head = temp.next;
        temp.next = null;
        size--;
        return temp.data;
    }
    public int removeLast(){
        if(size ==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for (int i=0;i<size-2;i++){
            prev = prev.next;
        }
        tail = prev;
        prev.next = null;
        size--;
        return 1;
    }
    public int findIndex(int data){
        Node temp = head;
        for (int i=0;i<size;i++){
            if(temp.data == data){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public int helper(int data, Node head){
        if(head == null){
            return -1;
        }
        if(head.data == data){
            return 0;
        }
        int idx = helper(data, head.next);

        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int findIndexRecurssive(int data){
        return helper(data, head);
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next; 
        }
        head = prev;
    }
    public void removeNthFromEnd(int n){
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size = size+1;
        }
        if(n == size){
            head = head.next;
            return;
        }
        int index = 1;
        int idxToFind = size-n;
        Node prev = head;
        while (index < idxToFind) {
            prev = prev.next;
            index++;
        }
        prev.next = prev.next.next;
        return;
    }
    public Node middlNode(Node head){
        int idx = 0;
        Node mid = head;
        while (idx < size/2) {
            mid = mid.next;
            idx = idx+1;
        }
        return mid;
    }
    public void llPalindrome(){
        Node mid = middlNode(head);

        //reverse
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        Node left = prev;
        Node right = head;
        while (left != null) {
            if(left.data != right.data){
                System.out.println("Not A valid Palindrome");
                return ;
            }
            left = left.next;
            right = right.next;
        }
        System.out.println("It is a palindrome");
        return;
    }
    public static Boolean isCycle(){
        Node slow = head; Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        Node slow = head; Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                Node prev = slow;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                    prev = slow;
                }
                prev.next = null;
            }
        }
    }
    public static void zigZagLL(){
        Node slow = head; Node fast = head;
        Node mid;
        //finding mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        //reverse
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftNode = head;
        Node righNode = prev;
        Node tempNode;
        Node tempRight;
        //assigning
        //1->2->3->4
        while (righNode != null && righNode.next != null) {
            tempNode = leftNode.next;
            tempRight = righNode.next;
            leftNode.next = righNode;
            righNode.next = tempNode;
            leftNode = tempNode;
            righNode = tempRight;
        }
        
    }
    public void deleteMNodesN(int n, int m){
        Node temp = head;
        int idx = 1;
        while (temp != null && temp.next != null) {
            if(idx == n){
                Node mNodes = temp;
                int midx = 0;
                while (midx <= m && mNodes != null) {
                    mNodes = mNodes.next;
                    midx++;
                }
                temp.next = mNodes;
                idx = 0;
            }
            temp = temp.next;
            idx++;
        }
    }
    public static class Stack {
        static Node head = null;
        public void push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public Boolean isEmpty(){
            return head == null;
        }
        public int pop(){
            if(head == null) {
                return Integer.MIN_VALUE;
            }
            int val = head.data;
            head = head.next;
            return val;
        }
        public int peek(){
            if(head == null) {
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());

        // LinkedList<Integer> head = new LinkedList<>();
        // head.add(9);
        // head.addFirst(10);
        // head.addLast(11);
        // head.addLast(12);
        // LinkedListTemp ll = new LinkedListTemp();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.addLast(9);
        // ll.addLast(10);
        // ll.deleteMNodesN(3, 2);
        // ll.print();
    }
}



// head = new Node(1);
//         Node temp = new Node(2);
//         head.next = temp;
//         head.next.next = new Node(3);
//         head.next.next.next = temp;
//         // ll.removeNthFromEnd(3);
//         // ll.print();
//         // ll.llPalindrome();
//         System.out.println(isCycle());
//         removeCycle();
//         System.out.println(isCycle());
        // ll.print();