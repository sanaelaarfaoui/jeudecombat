import java.util.Scanner;

public class Magicien extends Personnage{
	Magicien(){
		super();
		this.Armes[0] = 1;
		this.Armes[1] = 3;
		this.Armes[2] = 5;
	}
	Magicien(String nom){
		super(nom);
		this.Armes[0] = 1;
		this.Armes[1] = 3;
		this.Armes[2] = 5;
	}
	Magicien(int force,int dexterite,int intelligence, int concentration){
		super(force,dexterite,intelligence,concentration);
		this.Armes[0] = 1;
		this.Armes[1] = 3;
		this.Armes[2] = 5;
	}
	
	/*
	 * 
	 *  Fonctions qui servent à déterminer les aptitudes du Guerrier
	 *  et vérifier si elles vérifient les conditions de l'énoncée
	 * 
	 */
	void setAptitude() {
		Scanner sc = new Scanner(System.in);
		// on initialise au début des variables f,d,i,c par des valeur négatives
		double f= -1,d = -1,i = -1,c = -1;
		// Demander au joueur de saisir les aptitudes:
		System.out.println("Donnez les aptitudes du " + this.getType() + " : \n");
		// une boucle qui se repete tant que les aptitude donnée par l'utilisateur ne vérifient pas les conditions de l'enoncée
		while(!this.checkAptitude(f,d,i,c)) {
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la force du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkF(f)) {
				System.out.println("Force (inférieure à "+(100+exp)/4 + ")");
				f = sc.nextInt();
			}
			// Enregistrer la force si la valeur saisie est valide
			this.force = f;
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la dextérité du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkD(d)) {
				System.out.println("Dextérité (inférieure à "+(100 + exp - f)/4+ ")");
				d = sc.nextInt();
			}
			// Enregistrer la dextérite si la valeur saisie est valide
			this.dexterite = d;
			
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir l'intelligence du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkI(i)) {
				System.out.println("Intelligence (entre " + (15 + max(f,d)) + "et "+(70 + exp - (2 * max(f,d)))+")");
				i = sc.nextInt();
			}
			// Enregistrer l'intelligence si la valeur saisie est valide
			this.intelligence = i;
			
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la concentration du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkC(c)) {
				System.out.println("c (entre " + (15 + max(f,d)) + "et "+(100+exp - f-d - i)+")");
				c = sc.nextInt();
			}
			// Enregistrer la concentration si la valeur saisie est valide
			this.concentration = c;
		}
	}
	// Verifier si la force du magicien est inférieur à (100+ exp)/4
	boolean checkF(double f) {
		boolean v = false;
		if(f<=(70 + exp)/4 && f >=0) {
			v =true;
		}
		return v;
	}
	// Verifier si la dextérité du magicien est  
	boolean checkD(double d) {
		boolean v = false;
		if(d <= (70 + exp - this.force)/4 && d >= 0) {
			v =true;
		}
		return v;
	}
	// Verifier si la intelligence du magicien est entre 15 et 100-15+exp
	boolean checkI(double i) {
		boolean v = false;
		if(i <= (70 + exp - (2 * max(this.force,this.dexterite))) && i >= (max(this.force,this.dexterite) + 15)) {
			v =true;
		}
		return v;
	}
	// Verifier si la concentration du magicien est entre 15 et 100+exp-intelligence
	boolean checkC(double c) {
		boolean v = false;
		if(c <= (100+exp - this.force - this.dexterite - this.intelligence) && c >= (max(this.force,this.dexterite) + 15)) {
			v =true;
		}
		return v;
	}
	
	// verifier que les aptitudes vérifient les conditions
	boolean checkAptitude(double f,double d,double i,double c) {
		if(f < 0 || d < 0 || i < 0 || c < 0) {
			return false;
		}
		
		// cette variable restera false si les valeurs ne vérifient pas les conditions suivante sinon elle retournera true
		boolean v = false;
		
		//valeur des aptitudes positives
		 // intelligence >max(force,dextérité) + 15 et  concentration > max(force,dextérité) + 15
		if(f+d+i+c <= 100+exp && i>=max(f,d)+15 &&  c>=max(f,d)+15) {
			v = true;
		}
		return v;
	}
	/*
	 * 
	 * FIN des Fonctions d'aptitude du Guerrier
	 * 
	 */
	String getType() {
		return "Magicien";
	}
	
	// recevoir le max de deux nombres
	
	int type() {
		return 3;
	}

}
