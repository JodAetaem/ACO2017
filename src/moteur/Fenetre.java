package moteur;

import javax.swing.*;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import javax.swing.text.BadLocationException;
import javax.swing.GroupLayout.*;

import java.awt.Color;

public class Fenetre extends JFrame{
	
    private JLabel etiquette;
    private JScrollPane scroll;
    private JTextArea zonetexte;
	
	private void initialisation() {
		JLabel etiquette = new JLabel("Bienvenu dans l'éditeur de l'amour");
		
		zonetexte = new JTextArea();
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    zonetexte.setColumns(40);
	    zonetexte.setRows(10);
	    zonetexte.setLineWrap(true);	// passage a la ligne quand on arrive en bout de ligne
	    zonetexte.setWrapStyleWord(true);//ne coupe pas les mot en cas de passage a la ligne (avec espace)
	    
	    scroll = new JScrollPane(zonetexte); //barre de scroll pour l'éditeur de texte
	    
	    GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        
        //Grand groupe horizontal
        ParallelGroup groupeHori = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        
    	SequentialGroup horigroupe1 = layout.createSequentialGroup();	//groupe sequentielle (l'un après l'autre)
        ParallelGroup horigroupe2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);//groupe parallel
        
        horigroupe2.addComponent(scroll, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        horigroupe2.addComponent(etiquette, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE);
        
        horigroupe1.addContainerGap();//espace a gauche de la zone de texte
        horigroupe1.addGroup(horigroupe2);	//ajout du groupe 2 dans le groupe 1
        horigroupe1.addContainerGap();		//espace a droite de la zone de texte
        
        groupeHori.addGroup(Alignment.TRAILING,horigroupe1);	// le groupe 1 dans le grand groupe
        
    	layout.setHorizontalGroup(horigroupe1); //Le Horigroupe devient le groupe horizontal
    	
    	//Faire un groupe vertical
    	ParallelGroup groupeVerti = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
    	
    	SequentialGroup vertigroupe1 = layout.createSequentialGroup();	
    	vertigroupe1.addContainerGap();
    	vertigroupe1.addComponent(etiquette);
    	vertigroupe1.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
    	vertigroupe1.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE);
    	vertigroupe1.addContainerGap();//espace en dessous de la zone de texte
    	
    	groupeVerti.addGroup(vertigroupe1);
    	layout.setVerticalGroup(groupeVerti); //le VertiGroupe devient le groupe verticale
    	
    	// IL faut que le groupe Horizontal soit liée a un vertical, sinon crash
    	
    	
    	pack();
    	
	}
	
	
	
	public Fenetre(){
		
		
		initialisation();
		
			//init de la fenetre
		this.setTitle("Editeur ACO Love V1"); //Titre de la fenetre
		this.setSize(800, 600); 		//Taille a l'ouverture de la fenetre
		//this.setMaximumSize(maximumSize);	// Taille max de la fenetre, a définir ?
		this.setLocationRelativeTo(null); // postionne la fenetre au centre de l'écran
		this.setVisible(true);		//Visibilité : True
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application en même temps que la fenetre
		

	/*
		//JPanel
	JPanel panel = new JPanel(); // initialisation du panel
	panel.setBackground(Color.pink);	// Couleur de fond 
	
		//JTextArea
	JTextArea zonetexte = new JTextArea(5,30);
	zonetexte.setEditable(false);
	JScrollPane panes = new JScrollPane(zonetexte);
	zonetexte.append("azizi a toutes et a tous");
	
	
	//this.setContentPane(panel);
	Panneau p = new Panneau();
	this.setContentPane(p);	
		*/
	}

}
