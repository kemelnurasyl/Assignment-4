import java.util.*;

public class DijkstraShortestPath {

    static class Edge {
        String destination;
        int weight;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        String city;
        int distance;

        Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private Map<String, List<Edge>> graph;

    public DijkstraShortestPath() {
        graph = new HashMap<>();

        addEdge("Edinburgh", "Glasgow", 70);
        addEdge("Edinburgh", "Stirling", 50);
        addEdge("Edinburgh", "Perth", 100);
        addEdge("Glasgow", "Stirling", 50);
        addEdge("Stirling", "Perth", 40);
        addEdge("Perth", "Dundee", 60);
    }

    private void addEdge(String source, String destination, int weight) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());

        graph.get(source).add(new Edge(destination, weight));
        graph.get(destination).add(new Edge(source, weight));
    }

    public void dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }

        distances.put(start, 0);
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentCity = currentNode.city;

            if (currentNode.distance > distances.get(currentCity)) {
                continue;
            }

            for (Edge edge : graph.get(currentCity)) {
                int newDistance = distances.get(currentCity) + edge.weight;

                if (newDistance < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDistance);
                    previous.put(edge.destination, currentCity);
                    priorityQueue.add(new Node(edge.destination, newDistance));
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        System.out.println("Task 5 – Dijkstra's Algorithm Implementation");
        System.out.println("Shortest path from " + start + " to " + end + ":");
        System.out.println(String.join(" -> ", path));
        System.out.println("Total distance: " + distances.get(end));
    }

    public static void main(String[] args) {
        DijkstraShortestPath shortestPath = new DijkstraShortestPath();

        shortestPath.dijkstra("Edinburgh", "Dundee");
    }
}