import org.junit.Test;

public class code3_5 {
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

    public void SortStack(MyStack<Integer> myStack) throws Exception {
        MyStack<Integer> tempStack = new MyStack<Integer>();
        while (!myStack.isEmpty()) {
            Integer toPush = myStack.pop();
            int count = 0;
            while (!tempStack.isEmpty()) {
                Integer toCompare = tempStack.peek();
                if (toCompare <= toPush) {
                    break;
                } else {
                    myStack.push(tempStack.pop());
                    count++;
                }
            }
            tempStack.push(toPush);
            while (count > 0) {
                tempStack.push(myStack.pop());
                count--;
            }
        }

        while (!tempStack.isEmpty()) {
            myStack.push(tempStack.pop());
        }
    }

    @Test
    public void test() throws Exception {
        MyStack<Integer> test = new MyStack<>();
        test.push(5);
        test.push(7);
        test.push(3);
        test.push(2);
        test.push(10);
        test.push(2);
        test.push(4);
        SortStack(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}