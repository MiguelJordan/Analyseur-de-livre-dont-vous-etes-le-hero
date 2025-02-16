package analyseur.model;

import java.util.ArrayList;
import java.util.List;

import analyseur.backbone.Page;


import java.util.HashMap;

import java.util.Map;

public class Graph {
    
    List<Node> nodes;
    Map<String,Node> nodeMap;

    /**
     * 
     * @param pages liste des pages de notre livre
     */
    public Graph(List<Page> pages){
        this.nodes = new ArrayList<>();
        fillGraph(pages);
    }

    /**
     * 
     * @return liste de noeuds
     */
    public List<Node> getNodes(){
       return this.nodes;
    }

    /**
     * 
     * @return un hashmap avec comme clé l'identifiant du noeud et valeur le noeud en question
     */
    public  Map<String,Node> getNodeMap(){
        return this.nodeMap;
     }
    
     /**
      * 
      * @param pages liste des pages de notre livre
      */
    private void fillGraph(List<Page> pages){
        Map<String, Node> nodeMap = new HashMap<>(); // Utilisez une carte pour stocker les nœuds déjà créés
        int numCols = (int) Math.ceil(Math.sqrt(pages.size())); // Nombre de colonnes en fonction du nombre de pages
        int numRows = (int) Math.ceil((double) pages.size() / numCols); // Nombre de lignes en fonction du nombre de pages et du nombre de colonnes
        double cellWidth = 300.0 / numCols; // Largeur de chaque cellule
        double cellHeight = 4.0 / numRows; // Hauteur de chaque cellule
        double startX = cellWidth / 2; // Décalage initial en x
        double startY = cellHeight / 2; // Décalage initial en y
        
        for (Page page : pages) {
            String nodeId = page.getIdPage();
            int pageIndex = pages.indexOf(page);
            int colIndex = pageIndex % numCols;
            int rowIndex = pageIndex / numCols;
            Boolean fight = page.isFight();
            
            // Calculez les coordonnées du nœud dans la cellule de la grille
            double x = startX + colIndex * cellWidth;
            double y = startY + rowIndex * cellHeight;
            
            // Vérifiez si le nœud existe déjà dans la carte
            if (!nodeMap.containsKey(nodeId)) {
                // Si le nœud n'existe pas, créez-le et ajoutez-le à la carte
                Node node = new Node(nodeId);
                nodeMap.put(nodeId, node);
                node.setX(x);
                node.setY(y);
                node.setText(page.getText());
                node.setFight(fight);
            }
            
            // Traitez les choix de la page
            List<String> choices = page.getChoice();
            for (String choice : choices) {
                // Vérifiez si le nœud de choix existe déjà dans la carte
                if (!nodeMap.containsKey(choice)) {
                    // Si le nœud n'existe pas, créez-le et ajoutez-le à la carte
                    Node choiceNode = new Node(choice);
                    choiceNode.setFight(fight);
                    nodeMap.put(choice, choiceNode);
                }
                
                // Récupérez les nœuds correspondants dans la carte
                Node sourceNode = nodeMap.get(nodeId);
                Node targetNode = nodeMap.get(choice);
                
                // Créez une arête entre les nœuds source et destination
                Edge edge = new Edge(targetNode, 1);
                sourceNode.addEdges(edge);
            }
        }
        
        // Ajoutez tous les nœuds de la carte à la liste de nœuds du graphe
        this.nodes.addAll(nodeMap.values());

        this.nodeMap = nodeMap;
    }
}

