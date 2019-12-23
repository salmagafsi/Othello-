package exemple;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;

public class Test {
  


public static void main(String[] args) {
		
		//***********creation de l'interface******************
	
		 fenetre fen = new fenetre();
		 Dimension dim = new Dimension(50, 40);
		 JButton[] tab_button = new JButton [64] ;
		

		 for (int i=0 ; i<64; i++)
					{
			 tab_button[i] =new JButton ();
			 tab_button[i].setPreferredSize(dim);
			}
			
		 fen.setLayout(new GridLayout(8,8,3,3));
		 for (int i=0 ; i<64 ; i++)
			{
				fen.getContentPane().add(tab_button[i]);
				tab_button[i].setBackground(Color.green);

			}

			 
		 fen.setVisible(true);
		 tab_button[27].setBackground(Color.black);
		 tab_button[28].setBackground(Color.white);
		 tab_button[35].setBackground(Color.white);
		 tab_button[36].setBackground(Color.black);
		
		
		//************list blanc**************
	
		Set<Integer> listBlanc = new HashSet<Integer>(){
			private static final long serialVersionUID = 1L;{ add(28);add(35);}};
			
		
		
		
		//*************list noir************
			
		    Set<Integer> listNoir = new HashSet<Integer>(){
			private static final long serialVersionUID = 1L;{ add(27);add(36);}};
		
			
			
			
			//***************creation des joueurs***************

		
		 joueur joueurB= new joueur(listBlanc, Color.white);
		 joueur joueurN= new joueur(listNoir, Color.black);
		 

            //***************commencer le jeu***************** 
		    int a=0; //compter le nombre des pions à placer 
			boolean ok=true;   //le joueur noir joue lorsque ok=true el le joueur blanc joue lorsque ok=false 

	while(a<59)
 
	{
	   if (ok==true)
		
			{
			 
			//***********recherche du position pour le joueur noir**********
			 
			 
				   joueurN.rouge.clear();
 			       for(int j:joueurN.getSet()) {
				             joueurN.recherche_pion(j, joueurB.getSet());
			       for(int i:joueurN.result) {
				             tab_button[i].setBackground(Color.red); }}
			 
	      if(joueurN.rouge!=null)    //si le joueur noir a la possiblité de placer un pion  
			   
			   {
			
			
			//***********************************jouer le coup joueur noir*********************
			

			 
			   HashSet<Integer> copie_blanc = new HashSet<Integer>();  //pour conserver les pions à inverser 
		       HashSet<Integer> copie_noir = new HashSet<Integer>();   //les pions gagnés par le joueur 
		       ArrayList<Integer> l=new ArrayList<Integer>();
			  
			while (l.size()!=1)
			{
			  for(int i:joueurN.rouge) {
				   tab_button[i].addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){l.add(i); if (l.size()==1)  
						   tab_button[i].setBackground(Color.black); }});}   //où le joueur a placé son pion  
			 }
			
			  if (l.size()==1)
			  {  
				  joueurN.rouge.remove(l.get(0));
				  copie_noir.add(l.get(0));
	  
			  for(int i:joueurN.rouge) {tab_button[i].setBackground(Color.green); } 
			  joueurN.rouge.clear();
    
	//changer les couleurs des pions de l'adversaire qui sont placés entre le pion joué	et un autre pion de la même couleur		  
			 
			  for(int j:joueurN.getSet()) {
				 int i=l.get(0);
								joueurN.recherche_pion(j, joueurB.getSet());
							    if(joueurN.result.contains(i)) {
								   int k=j-i;
								   if(k%8==0) {if(j<i) {for(j+=8;j<i;j+=8) {tab_button[j].setBackground(Color.black); copie_noir.add(j);copie_blanc.add(j);}}
								              else{for(j-=8;i<j;j-=8) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}} }
								   
								   else if(k%7==0) {if(j<i) {for(j+=7;j<i;j+=7) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}
						                      else{for(j-=7;i<j;j-=7) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}}
								   
								   else if(k%9==0) {if(j<i) {for(j+=9;j<i;j+=9) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}
						                      else{for(j-=9;i<j;j-=9) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}}
								   
								   else {if(j<i) {for(j+=1;j<i;j++) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}
						                      else{for(j-=1;i<j;j--) {tab_button[j].setBackground(Color.black);copie_noir.add(j);copie_blanc.add(j);}}}
								   
							       }
							    
						       }	
						   
							  for(int h: copie_noir){joueurN.getSet().add(h);} // mise à jour de l'ensemble qui contient les pions de joueur noir 
							  for(int h: copie_blanc){joueurB.getSet().remove(h);}  // mise à jour de l'ensemble qui contient les pions de joueur blanc 
							ok=false;
							a++;
						
							  

						   }}
			  
	
		 else ok=false; //le joueur blanc qui va jouer à la place de joueur noir 
	      }
		
