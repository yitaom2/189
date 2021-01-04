import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class code4_7 {
    public class GraphNode<T> {
        T value;
        ArrayList<GraphNode<T>> children = new ArrayList<>();
        Integer preOrder;
        Integer postOrder;

        public GraphNode(T value) {
            this.value = value;
        }
    }

    @Test
    public void test() {
        ArrayList<Character> projects = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
        ArrayList<Pair<Character, Character>> dependencies = new ArrayList<>(
                Arrays.asList(new Pair<>('a', 'd'), new Pair<>('f', 'b'), new Pair<>('b', 'd'), new Pair<>('f', 'a'), new Pair<>('d', 'c')));
        ArrayList<Character> result = Dfs(projects, dependencies);
        if (result == null) {
            System.out.println("No order");
        } else {
            for (Character proj : result) {
                System.out.print(proj + " ");
            }
        }
    }

    public ArrayList<Character> Dfs(ArrayList<Character> projects, ArrayList<Pair<Character, Character>> dependencies) {
        // initialize graph
        HashMap<Character, GraphNode<Character>> graph = new HashMap<>();
        for (Character proj : projects) {
            graph.put(proj, new GraphNode<Character>(proj));
        }
        for (Pair<Character, Character> edge : dependencies) {
            GraphNode<Character> startNode = graph.get(edge.getKey());
            GraphNode<Character> endNode = graph.get(edge.getValue());
            startNode.children.add(endNode);
        }
        // traverse graph to build timestamp
        int clock = 0;
        for (Character proj : projects) {
            if (graph.get(proj).preOrder == null) {
                clock = traverseGraph(graph, proj, clock);
            }
        }
        // determine if cycle exist
        for (Pair<Character, Character> edge : dependencies) {
            GraphNode<Character> startNode = graph.get(edge.getKey());
            GraphNode<Character> endNode = graph.get(edge.getValue());
            if (startNode.postOrder < endNode.postOrder) {
                return null;
            }
        }
        // use timestamp build order
        ArrayList<Character> result = new ArrayList<>();
        HashMap<Integer, Character> order = new HashMap<>();
        for (Character proj : projects) {
            order.put(clock - 1 - graph.get(proj).postOrder, proj);
        }

        for (Integer i = 0; i < clock; i++) {
            if (order.containsKey(i)) {
                result.add(order.get(i));
            }
        }

        return result;
    }

    public int traverseGraph(HashMap<Character, GraphNode<Character>> graph, Character proj, int clock) {
        GraphNode<Character> cur = graph.get(proj);
        if (cur.preOrder != null) return clock;
        cur.preOrder = clock;
//        System.out.printf("Pre %c %d\n", proj, cur.preOrder);
        clock++;
        for (GraphNode<Character> child : cur.children) {
            clock = traverseGraph(graph, child.value, clock);
        }
        cur.postOrder = clock;
//        System.out.printf("Aft %c %d\n", proj, cur.postOrder);
        clock++;
        return clock;
    }
}


