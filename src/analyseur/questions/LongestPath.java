package analyseur.questions;

import analyseur.model.Node;
import analyseur.model.Edge;

import java.util.*;

/***
 * 
 * @author ALHAZZAA Laith
 * 
*/
/**
    * Représente un objet pour trouver le plus long chemin entre deux nœuds dans un graphe.
    * 
    * @param startingNode Le nœud de départ pour la recherche du chemin le plus long.
    * @param endingNode Le nœud d'arrivée pour la recherche du chemin le plus long.
    * @requires startingNode != null && endingNode != null
    * @ensures visited.isEmpty() && previous.isEmpty()
*/
public class LongestPath {
    private final Node startingNode, endingNode;
    private final Map<Node,Boolean> visited;
    private final Map<Node,Node> previous;
    
    /**
        * Représente un objet pour trouver le plus long chemin entre deux nœuds dans un graphe.
        * 
        * @param startingNode Le nœud de départ pour la recherche du chemin le plus long.
        * @param endingNode Le nœud d'arrivée pour la recherche du chemin le plus long.
        * @requires startingNode != null && endingNode != null
        * @ensures visited.isEmpty() && previous.isEmpty()
    */
    public LongestPath(Node startingNode, Node endingNode) {
        this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.visited = new HashMap<>();
        this.previous = new HashMap<>();
    }

    /**
        * Recherche et retourne un chemin entre le nœud de départ et le nœud de fin dans le graphe.
        *
        * @return Un ensemble de chaînes de caractères représentant un chemin entre le nœud de départ et le nœud de fin.
        *         Si aucun chemin n'est trouvé, retourne un ensemble contenant la chaîne "Pas de chemin possible".
        * @requires startingNode et endingNode ont été initialisés.
        * @ensures Le chemin retourné est un chemin valide entre startingNode et endingNode, ou contient "Pas de chemin possible".
    */
    public Set<String> path() {
        Queue<Node> queue = new LinkedList<>();
        Set<String> longestPath = new HashSet<>();

        queue.add(startingNode);
        visited.put(startingNode, true);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.equals(endingNode)) {
                longestPath = reconstructPath();
            }

            for (Edge edge : currentNode.getEdges()) {
                Node adjacencyNode = edge.getTarget();

                if (visited.get(adjacencyNode) == null) {
                    visited.put(adjacencyNode, true);
                    previous.put(adjacencyNode, currentNode);
                    queue.add(adjacencyNode);
                }
            }
        }

        return longestPath.isEmpty() ? Collections.singleton("Pas de chemin possible") : longestPath;
    }

    /**
        * Reconstruit et retourne un chemin à partir des nœuds précédents.
        *
        * @return Un ensemble de chaînes de caractères représentant le chemin reconstruit.
        * @requires Les nœuds précédents ont été correctement définis.
        * @ensures Le chemin retourné est un chemin valide reconstruit à partir des nœuds précédents.
    */
    private Set<String> reconstructPath() {
        Set<String> path = new HashSet<>();
        Node currentNode = endingNode;

        while (currentNode != null) {
            path.add(currentNode.getId());
            currentNode = previous.get(currentNode);
        }

        return path;
    }
}


