package analyseur.backbone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Note: .
 * 
 * @author Laith Alhazzaa, Université de Caen Normandie, France
 * @author Ayath Abogounrin, Université de Caen Normandie, France
 * @author Miguel Jordan Kamgang Kenmoe, Université de Caen Normandie, France
 * @author Dioukou Moussa Sissoko, Université de Caen Normandie, France
 */

public class Page {
	private String idPage;
	private List<String> choice;
	private String text;
	private String label;
	private boolean fight;
	//private List<Boolean> fighList;

	public Page(){
	
		this.choice = new ArrayList<>();
		fight = false;
		
	
	}
	
	
	//setters

	/**
	 * 
	 * @param idPage l'identifiant de la page
	 * @ensures de modifier l'identifiant
	 */
	public void setIdPage(String idPage) {
		this.idPage = idPage;
	}
	/**
	 * 
	 * @param choice un des choix pour la page suivante
	 * @ensures d'ajouter ce choix dans la liste des choix
	 */
	public void setChoice(String choice) {
		this.choice.add(choice);
	}

	/**
	 * 
	 * @param text le texte de la page
	 * @ensure de modifier le texte de la page
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @param label le label de la page
	 */
	public void setLibelle(String label) {
		this.label = label;
	}

	/**
	 * @ensures de dire qu'il y a combat dans la page
	 */
	public void setCombat() {
		this.fight = true;
	}
	
	
	
	//getters

	/**
	 * 
	 * @return l'identifiant de la page
	 */
	public String getIdPage() {
		return this.idPage;
	}
	
	/**
	 * 
	 * @return le texte de la page
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * 
	 * @return un booleen qui dit si il y a combat
	 */
	public boolean isFight() {
		return this.fight;
	}
	
	/**
	 * 
	 * @return le label de la page
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * 
	 * @return la liste des choix suivants pour la page
	 */
	public List<String> getChoice() {
		return this.choice;
	}

	

	public String toString(){
		return "numero: "+this.idPage+" choix: "+this.choice + " combat? = " + this.fight;
	  }

}
