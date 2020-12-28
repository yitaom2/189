import org.junit.Test;

import java.util.ArrayList;

public class code3_3 {
    public class My_stack<T> {
        private class stack_node<T> {
            T value;
            stack_node next;
            public stack_node(T value, stack_node next) {
                this.value = value;
                this.next = next;
            }
        }

        private stack_node<T> top;

        public T pop() throws Exception {
            if (this.top == null) {
                throw new Exception();
            }
            stack_node<T> temp = top;
            top = top.next;
            return temp.value;
        }

        public void push(T v) {
            stack_node curr = new stack_node(v, top);
            top = curr;
        }

        public T peek() throws Exception {
            if (this.top == null) {
                throw new Exception();
            }
            return this.top.value;
        }

        public Boolean isEmpty() {
            if (top == null) return true;
            return false;
        }
    }

    public class SetOfStack extends My_stack<Integer> {
        int threshold;
        ArrayList<My_stack<Integer>> store = new ArrayList<>();
        int stack_counter;
        int height_counter;

        public SetOfStack(int threshold) {
            this.threshold = threshold;
            this.stack_counter = 0;
            this.height_counter = 0;
        }

        public Integer pop() throws Exception {
            if (this.isEmpty()) {
                throw new Exception();
            }
            if (height_counter == 0) {
                stack_counter--;
                height_counter = this.threshold - 1;
                return store.get(stack_counter).pop();
            } else {
                height_counter--;
                return store.get(stack_counter).pop();
            }
        }

        public void push(Integer v) {
            if (height_counter == threshold) {
                stack_counter++;
                height_counter = 0;
            }
            if (height_counter == 0) {
                store.add(new My_stack<Integer>());
            }
            store.get(stack_counter).push(v);
            height_counter++;
        }

        public Boolean isEmpty() {
            if (stack_counter == 0 && store.get(stack_counter).isEmpty()) return true;
            return false;
        }
    }

    @Test
    public void test() throws Exception {
        SetOfStack test = new SetOfStack(2);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}