package analyseur.view;

//import analyseur.model.TextBuilder;


import java.util.List;
import analyseur.backbone.Book;
import analyseur.backbone.Page;
import analyseur.model.Graph;
import analyseur.extraction.BookLabel;
import analyseur.extraction.JsonBuilder;





public class Main {
    public static void main(String[] args) {
        
        Book book = new JsonBuilder("res/hero.json",
                new BookLabel("sections", "choices", "section", "text"));
        //Book book = new TextBuilder("src/analyseur/model/files/ames.txt") ;       
        List<Page> pages;
        pages = book.getPages();
        Graph graph = new Graph(pages);

        new GUI(graph);

       
    }
}
