package exemple;


import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;



public class joueur extends fenetre{
	/**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private  Set<Integer> set ;
   public HashSet<Integer> rouge=new HashSet<Integer>(); //position possibles pour la totalité des pions 
   public HashSet<Integer> result=new HashSet<Integer>(); //position possibles pour un seul pion 
   public Color col;
   
	public joueur(Set<Integer> sb, Color c) {
		
        col=c;
		set= sb ; 
		
	}
	//************************* RECHERCHE DES POSITIONS POUR UN SEUL PION *************************
	public void recherche_pion (int j,Set<Integer> s)
	{  

   
		
     result.clear();
    //********************************************BAS**********************************************
    int i=j;
    boolean ok=false;
    i+=8;
    while( (s.contains(i)==true) &&(i<=55)) {
    	i+=8; 
    	ok=true;}
    if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && (ok==true)) {result.add(i); rouge.add(i);}
   
    // ********************************************HAUT**********************************************
    i=j;
    ok=false;
    i-=8;
    while( (s.contains(i)==true) &&(i>=7)) {
    	i-=8;
    	ok=true;}
    
     if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i); rouge.add(i);}
   
     // *********************************************DROITE*****************************************
    i=j;
    ok=false;
    i+=1;
    while( (s.contains(i)==true) &&(i%8!=7)) {
    	i+=1;
    	ok=true;}
    
    if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i);rouge.add(i);}
   
    // *********************************************GAUCHE*****************************************
    i=j;
    ok=false;
    i-=1;
    while( (s.contains(i)==true) &&(i%8!=0)) {
    	i-=1;
    	ok=true;}
   
     if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i);rouge.add(i);}
   
     // *********************************************HAUT_DROITE***************************************
     i=j;
     ok=false;
     i-=7;
     while( (s.contains(i)==true) &&(i%8!=7)&&(i>=7)) {
     	i-=7;
     	ok=true;}
    
      if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i);rouge.add(i);}
   
     // ***********************************************HAUT_GAUCHE************************************
      i=j;
      ok=false;
      i-=9;
      while( (s.contains(i)==true) &&(i%8!=0)&&(i>=7)) {
      	i-=9;
      	ok=true;}
     
       if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i); rouge.add(i);}
    
     // *******************************************BAS_DROITE******************************************
       i=j;
       ok=false;
       i+=9;
       while( (s.contains(i)==true) &&(i%8!=7)&&(i<=55)) {
       	i+=9;
       	ok=true;}
      
        if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i);rouge.add(i);}
     
     // *******************************************BAS_GAUCHE******************************************
        i=j;
        ok=false;
        i+=7;
        while( (s.contains(i)==true) &&(i%8!=0)&&(i<=55)) {
        	i+=7;
        	ok=true;}
       
         if ((set.contains(i)==false)&&(s.contains(i)==false) && (i>=0) && ok==true) {result.add(i);rouge.add(i);}
       
	}
	 
	 public Set<Integer> getSet()
	 
	 {
		 return set;
	 
	 }
	  
	 
	 public void setSet(Set<Integer> s)
	 
	 {
		 set=s ;
		 }
	 	 
	}