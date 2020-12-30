import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class code4_1 {
    public class GraphNode<T> {
        T value;
        ArrayList<GraphNode<T>> neighbors;

        public GraphNode(T value, ArrayList<GraphNode<T>> neighbors) {
            this.value = value;
            this.neighbors = neighbors;
        }
    }

    public boolean Dfs(GraphNode<String> start, String end) {
        HashSet<GraphNode<String>> visited = new HashSet<>();
        return helper(start, end, visited);
    }

    public boolean helper(GraphNode<String> cur, String target, HashSet<GraphNode<String>> visited) {
        if (cur.value.equals(target)) {
            return true;
        }
        visited.add(cur);
        for (GraphNode<String> neighbor : cur.neighbors) {
            if (!visited.contains(neighbor) && helper(neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        GraphNode<String> e = new GraphNode("e", new ArrayList<GraphNode>());
        GraphNode<String> d = new GraphNode("d", new ArrayList<GraphNode>());
        GraphNode<String> c = new GraphNode("c", new ArrayList<GraphNode>());
        GraphNode<String> b = new GraphNode("b", new ArrayList<GraphNode>(Arrays.asList(d, c)));
        GraphNode<String> a = new GraphNode("a", new ArrayList<GraphNode>(Arrays.asList(b)));

        boolean result1 = Dfs(a,"d");
        boolean result2 = Dfs(a,"e");
        System.out.printf("True: %b, False: %b",result1, result2);
    }
}