class Node {
    
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LengthOfLL {
public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(11);
    head.next.next = new Node(111);
    head.next.next.next = new Node(2712);
    System.out.println(length(head));
    
}

    static int length(Node head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}