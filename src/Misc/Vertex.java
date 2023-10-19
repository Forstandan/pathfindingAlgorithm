package Misc;

import java.util.Map;
import java.util.Set;

public class Vertex<Item> {
    private Item data;
    private Map<Vertex<Item>, Float> neighborMap;
    private int numOfNeighbors;

    public Vertex(Map<Vertex<Item>, Float> neighborMap, Item data) {
        this.data = data;
        this.neighborMap = neighborMap;
        this.numOfNeighbors = 0;
    }
    public Item getData() {
        return data;
    }
    public void setData(Item data) {
        this.data = data;
    }
    public int getNumOfNeighbors() {
        return numOfNeighbors;
    }
    public void addNeighbor(Vertex<Item> targetVertex, float cost) {
        neighborMap.put(targetVertex, cost);
        numOfNeighbors++;
    }
    public float removeNeighbor(Vertex<Item> targetVertex) {
        float cost = neighborMap.get(targetVertex);
        neighborMap.remove(targetVertex);
        return cost;
    }
    public Set<Vertex<Item>> getNeighborSet() {
        return neighborMap.keySet();
    }
}


//public class Misc.Vertex<Item> {
//    private Item data;
//    private Edge firstEdge;
//    private int numOfEdges;
//
//    public class Edge {
//        public Misc.Vertex<Item> leftTarget;
//        public Misc.Vertex<Item> rightTarget;
//        public Edge nextEdge;
//
//        public Edge(Misc.Vertex<Item> leftTarget, Misc.Vertex<Item> rightTarget) {
//            this(leftTarget, rightTarget, null);
//        }
//        public Edge(Misc.Vertex<Item> leftTarget, Misc.Vertex<Item> rightTarget, Edge nextEdge) {
//            this.leftTarget = leftTarget;
//            this.rightTarget = rightTarget;
//            this.nextEdge = nextEdge;
//        }
//        public void setLeftTarget(Misc.Vertex<Item> leftTarget) { this.leftTarget = leftTarget; }
//        public void setRightTarget(Misc.Vertex<Item> rightTarget) { this.rightTarget = rightTarget; }
//
//        public Misc.Vertex<Item> getLeftTarget() {
//            return leftTarget;
//        }
//        public Misc.Vertex<Item> getRightTarget() {
//            return rightTarget;
//        }
//        public void setNextEdge(Edge nextEdge) { this.nextEdge = nextEdge; }
//        public Edge getNextEdge() { return nextEdge; }
//    }
//
//    public Misc.Vertex(Item entry) {
//        data = entry;
//        firstEdge = null;
//        numOfEdges = 0;
//    }
//    public Item getData() {
//        return data;
//    }
//    public int getNumOfNeighbors() { return numOfEdges; }
//    private boolean isEmpty() { return numOfEdges == 0; }
//    //Each vertex its first edge (neighbor)
//    public void addNeighbor(Misc.Vertex<Item> target) {
//        // make the current firstNeighbor into the old first neighbor
//        Edge oldFirstEdge = firstEdge;
//        // make a new edge to a target vertex whose next node is the old firstNeighbor
//        firstEdge = new Edge(this, target, oldFirstEdge);
//        numOfEdges++;
//    }
//    public Item removeNeighbor(Misc.Vertex<Item> target) {
//        Edge currentEdge = firstEdge;
//        do {
//            if (currentEdge.getRightTarget().equals(target) ||
//                    currentEdge.getLeftTarget().equals(target) && !isEmpty()) {
//                // save the target's data
//                Item targetValue = target.getData();
//                // make the target equal to the firstNeighbor
////                currentEdge.setRightTarget(firstEdge.getRightTarget());
//                // make the firstNeighbor equal to the next firstNeighbor
//                firstEdge = firstEdge.getNextEdge();
//                // return the value
//                return targetValue;
//            }
//        }
//        while ((currentEdge.getRightTarget() != target || currentEdge.getLeftTarget() != target && !isEmpty()));
//        return null;
//    }
//
////@SuppressWarnings("unchecked")
////    public Item[] printNeighbors() {
////        Edge currentEdge = firstEdge;
////        int counter = 0;
////        Item[] resultArray = (Item[]) new Object[getNumOfNeighbors()];
////
////        while (!isEmpty() && counter < getNumOfNeighbors()) {
////            //Iterate through the linked list of neighbors and put into an array
////            resultArray[counter] = currentEdge.getTarget().getData();
////            currentEdge = currentEdge.getNextEdge();
////            counter++;
////        }
//
////        //return array
////        return resultArray;
////    }
//}
