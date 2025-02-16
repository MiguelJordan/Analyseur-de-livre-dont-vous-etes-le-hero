package analyseur.extraction;

import analyseur.backbone.Book;
import analyseur.backbone.Page;

import javax.json.*;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author KAMGANG KENMOE MIGUEL JORDAN
 *
 */

public class JsonBuilder implements Book {
    
    BookLabel book;
    List<Page> pages;
    private String path;

    public JsonBuilder(String path,BookLabel book){
        this.pages = new ArrayList<>();
        this.book = book;
        this.path = path;
    }

  

   /**
    * @return  la liste des pages 
    */
   public List<Page> getPages(){

    try {
            // Lire le fichier JSON en tant qu'objet JsonObject
            JsonObject jsonObject = lireFichierJson(path);

            // Accéder à la section principale "sections"
            JsonObject sectionsObject = jsonObject.getJsonObject(book.getTitle());

            //accéder au synonymes des mots
           // JsonObject synonymes = jsonObject.getJsonObject("synonyms");
            JsonArray synonymes =  jsonObject.getJsonArray("synonyms");
          
            List fightSynonyms = synonymes.getJsonArray(1);

            List<String> list = new ArrayList<String>();

            for(int i=0; i<fightSynonyms.size();i++){
                
                String str = fightSynonyms.get(i).toString();
                list.add(str.substring(1, str.length()-1));
                //System.out.println("added : " + str.substring(1, str.length()-1));
            }

            System.out.println("synonyms : " + list);

            // Parcourir chaque entrée de la section "sections"
            for (Map.Entry<String, JsonValue> entry : sectionsObject.entrySet()) {
                String sectionNumber = entry.getKey();
                JsonObject section = (JsonObject) entry.getValue();

                String text = section.getString(book.getTextLabel(), "");

                Page p = new Page();
                p.setIdPage(sectionNumber);
                p.setText(text);

                for(int i =0; i < list.size(); i++){
                    
                    //System.out.println(text);
                    if(text.contains(list.get(i))){
                        p.setCombat();
                       
                        break;
                    }
                }
               

               // System.out.println("Paragraphe: " + text);
               // System.out.println("Numéro de page: " + sectionNumber);
         

                // Vérifier s'il y a des choix
                if (section.containsKey(book.getChoiceLebel())) {
                    JsonArray choicesArray = section.getJsonArray(book.getChoiceLebel());

                    // Parcourir chaque élément de la section des choix
                    for (JsonValue choiceValue : choicesArray) {
                        JsonObject choice = (JsonObject) choiceValue;

                    

                        // Extraire le texte du choix et la section de destination
                        //String choiceText = choice.getString("text", "");
                        String destinationSection = choice.getString(book.getNextPageLebel(), "");

                        p.setChoice(destinationSection);

                        //System.out.println("   Choix: " + choiceText + " (Destination: " + destinationSection + ")");
                    }
                }

                pages.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

      return pages;
   }

       

    // 
    /**
     * Méthode pour lire le fichier JSON en tant qu'objet JsonObject
     * @param cheminFichier represente le chemin vers le fichier json
     * @return un objet json 
     */
    private static JsonObject lireFichierJson(String cheminFichier) {
        Path chemin = Paths.get(cheminFichier);

        System.out.println("Chemin absolu du fichier : " + chemin.toAbsolutePath());

        try (JsonReader reader = Json.createReader(new FileReader(chemin.toFile()))) {
            return reader.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

}
