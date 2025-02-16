package analyseur.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import analyseur.model.Edge;
import analyseur.model.Node;

public class NodeTest {


    @Test
    public void testNodeCreation() {
     Node node = new Node("1");
     assertNotNull(node);
    }

    @Test
    public void getId_should_return_node_id(){
        Node node = new Node("10");
        assertEquals("10", node.getId());
    }

    @Test
    public void getText_should_return_node_text(){
        String text = "Hi, World!";
        Node node = new Node("55");
        node.setText(text);
        assertEquals(text, node.getText());
    }

    @Test
    public void testAddEdges() {
        Node node = new Node("1");
        Edge edge = new Edge( node, 1);
        node.addEdges(edge);
        assertEquals(1, node.getEdges().size());
        assertTrue(node.getEdges().contains(edge));
    }

    @Test
    public void getEdges_should_be_not_null(){
        Node node = new Node("223");
        Node nodeTarget = new Node("225");
        Edge edge = new Edge(nodeTarget,1);
        node.addEdges(edge);
        assertNotNull(node.getEdges());
    }

    @Test
    public void getEdges_should_return_0(){
        Node node = new Node("223");
        assertEquals(0, node.getEdges().size());
    }

    @Test
    public void getFight_should_return_false(){
        Node node = new Node("224");
        assertFalse(node.getFigth());
    }

    @Test
    public void getFight_should_return_true(){
        Node node = new Node("224");
        node.setFight(true);
        assertTrue(node.getFigth());
    }


    @Test
    public void testUpdatePosition() {
     Node node = new Node("1");
     node.setDx(1.0);
     node.setDy(2.0);
     node.updatePosition(5.0);
     assertTrue(node.getX() != 0.0 || node.getY() != 0.0);
     assertEquals(0.0, node.getDx(),0.000001);
     assertEquals(0.0, node.getDy(),0.00001);
    }
}