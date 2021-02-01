import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
public class CreationPerso1 {
	Personnage p1 = null;
	String nom = "";
	int type = 0;
	int exp = 0;
	int f = 0,d = 0,i = 0,c = 0;
	int arme[] = {-1,-1,-1};
	public CreationPerso1() {
		// création de la fenetre pricipale	
		JFrame f1 = new JFrame("jeu de combat");
		f1.setSize(400,300);
		f1.setLocationRelativeTo(null);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// création du conteneur principale
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new BorderLayout());
		CardLayout cl = new CardLayout();
		jp.setLayout(cl);
		// les caracteriques
		
		
		// Le nom du Perso
		JPanel c1 = new JPanel(new GridLayout(9,1));
		JPanel cpp = new JPanel(new GridLayout(1,4));
		JPanel s1 = new JPanel(new GridLayout(1,3));	
		JLabel l1 = new JLabel("Nom");
		JTextField tf1 = new JTextField();
		JPanel jpname = new JPanel(new GridLayout(1,2));
		jpname.add(l1);
		jpname.add(tf1);
		JButton but1 = new JButton("Suivant");
		JButton but2 = new JButton("FIN");
		
		c1.add(jpname);
		c1.add(cpp);
		s1.add(but2);
		s1.add(but1);
		jp1.add(c1,BorderLayout.NORTH);
		jp1.add(c1,BorderLayout.CENTER);
		jp1.add(s1,BorderLayout.SOUTH);
		
		
		
		
		// Type perso
		JPanel c2 = new JPanel(new GridLayout(9,1));
		JPanel s2 = new JPanel(new GridLayout(1,3));	
		//JPanel type = new JPanel(new GridLayout(1,4));
		JLabel l2 = new JLabel("Type : ");
		JPanel jptype = new JPanel(new GridLayout(1,2));
		jptype.add(l2);
		JButton bg = new JButton("Guerrier");
		JButton ba = new JButton("Athlete");
		JButton bm = new JButton("Magicien");
		
		c2.add(jptype);
		c2.add(bg);
		c2.add(ba);
		c2.add(bm);
		//s2.add(but2);
		//s2.add(but1);
		jp2.add(c2,BorderLayout.CENTER);
		jp2.add(s2,BorderLayout.SOUTH);
		
