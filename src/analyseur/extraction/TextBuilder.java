package analyseur.extraction;

import analyseur.backbone.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author KAMGANG KENMOE MIGUEL JORDAN
 *
 */

public class TextBuilder implements Book {

    private List<Page> pages;
    private String path;

    public TextBuilder(String path){
        this.pages = new ArrayList<>();
        this.path = path;
    }

    /**
     * @return la liste des pages
     */
    public List<Page> getPages() {
        //String path = "src/analyseur/model/files/ames.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder currentPageText = new StringBuilder();
            String currentPageNumber = "";
            List<String> nextPageNumbers = new ArrayList<>();
            Page page = new Page();

            while ((line = reader.readLine()) != null) {

                // Vérifiez si la ligne est un numéro de page
                if (line.matches("\\d+")) {
                    // Traitez le texte associé à la page précédente
                    if (page != null) {
                        extractChoices(currentPageText.toString(), nextPageNumbers,page);
                        page.setText(currentPageText.toString());
                        page.setIdPage(currentPageNumber);
                        for(String p:nextPageNumbers){page.setChoice(p);} 
                     
                       pages.add(page);
                        

                        nextPageNumbers = new ArrayList<>(); // Réinitialisez les numéros de page suivante
                        currentPageText = new StringBuilder(); // Réinitialisez le texte pour la nouvelle page
                    }

                    // Créez une nouvelle page
                    page = new Page();
                    currentPageNumber = line;
                } else {
                    // Ajoutez la ligne au texte de la page actuelle
                    currentPageText.append(line).append("\n");
                }
            }

            // Traitez le texte de la dernière page
            if (page != null) {
                extractChoices(currentPageText.toString(), nextPageNumbers,page);
                page.setText(currentPageText.toString());
                page.setIdPage(currentPageNumber);
                for(String p:nextPageNumbers){page.setChoice(p);} 
                pages.add(page);
            }

            // Affichez les pages créées
          

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(pages.get(0).getIdPage() == "") pages.remove(0);

       

        return pages;
    }

    /**
     * 
     * @param text represente le text a rechercher
     * @param nextPageNumbers represente la liste de pages suivantes
     * @param page represente la page sur laquelle on travaille
     */
    private static void extractChoices(String text, List<String> nextPageNumbers,Page page) {
        // Utilisez une expression régulière pour extraire les numéros après "rendez-vous au"
        Pattern pattern = Pattern.compile("(?i)rendez\\s*-\\s*vous\\s*au\\s*(\\d+)");
        Pattern patternCombat = Pattern.compile("(?i)Si vous êtes vainqueur");
        Matcher matcher = pattern.matcher(text);
        Matcher matcherCombat = patternCombat.matcher(text);

        if(matcherCombat.find()){
          page.setCombat();
        }

        while (matcher.find()) {
            String rendezVousAuNumber = matcher.group(1);
            nextPageNumbers.add(rendezVousAuNumber);
        }
    }
}
