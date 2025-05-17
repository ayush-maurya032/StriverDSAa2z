//package LinkedList;

class Node {
    int data;
    Node next;

    Node() {
        data = 0;
    }

    Node(int d) {
        data = d;
    } // constructor to create a new node
}

public class Array2LL {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Node head = constructLL(arr);
        printLinkedList(head);
    }

    static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    static Node constructLL(int arr[]) {
        // code here
        if (arr.length == 0)
            return null;

        // creating the head of the linked list
        Node head = new Node(arr[0]);
        Node cur = head;

        // adding elements to the linked list
        for (int i = 1; i < arr.length; i++) {
            Node tmp = new Node(arr[i]);
            cur.next = tmp;
            cur = tmp;
        }

        // returning the head of the linked list
        return head;
    }
}