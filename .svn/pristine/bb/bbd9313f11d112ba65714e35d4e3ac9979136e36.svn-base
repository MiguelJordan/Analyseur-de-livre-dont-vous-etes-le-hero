package analyseur.view;
import javax.swing.*;


import analyseur.model.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


/**
 * 
 * @author KAMGANG KENMOE MIGUEL JORDAN
 *
 */

public class GraphVisualization extends JPanel {
    private static final  double nodeSize = 13.0;   // Taille du noeud
    private Graph graph;
    private double maxDisplacement = 15; // Déplacement maximal par étape
    private double k; // Constante de gravité
    private double temperature = 90.0; // Température initiale
    private double coolingFactor = 0.99; // Facteur de refroidissement

    public GraphVisualization(Graph graph) {
        this.graph = graph;
        k = Math.sqrt(850*1850/(graph.getNodes().size()))+70;

        // Ajouter un écouteur de souris pour détecter les clics sur les nœuds
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) { // Clic gauche de la souris
                    Node clickedNode = getNodeAt(e.getX(), e.getY());
                    if (clickedNode != null) {
                        // Affichage de l'ID du nœud dans une fenêtre contextuelle
                        String nodeText = clickedNode.getText();
                        String message = nodeText.isEmpty() ? "Pas de texte" : "Texte : " + nodeText;
                        String id =  "Numero de page : " + clickedNode.getId() +  "\n";
                        JOptionPane.showMessageDialog(GraphVisualization.this,id + message);
                    }
                }
            }
        });
        setPreferredSize(new Dimension(2000,2500));
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Attendez 1 seconde avant d'exécuter la méthode run()
                run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
       
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Node node : graph.getNodes()) {
            int x = (int) (node.getX() - nodeSize / 2);
            int y = (int) (node.getY() - nodeSize / 2);
            g2d.setColor(Color.RED); // Couleur noeuds
            g2d.fillOval(x, y, (int) nodeSize, (int) nodeSize);
            // Afficher l'ID du nœud
            g2d.setColor(Color.BLACK);
            g2d.drawString(node.getId(), x, y);

            for (Edge edge : node.getEdges()) {
                Node targetNode = edge.getTarget();
                // Dessiner la ligne de l'arête
                g2d.drawLine((int) node.getX(), (int) node.getY(), (int) targetNode.getX(), (int) targetNode.getY());

                // Dessiner la pointe de la flèche
                double arrowLength = 10.0; // Longueur de la flèche
                double arrowAngle = Math.toRadians(20); // Angle de la flèche
                double deltaX = targetNode.getX() - node.getX();
                double deltaY = targetNode.getY() - node.getY();
                double angle = Math.atan2(deltaY, deltaX);


                // Calculer les coordonnées de la pointe de la flèche
                double arrowX1 = targetNode.getX() - arrowLength * Math.cos(angle - arrowAngle);
                double arrowY1 = targetNode.getY() - arrowLength * Math.sin(angle - arrowAngle);
                double arrowX2 = targetNode.getX() - arrowLength * Math.cos(angle + arrowAngle);
                double arrowY2 = targetNode.getY() - arrowLength * Math.sin(angle + arrowAngle);

                // Dessiner la pointe de la flèche
                g2d.drawLine((int) targetNode.getX(), (int) targetNode.getY(), (int) arrowX1, (int) arrowY1);
                g2d.drawLine((int) targetNode.getX(), (int) targetNode.getY(), (int) arrowX2, (int) arrowY2);
            }
        }
    }

     
    /**
     * Méthode pour obtenir le nœud situé aux coordonnées (x, y)
     * @param x represente l'axe des abscises
     * @param y represente l'axe des ordonnées
     * @return le noeud situé aux coordonnées (x, y) s'il le trouve, sinon null
     */
    private Node getNodeAt(int x, int y) {
        for (Node node : graph.getNodes()) {
            double centerX = node.getX();
            double centerY = node.getY();
            if (x >= centerX - nodeSize / 2 && x <= centerX + nodeSize / 2 &&
                    y >= centerY - nodeSize / 2 && y <= centerY + nodeSize / 2) {
                return node;
            }
        }
        return null;
    }

    /**
     * Cette permet de positionner les nœuds à des positions aléatoires sur l'écran tout en restant à l'intérieur du cadre
     */
    public void run() {
        // Obtenir les dimensions du cadre
        int frameWidth = getWidth();
        int frameHeight = getHeight();
       

        // Positionner les nœuds à des positions aléatoires sur l'écran tout en restant à l'intérieur du cadre
        Random random = new Random();
        for (Node node : graph.getNodes()) {
            int x = random.nextInt(frameWidth-50 - (int) nodeSize) + (int) (nodeSize / 2);
            int y = random.nextInt(frameHeight- (int) nodeSize) + (int) (nodeSize / 2);
            node.setX(x);
            node.setY(y);
        }

        FruchtermanAlgo algo = new FruchtermanAlgo(graph);

        // Boucle principale de l'algorithme de disposition de graphes
        for (int i = 0; i < 11; i++) { // Exemple : effectuez 25 itérations
            algo.updateNodePositions(maxDisplacement, k,temperature,coolingFactor,1800);
            repaint();

        }
    }

}
