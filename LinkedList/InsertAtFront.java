class Node {
   int data;
   Node next;

   Node(int var1) {
      this.data = var1;
      this.next = null;
   }
}

public class InsertAtFront {
   public static void main(String[] args) {
      // Create a hard-coded linked list:
      // 1 -> 2 -> 3 -> 4 -> 5
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);

      int newData = 6;
      Node ans = insertAtBegining(head, newData);
      printList(ans);
   }

   static void printList(Node node) {
      Node curr = node;
      while (curr != null) {
         System.out.print(curr.data + " ---> ");
         curr = curr.next;
      }
      System.out.println();
   }

   public static Node insertAtBegining(Node head, int x) {
      // Code here
      Node temp = new Node(x);
      temp.next = head;

      return temp;
   }
}