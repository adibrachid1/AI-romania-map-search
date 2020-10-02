class Node {
	public final String value;
	public destination[] voisins;
	public Node parent;
	public int heuristic;

	public Node(String val, int heur) {

		value = val;
		heuristic = heur;
	}

	public Node(Node node) {
		int i = 0;
		voisins = new destination[node.voisins.length];
		value = node.value;
		for (destination e : node.voisins) {
			voisins[i++] = e;
		}
		parent = node.parent;
	}

	public String toString() {
		return value + "(" + heuristic + ")";
	}

}
