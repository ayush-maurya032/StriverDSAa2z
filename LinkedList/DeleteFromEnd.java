import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DeleteFromEnd {
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
        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
            

        }
        prev.next = null;
        temp = null;
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