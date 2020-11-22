import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(findMinHeightTrees(6, edges));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }

        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        if (leaves.size() == 0) {
            return result;
        }

        while (n > 2) {
            n = n - leaves.size();

            LinkedList<Integer> newLeaves = new LinkedList<Integer>();

            for (int l : leaves) {
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}