import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtEnd {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("enter the limit");
        int limit = Sc.nextInt();
        System.out.println("Insert the first element in ll");
        Node head = new Node(Sc.nextInt());
        Node curr = head;
        for (int i = 2; i <= limit; i++) {
            System.out.println("Enter the element number " + i);
            int value = Sc.nextInt();
            curr.next = new Node(value);
            curr = curr.next;

        }
        printList(head);
        Node ans = insert(head, 3);
        printList(head);

    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node insert(Node head, int data) {

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;

        return head;
    }
}