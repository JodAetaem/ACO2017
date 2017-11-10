package moteur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

//JtextArea

public class Panneau extends JPanel{
	
	public Panneau() {
		this.setBackground(Color.PINK);
		this.setOpaque(true);
	}

	@Override	
	public void paintComponent(Graphics g) {
		//g.drawRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2);
		super.paintComponent(g);	//pout la couleur de fond

		Font police = new Font("Comic sans MS",0, 15);	
		g.setFont(police);
		String phrase = "Azizi a toutes et tous ceci est moi qui suis content de vous voir en ce jour, yallah al vie de ma mère je suis refait de toutes ces friandises";

		g.drawString(phrase, 10, 20);

		
	}
	
	//NEWLINE NE MARCHE PAS DANS UN PANEL
	/**
	 * @author Charles & JB
	 * @return la string s en passant a la ligne tout les taille caractères
	 * @param s La string a découper
	 * @param taille La taille de la string avant de la découper
	 *  
	 */
	public String lecoupeur(String s, int taille) {
		String rep ="";
		String alali = System.getProperty("line.separator");
		if(s.length()>taille) {
			rep = s.substring(0, taille) + alali + lecoupeur(s.substring(taille+1,s.length()), taille);
		}
		
		return rep;
	}
	
}
