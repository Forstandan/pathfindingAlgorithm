public class Main {
    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();
        //Adding vertices
        graph.addVertex("A", "A");
        graph.addVertex("B", "B");
        graph.addVertex("C", "C");
        graph.addVertex("D", "D");
        graph.addVertex("E", "E");
        graph.addVertex("F", "F");
        graph.addVertex("G", "G");
        graph.addVertex("H", "H");
        graph.addVertex("I", "I");
        //Adding neighbors
        graph.addNeighbor("A", "B");
        graph.addNeighbor("A", "D");
        graph.addNeighbor("A", "E");
        graph.addNeighbor("B", "E");
        graph.addNeighbor("C", "B");
        graph.addNeighbor("D", "G");
        graph.addNeighbor("E", "H");
        graph.addNeighbor("E", "F");
        graph.addNeighbor("F", "H");
        graph.addNeighbor("G", "H");
        graph.addNeighbor("H", "I");
        graph.addNeighbor("I", "F");
        //Printing the neighbors
        graph.getNeighbors("E");
    }
}