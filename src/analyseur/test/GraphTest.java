package analyseur.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import analyseur.backbone.Page;
import analyseur.model.Graph;
import analyseur.model.Node;

/**
 * 
 * DIOUKOU MOUSSA SISSOKO
 * 
 */

public class GraphTest {

    @Test
    public void getNodes() {
    }

    @Test
    public void getNodeMap() {
        Page page1 = new Page();
        Page page2 = new Page();
        Page page3 = new Page();
        Page page4 = new Page();

        page1.setIdPage("1");
        page2.setIdPage("2");
        page3.setIdPage("3");
        page4.setIdPage("4");

        page1.setCombat();
        page3.setCombat();

        page1.setText("Text page1");
        page2.setText("Text page2");
        page3.setText("Text page3");
        page4.setText("Text page4");

        page1.setChoice(Arrays.asList("2","3").toString());
        page2.setChoice(Arrays.asList("3").toString());
        page3.setChoice(Arrays.asList("4").toString());
        page4.setChoice(Collections.emptyList().toString());

        List<Page> pages = new ArrayList<>();
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);

        Graph graph = new Graph(pages);
        assertNotNull(graph);

        // Vérifie que chaque nœud contient les données attendues
        Map<String, Node> nodeMap = graph.getNodeMap();
        assertTrue(nodeMap.containsKey("1"));
        assertTrue(nodeMap.containsKey("2"));
        assertTrue(nodeMap.containsKey("3"));
        assertTrue(nodeMap.containsKey("4"));

        Node node1 = nodeMap.get("1");
        assertEquals("Text page1", node1.getText());
        assertTrue(node1.getFigth());
        assertEquals(1, node1.getEdges().size());

        Node node2 = nodeMap.get("2");
        assertEquals("Text page2", node2.getText());
        assertFalse(node2.getFigth());
        assertEquals(1, node2.getEdges().size());

        Node node3 = nodeMap.get("3");
        assertEquals("Text page3", node3.getText());
        assertTrue(node3.getFigth());
        assertEquals(1, node3.getEdges().size());

        Node node4 = nodeMap.get("4");
        assertEquals("Text page4", node4.getText());
        assertFalse(node4.getFigth());
        assertEquals(1, node4.getEdges().size());
    }
}