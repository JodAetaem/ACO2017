package moteur;


/**
 * @info Implémentation du moteur 
 * @generated
 */

public class MoteurImp implements Moteur
{
	/**
	 * @info Buffer de texte 
	 * @generated
	 * @ordered
	 */
	
	private StringBuffer texte;

	/**
	 * @info PressPapier
	 * @generated
	 * @ordered
	 */
	
	private String presspaper;
	/**
	 * @info portion de texte selectionner. Si end == start , alors position courante
	 * @generated
	 * @ordered
	 */
	
	private Selection selection;//c'est un test #passalivaire mdr
	
	

	public StringBuffer getTexte() {
		return texte;
	}

	public void setTexte(StringBuffer texte) {
		this.texte = texte;
	}

	public String getPresspaper() {
		return presspaper;
	}

	public void setPresspaper(String presspaper) {
		this.presspaper = presspaper;
	}

	public Selection getSelection() {
		return selection;
	}
	
	public void setSelection(int start, int end) {
		selection.setEnd(end);
		selection.setStart(start);
	}


	/**
	 *@info constructeur
	 * @generated
	 */
	public MoteurImp(String texteinit){
		texte = new StringBuffer (texteinit);
		presspaper="";
		selection = new Selection();
		selection.selection(0,0);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public void Selectionner(int start, int end) {
		if(end !=-1 ) {
			if(start < 0 || end < 0 ) {
				selection.setStart(0);
				selection.setEnd(0);
			}
			else if(texte.length()<end ){
				if(texte.length()<start) {
					selection.setEnd(texte.length()); //end et start son plus grand que la longeur u texte
					selection.setStart(texte.length());//on selectionne donc tout le texte
				}
				else {
					selection.setStart(start);
					selection.setEnd(texte.length());
				}
			}
			else if(texte.length()<start) { //si jamais selection end correct mais start incorrect (ex: 117000 et 3)
				selection.setStart(end);	// mets le curseur a la position valide end
				selection.setEnd(end);
			}
			else if (end<start){
				selection.setStart(end);
				selection.setEnd(start);
				
			}else {
				selection.setStart(start);
				selection.setEnd(end);
				}
		}
		else {
			if(start<0) {
				selection.setStart(0);
				selection.setEnd(texte.length());
			}
			else if(texte.length()<start) {
				selection.setEnd(texte.length()); //end et start son plus grand que la longeur u texte
				selection.setStart(texte.length());//on selectionne donc tout le texte
			}
			else {
				selection.setStart(start);
				selection.setEnd(texte.length());
			}
		}
		
	}

	/**
	 *@info colle le texte precedement copier a la position courante
	 * @generated
	 * @ordered
	 */
	
	public void Coller() {
		Inserer(presspaper);
		}

	/**
	 * @info coupe le texte selectionner
	 * @generated
	 * @ordered
	 */
	
	public void Couper() {
		Copier();
		texte.delete(selection.getStart(), selection.getEnd());
		selection.setEnd(selection.getStart());
	}

	/**
	 * @info inserer le texte parameter a la position courante
	 * @generated
	 * @ordered
	 */
	
	public void Inserer(String phrase) {
		if (selection.getEnd()==selection.getStart()){
			texte.insert(selection.getStart(), phrase.toCharArray());
			selection.setStart(selection.getStart()+phrase.length());	// on positionne le curseur a la fin de la string colle
			selection.setEnd(selection.getStart());
		}
		else {
			texte.delete(selection.getStart(), selection.getEnd());
			texte.insert(selection.getStart(), phrase.toCharArray());
			selection.setStart(selection.getStart()+phrase.length());	// on positionne le curseur a la fin de la string colle
			selection.setEnd(selection.getStart());
		}
	}

	/**
	 * @info copie la selection courante
	 * @generated
	 * @ordered
	 */
	
	public void Copier() {
		presspaper = texte.substring(selection.getStart(), selection.getEnd());
			}
	
	
	/**
	 * mets la selection a la fin du texte
	 */
	public void finDuTexte() {
		setSelection(texte.length(), texte.length());
	}

}



