import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtAGivenPosition {
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
        Node ans = insert(head, 3, 3);
        printList(head);

    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node insert(Node head, int index, int data) {

        // edge cases
        Node temp = head;
        if (head == null) {
            return null;
        }
        int cnt = 0;
        while (temp != null) {
            cnt++;

            temp = temp.next;
        }

        if (index > cnt) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        for (int i = 1; i < index; i++) {
            prev = curr;
            curr = curr.next;

        }
        Node newNode = new Node(data);
        newNode.next = curr;
        prev.next = newNode;

        return head;
    }
}