public class code2_2 {
    public static class LinkedListNode {
        Integer value;
        LinkedListNode next;
        public LinkedListNode(Integer a) {
            this.value = a;
            this.next = null;
        }
    }

    public static class Index {
        Integer value;
        public Index(Integer a) {
            this.value = a;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode node = head;
        for (int i = 1; i < 10; i ++) {
            node.next = new LinkedListNode(i);
            node = node.next;
        }
        Integer k = 3;
        kLastNode(head, k);
    }

    public static void kLastNode(LinkedListNode node, Integer k) {
        Index count = new Index(0);
        LinkedListNode back = Helper(node, count, k);
        System.out.println(back.value);
    }

    public static LinkedListNode Helper(LinkedListNode node, Index count, Integer k) {
        if (node == null) {
            return null;
        }
        LinkedListNode back = Helper(node.next, count, k);
        count.value = count.value + 1;
        if (count.value == k) {
            return node;
        }
        return back;
    }
}