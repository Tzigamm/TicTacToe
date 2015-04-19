package pack_Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class FenetreLogs implements ActionListener {

	private JFrame frame;
	private JTextPane textPane;
	JButton btnClear = new JButton("Clear");
	JScrollPane scrollPane;
	FenetreLogs window;
	
	MessageConsole mc;
	
	private int X, Y, WIDTH, HEIGHT;
	private boolean ouvert = false;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new FenetreLogs();
					window.frame.setVisible(true);
					window.frame.setBounds(X, Y, WIDTH, HEIGHT);
					window.frame.setAlwaysOnTop(true);
					window.frame.setResizable(true);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.frame.setTitle("Logs");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreLogs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(X, Y, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		btnClear.addActionListener(this);
		panel.add(btnClear, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		scrollPane  = new JScrollPane(textPane);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		mc = new MessageConsole(textPane);
		mc.redirectOut();
	}
	
	public void ecrireTexte(String texteAEcrire) //Methode pour inscrire du texte dans le JtextPane
	{
		textPane.setText(texteAEcrire);
	}
	
	public void ecrireTexteALaSuite(String texteAEcrire)
	{
		textPane.setText(textPane.getText().concat(texteAEcrire));
	}
	
	public void ecrireTexteALaLigne(String texteAEcrire)
	{
		textPane.setText(textPane.getText().concat("\n").concat(texteAEcrire));
	}
	
	//Methodes pour afficher les logs
	
	public void afficherMessagePlacement(int joueur, int X, int Y)
	{
		if(joueur == 1)
			System.out.println("- Joueur 1 a placé un Rond en " + X + "," + Y);
		if(joueur == 2)
			System.out.println("- Joueur 2 a placé une Croix en " + X + "," + Y);
	}
	
	public void afficherMessageVictoire(int joueur, PartieEnCours partie)
	{
		if(joueur == 1)
			System.out.println("- Joueur 1 a gagné avec un score de " + partie.getVictoires(1) + " à " + partie.getVictoires(2));
		if(joueur == 2)
			System.out.println("- Joueur 2 a gagné avec un score de " + partie.getVictoires(2) + " à " + partie.getVictoires(1));
	}
	
	public void afficherMessageReset()
	{
		System.out.println("- La partie a été remise à zéro !");
	}
	
	public void afficherMessageRejouer()
	{
		System.out.println("- Une partie à été démaré !");
	}
	
	public void sauterLignes(int nbLignes)
	{
		int i;
		
		for(i=0 ; i< nbLignes ; i++)
		{
			System.out.print("\n");
		}
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnClear)
		{
			textPane.setText("");;
		}
		
	}
	
	public void refreshTaille()
	{
		window.frame.setBounds(X, Y, WIDTH, HEIGHT);
	}
	
	//Fonction pour fermer la fenetre
	
	public void close()
	{
		window.frame.dispose();
	}
}
