import dsa.LinkedListPractice;
import dsa.ListNode;
import dsa.RecursionPractice;

public class Main {
    public static void main(String[] arg) {
      //RecursionPractice obj = new RecursionPractice();
      //System.out.println("Result: "+ obj.sampleFunc(3));
      LinkedListPractice obj = new LinkedListPractice();
      int[] arr = new int[]{1,2,3,4};
      ListNode head = obj.createLinkedList(arr);
      obj.printLinkedList(head);
     // obj.reverseLinkedList(head);
      //ListNode middleNode = obj.middleNode(head);
      //obj.printLinkedList(middleNode);
      //System.out.println("Middle node of the List is: "+ middleNode.value);
      obj.createCycle(head, 2);
      //System.out.println("Is this linkedlist has a cycle: "+ obj.isCycle(head));
      ListNode cycleNode = obj.detectCycleNode(head);
      System.out.println("Cyclic Node: "+ cycleNode.value);
    }


  
}
