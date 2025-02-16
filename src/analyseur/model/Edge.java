package analyseur.model;

public class Edge {
    private Node target;
    private int weight;

    
    /**
     * 
     * @param target noeud de destination
     * @param weight poids de l'arret
     */
    public Edge(Node target, int weight){
        this.target = target;
        this.weight = weight;
    }

    /**
     * 
     * @return le noeud de destination
     */
    public Node getTarget(){return this.target;}

    /**
     * 
     * @return le poids de l'arret
     */
    public int getWeight(){
        return this.weight;
    }

     
    public String toString(){
        return this.target.getId().toString();
    }
}
