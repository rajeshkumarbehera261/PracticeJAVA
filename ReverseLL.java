public class ReverseLL {
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
    public static int size = 0;

    public static void addFisrtend(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }    
    public static void addEndSide(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public static void reverseIteratievly(){
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
    
    
    public static int deleteNode(int val){
        //case 1
        if(size == 0){
            System.out.println("ll is emepty nothing to delete");
            return Integer.MIN_VALUE;
        }
        //case 2
        if(head.data == val){
            int value = head.data;
            head = head.next;
            size--;
            if(head == null){
                tail = null;
            }
            return value;
        }
        //case 3
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if(temp.data == val){
                prev.next = temp.next;
                if(temp == tail){
                    tail = prev;
                }
                size--;
                return val;
            }
            prev = temp;
            temp = temp.next;

        }
        return -1;
    }
    // public static boolean isPalindrome(){
    //     Node sn = head;
    //     Node en = tail;
    //     //Edge case
    //     if(sn == en){
    //         return true;
    //     }
    //     while (sn != en && sn != null && en != null) {
    //         if(sn.data != en.data){
    //             return false;
    //         }
    //         sn = sn.next;
    //         en = getPrevNode(en);
    //     }
    //     return true;
    // }

    public static Node midNode(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // get mid value
        Node mid = midNode();
        //reverse 2nd part
        Node prev = null;
        Node curNode = mid;
        Node next;
        while (curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        Node rightHead = prev;
        Node leftHead = head;
        //checking data are same or not
        while (rightHead != null) {
            if(leftHead.data != rightHead.data){
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true;
    }
    
    public static Node getPrevNode(Node node){
        Node temp = head;
        while (temp != null && temp.next != node) {
            temp = temp.next;
        }
        return temp;
    }
    public static void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void deleteFromEnd(int idx){
        //get size of ll
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if(idx == sz){
            head = head.next;
            return;
        }
        // delete step by getting previous node
        int i =1;
        int n = sz -idx; // 1->2->3->4->6
        Node prev = head;
        while (i< n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    public static void main(String[] args) {
     
        addEndSide(0);
        addEndSide(2);
        addEndSide(0);
        addEndSide(4);
        addFisrtend(4);
        display();
        System.out.println();
        //System.out.println(isPalindrome());
        //System.out.println(isPalindrome());
        //System.out.println(deleteNode(-1));
        //reverseIteratievly();
        deleteFromEnd(4);
        display();


    }
}
