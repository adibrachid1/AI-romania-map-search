class Node {
	public final String value;
	public int pathCost;
	public int heuristic;
	public destination[] voisins;
	public Node parent;
	public int tillNow;
	public Node(String val,int heur) {

		value = val;
		heuristic =heur;
	}

	public Node(Node node) {
		int i = 0;
		voisins = new destination[node.voisins.length];
		value = node.value;
		pathCost = node.pathCost;
		heuristic = node.heuristic;
		for (destination e : node.voisins) {
			voisins[i++] = e;
		}
		parent = node.parent;
	}

	public String toString() {
		return value + "(" +pathCost + ")";
	}

}
