import java.util.Scanner;

public class Athlete extends Personnage{
	Athlete(){
		super();
		this.Armes[0] = 0;
		this.Armes[2] = 4;
	}
	Athlete(String nom){
		super(nom);
		this.Armes[0] = 0;
		this.Armes[2] = 4;
	}
	Athlete(int force,int dexterite,int intelligence, int concentration){
		super(force,dexterite,intelligence,concentration);
		this.Armes[0] = 0;
		this.Armes[2] = 4;
	}
	
	/*
	 * 
	 *  Fonctions qui servent � d�terminer les aptitudes du Guerrier
	 *  et v�rifier si elles v�rifient les conditions de l'�nonc�e
	 * 
	 */
	void setAptitude() {
		Scanner sc = new Scanner(System.in);
		// on initialise au d�but des variables f,d,i,c par des valeur n�gatives
		double f= -1,d = -1,i = -1,c = -1;
		// Demander au joueur de saisir les aptitudes:
		System.out.println("Donnez les aptitudes du " + this.getType() + " : \n");
		
		// une boucle qui se repete tant que les aptitude donn�e par l'utilisateur ne v�rifient pas les conditions de l'enonc�e
		while(!this.checkAptitude(f,d,i,c)) {
			
			// une boucle qui redemande � chaque fois � l'utilisateur de resaisir la force du personnage tant que celle ci ne v�rifie pas la condition affich�
			while(!this.checkF(f)) {
				System.out.println("Force (entre 20 et "+(100-60+exp)+")");
				f = sc.nextInt();
			}
			// Enregistrer la force si la valeur saisie est valide
			this.force = f;
			
			// une boucle qui redemande � chaque fois � l'utilisateur de resaisir la dext�rit� du personnage tant que celle ci ne v�rifie pas la condition affich�
			while(!this.checkD(d)) {
				System.out.println("Dext�rit� (entre 20 et "+((100-f-40)+exp)+")");
				d = sc.nextInt();
			}
			// Enregistrer la dext�rite si la valeur saisie est valide
			this.dexterite = d;
			// une boucle qui redemande � chaque fois � l'utilisateur de resaisir l'intelligence du personnage tant que celle ci ne v�rifie pas la condition affich�
			while(!this.checkI(i)) {
				System.out.println("Intelligence (entre 20 et "+((100-f-d-20)+exp)+")");
				i = sc.nextInt();
			}
			// Enregistrer l'intelligence si la valeur saisie est valide
			this.intelligence = i;
			// une boucle qui redemande � chaque fois � l'utilisateur de resaisir la concentration du personnage tant que celle ci ne v�rifie pas la condition affich�
			while(!this.checkC(c)) {
				System.out.println("C =  (entre 20 et "+((100-f-d-i)+exp)+")");
				c = sc.nextInt();
			}
			// Enregistrer la concentration si la valeur saisie est valide
			this.concentration = c;
		}
		
	}
	
	// Verifier si la force du guerrier est entre 20 et 100-60+exp (les conditions donn�e dans l'�nonc� du projet)
	boolean checkF(double f) {
		boolean v = false;
		if(f <= 40 + exp && f >= 20) {
			v =true;
		}
		return v;
	}
	// Verifier si la dext�rit� du guerrier est entre 20 et 100-40+exp-force (les conditions donn�e dans l'�nonc� du projet)
	boolean checkD(double d) {
		boolean v = false;
		if(d <= 60 + (exp - this.force) && d >= 20) {
			v =true;
		}
		return v;
	}
	// Verifier si la intelligence du guerrier est entre 20 et 100-20+exp-force-dexterit� (les conditions donn�e dans l'�nonc� du projet)
	boolean checkI(double i) {
		boolean v = false;
		if(i <= 80 + (exp-this.force-this.dexterite) && i >= 20) {
			v =true;
		}
		return v;
	}
	// Verifier si la concentration du guerrier est entre 0 et 100+exp-force-dext�rit�-intelligence (les conditions donn�e dans l'�nonc� du projet)
	boolean checkC(double c) {
		boolean v = false;
		if(c <= 100 + (exp-this.force-this.dexterite-this.intelligence) && c >= 20) {
			v =true;
		}
		return v;
	}
	// verifier que les aptitudes v�rifient les conditions
	boolean checkAptitude(double f,double d,double i,double c) {
		if(f < 0 || d < 0 || i < 0 || c < 0) {
			return false;
		}
		
		
		// cette variable restera false si les valeurs ne v�rifient pas les conditions suivante sinon elle retournera true
		boolean v = false;
		//valeur des aptitudes positives
		 // force >20 et dext�rit�> 20 et intelligence > 20 et concentration > 20
		if(f+d+i+c <= 100+exp && f>=20 &&  d>=20 && i>=20 && c>=20) {
			v = true;
		}
		return v;
	}
	/*
	 * 
	 * FIN des Fonctions d'aptitude du Guerrier
	 * 
	 */
	
	// donner le type du perso
	String getType() {
		return "Athlete";
	}
	
	int type() {
		return 2;
	}
}

