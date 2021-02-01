import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class Combat {
	Personnage p1;
	Personnage p2;
	Combat(Personnage p1, Personnage p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	void showVie() {
		System.out.println("Le "+p1.getType() +" "+p1.getNom()+" : Vie = " + p1.vie + 
				"\n Le "+p2.getType() +" "+p2.getNom()+" : Vie = " + p2.vie);
	}
	int actionChoice(int n) {
		int c = -1;
		//Arme a = new Arme(p1,p1.Armes[n]);
		if(p1.Armes[n] == 0) {
			System.out.println("Avec l'épée, Choissiez vous d'Attaquer (0) ou Défendre (1)");
			return c;
		}else if(p1.Armes[n] == 0 && p1.Armes[n] == 1) {
			c = 0;
		}else if(p1.Armes[n] == 2 || p1.Armes[n] == 3) {
			c = 1;
		}else if(p1.Armes[n] == 4 || p1.Armes[n] == 5) {
			c = 2;
		}
		return c;
	}
	void getArmes() {
		Arme a1 = new Arme(p1, p1.Armes[0]);
		Arme a2 = new Arme(p1, p1.Armes[1]);
		System.out.println("[0] " + a1.getNom());
		System.out.println("[1] " + a2.getNom());
	}
	
	
	String attack(Personnage p1,Personnage p2,Arme a){
		JFrame jfinfo = new JFrame();
		String message = new String();
		int prAttack = ThreadLocalRandom.current().nextInt(0, 10000)/10000;
		System.out.println("prAttack = " + prAttack);
		System.out.println("PrAttackArme = " + a.getPRAttack());
		if(prAttack < a.getPRAttack()) {
			message = message + "Attaque réussite !! \n";
			if(p2.pdef) {
				if(a.getImpactAttack() > p2.ppar) {
					message = message + "L'autre combattant utilisait une défense mais votre attaque est plus forte \n";
					p2.vie = p2.vie - (a.getImpactAttack()-p2.ppar);
					message = message + " Dégat = - " + (a.getImpactAttack()-p2.ppar) + "\n";
					System.out.println("-" + (a.getImpactAttack()-p2.ppar) + " de vie");
				}else {
					System.out.println("Defence adverse :");
					p2.vie = p2.vie;
					System.out.println("parade = " + p2.ppar + ">" + a.getImpactAttack());
				}
			}else {
				p2.vie = p2.vie - a.getImpactAttack();
				System.out.println("-" + a.getImpactAttack()+ " de vie");
			}
		}else {
			message = message + "Attaque non réussite";
		}
		//JOptionPane.showMessageDialog(jfinfo, message, "Attaque", JOptionPane.PLAIN_MESSAGE);
		return message;
	}
	String parade(Personnage p,Arme a){
		JFrame jfinfo = new JFrame();
		String message = new String();
		double prParade = ThreadLocalRandom.current().nextInt(0, 10000)/10000;
		if(prParade < a.getPRParade()) {
			message = message + "Parade réussite\n";
			message = message + "Vous êtes en position de défense";
			p.pdef = true;
			p.ppar = a.getImpactParade();
		
		}
		//JOptionPane.showMessageDialog(jfinfo, message, "Défense", JOptionPane.PLAIN_MESSAGE);
		return message;
	}
	String soin(Personnage p,Arme a){
		JFrame jfinfo = new JFrame();
		String message = new String();
		int prSoin = ThreadLocalRandom.current().nextInt(0, 10000)/10000;
		if(prSoin < a.getPRSoin()) {
			message = message + "Vous avez utilisé Soin : \n Vitalité +" + a.getImpactSoin();
			p.vie = p.vie + a.getImpactSoin();
		}
		//JOptionPane.showMessageDialog(jfinfo, message, "Soin", JOptionPane.PLAIN_MESSAGE);
		return message;
	}
	String ordinateur() {
		JFrame jfinfo = new JFrame();
		String message = new String();
		int n = 0,c=0;
		if(p2.getType().equals("Guerrier")) {
			n = ThreadLocalRandom.current().nextInt(0, 2);
		}else if(p2.getType().equals("Athlete")) {
			n = ThreadLocalRandom.current().nextInt(0, 3);
			if(n == 1) {
				n = n + (ThreadLocalRandom.current().nextInt(1 + 1 -1) - 1);
			}
		}else if(p2.getType().equals("Magicien")) {
			n = ThreadLocalRandom.current().nextInt(0, 3);
		}
		Arme a = new Arme(p2,p2.Armes[n]);
		if(p2.Armes[n] < 0) {
			n = ThreadLocalRandom.current().nextInt(0, 2);
		}
		if(n == 0) {
			message = message + "L'ordinateur choisi d'attaquer avec " + a.getNom();
			attack(p2,p1, a);
			p1.pdef = false;
			p1.ppar = 0;
		}else if(n == 1) {
			message = message + "L'ordinateur choisi de defendre avec " + a.getNom();
			parade(p2,a);
		}else if(n == 2) {
			message = message + "L'ordinateur choisi de se soigner avec " + a.getNom();
			soin(p2,a);
		}
		//JOptionPane.showMessageDialog(jfinfo, message, "Ordinateur", JOptionPane.PLAIN_MESSAGE);
		return message;
	}
}