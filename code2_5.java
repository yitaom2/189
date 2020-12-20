public class code2_5 {
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
        LinkedListNode head1 = new LinkedListNode(1);
        LinkedListNode head2 = new LinkedListNode(5);
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        Integer[] test1 = {2,3,4};
        Integer[] test2 = {6,7};
        for (Integer elem : test1) {
            node1.next = new LinkedListNode(elem);
            node1 = node1.next;
        }
        for (Integer elem : test2) {
            node2.next = new LinkedListNode(elem);
            node2 = node2.next;
        }
        add(head1, head2);
    }

    public static void add(LinkedListNode node1, LinkedListNode node2) {
        Index record = new Index(0);

        LinkedListNode It1 = node1;
        LinkedListNode It2 = node2;
        Integer toPad = 0;
        Integer numToPad = 0;
        while (It1 != null || It2 != null) {
            if (It1 == null) {
                toPad = 1;
                numToPad += 1;
            }
            if (It2 == null) {
                toPad = 2;
                numToPad += 1;
            }
            It2 = It2 == null ? null : It2.next;
            It1 = It1 == null ? null : It1.next;
        }
        LinkedListNode padNode = toPad == 1 ? node1 : node2;
        LinkedListNode noPadNode = toPad == 1 ? node2 : node1;
        while (numToPad > 0) {
            LinkedListNode current = new LinkedListNode(0);
            current.next = padNode;
            padNode = current;
            numToPad--;
        }

        LinkedListNode result = Helper(padNode, noPadNode, record);
        if (record.value == 1) {
            LinkedListNode current = new LinkedListNode(1);
            current.next = result;
            result = current;
        }
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    public static LinkedListNode Helper(LinkedListNode node1, LinkedListNode node2, Index record) {
        if (node1 == null && node2 == null) {
            return null;
        }
        LinkedListNode more = Helper(
            node1 == null ? null : node1.next,
            node2 == null ? null : node2.next,
            record
        );
        Integer value = record.value;
        if (node1 != null) value += node1.value;
        if (node2 != null) value += node2.value;
        LinkedListNode current = new LinkedListNode(value % 10);
        current.next = more;
        if (value >= 10) {
            record.value = 1;
        } else {
            record.value = 0;
        }
        return current;
    }
}