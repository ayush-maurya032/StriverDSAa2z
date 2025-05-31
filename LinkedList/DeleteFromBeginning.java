import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFromBeginning {
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
        Node ans = delete(head);
        printList(ans);
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node delete(Node head) {

        if (head == null)
            return null;

        // Store the current head in a temporary variable
        Node temp = head;

        // Move the head pointer to the next node
        head = head.next;

        // Help the garbage collector by
        // removing the reference
        temp.next = null;
        temp = null;

        return head;

    }

}