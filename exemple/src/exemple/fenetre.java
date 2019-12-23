package exemple;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//CardLayout cl = new CardLayout();
	//JPanel panel=new JPanel(); 
	// Instanciation d'un objet JPanel
	 
    
	 
	 
	 
	
	public fenetre() {
		
		
	    this.setTitle("Jeu Othello");                         // nom du fenetre
	    this.setSize(700, 700);                               // size du fenetre
	    this.setLocationRelativeTo(null);                     // position du fenetre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // fermer la fenetre lorsque on clique sur la croix rouge
	  
	    this.setLayout(new GridLayout(8,8,4,4));
	    //ou   //GridLayout gh= new GridLayout (8,8);
	    //gh.setHgap(4); //4pixels d'espace entre les colonnes 
	    //gh.setVgap(4); //4pixels d'espace entre les lignes
	   
	      
	   
	   }
}






	
	