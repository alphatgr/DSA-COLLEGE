import java.util.*;
class Graph1{
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d)
        {
            this.src=s;
            this.dest=d;
        }
    }
    public static void buildGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(s:0,d:1));
        graph[0].add(new Edge(s:0,d:2));

        graph[1].add(new Edge(s:1,d:0));
        graph[1].add(new Edge(s:1,d:3));


        graph[2].add(new Edge(s:2,d:0));
        graph[2].add(new Edge(s:2,d:4));


        graph[3].add(new Edge(s:3,d:1));
        graph[3].add(new Edge(s:3,d:5));


        graph[4].add(new Edge(s:4,d:1));
        graph[4].add(new Edge(s:4,d:3));


        graph[5].add(new Edge(s:5,d:3));
        graph[5].add(new Edge(s:5,d:6));

        graph[6].add(new Edge(s:6,d:5));
        // graph[6].add(new Edge(s:1,d:3));

    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge> graph[]= new ArrayList[V+1];
        buildGraph(graph);

        //2's neighbour
        for (int i = 0; i<graph[5].size(); i++) {
            System.out.print(graph[5].get(i).dest +" ");
        }
    }
 }