
public class LinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // asuming there was no node intially
        Node newNode = new Node(data);
        size++;
        if(head == null){
           head = tail = newNode;
           return;
        }
        //step 2 - newNode next = head
        newNode.next = head;
        // step 3 - 
        head = newNode;
    }
    public void addLast(int data){
        // create a node by assuing there is no node intially
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //assuming there was a node existing
        tail.next = newNode;
        tail = newNode;
    }
    public void add(int data, int idx){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        
        if(head == null){
            head = tail = newNode;
            return;
        }
        while (i < idx -1) {
            temp = temp.next;  
            i++;      
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.data;
    }
    public static int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        for(int i = 0; i< size-2; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }
    //search iteratively
    // public static int search(int key){
    //     int i = 0;
    //     Node temp = head;
    //     while (temp != null) {
    //         if(temp.data == key){
    //             return i;
    //         }
    //         temp = temp.next;
    //         i++;
    //     }
    //     return -1;
    // }
    // search recusrively
    public static boolean searchRec(Node head, int key){
        Node temp = head;
        //base case
        if(temp == null){
            return false;
        }
        if(temp.data == key){
            return true;
        };
        return searchRec(temp.next, key);
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(0);   
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(10);
        ll.addLast(12);
        ll.add(8,3);
        ll.add(50,0);
        display();
        System.out.println();
        System.out.println("remove element: " + removeFirst());
        System.out.println("Size of linked list is: "+ size);
        System.out.println("remove last element: " + removeLast());
        System.out.println("Size of linked list is: "+ size);
        //System.out.println(search(8));
        System.out.println(searchRec(head,50));
        display();

    }
}
