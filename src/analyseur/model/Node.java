package analyseur.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String id;
    String text="";
    List<Edge> edges;
    double x; // Position en x
    double y; // Position en y
    double dx; // Composante de force en x
    double dy; // Composante de force en y
    Boolean figth;

    public Node(String id){
        assert !id.isEmpty();
        this.id = id;
        this.edges = new ArrayList<>();
        this.x = Math.random(); // Initialisation aléatoire de la position en x
        this.y = Math.random(); // Initialisation aléatoire de la position en y
        this.dx = 0.0;
        this.dy = 0.0;
        this.figth = false;
    }

    public void addEdges(Edge e){
        this.edges.add(e);
    }

    /**
     * 
     * @return l'identifiant du noeud
     */
    public String getId(){return this.id;}

    /**
     * 
     * @return le texte associé au noeud
     */
    public String getText(){return this.text;}

    /**
     * 
     * @return l'ordonné du noeud
     */
    public double getX(){ return this.x; }

    /**
     * 
     * @return l'abcisse du noeud
     */
    public double getY(){ return this.y; }

    /**
     * 
     * @return derivéé en x du noeud
     */
    public double getDx(){ return this.dx; }

    /**
     * 
     * @return derivéé en y du noeud
     */
    public double getDy(){ return this.dy; }

    /**
     * 
     * @return si il y a un combat 
     */
    public Boolean getFigth(){ return this.figth;}

    /**
     * 
     * @param dx composant de force en x
     * @ensures de modifier la composante de force en x
     */
    public void setDx(double dx){ this.dx = dx; }

    /**
     * 
     * @param dy composant de force en y
     * @ensures de modifier la composante de force en y
     */
    public void setDy(double dy){ this.dy = dy; }

    /**
     * 
     * @param x coordonnéé en x
     * @ensures de modifier la coordonné x
     */
    public void setX(double x){ this.x = x; }

    /**
     * 
     * @param y coordonnéé en y
     * @ensures de modifier la coordonné y
     */
    public void setY(double y){ this.y = y; }

    /**
     * 
     * @param text texte du noeud
     * @ensures de modifier le texte du noeud
     */
    public void setText(String text){ this.text = text; }

    /**
     * 
     * @param f un boolean pour indiqué si il y a combat
     */
    public void setFight(Boolean f){this.figth = f;}

    /**
     * 
     * @return liste des arrets
     */
    public List<Edge> getEdges(){ return this.edges; }

    /**
     * 
     * @param maxDisplacement deplacement maximal du noeud
     * @ensures de mettre à jour la position et les composants de force du noeud
     */
    public void updatePosition(double maxDisplacement) {
        double displacementSquared = dx * dx + dy * dy;
        if (displacementSquared > maxDisplacement * maxDisplacement) {
            double scale = maxDisplacement / Math.sqrt(displacementSquared);
            x += dx * scale;
            y += dy * scale;
        } else {
            x += dx;
            y += dy;
        }

        // Remise à zéro des composantes de force
        dx = 0.0;
        dy = 0.0;
    }


    public String toString(){
       
        String result = "";
        result += "[";
        for(Edge e : edges){
          result += e.toString() +",";
        }
        result += "]";
        return this.id + ": "+result;
    }

}
