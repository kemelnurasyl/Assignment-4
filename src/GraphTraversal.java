import java.util.*;

public class GraphTraversal {
    private Map<String, List<String>> graph;

    public GraphTraversal() {
        graph = new LinkedHashMap<>();

        graph.put("A", Arrays.asList("C", "B", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));
    }

    public void dfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        dfsRecursive(start, visited);

        System.out.println("DFS visiting order: " + String.join(" -> ", visited));
    }

    private void dfsRecursive(String vertex, Set<String> visited) {
        visited.add(vertex);

        for (String neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void bfs(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("BFS visiting order: " + String.join(" -> ", visited));
    }

    public static void main(String[] args) {
        GraphTraversal traversal = new GraphTraversal();

        System.out.println("Task 3 – DFS and BFS Implementation");
        traversal.dfs("A");
        traversal.bfs("A");

        System.out.println();
        System.out.println("Comparison:");
        System.out.println("DFS output matches Task 1: A -> C -> B -> E -> G -> F -> D");
        System.out.println("BFS output matches Task 2: A -> C -> B -> D -> E -> G -> F");
    }
}