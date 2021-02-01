import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Principale {

	public Principale() {
		
		// création de la fenetre pricipale
		JFrame f2 = new JFrame("jeu de combat");
		f2.setSize(600,600);
		f2.setLocationRelativeTo(null);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// création du conteneur principale
		JPanel jp = new JPanel(new BorderLayout());
		Photo1 a= new Photo1();
		jp.add(a,BorderLayout.CENTER);
		// 
		// conteneur des bouttons
		JPanel south = new JPanel(new GridLayout(4,1));
		
		// Texts
		JLabel lab = new JLabel("bienvenue à ce jeux", SwingConstants.CENTER);
		lab.setFont(new Font("Cambria", Font.BOLD, 20));
		lab.setForeground(new Color(204,0,0));
		
		// création des buttons
		JButton but1 = new JButton("SUIVANT");
		JButton but2 = new JButton("ACCUEIL");
		JButton but3 = new JButton("FIN");

		// création des actions de buttons
		but1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  CreationPerso1 w1 = new CreationPerso1();
				  f2.setVisible(false);
			  	}});
		but3.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  System.exit(0);
			  	}});

		south.add(lab);
		south.add(but1);
		south.add(but2);
		south.add(but3);
		
		jp.add(south,BorderLayout.SOUTH);

		f2.add(jp);

		f2.setVisible(true);
	}

}
