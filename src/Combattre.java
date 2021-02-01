import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;

public class Combattre extends JFrame{
	private JPanel containerPane;
	private Combat c;
	private JPanel topPane;
	private JPanel bottomPane;
	Combattre(Personnage p1, Personnage p2){
		c =  new Combat(p1,p2);
		//Combat c = new Combat(p1,p2);
		//f1 = new JFrame("Example of 2 panels");
        containerPane = new JPanel();
        topPane = new JPanel();
        bottomPane = new JPanel();
        JButton	bAttack = new JButton("Attaquer");
		JButton	bDefense = new JButton("Defense");
		JButton	bSoin = new JButton("Soin");
		
		JLabel l1 = new JLabel();
		JLabel l1a = new JLabel();
		JLabel l2o = new JLabel("");
		JLabel l2j = new JLabel("");
        containerPane.setLayout(new GridLayout(2, 1));
        topPane.setLayout(new GridLayout(1, 2));
        bottomPane.setLayout(new BorderLayout());
        JPanel eastp = new JPanel(new GridLayout(2, 1));
        JPanel centerp = new JPanel(new GridLayout(2, 1));
        JPanel westp = new JPanel(new GridLayout(2, 1));
        topPane.add(l1a);
        topPane.add(l2o);
        westp.add(bAttack);
        eastp.add(bDefense);
        centerp.add(bSoin);
        
        bottomPane.add(eastp, BorderLayout.EAST);
        bottomPane.add(centerp, BorderLayout.CENTER);
        bottomPane.add(westp, BorderLayout.WEST);


        bottomPane.add(l2j, BorderLayout.SOUTH);
        

        topPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p2.getNom() + " (Ordinateur) : Vie = " + p2.vie));
        bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p1.getNom() + " : Vie = " + p1.vie));

        containerPane.add(topPane);
        containerPane.add(bottomPane);

        this.add(containerPane);
        
//      frame.pack();
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bAttack.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		Arme a = new Arme(p1,p1.Armes[0]);
        		//c.attack(p1, p2, a);
        		l2j.setText(c.attack(p1, p2, a));        		
        		topPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p2.getNom() + " (Ordinateur) : Vie = " + p2.vie));
        		l2o.setText(c.ordinateur());
        		bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p1.getNom() + " : Vie = " + p1.vie));
        		if(p1.vie < 0) {
        			JFrame jfinfo = new JFrame();
            		JOptionPane.showMessageDialog(jfinfo, "Votre combattant : Le " + p1.getType() + " " + p1.getNom() + " est Mort \n G A M E \t \t O V E R", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}else if(p2.vie < 0) {
        			JFrame jfinfo = new JFrame();
        			JOptionPane.showMessageDialog(jfinfo, "L'Ordinateur : Le " + p2.getType() + " " + p2.getNom() + " est Mort \n Y O U \t \t W I N", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
		});
        bDefense.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {
        		Arme a = new Arme(p1,p1.Armes[0]);
        		//c.parade(p1,a);
        		l2j.setText(c.parade(p1,a));      
        		l2o.setText(c.ordinateur());
        		bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p1.getNom() + " : Vie = " + p1.vie));
        		if(p1.vie < 0) {
        			JFrame jfinfo = new JFrame();
            		JOptionPane.showMessageDialog(jfinfo, "Votre combattant : Le " + p1.getType() + " " + p1.getNom() + " est Mort \n G A M E \t \t O V E R", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}else if(p2.vie < 0) {
        			JFrame jfinfo = new JFrame();
        			JOptionPane.showMessageDialog(jfinfo, "L'Ordinateur : Le " + p2.getType() + " " + p2.getNom() + " est Mort \n Y O U \t \t W I N", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}
			}
		});
        bSoin.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) {

        		Arme a = new Arme(p1,p1.Armes[0]);
        		//c.soin(p1,a);
        		l2j.setText(c.soin(p1,a));   
        		bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p1.getNom() + " : Vie = " + p1.vie));
        		//JOptionPane.showMessageDialog(jfinfo, "Vous avez utilisé soin + " + a.getImpactSoin(), "Soin", JOptionPane.PLAIN_MESSAGE);
        		l2o.setText(c.ordinateur());
        		bottomPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), p1.getNom() + " : Vie = " + p1.vie));
        		if(p1.vie < 0) {
        			JFrame jfinfo = new JFrame();
            		JOptionPane.showMessageDialog(jfinfo, "Votre combattant : Le " + p1.getType() + " " + p1.getNom() + " est Mort \n G A M E \t \t O V E R", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}else if(p2.vie < 0) {
        			JFrame jfinfo = new JFrame();
        			JOptionPane.showMessageDialog(jfinfo, "L'Ordinateur : Le " + p2.getType() + " " + p2.getNom() + " est Mort \n Y O U \t \t W I N", "Fin du Jeu", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
		});
        
	}
	
}
