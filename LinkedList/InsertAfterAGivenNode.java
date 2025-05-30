
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;

    }
}

public class InsertAfterAGivenNode {
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        printList(head);
        int key = 3;
        int newData = 4;
        Node ans = insert(head, key, newData);
        printList(head);
    }


    static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " " );
            temp = temp.next;
        }
        System.out.println();
    }


    public static Node insert(Node head, int key, int newData){


        // Special case: if the key is at the head
        if (head == null) {
            return null;
        }
        if (head.data == key) {
            Node newNode = new Node(newData);
            head.next = newNode;
            return head;

        }



        Node temp = head;
        while(temp != null && temp.data != key){
            temp = temp.next;
        }

        Node newNode = new Node(newData);
        newNode.next = temp.next;
        temp.next = newNode;


        return head;
    }



}