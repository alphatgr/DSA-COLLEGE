import java.util.*;

public class DijkstraAlgorithm {
    static final int INF = Integer.MAX_VALUE;

    static class Graph {
        int V;
        int[][] adjMatrix;

        Graph(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
            for (int i = 0; i < V; i++) {
                Arrays.fill(adjMatrix[i], INF);
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjMatrix[src][dest] = weight;
            adjMatrix[dest][src] = weight; // For undirected graph
        }

        void dijkstra(int src) {
            int[] dist = new int[V];
            boolean[] visited = new boolean[V];
            PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(node -> node.dist));

            Arrays.fill(dist, INF);
            dist[src] = 0;
            pq.add(new Node(src, 0));

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int u = node.vertex;

                if (visited[u]) continue;
                visited[u] = true;

                for (int v = 0; v < V; v++) {
                    if (!visited[v] && adjMatrix[u][v] != INF && dist[u] + adjMatrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + adjMatrix[u][v];
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }

            printSolution(dist, src);
        }

        void printSolution(int[] dist, int src) {
            System.out.println("Vertex \t Distance from Source " + src);
            for (int i = 0; i < V; i++) {
                if (dist[i] == INF) {
                    System.out.println(i + " \t\t " + "INF");
                } else {
                    System.out.println(i + " \t\t " + dist[i]);
                }
            }
        }

        static class Node {
            int vertex, dist;

            Node(int vertex, int dist) {
                this.vertex = vertex;
                this.dist = dist;
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);

        // Adding edges to the graph
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        graph.dijkstra(0); // Find shortest paths from vertex 0
    }
}
