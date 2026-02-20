public class DoublyLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    
    public static void addfirst(int data){
        Node newNode = new Node(data);
        //base case
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        newNode.prev = null;

    }
    public static void display(){
        if(head == null){
            System.out.println("ll is empty");
            return;
        }
        //Node temp = head;
        // while (temp != null) {
        //     System.out.print(temp.data + " <-> ");
        //     temp = temp.next;
        // }
        // System.out.print("null");
        // System.out.println();
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data +"<->");
            temp = temp.prev;
        }
        System.out.print("null");
        System.out.println();

    }
    public static int removeLast(){
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if(size == 1){
            head = tail = null;
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        
        tail = tail.prev;
        tail.next = null;
        return val;
    }
    public static void main(String[] args) {
        addfirst(4);
        addfirst(3);
        addfirst(2);
        addfirst(1);

        display();
        System.out.println(removeLast());
        display();
    }
}