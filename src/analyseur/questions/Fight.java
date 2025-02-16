package analyseur.questions;

import java.util.Map;

import analyseur.model.*;

/***
 * 
 * @author DIOUKOU MOUSSA SISSOKO
 * 
 */
public class Fight {
  private int fightNumbers;

  public Fight(){
    this.fightNumbers = 0;
  }

  /**
   * 
   * @param nodes ,ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant 
   * @return nombre total de combat dans le livre
   */
  public int totalFight(Map<String, Node> nodes){
    for(Map.Entry<String, Node> n: nodes.entrySet()){
      if(n.getValue().getFigth()){
        this.fightNumbers++;
      }
    }
    return this.fightNumbers;
  }

  /**
   * 
   * @param nodes , ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant
   * @return le plus grand nombre de combat dans le livre
   */
  public int mostFightNumber(Map<String, Node> nodes){
    int result=0;
    int max = 0;
    for(Map.Entry<String, Node> n: nodes.entrySet()){
      if(n.getValue().getFigth()){
        String key = n.getKey();
        int nbr = 0;
        for(Map.Entry<String, Node> n_2: nodes.entrySet()){
          if(n.getValue().getFigth()){
            for(Edge n_3 : n_2.getValue().getEdges()){
              if(key.equals(n_3.getTarget().getId().toString())){
                nbr++;
                if(nbr > max){
                  max = nbr;
                }
              }
            }
          }
        }
      }
    }
    result = max;
    return result;
  }
  
  /**
   * 
   * @param nodes , ce qui represente un hashmap ou la clé est l'identifiant du noeud et la valeur est un objet Node qui a ce identifiant
   * @return l'identifiant du noeud ou il y a le plus de combat
   */
  public String mostFightNode(Map<String, Node> nodes){
    String result="";
    int max = 0;
    for(Map.Entry<String, Node> n: nodes.entrySet()){
      if(n.getValue().getFigth()){
        String key = n.getKey();
        int nbr = 0;
        for(Map.Entry<String, Node> n_2: nodes.entrySet()){
          if(n.getValue().getFigth()){
            for(Edge n_3 : n_2.getValue().getEdges()){
              if(key.equals(n_3.getTarget().getId().toString())){
                nbr++;
                if(nbr >= max){
                  max = nbr;
                  result = key;
                }
              }
            }
          }
        }
      }
    }
    //result = max;
    return result;
  }
}
