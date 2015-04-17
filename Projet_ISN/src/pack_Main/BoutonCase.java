package pack_Main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonCase extends JButton{

	private static final long serialVersionUID = 1L;
	private int posX;
	private int posY;
	private int taille;
	
	BoutonCase(int largeurPanel, int hauteurPanel, int tailleTbl, int numeroBouton, int positionY, int positionX)
	{
		int largeurBouton;
		int hauteurBouton;
		posX = positionX;
		posY = positionY;
		taille = tailleTbl;
		
		largeurBouton = largeurPanel/taille;
		hauteurBouton = (hauteurPanel-25)/taille;
		
		this.setName("BoutonGrille" + numeroBouton);
		this.setBounds(largeurBouton*posX+1, hauteurBouton*posY+27, largeurBouton, hauteurBouton);
		//System.out.println("numero" + numeroBouton + ":");
		//System.out.println(this.getX());
		//System.out.println(this.getY());
		//System.out.println(this.getWidth());
		//System.out.println(this.getHeight());
		//System.out.println();
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		reset();
	}
	
	public void griseBouton()
	{
		this.setEnabled(false);
	}
	
	public void degriseBouton()
	{
		this.setEnabled(true);
	}
	
	public void setCircle()
	{
		BufferedImage img = null;
		
		if(taille == 1)
			img = addImage(createMilieu(), createCircle());
		
		else
		{
			if(posY != 0 && posY != taille-1)
				if(posX == 0)
				{
					img = addImage(createCentreGauche(), createCircle());
				}
				if(posX == taille-1)
				{
					img = addImage(createCentreDroit(), createCircle());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createMilieu(), createCircle());
				}
			if(posY == 0)
			{
				if(posX == 0)
				{
					img = addImage(createCoinEnHautAGauche(), createCircle());
				}
				if(posX == taille-1)
				{
					img = addImage(createCoinEnHautADroite(), createCircle());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createAutreHaut(), createCircle());
				}
			}
			if(posY == taille-1)
			{
				if(posX == 0)
				{
					img = addImage(createCoinEnBasAGauche(), createCircle());
				}
				if(posX == taille-1)
				{
					img = addImage(createCoinEnBasADroite(), createCircle());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createAutreBas(), createCircle());
				}
			}
		}
		
		this.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));	}
	
	public void setCross()
	{
		BufferedImage img = null;
				
		if(taille == 1)
			img = addImage(createMilieu(), createCross());
		
		else
		{
			if(posY != 0 && posY != taille-1)
				if(posX == 0)
				{
					img = addImage(createCentreGauche(), createCross());
				}
				if(posX == taille-1)
				{
					img = addImage(createCentreDroit(), createCross());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createMilieu(), createCross());
				}
			if(posY == 0)
			{
				if(posX == 0)
				{
					img = addImage(createCoinEnHautAGauche(), createCross());
				}
				if(posX == taille-1)
				{
					img = addImage(createCoinEnHautADroite(), createCross());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createAutreHaut(), createCross());
				}
			}
			if(posY == taille-1)
			{
				if(posX == 0)
				{
					img = addImage(createCoinEnBasAGauche(), createCross());
				}
				if(posX == taille-1)
				{
					img = addImage(createCoinEnBasADroite(), createCross());
				}
				if(posX != 0 && posX != taille-1)
				{
					img = addImage(createAutreBas(), createCross());
				}
			}
		}
		
		this.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	public void reset()
	{
		BufferedImage img = null;
		
		if(taille == 1)
			img = createMilieu();
		
		else
		{
			if(posY != 0 && posY != taille-1)
				if(posX == 0)
				{
					img = createCentreGauche();
				}
				if(posX == taille-1)
				{
					img = createCentreDroit();
				}
				if(posX != 0 && posX != taille-1)
				{
					img = createMilieu();
				}
			if(posY == 0)
			{
				if(posX == 0)
				{
					img = createCoinEnHautAGauche();
				}
				if(posX == taille-1)
				{
					img = createCoinEnHautADroite();
				}
				if(posX != 0 && posX != taille-1)
				{
					img = createAutreHaut();
				}
			}
			if(posY == taille-1)
			{
				if(posX == 0)
				{
					img = createCoinEnBasAGauche();
				}
				if(posX == taille-1)
				{
					img = createCoinEnBasADroite();
				}
				if(posX != 0 && posX != taille-1)
				{
					img = createAutreBas();
				}
			}
		}
		
		this.setIcon(new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
	}
	
	private BufferedImage addImage(BufferedImage image1, BufferedImage image2)
	{
		Graphics2D g2d = image1.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		                RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
		                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	 
		g2d.drawImage(image2, 0, 0, null);
	 
		g2d.dispose();
	 
		return image1 ;
	}
	
	private BufferedImage createCircle()
	{
		BufferedImage img = null;
		double nbAleat = Math.round(Math.random() * 3);
		
		if(nbAleat == 1.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/rond1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(nbAleat == 2.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/rond2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(nbAleat == 0.0 || nbAleat == 3.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/rond3.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return img;
	}
	
	private BufferedImage createCross()
	{
		BufferedImage img = null;
		double nbAleat = Math.round(Math.random() * 3);
		
		if(nbAleat == 1.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/croix1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(nbAleat == 2.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/croix2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(nbAleat == 0.0 || nbAleat == 3.0)
		{
			try {
				img = ImageIO.read(new File("./ressources/IMG/Grille/Rond et Croix/croix3.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return img;
	}
	
	private BufferedImage createCoinEnHautAGauche()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createCoinEnHautADroite()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample3.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createAutreHaut()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createCoinEnBasAGauche()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample7.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createCoinEnBasADroite()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample9.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createAutreBas()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample8.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createCentreGauche()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample4.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createCentreDroit()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample6.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	private BufferedImage createMilieu()
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./ressources/IMG/Grille/Morceaux de Grille/sample5.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
}
