package analyseur.test;


import analyseur.backbone.Page;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
/**
 * 
 * DIOUKOU MOUSSA SISSOKO
 * 
 */

public class PageTest {

    @Test
    public void set_idPage_and_get_idPage_should_return_true() {
        Page page = new Page();
        page.setIdPage("1");
        assertEquals("1",page.getIdPage());
    }

    @Test
    public void setChoice_and_getChoice_should_return_true() {
        Page page = new Page();
        page.setChoice("2");
        assertEquals(Arrays.asList("2"), page.getChoice());
    }

    @Test
    public void setText_and_getText_should_return_true() {
        Page page = new Page();
        page.setText("Page text");
        assertEquals("Page text", page.getText());
    }

    @Test
    public void setLibelle_and_getLibele_should_return_true() {

    }

    @Test
    public void setCombat_should_return_true() {
            Page page = new Page();
            page.setCombat();
            assertTrue(page.isFight());
    }

    @Test
    public void getIdPage_should_return_true() {
        Page page = new Page();
        page.setLibelle("Page label");
        assertEquals("Page label", page.getLabel());
    }

    @Test
    public void isFight_should_return_false() {
        Page page = new Page();
        assertFalse(page.isFight());
    }

    @Test
    public void isFight_should_return_true() {
        Page page = new Page();
        page.setCombat();
        assertTrue(page.isFight());
    }

    @Test
    public void test_page_creation() {
        Page page = new Page();
        assertNotNull(page);
        assertFalse(page.isFight());
        assertNotNull(page.getChoice());
        assertEquals(0, page.getChoice().size());
        assertNull(page.getIdPage());
        assertNull(page.getText());
        assertNull(page.getLabel());
    }

}