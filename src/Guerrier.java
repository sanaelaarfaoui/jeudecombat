import java.util.Scanner;

public class Guerrier extends Personnage{
	// Constructeur
	Guerrier(){
		super();
		this.Armes[0] = 0;
		this.Armes[1] = 2;
	}
	Guerrier(String nom){
		super(nom);
		this.Armes[0] = 0;
		this.Armes[1] = 2;
	}
	Guerrier(int force,int dexterite,int intelligence, int concentration){
		super(force,dexterite,intelligence,concentration);
		this.Armes[0] = 0;
		this.Armes[1] = 2;
	}
	
	
	/*
	 * 
	 *  Fonctions qui servent à déterminer les aptitudes du Guerrier
	 *  et vérifier si elles vérifient les conditions de l'énoncée
	 * 
	 */
	
	
	void setAptitude() {
		Scanner sc = new Scanner(System.in);
		// on initialise ses variable par des valeur négatives
		double f= -1,d = -1,i = -1,c = -1;
		// Demander au joueur de saisir les aptitudes:
		System.out.println("Donnez les aptitudes du " + this.getType() + " : \n");
		
		// unz boucle qui se repete tant que les aptitude donnée par l'utilisateur ne vérifient pas les conditions de l'enoncée
		while(!this.checkAptitude(f,d,i,c)) {
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la force du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkF(f)) {
				System.out.println("Force (entre 30 et "+(70+exp)+")");
				f = sc.nextInt();
			}
			// Enregistrer la force si la valeur saisie est valide
			this.force = f;
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la dextérité du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkD(d)) {
				System.out.println("Dextérité (entre 20 et "+(90+(exp-f))+")");
				d = sc.nextInt();
			}
			// Enregistrer la dextérite si la valeur saisie est valide
			this.dexterite = d;
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir l'intelligence du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkI(i)) {
				System.out.println("Intelligence (entre 10 et "+(100+(exp-f-d))+")");
				i = sc.nextInt();
			}
			// Enregistrer l'intelligence si la valeur saisie est valide
			this.intelligence = i;
			// une boucle qui redemande à chaque fois à l'utilisateur de resaisir la concentration du personnage tant que celle ci ne vérifie pas la condition affiché
			while(!this.checkC(c)) {
				System.out.println("Concentration  (entre 0 et "+(100+(exp-f-d-i))+")");
				c = sc.nextInt();
			}
			// Enregistrer la concentration si la valeur saisie est valide
			this.concentration = c;
		}
	}
	
	// Verifier si la force du guerrier est entre 30 et 70+exp (les conditions donnée dans l'énoncé du projet)
	boolean checkF(double f) {
		boolean v = false;
		if(f < 100 + exp && f > 10) {
			v =true;
		}
		return v;
	}
	// Verifier si la dextérité du guerrier est entre 20 et 90+exp-f (les conditions donnée dans l'énoncé du projet)
	boolean checkD(double d) {
		boolean v = false;
		if(d <= 100 + (exp - this.force) && d >= 0) {
			v =true;
		}
		return v;
	}
	// Verifier si la force du intelligence est entre 10 et 100+exp-f-d (les conditions donnée dans l'énoncé du projet)
	boolean checkI(double i) {
		boolean v = false;
		if(i <= 100 + (exp-this.force-this.dexterite) && i >= 0) {
			v =true;
		}
		return v;
	}
	// Verifier si la force du concentration est entre 0 et 100+exp-f-d-i (les conditions donnée dans l'énoncé du projet)
	boolean checkC(double c) {
		boolean v = false;
		if(c <= 100 + (exp-this.force-this.dexterite-this.intelligence) && c >= 0) {
			v =true;
		}
		return v;
	}
	// verifier que les aptitudes vérifient les conditions (, et la sommes des aptitude inférieur à 100 + exp)
	boolean checkAptitude(double f,double d,double i,double c) {
		if(f < 0 || d < 0 || i < 0 || c < 0) {
			return false;
		}
		boolean v = false;
		/*
		 * valeur des aptitudes positives
		 * force > dextérité + 10 > intelligence + 10 > concentration
		 */
		if(f+d+i+c <= 100+exp && f>=d+10 &&  d+10>=i+10 && i+10>c) {
			v = true;
		}
		return v;
	}
	/*
	 * 
	 * FIN des Fonctions d'aptitude du Guerrier
	 * 
	 */
		
	
	// Retourner le type du personnage
	String getType() {
		return "Guerrier";
	}
	int type() {
		return 1;
	}
}
