package augChallenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//import ch2.GraphAdjacencyList;

class GraphAdjacencyList {

/* Makes use of Map collection to
 * store the adjacency list for each vertex.
 */	
  Map <Integer , List<Integer>> AdjacencyList ;
  int vertexCount=0;
/*
 * Initializes the map to with size equal to number of
 * vertices in a graph
 * Maps each vertex to a given List Object 
 */  
  public  GraphAdjacencyList(int vertexCount) {
	// TODO Auto-generated constructor stub
	  this.vertexCount=vertexCount;
	  AdjacencyList = new HashMap<Integer, List<Integer>>();
	  for (int i = 1; i <= vertexCount; i++) {
		AdjacencyList.put(i, new LinkedList<Integer>());
		AdjacencyList.put(-i, new LinkedList<Integer>());
	  }
	  
}
  
  /* Adds nodes in the Adjacency list for the corresponding vertex.*/
  public void addEdge(int source , int destination)  {
	  if(source > AdjacencyList.size() || destination > AdjacencyList.size())  {
		  System.out.println("The vertex entered is not present");
		  return;
	  }
	  List<Integer> slist = AdjacencyList.get(source);
	  slist.add(destination);
	//  AdjacencyList.put(source,slist);
}
  
  public List<Integer> outEdges(int source) {
	// TODO Auto-generated method stub
	  List<Integer> slist = AdjacencyList.get(source);
	  return slist;
}

}

class REVERSE {
 
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final PrintWriter pw = new PrintWriter(System.out);
    static GraphAdjacencyList graph ;
    static Map<Integer,Integer> path ;
    static List<Integer> reachableStraight; 
    static List<Integer> reachableReverse ;
    static int noOfReverse=-1;
    public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			compute();
		} finally {
			pw.close();
		}
	}

	private static void compute() throws IOException {
		// TODO Auto-generated method stub
		
		String inp[];
		inp=br.readLine().split(" ");
		int V = Integer.parseInt(inp[0]);
		int E = Integer.parseInt(inp[1]);
//		int graph[][]=new int[V][V];
		
		graph = new GraphAdjacencyList(V);
		path = new HashMap<Integer,Integer>();
		int x , y;
		for (int i = 0; i < E; i++) {
			inp=br.readLine().split(" ");
			x= Integer.parseInt(inp[0]);
			y= Integer.parseInt(inp[1]);
			graph.addEdge(x, y);
			graph.addEdge(-y, x);			
		}
		
		calculate(V);
		System.out.println(path.get(1));
	}

	private static void calculate(int N) {
		// TODO Auto-generated method stub
		
		 Queue<Integer> q = new LinkedList<Integer>();
		 Queue<Integer> qC;
		 q.offer(new Integer(N));
		 int reverseCount=0;
		 path.put(N, 0);
		 while(!q.isEmpty())
		 {
//			    qC = new LinkedList<Integer>(q);
//			    System.out.println("\nqueue->");
//			    while (!qC.isEmpty()) {
//			        System.out.print(qC.peek()+ "-"+ path.get(qC.peek()) +" ,  ");         // take the front first
//			        qC.poll();                         // before popping (dequeue-ing) it
//			      }
//			    System.out.println();
			 reachableStraight = graph.outEdges(-q.peek());
			 reachableReverse = graph.outEdges(q.peek());
			 reverseCount = path.get(q.peek());
			 for (Iterator iterator = reachableStraight.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					
					if(integer == 1)
					{
						if(!path.containsKey(1)){path.put(1, reverseCount);}
						else if(path.get(integer)>reverseCount){path.put(1, reverseCount);}
					}
					
					else if(!path.containsKey(integer))
						{
							path.put(integer, reverseCount);
							q.offer(integer);
						}
					else if(path.get(integer)>reverseCount)
						{
							if(q.contains(integer))path.put(integer, reverseCount);
							else q.offer(integer);
						}
					
				}
			for (Iterator iterator = reachableReverse.iterator(); iterator.hasNext();) {
			    	Integer integer = (Integer) iterator.next();
			    	if(integer == 1)
					{
						if(!path.containsKey(1)){path.put(1, reverseCount+1);}
						else if(path.get(integer)>reverseCount+1){path.put(1, reverseCount+1);}
					}
			    	else if(!path.containsKey(integer))
					{
						path.put(integer, reverseCount+1);
						q.offer(integer);
					}
					else if(path.get(integer)>reverseCount+1)
					{
						if(q.contains(integer))path.put(integer, reverseCount+1);
						else q.offer(integer);
					}
				}
			q.poll();					
		 }
		 
	
// if not visited ever - then put how much reverse it took to come to it
// if visited - check if reverseCount is greater ->ignore
// if visited - check if reverseCount is equal -> ignore
// if visited - check if reverseCount is less -> again loop through ######## NEED OPTIMIZATION HERE -1 #########
		
//		if(!path.containsKey(vertex)) path.put(vertex,reverseCount);
//		else if(path.get(vertex)<=reverseCount)return;
		// if if reverseCount is less	-it will be doing the process again from here ######## NEED OPTIMIZATION HERE -1 #########
	
		
//			
//		if(vertex==1) {
//			
//			rechableStraight = graph.inEdges(-vertex);
//			rechableReverse = graph.inEdges(vertex);
//			for (Iterator iterator = rechableStraight.iterator(); iterator.hasNext();) {
//				Integer integer = (Integer) iterator.next();
//				
//				
//			}
//			for (Iterator iterator = rechableReverse.iterator(); iterator.hasNext();) {
//				Integer integer = (Integer) iterator.next();
//				calculate(integer,reverseCount+1);
//			}
//			
//			
//		}
//		else {
//			
//			rechableStraight = graph.inEdges(-vertex);
//			rechableReverse = graph.inEdges(vertex);
//			for (Iterator iterator = rechableStraight.iterator(); iterator.hasNext();) {
//				Integer integer = (Integer) iterator.next();
//				calculate(integer,reverseCount);
//				
//			}
//			for (Iterator iterator = rechableReverse.iterator(); iterator.hasNext();) {
//				Integer integer = (Integer) iterator.next();
//				calculate(integer,reverseCount+1);
//			}
//		}
//		
	}
}

