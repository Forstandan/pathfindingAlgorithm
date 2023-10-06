public class Vertex<Item> {
    private Item data;
    private Edge firstNeighbor;
    private int numOfNeighbors;

    public class Edge {
        public Vertex<Item> target;
        public Edge nextEdge;

        public Edge(Vertex<Item> target) {
            this(target, null);
        }
        public Edge(Vertex<Item> target, Edge nextEdge) {
            this.target = target;
            this.nextEdge = nextEdge;
        }
        public void setTarget(Vertex<Item> target) { this.target = target; }
        public Vertex<Item> getTarget() {
            return target;
        }
        public void setNextEdge(Edge nextEdge) { this.nextEdge = nextEdge; }
        public Edge getNextEdge() { return nextEdge; }
    }

    public Vertex(Item entry) {
        data = entry;
        firstNeighbor = null;
        numOfNeighbors = 0;
    }
    public Item getData() {
        return data;
    }
    public int getNumOfNeighbors() { return numOfNeighbors; }
    private boolean isEmpty() { return numOfNeighbors == 0; }
    //Each vertex its first edge (neighbor)
    public void addNeighbor(Vertex<Item> target) {
        // make the current firstNeighbor into the old first neighbor
        Edge oldFirstNeighbor = firstNeighbor;
        // make a new edge to a target vertex whose next node is the old firstNeighbor
        firstNeighbor = new Edge(target, oldFirstNeighbor);
        numOfNeighbors++;
    }
    public Item removeNeighbor(Vertex<Item> target) {
        Edge currentNeighbor = firstNeighbor;
        do {
            if (currentNeighbor.getTarget().equals(target) && !isEmpty()) {
                // save the target's data
                Item targetValue = target.getData();
                // make the target equal to the firstNeighbor
                currentNeighbor.setTarget(firstNeighbor.getTarget());
                // make the firstNeighbor equal to the next firstNeighbor
                firstNeighbor = firstNeighbor.getNextEdge();
                // return the value
                return targetValue;
            }
        }
        while ((currentNeighbor.getTarget() != target && !isEmpty()));
        return null;
    }

@SuppressWarnings("unchecked")
    public Item[] printNeighbors() {
        Edge currentNeighbor = firstNeighbor;
        int counter = 0;
        Item[] resultArray = (Item[]) new Object[getNumOfNeighbors()];

        while (!isEmpty() && counter < getNumOfNeighbors()) {
            //Iterate through the linked list of neighbors and put into an array
            resultArray[counter] = currentNeighbor.getTarget().getData();
            currentNeighbor = currentNeighbor.getNextEdge();
            counter++;
        }

        //return array
        return resultArray;
    }
}
