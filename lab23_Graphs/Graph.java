import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Graph implements Iterable<Integer>{
	// linkedlist 
    private LinkedList<Edge>[] myAdjLists;
    // store the number of vertex in a graph 
    private int myVertexCount;
    // store the start of the vertex
    private int myStartVertex;

    // Initialize a graph with the given number of vertices and no edges.
    public Graph(int numVertices) {
    	// create a linkedlist with the size of numVertices
        myAdjLists = new LinkedList[numVertices];
        // initialize start to 0 
        myStartVertex = 0;
        // loop through the linkedlist 
        for (int k = 0; k < numVertices; k++) {
        	// create a new linkedList edge for each vertex 
            myAdjLists[k] = new LinkedList<Edge>();
        }
        // update myVertexCount to the length of the linkedList 
        myVertexCount = numVertices;
    }
    
    // Change the vertex the iterator will start DFS from
    public void setStartVertex(int v){
        if (v < myVertexCount && v >= 0){
            myStartVertex = v;
        } else {
            throw new IllegalArgumentException("Cannot set iteration start vertex to " + v + ".");
        }
    }
    
    // Add to the graph a directed edge from vertex v1 to vertex v2.
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, null);
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2.
    public void addUndirectedEdge(int v1, int v2) {
        addUndirectedEdge(v1, v2, null);
    }

    // Add to the graph a directed edge from vertex v1 to vertex v2,
    // with the given edge information.
    public void addEdge(int v1, int v2, Object edgeInfo) {
    	// create an edge Link list with direction from  v1, to v2, and info of the object weight
    	Edge edge = new Edge(v1, v2, edgeInfo);
    	// Conditions to add 
    		// if v1 is less the myVertexCount 
    		// if v2 is less than myVertexCount 
    		// if v1 is greater than or equal to 0 
    		// if v2 is greater than or equal to 0 
    		// if v1 does not contain an edge with the same to, from and edgeinfo. 
    			// because this would mean it is an undirected graph. 
        if (v1 < myVertexCount && v2 < myVertexCount && v1 >=0 && v2 >= 0 && !myAdjLists[v1].contains(edge)) {
        	    myAdjLists[v1].add(edge);  
        // else cannot exist since it is not a directed edge. 
        } else {
        	throw new NoSuchElementException("Edge (" + v1 + ", " + v2 + ") cannot exist.");
        }
    }

    // Add to the graph an undirected edge from vertex v1 to vertex v2,
    // with the given edge information.
    public void addUndirectedEdge(int v1, int v2, Object edgeInfo) {
    	// create an edge1 linkedList 
    	Edge edge1 = new Edge(v1, v2, edgeInfo);
    	// create an edge2 linkedList
    	Edge edge2 = new Edge(v2, v1, edgeInfo);
    	// conditions before adding 
    		// if v1 is less than myVertexCount 
    		// if v2 is less than myVertexCount 
    		// if v1 is greater than or equal to 0 
    		// if v2 is greater than or equal to 0 
    		// if myAdjLists linkedList doesn't already contain edge1 or edge2 
        if (v1 < myVertexCount && v2 < myVertexCount && v1 >=0 && v2 >= 0 &&
            !myAdjLists[v1].contains(edge1) && !myAdjLists[v2].contains(edge2)) {
        	    myAdjLists[v1].add(edge1);
        	    myAdjLists[v2].add(edge2);
        // else throw an exception 
        } else {
        	throw new NoSuchElementException("Undirected edge (" + v1 + ", " + v2 + ") cannot exist.");
        }
    }

    // Return true if there is an edge from vertex "from" to vertex "to";
    // return false otherwise.
    public boolean isAdjacent(int from, int to) {
    	// if from is less than myVertexCount and from is a positive integer 
    	// if myAdjLists that takes in the edge from contains a new edge
    	// Question: how do you know the objectinfo is null? 
        if (from < myVertexCount && from > 0 && myAdjLists[from].contains(new Edge(from, to, null))) {
        	return true;
        }
        // else it is not adjacent so must be false. 
        return false;
    }

    // Return the number of incoming vertices for the given vertex,
    // i.e. the number of vertices v such that (v, vertex) is an edge.
    public int inDegree(int vertex) {
    	// create a count variable 
        int count = 0;
        // for every LinkedList<edge> loop through myAdjLists 
        for (LinkedList<Edge> list: myAdjLists) {
        	// for every edge on each of the linked list 
        	for (Edge e: list) {
        		// if e.to is the vertex, increment your count 
        		if (e.to() == vertex) {
        			count++;
        		}
        	}
        }
        return count;
    }
    
    public Iterator<Integer> iterator(){
        return new TopologicalIterator();
    }

    // A class that iterates through the vertices of this graph, starting with a given vertex.
    // Does not necessarily iterate through all vertices in the graph: if the iteration starts
    // at a vertex v, and there is no path from v to a vertex w, then the iteration will not
    // include w
    private class DFSIterator implements Iterator<Integer> {
    	
    	// create a stack which will be the fringe 
        private Stack<Integer> fringe;
        // create a hashSet which will be the key 
        private HashSet<Integer> visited;

        // Constructor includes creating the fringe stack, creating the fringe visited
        // creating fringe that adds 
        public DFSIterator(Integer start) {
        	fringe = new Stack<Integer>();
        	visited = new HashSet<Integer>();
        	// add the integer to the fringe 
            fringe.add(start);
        }

        // hasNext() 
        public boolean hasNext() {
        	// if fringe is not empty, return true. 
            if (!fringe.isEmpty()) {
            	return true;
            }
            // else return false.
            return false;
        }

        // next() 
        public Integer next() {
        	// pop the fringe for the first value 
            int rtn = fringe.pop();
            // if visited hashset contains the popped value and it contains a next, 
            	// recursively call it again 
            // Question: why did you need this condition? Why do we need a hashSet? 
            	// to keep track of the vertex in one edge? 
            if (visited.contains(rtn) && this.hasNext()) {
            	return this.next();
            }
            // else, add rtn to the hashset
            visited.add(rtn);
            // loop through the whole edge of the linkedlist rtn 
            for (Edge e: myAdjLists[rtn]) {
            	// if visited contains e.to, add that to the fringe 
            	if (!visited.contains(e.to())) {
            		// add to the fringe the vertex to of edge. 
            		fringe.add(e.to());
            	}
            }
            // return the value 
            return rtn;
        }

        //ignore this method
        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    // Return the collected result of iterating through this graph's
    // vertices as an ArrayList.
    public ArrayList<Integer> visitAll(int startVertex) {
    	// create an arraylist you will return with the vertices 
        ArrayList<Integer> result = new ArrayList<Integer>();
        // create an iterator 
        Iterator<Integer> iter = new DFSIterator(startVertex);
        // go through the iterator and add the vertices one at a time
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        // return the arrayList
        return result;
    }

    public boolean pathExists(int startVertex, int stopVertex) {
    	// for integer in visitall(startVertex))
        for (Integer v: visitAll(startVertex)){
        	// if v == stopVertex, return true
        	if (v == stopVertex) {
        		return true;
        	}
        }
        // else return false. 
        return false;
    }
    
    public ArrayList<Integer> path(int startVertex, int stopVertex) {
    	// create an arrayList of integers which will store the path 
        ArrayList<Integer> path = new ArrayList<Integer>();
        // if the path exists, return the arraylist
        if (!pathExists(startVertex, stopVertex)) {
            return path;
        } else {
        	// store vertex
        	int vertex;
        	// initialize iterator 
            Iterator<Integer> iter = new DFSIterator(startVertex);
            // create an arraylist visited
            ArrayList<Integer> visited = new ArrayList<Integer>();
            // while there is a hasNext
            while (iter.hasNext()) {
            	// keep iterating through 
                vertex = iter.next();
                // once vertex == stopVertex, break
                if (vertex == stopVertex) {
                	break;
                }
                // add vertex to visited 
                visited.add(vertex);
            }
            // implement iterator 
            Iterator<Integer> iter1 = new DFSIterator(startVertex);
            // store stopvertex
            int end = stopVertex;
            // while there is a next and the end is not the start
            while (iter1.hasNext() && end != startVertex) {
            // ??     
            }
            
            Stack<Integer> reverser = new Stack<Integer>();
            for (Integer v: path) {
            	reverser.add(v);
            }
            path = new ArrayList<Integer>();
            path.add(startVertex);
            while (!reverser.isEmpty()) {
            	path.add(reverser.pop());
            }
            
        }
        return path;
    }

    public ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = new TopologicalIterator();
        while (iter.hasNext()) {
            result.add(iter.next());
        }
        return result;
    }
    
