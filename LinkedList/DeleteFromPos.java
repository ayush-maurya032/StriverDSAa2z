import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DeleteFromPos {
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
        Node ans = delete(head, 4);
        printList(ans);

    }

    static Node delete(Node head, int x) {
        // code here

        if (head == null) {
            return null;
        }
        if (x <= 0) {
            System.out.println("Position must be >= 1");
            return head;
        }

        int l = length(head);

        if (x > l) {
            return null;
        }
        if (x == 1) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        Node prev = head;
        for (int i = 1; i < x - 1 && prev != null; i++) {

            prev = prev.next;

        }

        // if pos is invalid

        if (prev == null || prev.next == null) {
            System.out.println("Invalid position");
            return head;
        }

        Node toDelete = prev.next;
        prev.next = toDelete.next;
        toDelete.next = null;

        return head;

    }

    static int length(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}