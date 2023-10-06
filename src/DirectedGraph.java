import java.util.Arrays;
import java.util.HashMap;

public class DirectedGraph<Item> {
    private int numOfVertices;
    private int numOfEdges;
    private HashMap<String, Vertex<Item>> vertices;

    public DirectedGraph() {
        numOfEdges = 0;
        numOfVertices = 0;
        vertices = new HashMap<>();
    }
    //The directedGraph knows all of its vertices
    public void getNeighbors(String name) {
        Vertex<Item> vertex = vertices.get(name);
        System.out.print("Neighbors of " + name + ": ");
        System.out.println(Arrays.toString(vertex.printNeighbors()));
    }
    public void addVertex(String name, Item entry) {
        vertices.put(name, new Vertex<>(entry));
    }
    public void addNeighbor(String source, String target) {
        //get the vertex object by the string name
        Vertex<Item> source_Vertex = vertices.get(source);
        Vertex<Item> target_Vertex = vertices.get(target);

        //add the neighbors
        source_Vertex.addNeighbor(target_Vertex);
    }
}
