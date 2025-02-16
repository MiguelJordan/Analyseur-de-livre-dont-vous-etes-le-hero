package analyseur.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import analyseur.model.Edge;
import analyseur.model.Node;
/**
 * 
 * DIOUKOU MOUSSA SISSOKO
 * 
 */
public class EdgeTest {
    @Test
    public void testEdgeCreation() {
        Node node = new Node("2");
        Edge edge = new Edge(node, 5);
        assertNotNull(edge);
    }

    @Test
    public void getTarget_should_return_targetNode(){
        Node targetNode = new Node("3");
        Edge edge = new Edge(targetNode,1);
        assertEquals(targetNode,edge.getTarget());
    }

    @Test
    public void getWeight_should_return_edge_weight(){
        Node targetNode = new Node("5");
        Edge edge = new Edge(targetNode,1);
        assertEquals(1,edge.getWeight());
    }
}