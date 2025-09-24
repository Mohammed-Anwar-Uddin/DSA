public class LinkedList {
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
            
        }

    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);
        // ll.removeNthFromEnd(3);
        ll.print();
        ll.llPalindrome();
        // ll.print();
    }
}