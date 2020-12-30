import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class code4_2 {
    public class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode<Integer> createMinBst(ArrayList<Integer> nodes) {
        return createMinBst(nodes, 0, nodes.size() - 1);
    }

    public TreeNode<Integer> createMinBst(ArrayList<Integer> nodes, int start, int end) {
        if (end < start) return null;
        int mid = (start + end) / 2;
        TreeNode<Integer> root = new TreeNode<>(nodes.get(mid), null, null);
        root.left = createMinBst(nodes, start, mid - 1);
        root.right = createMinBst(nodes, mid + 1, end);
        return root;
    }

    @Test
    public void test() {
        TreeNode<Integer> result = createMinBst(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8)));
        System.out.printf("%d %d %d", result.value, result.left.value, result.right.value);
    }
}