		// On donne le Nom et l'expérience du Personnage
		but1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				if(tf1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplire tous les champs", 
	                          "Erreur", 
	                          JOptionPane.WARNING_MESSAGE);
				}else {
					nom = tf1.getText();
					exp = ThreadLocalRandom.current().nextInt(0, 5);
						cl.show(jp, "2");
				}
			}
		});
		bg.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				type = 1;
				donnerAptitude();
				f1.setVisible(false);
			}
		});
		ba.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				type = 2;
				donnerAptitude();
				f1.setVisible(false);
			}
		});
		bm.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				type = 3;
				donnerAptitude();
				f1.setVisible(false);
			}
		});
		
		
		jp.add(jp1,"1");
		jp.add(jp2,"2");
		cl.show(jp, "1");
		f1.add(jp);
		
		f1.setVisible(true);
	}
	void donnerAptitude(){
		switch(type) {
			case 1:
				p1 = new Guerrier();
			break;
			case 2:
				p1 = new Athlete();
			break;
			case 3:
				p1 = new Magicien();
			break;
		}
		p1.setNom(nom);
		p1.setExp(exp);
		JFrame f2 = new JFrame("Aptitude du " + p1.getType());
		f2.setSize(600,300);
		f2.setLocationRelativeTo(null);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// création du conteneur principale
		JPanel jp = new JPanel();
		CardLayout cl = new CardLayout();
		jp.setLayout(cl);
		// les caracteristiques
		

		// La Force du Perso
		JPanel jpf = new JPanel(new BorderLayout());
		JLabel lf = new JLabel("Force : " + p1.aptitudeMinMax(type, "f"));
		JTextField tff = new JTextField();
		JPanel c1 = new JPanel(new GridLayout(9,1));
		JPanel s1 = new JPanel(new GridLayout(1,3));
		JPanel jp1 = new JPanel(new GridLayout(1,2));
		jp1.add(lf);
		jp1.add(tff);
		JButton but1 = new JButton("Suivant");
		JButton but2 = new JButton("FIN");
		c1.add(jp1);
		s1.add(but2);
		s1.add(but1);
		jpf.add(c1,BorderLayout.CENTER);
		jpf.add(s1,BorderLayout.SOUTH);
		
		// La Dext du Perso
		JPanel jpd = new JPanel(new BorderLayout());
		JTextField tfd = new JTextField();
		JPanel jp2 = new JPanel(new GridLayout(1,2));
		JLabel ld = new JLabel();
		JPanel c2 = new JPanel(new GridLayout(9,1));
		JPanel s2 = new JPanel(new GridLayout(1,3));	
		jp2.add(ld);
		jp2.add(tfd);
		JButton but3 = new JButton("Suivant");
		JButton but4 = new JButton("FIN");
		c2.add(jp2);
		s2.add(but4);
		s2.add(but3);
		jpd.add(c2,BorderLayout.CENTER);
		jpd.add(s2,BorderLayout.SOUTH);
		
		// L'int du Perso
		JPanel jpi = new JPanel(new BorderLayout());
		JLabel li = new JLabel();
		JPanel jp3 = new JPanel(new GridLayout(1,2));
		JTextField tfi = new JTextField();
		JPanel c3 = new JPanel(new GridLayout(9,1));
		JPanel s3 = new JPanel(new GridLayout(1,3));	
		jp3.add(li);
		jp3.add(tfi);
		JButton but5 = new JButton("Suivant");
		JButton but6 = new JButton("FIN");
		c3.add(jp3);
		s3.add(but6);
		s3.add(but5);
		jpi.add(c3,BorderLayout.CENTER);
		jpi.add(s3,BorderLayout.SOUTH);
		
		// La c du Perso
		JPanel jpc = new JPanel(new BorderLayout());
		JLabel lc = new JLabel();
		JPanel jp4 = new JPanel(new GridLayout(1,2));
		JTextField tfc = new JTextField();
		JPanel c4 = new JPanel(new GridLayout(9,1));
		JPanel s4 = new JPanel(new GridLayout(1,3));	
		jp4.add(lc);
		jp4.add(tfc);
		JButton but7 = new JButton("Suivant");
		JButton but8 = new JButton("FIN");
		c4.add(jp4);
		s4.add(but8);
		s4.add(but7);
		jpc.add(c4,BorderLayout.CENTER);
		jpc.add(s4,BorderLayout.SOUTH);
		
		
		but1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				if(p1.checkF(Integer.parseInt(tff.getText()))){
					f = Integer.parseInt(tff.getText());
					p1.force = f;
					cl.show(jp, "2");
					ld.setText("Dextérité : " + p1.aptitudeMinMax(type, "d"));
				}else {
					JOptionPane.showMessageDialog(null, "La force doit être : " + p1.aptitudeMinMax(type, "f"), 
	                          "Erreur", 
	                          JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		but3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(p1.checkD(Integer.parseInt(tfd.getText()))){
					d = Integer.parseInt(tfd.getText());
					p1.dexterite = d;
					cl.show(jp, "3");
					li.setText("Intelligence : " + p1.aptitudeMinMax(type, "i"));
				}else {
					JOptionPane.showMessageDialog(null, "La dextérité doit être : " + p1.aptitudeMinMax(type, "d"), 
	                          "Erreur", 
	                          JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		but5.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(p1.checkI(Integer.parseInt(tfi.getText()))){
					i = Integer.parseInt(tfi.getText());
					p1.intelligence = i;
					cl.show(jp, "4");
					lc.setText("Concentration : " + p1.aptitudeMinMax(type, "c"));
				  }else {
					  JOptionPane.showMessageDialog(null, "L'Intelligence doit être : " + p1.aptitudeMinMax(type, "i"), 
	                          "Erreur", 
	                          JOptionPane.WARNING_MESSAGE);
				  }
			}
		});
		but7.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(p1.checkC(Integer.parseInt(tfc.getText()))){
					c =Integer.parseInt(tfc.getText());
					p1.concentration = c;
					p1.setVie();
					CreationPerso2 cp2 = new CreationPerso2(p1);
					f2.setVisible(false);
				  }else {
					  JOptionPane.showMessageDialog(null, "concentration doit être : " + p1.aptitudeMinMax(type, "c"), 
	                          "Erreur", 
	                          JOptionPane.WARNING_MESSAGE);
				  }
			}
		});
		
		
		jp.add(jpf,"10");
		jp.add(jpd,"2");
		jp.add(jpi,"3");
		jp.add(jpc,"4");
		//jp.add(jpa1,"5");
		//jp.add(jpa2,"6");
		//jp.add(jpa3,"7");
		cl.show(jp, "1");
		f2.add(jp);
		
		f2.setVisible(true);
		
	}
}
