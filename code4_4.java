import org.junit.Test;

public class code4_4 {
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

    public class ResultWrapper {
        Boolean result;
        int height;

        public ResultWrapper(Boolean result, int height) {
            this.result = result;
            this.height = height;
        }
    }

    public ResultWrapper CheckBalanced(TreeNode<String> root) {
        if (root == null) {
            return new ResultWrapper(true, 0);
        }
        ResultWrapper leftChild = CheckBalanced(root.left);
        if (leftChild.result == false) {
            return leftChild;
        }
        ResultWrapper rightChild = CheckBalanced(root.right);
        if (rightChild.result == false) {
            return rightChild;
        }
        if (leftChild.height - rightChild.height > 1 || rightChild.height - leftChild.height > 1) {
            return new ResultWrapper(false, 0);
        }
        return new ResultWrapper(true, Math.max(leftChild.height, rightChild.height) + 1);
    }

    @Test
    public void test() {
        TreeNode<String> root = new TreeNode<>("a", new TreeNode<>("b", new TreeNode<>("c", null, null), null), new TreeNode<>("d", null, null));
        ResultWrapper rt = CheckBalanced(root);
        System.out.printf("%b %d", rt.result, rt.height);
    }
}