import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UCS {

	public static void UniformCostSearch(Node source, Node goal) {

		List<Node> explored = new ArrayList<Node>();
		source.pathCost = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {

			public int compare(Node i, Node j) {
				if ((i.pathCost > j.pathCost)) {
					return 1;
				}

				else if (i.pathCost < j.pathCost) {
					return -1;
				}

				else {
					return 0;
				}
			}
		}

		);

		queue.add(source);
		List<Node> path = new ArrayList<Node>();

		do {

			path.clear();
			Node current = queue.poll();
			// on affiche le pays qu'on va parcourir
			System.out.println(current);
			// maintenant on l'a explorer
			explored.add(current);
			for (Node node = current; node != null; node = node.parent) {
				path.add(node);
			}
			// Si on trouve le "goal"
			if (current.value.equals(goal.value)) {
				goal.parent = current.parent;
				goal.pathCost = current.pathCost;
				System.out.println("Least cost solution found : " + current);
				break;

			}
			// maintenant on parcours le tableau voisins (pour chaque pays dans
			// la frontiere)
			// le tableau contient chaque pays auquel on peut arriver a partir
			// du pays qu'on va explorer, donc chaque destiantion
			for (destination e : current.voisins) {
				// on mait chaque voisin dans un noeud qu'on appel voisin
				Node voisin = e.target;
				// on met le cost de ce voisin dans la variabe qu'on appel cost
				int cost = e.cost;

				/*
				 * il faut que: 1.Liste d'attente contient ce voisin 2.Voisin
				 * est deja explorer 3.voisin ne doit pas etre dans path
				 */
				if ((queue.contains(voisin) || explored.contains(voisin)) && !path.contains(voisin)) {
					/*
					 * Si les conditions sont verifie donc le voisin est soit
					 * dans la liste dattente soit il est deja explorer donc on
					 * ne peut pas lajouter directement a la liste d'attente, il
					 * faut changer son address pour qu'il ne fait pas un
					 * overwrite ndjdshfbusdbvdsbjdsbvudshvisvifvsu
					 */
					Node n = new Node(voisin);
					n.pathCost = current.pathCost + cost;
					n.parent = current;
					// finalement on ajoute ce voisin a la liste d'attente
					queue.add(n);
				} else if (!path.contains(voisin)) {
					// Dans le cas ou voisin n'appartient pas a path seulement
					// Il suffit de fair une mise a jour de son cost et de
					// l'ajouter a la liste dattente
					voisin.pathCost = current.pathCost + cost;
					voisin.parent = current;
					queue.add(voisin);
				}

			}
		} while (!queue.isEmpty());
		// Tant que la liste d'attente n'est pas vide

	}

	public static void main(String[] args) {
		// initialisation des pays
		Node n1 = new Node("Arad");
		Node n2 = new Node("Zerind");
		Node n3 = new Node("Oradea");
		Node n4 = new Node("Sibiu");
		Node n5 = new Node("Fagaras");
		Node n6 = new Node("Rimnicu Vilcea");
		Node n7 = new Node("Pitesti");
		Node n8 = new Node("Timisoara");
		Node n9 = new Node("Lugoj");
		Node n10 = new Node("Mehadia");
		Node n11 = new Node("Drobeta");
		Node n12 = new Node("Craiova");
		Node n13 = new Node("Bucharest");
		Node n14 = new Node("Giurgiu");

		// initialisation des voisins de chaque pays
		n1.voisins = new destination[] { new destination(n2, 75), new destination(n4, 140), new destination(n8, 118) };

		n2.voisins = new destination[] { new destination(n1, 75), new destination(n3, 71) };

		n3.voisins = new destination[] { new destination(n2, 71), new destination(n4, 151) };

		n4.voisins = new destination[] { new destination(n1, 140), new destination(n5, 99), new destination(n3, 151),
				new destination(n6, 80), };

		n5.voisins = new destination[] { new destination(n4, 99), new destination(n13, 211) };

		n6.voisins = new destination[] { new destination(n4, 80), new destination(n7, 97), new destination(n12, 146) };

		n7.voisins = new destination[] { new destination(n6, 97), new destination(n13, 101),
				new destination(n12, 138) };

		n8.voisins = new destination[] { new destination(n1, 118), new destination(n9, 111) };

		n9.voisins = new destination[] { new destination(n8, 111), new destination(n10, 70) };

		n10.voisins = new destination[] { new destination(n9, 70), new destination(n11, 75) };

		n11.voisins = new destination[] { new destination(n10, 75), new destination(n12, 120) };

		n12.voisins = new destination[] { new destination(n11, 120), new destination(n6, 146),
				new destination(n7, 138) };

		n13.voisins = new destination[] { new destination(n7, 101), new destination(n14, 90),
				new destination(n5, 211) };

		n14.voisins = new destination[] { new destination(n13, 90) };

		UniformCostSearch(n1, n13);

	}

}
