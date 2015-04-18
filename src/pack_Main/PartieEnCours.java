package pack_Main;

public class PartieEnCours {
	
	private int TAILLE;
	private boolean TOURJ1;
	private int nbVictoiresJ1;
	private int nbVictoiresJ2;
	private String nomJ1;
	private String nomJ2;

	public PartieEnCours(int taille)
	{
		TAILLE = taille;
	}
	
	public void setTaille(int arg0)
	{
		TAILLE = arg0;
	}
	
	public int getTaille()
	{
		return TAILLE;
	}
	
	public void passerTour()
	{
		if(TOURJ1 == false)
			TOURJ1 = true;
		else
			TOURJ1 = false;
	}
	
	public void setTourJoueur1()
	{
		TOURJ1 = true;
	}
	
	public void setTourJoueur2()
	{
		TOURJ1 = false;
	}
	
	public boolean getTour()
	{
		return TOURJ1;
	}
	
	public void J1Gagne()
	{
		nbVictoiresJ1++;
	}
	
	public void J2Gagne()
	{
		nbVictoiresJ2++;
	}
	
	public void setVictoires(int arg0, int arg1)
	{
		if(arg1 == 1)
			nbVictoiresJ1 = arg0;
		if(arg1 == 2)
			nbVictoiresJ2 = arg0;
	}
	
	public int getVictoires(int arg)
	{
		int retour = 0;
		
		if(arg == 1)
			retour = nbVictoiresJ1;
		if(arg == 2)
			retour = nbVictoiresJ2;
		
		return retour;
	}
	
	public void setName(String arg0, int arg1)
	{
		if(arg1 == 1)
			nomJ1 = arg0;
		if(arg1 == 2)
			nomJ2 = arg0;
	}
	
	public String getName(int arg)
	{
		String retour ="";
		
		if(arg == 1)
			retour = nomJ1;
		if(arg == 2)
			retour = nomJ2;
		
		return retour;
	}
}
