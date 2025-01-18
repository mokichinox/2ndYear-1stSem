import java.io.*;
import java.util.Scanner;

public class Main{
    
    static final int MAX_VERTICES = 20;
    static final int MAX_EDGES = 100;
    static final int INFINITY = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        
        //storing weights
        int[][] graph = new int[MAX_VERTICES][MAX_VERTICES];
        int vertexCount = 0;
        
        String[] vertices = new String[MAX_VERTICES];
        //read da graph.txt in vb
        BufferedReader reader = new BufferedReader(new FileReader("graph.txt"));
        String line;
        
        //read vertices
        while ((line = reader.readLine()) != null && !line.contains(" ")) {
            vertices[vertexCount++] = line.trim();
        }
        
        //graph with infinity
        for (int i = 0; i < vertexCount; i++){
            for (int j = 0; j < vertexCount; j++){
                graph[i][j] = (i == j) ? 0 : INFINITY;
            }
        }
        
        //read edges
        do {
            if (line == null || line.trim().isEmpty()) continue; //handling
            String[] edgeData = line.split(" ");
            if (edgeData.length == 3){
                int u = findIndex(vertices, edgeData[0], vertexCount);
                int v = findIndex(vertices, edgeData[1], vertexCount);
                int weight = Integer.parseInt(edgeData[2]);
                
                if (u != -1 && v != -1){
                    graph[u][v] = weight;
                }
                
            }else{
                System.out.println("Skipping indalivd line: " + line);
            }
        } while ((line = reader.readLine()) != null);
        
        reader.close();
        
        //ask the user to input a vertex
        System.out.print("Enter the starting vertex: ");
        String startVertex = scanner.nextLine();
        int startIndex = findIndex(vertices, startVertex, vertexCount);
        
        if(startIndex == -1){
            System.out.println("Invalid vertex....");
            return;
        }
        //using Dijkstra's algorithm
        int[] distances = new int[vertexCount];
        boolean[] visited = new boolean [vertexCount];
        
        for (int i = 0; i < vertexCount; i++){
            distances[i] = INFINITY;
        }
        distances[startIndex] = 0;
        
        for (int i = 0;i < vertexCount; i++){
            //search for vertex with the smallest distance
            int u = -1;
            int minDistance = INFINITY;
            for (int j = 0; j < vertexCount; j++){
                if(!visited[j] && distances[j] < minDistance){
                    minDistance = distances[j];
                    u = j;
                }
            }
            
            if (u == -1) break;
            visited [u] = true;
            
            for (int v = 0; v < vertexCount; v++){
                if (!visited[v] && graph [u][v] != INFINITY && distances [u] + graph[u][v] < distances[v]){
                    distances[v] = distances [u] + graph [u][v];
                }
            }
        }
        
        //print results
        System.out.println("Starting Vertex: " + startVertex);
        for (int i = 0; i < vertexCount; i++){
            if (i != startIndex){
                if (distances[i] == INFINITY){
                    System.out.println(vertices[i] + " is not reachable...");
                }else{
                    System.out.println("Shortest path to " + vertices[i] + " has a weigth of " + distances[i] + ".");
                }
            }
        }
    }
    
    private static int findIndex(String[] vertices, String vertex, int vertexCount){
        for (int i = 0; i < vertices.length; i++){
            if (vertices[i].equals(vertex)){
                return i;
            }
        }
        return -1;
    }
}
    
    
