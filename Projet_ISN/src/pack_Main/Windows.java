package pack_Main;

import java.awt.EventQueue;

import pack_Main.JImageViewer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Windows {

	private JFrame frame;
	private final Label label = new Label("MENU");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows window = new Windows();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setBounds(50, 50, 260, 365);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Windows() {
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
		
		JLabel lblExempleDeJoueur = new JLabel("Exemple de Joueur 1");
		lblExempleDeJoueur.setBounds(0, 0, 200, 30);
		panel_2.add(lblExempleDeJoueur);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 28, 264, 2);
		panel_2.add(separator_1);
		
		JLabel lblExempleDeJoueur_1 = new JLabel("Exemple de Joueur 2");
		lblExempleDeJoueur_1.setBounds(0, 28, 200, 30);
		panel_2.add(lblExempleDeJoueur_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 56, 264, 2);
		panel_2.add(separator_2);
		
		JLabel lblScore = new JLabel("Score1");
		lblScore.setBounds(189, 0, 75, 30);
		panel_2.add(lblScore);
		
		JLabel lblScore_1 = new JLabel("Score2");
		lblScore_1.setBounds(189, 28, 75, 30);
		panel_2.add(lblScore_1);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JButton btnOptions = new JButton("Options");
		panel_3.add(btnOptions);
	}
}
