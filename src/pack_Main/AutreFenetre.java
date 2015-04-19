package pack_Main;

import java.awt.EventQueue;

//import pack_Main.JImageViewer;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JSeparator;

import java.awt.Panel;
import java.awt.Label;
//import java.awt.event.ActionEvent;


public class AutreFenetre {

	AutreFenetre window;
	
	private JFrame frame;
	private final Label label = new Label("MENU");
	private int X, Y, WIDTH, HEIGHT;
	private int victoireJ1, victoireJ2;
	//private int nbJoueurEnTout = 2;
	
	private boolean ouvert = false;
	
	private JLabel lblScore_1, lblScore_2;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new AutreFenetre();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setBounds(X, Y, WIDTH, HEIGHT);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.frame.setTitle("Menu");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutreFenetre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		label.setFont(new Font("Arial", Font.PLAIN, 28));
		label.setAlignment(Label.CENTER);
		panel.add(label, BorderLayout.NORTH);
		
		JSeparator separator = new JSeparator();
		panel.add(separator, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblExempleDeJoueur = new JLabel("   Joueur 1");
		lblExempleDeJoueur.setBounds(0, 0, 200, 30);
		panel_2.add(lblExempleDeJoueur);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 28, 264, 2);
		panel_2.add(separator_1);
		
		JLabel lblExempleDeJoueur_1 = new JLabel("   Joueur 2");
		lblExempleDeJoueur_1.setBounds(0, 28, 200, 30);
		panel_2.add(lblExempleDeJoueur_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 56, 264, 2);
		panel_2.add(separator_2);
		
		lblScore_1 = new JLabel(Integer.toString(victoireJ1));
		lblScore_1.setBounds(189, 0, 75, 30);
		panel_2.add(lblScore_1);
		
		lblScore_2 = new JLabel(Integer.toString(victoireJ2));
		lblScore_2.setBounds(189, 28, 75, 30);
		panel_2.add(lblScore_2);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JButton btnOptions = new JButton("Options");
		panel_3.add(btnOptions);
	}
	
	//Methodes pour entrer les valeurs
	
		public void setX(int argX)
		{
			X = argX;
		}
		
		public void setY(int argY)
		{
			Y = argY;
		}
		
		public void setHeight(int argH)
		{
			HEIGHT = argH;
		}
		
		public void setWidth(int argW)
		{
			WIDTH = argW;
		}
		
		public void setVictoireJ1(int argV1)
		{
			victoireJ1 = argV1;
		}
		
		public void setVictoireJ2(int argV2)
		{
			victoireJ2 = argV2;
		}
		
		public void setOuvert(boolean arg0)
		{
			ouvert = arg0;
		}
		
		//Fin des methodes d'entrées
		
		//Méthodes pour obtenir les valeurs
		
		public int getX()
		{
			return X;
		}
		
		public int getY()
		{
			return Y;
		}
		
		public int getHeight()
		{
			return HEIGHT;
		}
		
		public int getWidth()
		{
			return WIDTH;
		}
		
		public boolean getOuvert()
		{
			return ouvert;
		}
		
		//Fin des methodes de sorties
		
		public void refreshTaille()
		{
			window.frame.setBounds(X, Y, WIDTH, HEIGHT);
		}
		
		public void refreshScore()
		{	
			lblScore_1 = new JLabel(Integer.toString(victoireJ1));
			lblScore_2 = new JLabel(Integer.toString(victoireJ2));
		}
		
		//Fonction pour fermer la fenetre
		
		public void close()
		{
			window.frame.dispose();
		}
}
