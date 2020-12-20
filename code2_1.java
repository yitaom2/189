import java.util.HashSet;

public class code2_1 {
    public static class LinkedListNode {
        Integer value;
        LinkedListNode next;
        public LinkedListNode(Integer a) {
            this.value = a;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode node = head;
        for (int i = 0; i < 10; i ++) {
            node.next = new LinkedListNode(i);
            node = node.next;
        }
        remDup(head);
    }

    public static void remDup(LinkedListNode node) {
        HashSet<Integer> record = new HashSet<>();
        LinkedListNode head = node;
        LinkedListNode prev = null;
        while (node != null) {
            if (record.contains(node.value)) {
                prev.next = node.next;
            } else {
                record.add(node.value);
            }
            prev = node;
            node = node.next;
        }
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}