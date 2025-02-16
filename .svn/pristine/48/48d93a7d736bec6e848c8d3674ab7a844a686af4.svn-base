package analyseur.questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import analyseur.model.Node;

/***
 * 
 * @author DIOUKOU MOUSSA SISSOKO
 * 
 */

public class PathFindingBFS {

    private final Node startingNode, endingNode;
    private final Map<Node,Boolean> visited;
    private final Map<Node,Node> previous;
    LinkedList<Node> queue;
    Map<String, Node> nodes = new HashMap<>();

    /**
     * 
     * @param startingNode noeud de départ
     * @param endingNode noeud d'arrivé
     * @param nodes ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant
     */
    public PathFindingBFS(Node startingNode, Node endingNode, Map<String, Node> nodes){
        this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.visited = new HashMap<>();
        this.previous = new HashMap<>();
        this.queue = new LinkedList<>();
        this.nodes = nodes;
    }

    /**
     * 
     * @return le plus court chemin pour arrivé a la victoire. ce chemin est composé des identifiant des noeuds et stocké dans une liste  
     */
    public ArrayList<String> pathFindingBFS(){
        this.queue.add(startingNode);
        ArrayList<String> path = new ArrayList<>();

        while(!this.queue.isEmpty()){
            String key = this.queue.remove().getId().toString();
            if(nodes.containsKey(key)){
            Node currentNode = nodes.get(key);
            
            if(currentNode.equals(endingNode)){
                path.add(endingNode.getId());
                Node previousNode = previous.get(currentNode);
                while(previousNode != null){
                    path.add(previousNode.getId());
                    previousNode = previous.get(previousNode);
                }
                Collections.reverse(path);
                return path;
            }

            if(visited.get(currentNode) == null){
                visited.put(currentNode, true);
                for(int i=0; i<currentNode.getEdges().size(); i++){
                    Node adjacencyNode = currentNode.getEdges().get(i).getTarget();
                    if(visited.get(adjacencyNode) == null){
                        if(previous.get(adjacencyNode) == null){
                            previous.put(adjacencyNode,currentNode);
                        }
                        this.queue.add(adjacencyNode);
                    }
                }
            }
        }
    }

    path.add("Pas de chemin possible");
    return path;
    }


}
