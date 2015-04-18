package pack_Main;

//import pack_Main.JImageViewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L; //Sert a rien
	JPanel panel = new JPanel(); //Fenetre Complete
	JPanel panel_1 = new JPanel(); //Barre de titre
	JPanel panel_grille = new JPanel(); //Sous fenetre de grille
	JButton btnLogs = new JButton("Logs"); 
	JButton btnOptions = new JButton("Options"); //3 boutons
	JButton btnReset = new JButton("Reset");
	final int WIDTH = 500;
	final int HEIGHT = 526;
	PartieEnCours partie = new PartieEnCours(0); //Défini la partie, pour changer le nb de cases, changer le nb en parenthèse
	BoutonCase[][] tableauBoutons; //Ma matrice de bouton
	int tableauEtatGrille[][]; //Etat, selon la position du bouton, même coordonnées: Quand 1ère utilisation, pas de valeur définie, après reset, tout a 0. 1 pour cercle, 2 pour croix
	FenetreLogs logs = new FenetreLogs();
	
	//Test commentaire
	
	public static void main(String[] args) //creer ma fenetre de base, ne pas trop toucher, sinon ça plante
	{
		EventQueue.invokeLater
		(
			new Runnable() 
			{
				public void run() 
				{
					try 
					{
						Main frame = new Main();
						frame.setVisible(true);
						frame.setResizable(false); //mettre a true pour redimensionner
						frame.setAlwaysOnTop(true);
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		);	
	}

	public Main() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");
		
	    int taille = Integer.parseInt(JOptionPane.showInputDialog(null, "Indiquer le nombre de cases que fait votre grille !", "Initialisation", JOptionPane.QUESTION_MESSAGE));
	    if(taille > 1)
	    	partie.setTaille(taille);
	    else
	    {
	    	int option = JOptionPane.showConfirmDialog(null, "Vous êtes sur de vous ?");
	    	
	    	if(option == JOptionPane.OK_OPTION)
	    	{
	    		JOptionPane.showMessageDialog(null, "Eh bien... Comme vous voudrez !");
	    		partie.setTaille(taille);
	    	}
	    	if(option == JOptionPane.NO_OPTION)
	    	{
	    		JOptionPane.showMessageDialog(null, "Bon choix !");
	    	}
	    }
		//partie.setTaille(3);
		
		panel.setLayout(new BorderLayout(0, 0));
		panel.setPreferredSize(new Dimension(500, 500));;
		add(panel);
		pack(); //Met la fenetre aux dimension de ce qu'il y a dedans
		this.setBounds(15, 15, this.getWidth(), this.getHeight());
		
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.setBounds(0, 0, WIDTH, 26);;
		
		btnLogs.addActionListener(this);
		panel_1.add(btnLogs, BorderLayout.WEST);
		
		btnReset.addActionListener(this);
		panel_1.add(btnReset, BorderLayout.CENTER);
		
		btnOptions.addActionListener(this);
		panel_1.add(btnOptions, BorderLayout.EAST);
		
		panel.add(panel_grille, BorderLayout.CENTER);
		panel_grille.setLayout(new GridLayout(partie.getTaille(), partie.getTaille()));
		
		tableauBoutons = new BoutonCase[partie.getTaille()][partie.getTaille()];
		tableauEtatGrille = new int[partie.getTaille()][partie.getTaille()];
		
		logs.setOuvert(false);
		
		creationBouton(WIDTH, HEIGHT-panel_1.getHeight()); //Initialise les boutons
		initialisationTableauEtat();
		
		resetPartie();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) { //Si bouton appuyé
		if(arg0.getSource() == btnLogs)
		{
			if(logs.getOuvert() == false)
			{
				logs.setX(this.getX()-5);
				logs.setY(this.getY() + this.getHeight()+5);
				logs.setHeight(150);
				logs.setWidth(this.getWidth()+10);
				
				logs.main(null);
				
				logs.setOuvert(true);
				
				System.out.println("Ouvert");
			}
			else
			{
				logs.close();
				
				logs.setOuvert(false);
				
				System.out.println("Fermé");
			}
		}
		
		if(arg0.getSource() == btnOptions)
		{
			//logs.testEcriture();
		}
		
		if(arg0.getSource() == btnReset) //btn = reset
		{
			if(btnReset.getLabel() == "Rejouer")
			{
				btnReset.setLabel("Reset");
				
				logs.sauterLignes(1);
				logs.afficherMessageRejouer();
				logs.sauterLignes(1);
				
				int i, j;
				
				for(j=0 ; j<partie.getTaille() ; j++)
				{
					for(i=0 ; i<partie.getTaille() ; i++)
					{
						tableauBoutons[i][j].degriseBouton();
					}
				}
			}
			else
			{
				String[] choix = {"Oui", "Non"};
			    int optionChoisie = JOptionPane.showOptionDialog(null, 
			      "Etes-vous sur ?" + "\n" + "Tous vos scores serons perdus !",
			      "Reset ?",
			      JOptionPane.YES_NO_CANCEL_OPTION,
			      JOptionPane.QUESTION_MESSAGE,
			      null,
			      choix,
			      choix[1]);
			    
			    if(choix[optionChoisie] == choix[0])
			    {
			    	partie.setVictoires(0, 1);
			    	partie.setVictoires(0, 2);
			    	
			    	logs.sauterLignes(1);
			    	logs.afficherMessageReset();
			    	logs.sauterLignes(1);
			    }
			}
			resetPartie();
		}
		
		if(arg0.getSource() != btnOptions && arg0.getSource() != btnLogs && arg0.getSource() != btnReset) //Si ce n'est pas un bouton dont on connait le nom//Pourquoi on ne connaîtrait pas son nom?
		{
			int i, j;
			
			for(j=0 ; j<partie.getTaille() ; j++)
			{
				for(i=0 ; i<partie.getTaille() ; i++)
				{
					if(arg0.getSource() == tableauBoutons[i][j]) //Cherche le nom du bouton en parcourant la matrice
					{
						if(tableauEtatGrille[i][j] == 0) //Verifie que le bouton n'a pas déja été clické
						{
							if(partie.getTour() == true) //Si tour du joueur 1
							{
								tableauBoutons[i][j].setCircle();
								tableauEtatGrille[i][j] = 1; //Met 1 dans la matrice de réponse a l'emplacement du cercle
								partie.passerTour(); //passe le tour au joueur 1
								
								logs.afficherMessagePlacement(1, i, j);
							}
							else
							{
								tableauBoutons[i][j].setCross();
								tableauEtatGrille[i][j] = 2; //Idem pour une croix: 2
								partie.passerTour(); //passe le tour au joueur 2
								
								logs.afficherMessagePlacement(2, i, j);
							}
							//System.out.println("case " + i + ", " + j + ": " + tableauEtatGrille[i][j]); //Affiche dans la console l'état des cases
						}
						
						int victoire = verificationVictoire();			
						
						if(victoire != 0)
						{
							btnReset.setLabel("Rejouer");
							
							int k, l;
							for(k=0 ; k<partie.getTaille() ; k++)
							{
								for(l=0 ; l<partie.getTaille() ; l++)
								{
									tableauBoutons[l][k].griseBouton();
								}	
							}
						}
						
						
						if(victoire == 1)
						{
							String[] choix = {"Oui", "Non"};
						    int optionChoisie = JOptionPane.showOptionDialog(null, 
						      "Joueur 1 gagne !" + "\n" + "Score: " + partie.getVictoires(1) + " - " + partie.getVictoires(2) + "\n" + "Rejouer ?",
						      "Rejouer ?",
						      JOptionPane.YES_NO_CANCEL_OPTION,
						      JOptionPane.QUESTION_MESSAGE,
						      null,
						      choix,
						      choix[1]);
						    
						    if(choix[optionChoisie] == choix[0])
						    {
						    	btnReset.setLabel("Reset");
								int a, b;
								
								for(b=0 ; b<partie.getTaille() ; b++)
								{
									for(a=0 ; a<partie.getTaille() ; a++)
									{
										tableauBoutons[a][b].degriseBouton();
									}
								}
								resetPartie();
						    }
						}
						else if(victoire == 2)
						{
							String[] choix = {"Oui", "Non"};
							
						    int optionChoisie = JOptionPane.showOptionDialog(null, 
						      "Joueur 2 gagne !" + "\n" + "Score: " + partie.getVictoires(1) + " - " + partie.getVictoires(2) + "\n" + "Rejouer ?",
						      "Rejouer ?",
						      JOptionPane.YES_NO_CANCEL_OPTION,
						      JOptionPane.QUESTION_MESSAGE,
						      null,
						      choix,
						      choix[1]);

						    if(choix[optionChoisie] == choix[0])
						    {
						    	btnReset.setLabel("Reset");
								int a, b;
								
								for(b=0 ; b<partie.getTaille() ; b++)
								{
									for(a=0 ; a<partie.getTaille() ; a++)
									{
										tableauBoutons[a][b].degriseBouton();
									}
								}
								resetPartie();
						    }
						}
					}
				}
			}
		}
	}
	
	void creationBouton(int largeurPanel, int hauteurPanel)
	{
		int numeroNom = 0;
		int i, j; 
		
		for(j=0 ; j<partie.getTaille() ; j++)
		{
			for(i=0 ; i<partie.getTaille() ; i++)
			{
				tableauBoutons[i][j] = new BoutonCase(largeurPanel, hauteurPanel, partie.getTaille(), numeroNom, j, i);
				tableauBoutons[i][j].addActionListener(this);
				panel_grille.add(tableauBoutons[i][j]);
				numeroNom++;
			}
		}
	}
	
	void initialisationTableauEtat()
	{
		int i, j;
		
		for(j=0 ; j<partie.getTaille() ; j++)
		{
			for(i=0 ; i<partie.getTaille() ; i++)
			{
				tableauEtatGrille[i][j] = 0;
			}
		}
	}
	
	void resetPartie()
	{
		partie.setTourJoueur1();
		
		resetBouton();
		System.out.println("");
		
		logs.sauterLignes(1);
	}
	
	void resetBouton()
	{
		int i, j; 
		
		for(i=0 ; i<partie.getTaille() ; i++)
		{
			for(j=0 ; j<partie.getTaille() ; j++)
			{
				tableauBoutons[i][j].reset();
				tableauEtatGrille[i][j] = 0;
			}
		}
	}
	
	int verificationVictoire()
	{
		int scoreLigne = 0;
		int victoire = 0;
		for(int joueur = 1 ; joueur <= 2 ; joueur++)//test de la ligne
		{
			for(int ligne = 0 ; ligne < partie.getTaille() ; ligne++)
			{
				scoreLigne = 0;
				for(int colonne = 0 ; colonne < partie.getTaille() ; colonne++)
				{
					if(tableauEtatGrille[colonne][ligne] == joueur)
					{
						scoreLigne ++;
						//System.out.println("joueur : " + joueur + "scoreLigne : " + scoreLigne);
						if(scoreLigne == partie.getTaille())
						{
							//System.out.println("joueur " + joueur + " à gagné");
							victoire = joueur;
						}
					}
				}
			}
		
		
			for(int colonne = 0 ; colonne < partie.getTaille() ; colonne++)
			{
				scoreLigne = 0;
				for(int ligne = 0 ; ligne < partie.getTaille() ; ligne++)
				{
					if(tableauEtatGrille[colonne][ligne] == joueur)
					{
						scoreLigne ++;
						//System.out.println("joueur : " + joueur + "scoreLigne : " + scoreLigne);
						if(scoreLigne == partie.getTaille())
						{
							//System.out.println("joueur " + joueur + " à gagné");
							victoire = joueur;
						}
					}
				}
			}
			scoreLigne = 0;
			for(int colonne = 0 ; colonne < partie.getTaille() ; colonne ++)
			{
				int ligne = colonne;
				if(tableauEtatGrille[colonne][ligne] == joueur)
				{
					scoreLigne ++;
					//System.out.println("joueur : " + joueur + "scoreLigne : " + scoreLigne);
					if(scoreLigne == partie.getTaille())
					{
						System.out.println("joueur " + joueur + " à gagné");
						victoire = joueur;
					}
				}
			}
			scoreLigne = 0;
			for(int ligne = partie.getTaille()-1 ; ligne >= 0 ; ligne--)
			{
				int colonne = partie.getTaille() - 1 - ligne;
				if(tableauEtatGrille[colonne][ligne] == joueur)
				{
					scoreLigne ++;
					//System.out.println("joueur : " + joueur + "scoreLigne : " + scoreLigne);
					if(scoreLigne == partie.getTaille())
					{
						System.out.println("joueur " + joueur + " à gagné");
						victoire = joueur;
					}
				}
			}
		}
		
		if(victoire == 1)
		{
			partie.J1Gagne();
			logs.afficherMessageVictoire(victoire, partie);
		}	
		if(victoire == 2)
		{
			partie.J2Gagne();
			logs.afficherMessageVictoire(victoire, partie);
		}
			
		return victoire;
	}
}