class Node {
	public final String value;
	public int pathCost;
	public destination[] voisins;
	public Node parent;

	public Node(String val) {

		value = val;

	}

	public Node(Node node) {
		int i = 0;
		voisins = new destination[node.voisins.length];
		value = node.value;
		pathCost = node.pathCost;
		for (destination e : node.voisins) {
			voisins[i++] = e;
		}
		parent = node.parent;
	}

	public String toString() {
		return value + "(" +pathCost + ")";
	}

}
