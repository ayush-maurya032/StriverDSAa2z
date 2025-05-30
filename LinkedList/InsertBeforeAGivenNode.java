class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class InsertBeforeAGivenNode {
    public static void main(String[] args) {
    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    printList(head);
    int key = 5;
    int newData = 4;
    Node ans = insert(head, key, newData);
    printList(ans);
    }
    
    static void printList(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    public static Node insert(Node head, int key, int newData){
      
      
    if (head == null) {
        return null;
    }

    if (head.data == key) {
        Node newNode = new Node(newData);
        newNode.next = head;
        return newNode;
    }


    Node curr = head;
    Node prev = null;


    while(curr != null && curr.data != key){
        prev = curr;
        curr = curr.next;
    }

    Node newNode = new Node(newData);
    newNode.next = curr;
    prev.next = newNode;

    return head;
     
    }

}