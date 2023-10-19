package Misc;

import java.util.Map;
import java.util.Set;

public class DirectedGraph<Item> {
    private int numOfVertices;
    private int numOfEdges;
    private Map<String, Vertex<Item>> vertices;

    public DirectedGraph(Map<String, Vertex<Item>> vertexMap) {
        numOfEdges = 0;
        numOfVertices = 0;
        vertices = vertexMap;
    }
//    The directedGraph knows all of its vertices
    public Set<Vertex<Item>> getNeighbors(String name) {
        Vertex<Item> vertex = vertices.get(name);
        return vertex.getNeighborSet();
    }
    public void addVertex(String name, Vertex<Item> target) {
        vertices.put(name, target);
    }
    public void addNeighbor(String source, String target, int cost) {
        //get the vertex object by the string name
        Vertex<Item> source_Vertex = vertices.get(source);
        Vertex<Item> target_Vertex = vertices.get(target);

        //add the neighbors
        source_Vertex.addNeighbor(target_Vertex, cost);
    }

    public Item removeVertex(String name) {
        Vertex<Item> target = vertices.get(name);
        for (Vertex<Item> vertex : target.getNeighborSet()) {
            vertex.removeNeighbor(target);
        }
        Item data = vertices.get(name).getData();
        vertices.remove(name);
        return data;
    }
}
