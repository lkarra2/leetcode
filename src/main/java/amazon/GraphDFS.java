package main.java.amazon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class GraphDFS {

    private int V;
    LinkedList<Integer> adjListArray[];

    public GraphDFS(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjListArray[v].add(w);
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(" " + v);
        Iterator<Integer> i = adjListArray[v].listIterator();
        while(i.hasNext()) {
            int nextV = i.next();
            if(!visited[nextV]) {
                DFSUtil(nextV, visited);
            }
        }
    }

    void DFSwithStack(int s) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push the current source node
        stack.push(s);

        while(stack.empty() == false) {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();

            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if(visited[s] == false) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then puah it
            // to the stack.
            Iterator<Integer> itr = adjListArray[s].iterator();

            while (itr.hasNext()) {
                int v = itr.next();
                if(!visited[v])
                    stack.push(v);
            }

        }
    }

    public static void printGraph(GraphDFS graph) {
        for(int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        // printGraph(g);
        g.DFS(2);
    }

}
