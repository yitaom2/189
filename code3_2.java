import org.junit.*;

public class code3_2 {
    public class NodeWithMin {
        int value;
        int min;
        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public class MyStack<T> {
        private class StackNode<T> {
            private T value;
            private StackNode next;

            private StackNode(T value, StackNode next) {
                this.value = value;
                this.next = next;
            }
        }

        private StackNode<T> top;

        public void push(T v) {
            StackNode<T> newNode = new StackNode<T>(v, this.top);
            top = newNode;
        }

        public T pop() throws Exception {
            if (top == null) {
                throw new Exception();
            }
            StackNode<T> retNode = top;
            top = top.next;
            return retNode.value;
        }

        public T peek() throws Exception {
            if (top == null) {
                throw  new Exception();
            }
            return top.value;
        }

        public Boolean isEmpty() {
            if (top == null) return true;
            return false;
        }
    }

    public class MyStackRevised extends MyStack<NodeWithMin> {
        public void push(int v) throws Exception {
            int minVal = Math.min(v, min());
            super.push(new NodeWithMin(v, minVal));
        }

        public int min() throws Exception {
            if (isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return peek().min;
        }
    }

    @Test
    public void tester() throws Exception {
        MyStackRevised test = new MyStackRevised();
        test.push(3);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
        test.push(1);
        System.out.println(test.min());
        test.pop();
        System.out.println(test.min());
    }
}