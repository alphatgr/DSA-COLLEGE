import java.util.*;

class Graph_bfs {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void buildGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Edge edge : graph[current]) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        buildGraph(graph);

        // Display neighbours of vertex 5
        System.out.print("Neighbours of vertex 5: ");
        for (int i = 0; i < graph[5].size(); i++) {
            System.out.print(graph[5].get(i).dest + " ");
        }
        System.out.println();

        // Perform BFS starting from vertex 0
        System.out.print("BFS traversal starting from vertex 0: ");
        bfs(graph, 0);
    }
}
