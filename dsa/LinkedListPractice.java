package dsa;


public class LinkedListPractice {
    public ListNode createLinkedList(int[] arr){
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public void printLinkedList(ListNode head){
        ListNode current = head;
        while(current != null){
             System.out.print(current.value+" -> ");
             current = current.next;
        }
        System.out.println("null");
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    public void createCycle(ListNode head, int pos) {
        if (head == null) return;

        ListNode temp = head;
        ListNode cycleNode = null;
        int index = 0;

        while (temp.next != null) {
            if (index == pos) {
                cycleNode = temp;
            }
            temp = temp.next;
            index++;
        }

        // connect last node to cycleNode
        if (cycleNode != null) {
            temp.next = cycleNode;
        }
    }

    public ListNode detectCycleNode(ListNode head){
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while(ptr1 != ptr2){
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }

        return null;
    }
}
