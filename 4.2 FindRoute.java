public class FindRoute {

	public static boolean findRoute(GraphNode start, GraphNode end){
		if(start==null||end==null) return false;
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			GraphNode cur = queue.remove();	
			if(cur!=null){				
				if(cur.visited==false){				
					cur.visited = true;
					if(cur == end){
						return true;
					}
					for(GraphNode child: cur.children){
						//if(child.visited==false)
						      queue.add(child);
					}
				}
			}	
		}
		return false;
	}
	
	public static void main(String []args){
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		n1.children.add(n2);
		n1.children.add(n1);
		n1.children.add(n3);
		n1.children.add(n4);
		n2.children.add(n6);
		n2.children.add(n2);
		n3.children.add(n6);
		n3.children.add(n5);
		n5.children.add(n2);
		n4.children.add(n5);		
		n5.children.add(n7);
		
		System.out.println(findRoute(n1, n7));
	}	

}

class GraphNode{
	int data;
	boolean visited;
	ArrayList<GraphNode> children = new ArrayList<GraphNode>();
	GraphNode(int data){
		this.data = data;
	}
	
}
