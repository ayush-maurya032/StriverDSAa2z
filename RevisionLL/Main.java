
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes");
        int noOfNodes = Sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < noOfNodes; i++) {
            System.out.println("Enter the " + (i + 1) + " node value");
            Node temp = new Node(Sc.nextInt());

            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }
}