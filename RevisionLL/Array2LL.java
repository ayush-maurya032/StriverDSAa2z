class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Array2LL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 7, 8, 3, 0 };
        Node head = convert(arr);
        printLL(head);

    }

    public static Node convert(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;

    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --->");
            temp = temp.next;

        }
        System.out.println("null");
    }
}