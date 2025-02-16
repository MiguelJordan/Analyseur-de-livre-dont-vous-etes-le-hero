package analyseur.questions;

import analyseur.model.Node;
import analyseur.model.Edge;

import java.util.*;

/***
 * 
 * @author ALHAZZAA Laith
 * 
*/

/***
 * 
 * @param startingNode noeud de départ
 * @param endingNode noeud d'arrivé
 * @param allPaths une liste de chemins, chaque chemin étant une liste de chaînes de caractères.
 * @requires startingNode != null && endingNode != null
*/
public class AllPath {
    private final Node startingNode, endingNode;
    private final List<List<String>> allPaths;

    /**
        * Crée une nouvelle instance de la classe AllPath.
        * 
        * @param startingNode Le nœud de départ pour la recherche de chemins.
        * @param endingNode Le nœud d'arrivée pour la recherche de chemins.
        * @param allPaths La liste des chemins à initialiser.
    */
    public AllPath(Node startingNode, Node endingNode) {
        this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.allPaths = new ArrayList<>();
    }

    /**
        * Trouve tous les chemins possibles entre le nœud de départ et le nœud de fin.
        *
        * @requires startingNode != null && endingNode != null
        * @ensures allPaths contient tous les chemins possibles entre startingNode et endingNode
        *
        * @return Une liste de listes de chaînes de caractères représentant tous les chemins possibles.
    */
    public List<List<String>> findAllPaths() {
        Stack<Node> stack = new Stack<>();
        Stack<List<String>> pathStack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        List<String> currentPath = new ArrayList<>();

        stack.push(startingNode);
        pathStack.push(currentPath);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            List<String> current = pathStack.pop();
            current.add(currentNode.getId());

            if (currentNode.equals(endingNode)) {
                allPaths.add(new ArrayList<>(current));
            } else {
                visited.add(currentNode);
                for (Edge edge : currentNode.getEdges()) {
                    Node nextNode = edge.getTarget();
                    if (!visited.contains(nextNode)) {
                        stack.push(nextNode);
                        pathStack.push(new ArrayList<>(current));
                    }
                }
            }
        }

        return allPaths;
    }
}

