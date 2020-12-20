import java.util.ArrayList;
import java.util.List;

public class code2_4 {
    public static class LinkedListNode {
        Integer value;
        LinkedListNode next;
        public LinkedListNode(Integer a) {
            this.value = a;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        LinkedListNode node = head;
        Integer[] test = {5,8,5,10,2,1};
        for (Integer elem : test) {
            node.next = new LinkedListNode(elem);
            node = node.next;
        }
        split(head, 5);
    }

    public static void split(LinkedListNode node, Integer k) {
        LinkedListNode smallerHead = new LinkedListNode(Integer.MIN_VALUE);
        LinkedListNode biggerHead = new LinkedListNode(Integer.MAX_VALUE);

        LinkedListNode smallerIt = smallerHead;
        LinkedListNode biggerIt = biggerHead;

        while (node != null) {
            if (node.value < k) {
                smallerIt.next = node;
                smallerIt = smallerIt.next;
            } else {
                biggerIt.next = node;
                biggerIt = biggerIt.next;
            }
            node = node.next;
        }

        biggerIt.next = null;
        smallerIt.next = biggerHead.next;
        smallerHead = smallerHead.next;
        while (smallerHead != null) {
            System.out.println(smallerHead.value);
            smallerHead = smallerHead.next;
        }
    }
}