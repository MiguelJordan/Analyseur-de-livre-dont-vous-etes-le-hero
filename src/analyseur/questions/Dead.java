package analyseur.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import analyseur.model.Node;
/***
 * 
 * @author DIOUKOU MOUSSA SISSOKO
 * 
 */
public class Dead {
  private int nbrDead;
  public Dead(){
    this.nbrDead = 0;
  }

  /**
   * @param nodes ,ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant
   * @return nombre de mort dans le graph
   */
  public int nbrDeads(Map<String, Node> nodes){
    for(Map.Entry<String,Node> node : nodes.entrySet()){
      if(node.getValue().getEdges().size()==0){
        this.nbrDead++;
      }
    }
    return this.nbrDead-1;
  }
 
  /**
   * 
   * @param nodes , ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant
   * @return tous les identifiants des noeuds qui representent la defaite
   */
  public List<String> nodeDeads(Map<String, Node> nodes){
    List<String> nodeOfDead = new ArrayList<>();
    for(Map.Entry<String,Node> node : nodes.entrySet()){
      if(node.getValue().getEdges().size()==0 && !node.getKey().equals("350")){
        nodeOfDead.add(node.getKey());
      }
    }
    return nodeOfDead;
  }
}
