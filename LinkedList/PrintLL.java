
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class PrintLL {
    public static void main(String[] args) {
        // Create a linked list: 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        printList(head);
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.println();
    }
}