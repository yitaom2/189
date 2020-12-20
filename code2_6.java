import java.util.Stack;

public class code2_6 {
    public static class LinkedListNode {
        Integer value;
        LinkedListNode next;
        public LinkedListNode(Integer a) {
            this.value = a;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode node = head;
        Integer[] test = {1,2,3,2,1,0};
        for (Integer elem : test) {
            node.next = new LinkedListNode(elem);
            node = node.next;
        }
        Wrapper(head);
    }

    public static void Wrapper(LinkedListNode node) {
        Stack<Integer> record = new Stack<>();
        LinkedListNode It1 = node;
        LinkedListNode It2 = node.next;

        Boolean odd = false;
        while (It2 != null) {
            record.push(It1.value);
            It1 = It1.next;
            if (It2.next != null) {
                odd = true;
            } else {
                odd = false;
            }
            It2 = It2.next == null ? null : It2.next.next;
        }
        if (odd == true) It1 = It1.next;

        while (It1 != null) {
            Integer v1 = record.pop();
            Integer v2 = It1.value;
            if (v1 != v2) {
                System.out.println(false);
                return;
            }
            It1 = It1.next;
        }
        System.out.println(true);
    }
}