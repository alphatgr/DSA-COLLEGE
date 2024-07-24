import java.util.*;

public class Dijkstra {
    private static final int NO_PARENT = -1;

    // Function to implement Dijkstra's algorithm
    public static void dijkstra(int[][] adjacencyMatrix, int startVertex) {
        int nVertices = adjacencyMatrix.length;

        // shortestDistances[i] will hold the shortest distance from startVertex to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will be true if vertex i is included in the shortest path tree
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all vertices
        for (int i = 1; i < nVertices; i++) {

            // Pick the minimum distance vertex from the set of vertices not yet processed
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as processed
            added[nearestVertex] = true;

            // Update distance value of the adjacent vertices of the picked vertex
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents);
    }

    // Function to print the constructed distance array and shortest paths
    private static void printSolution(int startVertex, int[] distances, int[] parents) {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            if (vertexIndex != startVertex) {
                System.out.print("\n" + startVertex + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }

    // Function to print the shortest path from the source vertex to the current vertex
    private static void printPath(int currentVertex, int[] parents) {
        // Base case: If the current vertex is the source vertex
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            { 0, 1, 4, 0, 0, 0 },
            { 1, 0, 4, 2, 7, 0 },
            { 4, 4, 0, 3, 5, 0 },
            { 0, 2, 3, 0, 4, 6 },
            { 0, 7, 5, 4, 0, 7 },
            { 0, 0, 0, 6, 7, 0 }
        };
        Dijkstra.dijkstra(adjacencyMatrix, 0);
    }
}
