package analyseur.questions;


import java.util.Map;
import java.util.Random;

import analyseur.model.*;

/**
 * 
 * @author KAMGANG KENMOE MIGUEL JORDAN
 * @author Dioukou Moussa Sissoko
 * @author Abogounrin Ayath
 *
 */

public class RandomWalk {

 
    Map<String,Node> nodeMap;

    /**
     * 
     * @param graph tous les noeuds present dans notre livre
     */

    public RandomWalk(Graph graph){

        nodeMap = graph.getNodeMap();
    }

    /**
     * 
     * @param startNodeId l'identifiant du noeud de départ  
     * @param endNodeString l'identifiant du noeud de d'arrivé
     * @param trials nombre d'essaie
     * @return probabilité de victoire apres une certaines marche aléatoire (trials)
     */

    public double simulator(String startNodeId,String endNodeString, int trials){ 
       
        double player = 0;
        
      
        for(int i = 0 ; i<trials ; i++ ){
            Node startNode = nodeMap.get(startNodeId);
            String id = startNode.getId();

            while(Integer.parseInt(id) != Integer.parseInt(endNodeString)){
          
                Edge edge = RandomSelect(startNode);
               
                if(edge != null){
                    startNode = nodeMap.get(edge.getTarget().getId());
                    id = edge.getTarget().getId();
                   
                }else{
                    break;
                }
               

                
               
            }

           // System.out.println(id +":"+endNodeString);

           if(Integer.parseInt(id) == Integer.parseInt(endNodeString)){ 
            player++; 
         
           }
          
           // System.out.println(player);
          
        }

        System.out.println(player);
        return player/trials;
        
    }

    /**
     * 
     * @param node un noeud de notre graph
     * @return un arret associé a ce noeud et choisi de manière aléatoire
     */

    private Edge RandomSelect(Node node){
        int size = node.getEdges().size();

        if( size !=0 ){
           
           Random random = new Random();

           int index = random.nextInt(size);


           return node.getEdges().get(index);
        }
        return null;
    }

  
}