else {
		

					
				
					//***********recherche du position pour joueur blanc**********
					
	                 joueurB.rouge.clear();
					 for(int j:joueurB.getSet()) {
						joueurB.recherche_pion(j, joueurN.getSet());
					    for(int i:joueurB.result) {
						         tab_button[i].setBackground(Color.blue); }}
					 
					 if(joueurB.rouge!=null) {
					
					//***********************************jouer le coup, joueur blanc*********************
					

					 
					HashSet<Integer> copie_blanc = new HashSet<Integer>();
				    HashSet<Integer> copie_noir = new HashSet<Integer>();
				     ArrayList<Integer> l=new ArrayList<Integer>();
					  
					while (l.size()!=1)
					{
					  for(int i:joueurB.rouge) {
						   tab_button[i].addActionListener(new ActionListener(){
							   public void actionPerformed(ActionEvent event){l.add(i); if (l.size()==1)  
								   tab_button[i].setBackground(Color.white); }});}
					 }
					
				if (l.size()==1)
					 {  
						 joueurB.rouge.remove(l.get(0));
						 copie_blanc.add(l.get(0));
						  
					  for(int i:joueurB.rouge) {tab_button[i].setBackground(Color.green); }
					  joueurB.rouge.clear();
					  
					  for(int j:joueurB.getSet()) {
						 int i=l.get(0);
										joueurB.recherche_pion(j, joueurN.getSet());
									    if(joueurB.result.contains(i)) {
										   int k=j-i;
										   if(k%8==0) {if(j<i) {for(j+=8;j<i;j+=8) {tab_button[j].setBackground(Color.white); copie_noir.add(j);copie_blanc.add(j);}}
										              else{for(j-=8;i<j;j-=8) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}} }
										   
										   else if(k%7==0) {if(j<i) {for(j+=7;j<i;j+=7) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}
								                      else{for(j-=7;i<j;j-=7) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}}
										   
										   else if(k%9==0) {if(j<i) {for(j+=9;j<i;j+=9) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}
								                      else{for(j-=9;i<j;j-=9) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}}
										   
										   else {if(j<i) {for(j+=1;j<i;j++) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}
								                      else{for(j-=1;i<j;j--) {tab_button[j].setBackground(Color.white);copie_noir.add(j);copie_blanc.add(j);}}}
										   
									       }
									    
								       }	
								   
									  for(int h: copie_blanc){joueurB.getSet().add(h);}
									  for(int h: copie_noir){joueurN.getSet().remove(h);}
									ok=true;
									a++;
								
									  

								   }}
					  
			
				 else ok=true; //le joueur noir qui va jouer à la place de joueur blanc  
				}


}

if (joueurN.getSet().size()>joueurB.getSet().size())
{
    System.out.println("Congratulations ! the winner is the black player");	
}
else if (joueurN.getSet().size()<joueurB.getSet().size())
		{
        	System.out.println("Congratulations ! the winner is the white player");
		}
else 
{
	System.out.println(" Equality !");
}



}
}











//**************************hors du main*********************************