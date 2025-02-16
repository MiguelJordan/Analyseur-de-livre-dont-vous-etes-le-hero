package analyseur.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import analyseur.model.Graph;

public class GUI extends JFrame{

    public GUI( Graph graph){
        setSize(1850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Graph Visualization");

        GraphVisualization visualization = new GraphVisualization(graph);

        JScrollPane scrollPane = new JScrollPane(visualization);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
       

        setVisible(true);
        pack();
    }
    
}
