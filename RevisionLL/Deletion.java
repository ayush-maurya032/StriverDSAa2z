class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Deletion {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
            printLL(removeHead(head));
            printLL(removeTail(head));
            printLL(deleteK(head, 3));
            printLL(deleteK(head, 1));
            printLL(deleteK(head, 4));

    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Deleting head...
    public static Node removeHead(Node head) {
        if (head == null)
            return null;
        head = head.next;
        return head;
    }
    // Deleting Tail...
    public static Node removeTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    //Deleting at Position k
    public static Node deleteK(Node head, int k){
        if(head == null) return head;
        if(k == 1){
            head = head.next;
            return head;
        }

        Node temp = head;
        int cnt = 0;
        Node prev = null;
        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}