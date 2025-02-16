package analyseur.extraction;

public class BookLabel {
    
    String pageContainer;
    String choiceLabel;
    String nextPageLabel;
    String textLabel;

    public BookLabel(String pageContainer, String choiceLabel,String nextPageLabel,  String textLabel){
        this.pageContainer = pageContainer;
        this.choiceLabel = choiceLabel;
        this.nextPageLabel = nextPageLabel;
        this.textLabel = textLabel;
    }

    /**
     * 
     * @return l'identifiant du conteneur des page
     */
    public String getTitle(){return this.pageContainer;}

    /**
     * 
     * @return l'identifiant du conteneur des choix
     */
    public String getChoiceLebel(){return this.choiceLabel;}
    /**
     * 
     * @return l'identifiant du conteneur des pages suivantes
     */
    public String getNextPageLebel(){return this.nextPageLabel;}
    /**
     * 
     * @return l'identifiant du conteneur des textes
     */
    public String getTextLabel(){return this.textLabel;}
}