//    public ArrayList<Integer> shortestPath(int startVertex, int endVertex) {
//    	Iterator<Integer> iter = new TopologicalIterator(); 
//    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    	
    	//Add the starting vertex s to the initially empty fringe with priority value 0
    	//Add all other vertices to the fringe with priority value of infinity
    	
    	// 2nd while 
    	// if it is less
    	// update the weight
    	// put the previous as the current weight 
    	
    	
    	// 3rd while 
    	// What is the previous backpointer of the vertex

   
    	
	
    //}
    
//    public Set<Set<Integer>> stronglyConnectedComponents() {
//    	// Intialize an empty stack S of vertices
//    	Stack<Integer> s = new Stack<Integer>(); 
//		//While S does not contain all of the vertices in the graph:
//		while (s.size() != myVertexCount)
//		{
//			//Pick a vertex from the graph that is not in S
//			//Perform DFS from that vertex.
//			//When DFS finishes expanding a vertex (i.e. all of the vertex's 
//				// descendents have been returned by DFS), 
//				//add that vertex to S
//		}
//		//Make a copy of the whole graph with all of its edges reversed
//		//While S is not empty:
//		while (!s.isEmpty())
//		{
//			//Pop off the top vertex from S.
//			//Perform DFS from that vertex using the reverse graph. 
//   			//All vertices you can reach are in a strongly connected 
//   			//component with the vertex. Remove them from S.
//			
//		}
//
//    }
//    

    private class TopologicalIterator implements Iterator<Integer> {

        private Stack<Integer> fringe;
        private Integer[] currentInDegree;
        private Integer currentVertex;
        private HashSet<Integer> visited;

        public TopologicalIterator() {
            fringe = new Stack<Integer>();
            visited = new HashSet<Integer>();
            currentInDegree = new Integer[myAdjLists.length];
            int degree;
            for (int i = 0; i < myAdjLists.length; i++) {
            	degree = inDegree(i);
            	currentInDegree[i] = degree;
                if (degree == 0) {
                	fringe.push(i);
                }
            }
        }

        public boolean hasNext() {
            return !fringe.isEmpty();
        }

        public Integer next() {
        	currentVertex = fringe.pop();
            for (Edge e: myAdjLists[currentVertex]) {
            	currentInDegree[e.to()]--;
            }
            visited.add(currentVertex);
            for (int i = 0; i < myAdjLists.length; i++) {
            	if (!visited.contains(i) && !fringe.contains(i) && currentInDegree[i] == 0) {
            	    fringe.push(i);
            	}
            }
            return currentVertex;
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "vertex removal not implemented");
        }

    }

    private class Edge {

        private Integer myFrom;
        private Integer myTo;
        private Object myEdgeInfo;

        public Edge(int from, int to, Object info) {
            myFrom = new Integer(from);
            myTo = new Integer(to);
            myEdgeInfo = info;
        }

        public Integer to() {
            return myTo;
        }

        public Object info() {
            return myEdgeInfo;
        }

        public String toString() {
            return "(" + myFrom + "," + myTo + ",dist=" + myEdgeInfo + ")";
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> result;

        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 4);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(4, 3);
        System.out.println("Traversal starting at 0");
        result = g1.visitAll(0);
        Iterator<Integer> iter;
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 2");
        result = g1.visitAll(2);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 3");
        result = g1.visitAll(3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Traversal starting at 4");
        result = g1.visitAll(4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 0 to 3");
        result = g1.path(0, 3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 0 to 4");
        result = g1.path(0, 4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 1 to 3");
        result = g1.path(1, 3);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 1 to 4");
        result = g1.path(1, 4);
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Path from 4 to 0");
        result = g1.path(4, 0);
        if (result.size() != 0) {
            System.out.println("*** should be no path!");
        }

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 4);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.addEdge(4, 3);
        System.out.println();
        System.out.println();
        System.out.println("Topological sort");
        result = g2.topologicalSort();
        iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
        Graph g3 = new Graph(7);
        g3.addUndirectedEdge(0,2); 
        g3.addUndirectedEdge(0,3); 
        g3.addUndirectedEdge(1,4); 
        g3.addUndirectedEdge(1,5); 
        g3.addUndirectedEdge(2,3); 
        g3.addUndirectedEdge(2,6); 
        g3.addUndirectedEdge(4,5);
        System.out.println();
        System.out.println();
        System.out.println("Undirected g3 is  not completely connected. 0,2,3,6 and 1,4,5 are not connected.");
        System.out.println("therefore g3 does not contain these edges:");
        for (int i = 0; i < 7; i ++) {
        	for (int j = 0; j < 7; j ++) {
        		if (!g3.pathExists(i, j)) {
        			System.out.print("(" + i + ", " + j +") ");
        		}
        	}
        }
    }

}