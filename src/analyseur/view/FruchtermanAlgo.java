package analyseur.view;

import java.util.List;

import analyseur.model.Edge;
import analyseur.model.Graph;
import analyseur.model.Node;

/**
 * 
 * @author Abogounrin Ayath
 *
 */

public class FruchtermanAlgo {

    private Graph graph;

    public FruchtermanAlgo(Graph graph) {
        this.graph = graph;
    }

    /**
     * Méthode pour mettre à jour les positions des nœuds en fonction des forces répulsives et attractives
     * @param maxDisplacement represente le déplacement maximal par étape
     * @param k represente la constante de gravité
     * @param initialTemperature represente la température initiale
     * @param coolingFactor represente le coefficient de refroidissement 
     * @param screenHeight represente la hauteur de l'écran 
     */

    public void updateNodePositions(double maxDisplacement, double k, double initialTemperature, double coolingFactor, double screenHeight) {
        List<Node> nodes = graph.getNodes();
        double temperature = initialTemperature;
        double topMargin = screenHeight * 0.05; // 5% du haut de l'écran

        while (temperature > 0.1) {
            // Calcul des forces répulsives et attractives
            calculateForces(nodes, k);

            // Mettre à jour les positions des nœuds
            for (Node node : nodes) {
                // Vérifier si le nœud dépasse le haut de l'écran
                if (node.getY() - maxDisplacement < topMargin) {
                    node.setY(topMargin + maxDisplacement);
                }
               
                node.updatePosition(maxDisplacement);
            }

            // Refroidissement du système
            temperature *= coolingFactor;
        }
    }

    /**
     * Cette fonction permet de calculer la force d'attraction et de répulsion entre les différents noeuds
     * @param nodes represente un hashmap dont la cle est l'identifiant du noeud et la valeur est un objet Node qui a cet identifiant
     * @param k represente la constante de gravité
     */

    private void calculateForces(List<Node> nodes, double k) {
        // Calcul des forces répulsives entre les nœuds
        for (Node node1 : nodes) {
            for (Node node2 : nodes) {
                if (node1 != node2) {
                    double deltaX = node2.getX() - node1.getX();
                    double deltaY = node2.getY() - node1.getY();
                    double distanceSquared = deltaX * deltaX + deltaY * deltaY;
                    double distance = Math.sqrt(distanceSquared);

                    // Calcul de la force répulsive (loi de Coulomb)
                    double repulsiveForce = k * k / distanceSquared;

                    // Mettre à jour les positions des nœuds en fonction de la force répulsive
                    node1.setDx(node1.getDx() - repulsiveForce * deltaX / distance);
                    node1.setDy(node1.getDy() - repulsiveForce * deltaY / distance);
                }
            }
        }

        // Calcul des forces attractives entre les nœuds connectés par une arête
        for (Node node : nodes) {
            for (Edge edge : node.getEdges()) {
                Node target = edge.getTarget();
                double deltaX = target.getX() - node.getX();
                double deltaY = target.getY() - node.getY();
                double distanceSquared = deltaX * deltaX + deltaY * deltaY;
                double distance = Math.sqrt(distanceSquared);

                // Calcul de la force attractive (loi de Hooke)
                double attractiveForce = distanceSquared / k;

                // Mettre à jour les positions des nœuds en fonction de la force attractive
                node.setDx(node.getDx() + attractiveForce * (deltaX / distance));
                node.setDy(node.getDy() + attractiveForce * (deltaY / distance));
                target.setDx(target.getDx() - attractiveForce * (deltaX / distance));
                target.setDy(target.getDy() - attractiveForce * (deltaY / distance));
            }
        }
    }
}
