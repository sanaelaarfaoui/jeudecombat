public class Arme {
	
	// Le num�ro / identifiant de l'arme
	int numArme;
	double maniabilite,impact,parade,facilite,efficacite,protection;
	
	// Chaque arme est identifi� par un num�ro (ID de l'arme) � partire de 0 pour facilit� la programmation
	private int[] numArmes = {0,1,2,3,4,5};
	// Tableau qui, � chaque id de l'arme (indices du tableau) associe une chaine de caract�re qui contient le nom de cette arme
	String[] nomArmes = {"Ep�e","Sortil�ge Offencif","Bouclier","Sortil�ge D�fensif","Rem�de","Sortil�ge gu�risseur"};
	
	
	/* les caract�ristiques de chaque Armes (L'�nonc� ne sp�cifie par des valeurs pour ces caract�ristique dans je les ai rempli moi m�me)
	*	Il s'agit d'un tableau de 6 colonnes (chaque colonne represente une caract�ristique) par l'ordre suivant {maniabilite,impact,parade,facilite,efficacite,protection}
	* et 6 ligne (chaque ligne repr�sente une arme)
	* Exemple cArmes[0][1] representre l'impact de l'�p�e; cArmes[3][3] repr�sente la facilit� du Bouclier
	*/ 
	private int[][] cArmes = {{325,5,1,0,0,0},{0,0,0,200,7,0},{0,0,0,200,0,4},{0,0,0,300,3,0},{0,0,0,200,1,0},{0,0,0,200,1,0}};
	
	
	// tableau des probabilit� de r�ussite des Attaques/Parade/Soin de chaque arme, ils sont tous initialis� � 0 au d�but
	private double[][] prArmes = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	// tableau des impactes des Attaques/Parade/Soin de chaque arme, ils sont tous initialis� � 0 au d�but
	private double[][] iArmes = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	// dans les deux tableau pr�cedents chaque arme � 3 valeurs: la premi�re (d'indice 0) est la valeur de l'attaque, la deuxi�me (indice 1) est la parade, la 3�me est le soin
	
	
	
	// Constructeurs
	Arme(){
		
	}
	Arme(Personnage p, int numArme){
		maniabilite = cArmes[numArme][0];
		impact = cArmes[numArme][1];
		parade = cArmes[numArme][2];
		facilite = cArmes[numArme][3];
		efficacite = cArmes[numArme][4];
		protection = cArmes[numArme][5];
		this.numArme = numArme;
		
		
		// Une boucle pour remplire les tableaux des probabilt� de r�ussite et de l'impact de chaque arme;
		for(int i = 0; i<prArmes[numArme].length;i++) {
			switch(numArme) {
				case 0: // Ep�e
					// Attaque
					prArmes[numArme][0] = (p.dexterite*maniabilite)/10000; // (l'indice 0 pour l'attaque)
					iArmes[numArme][0] = (p.force*impact)/100;
					// Parade
					prArmes[numArme][1] = (p.dexterite*maniabilite); //(l'indice 1 pour la parade/defense)
					iArmes[numArme][1] = (p.force*parade)/100;
					break;
				case 1: // Soritl�ge Offensif
					// Attaque
					prArmes[numArme][0] = (p.concentration*facilite)/10000;
					iArmes[numArme][0] = (p.intelligence*efficacite)/100;
				case 2: // Bouclier
					// Parade
					prArmes[numArme][1] = (p.dexterite*maniabilite)/10000;
					iArmes[numArme][1] = (p.force*protection)/100;
					break;
				case 3: // Sortil�ge D�fensif
					// Parade
					prArmes[numArme][1] = (p.concentration*facilite)/10000;
					iArmes[numArme][1] = (p.intelligence*efficacite)/100;
					break;
				case 4: // Rem�de
					// Parade (l'indice 2 represente l'attaque)
					prArmes[numArme][2] = (p.dexterite*facilite)/10000; // (l'indice 2 represente le soin)
					iArmes[numArme][2] = (p.dexterite*efficacite)/100;
					break;
				case 5: // Sortil�ge Gu�risseur
					// Parade
					prArmes[numArme][2] = (p.concentration*facilite)/10000;
					iArmes[numArme][2] = (p.intelligence*efficacite)/100;
					break;
			}
		}
	}
	
	// donner la probabilit� de r�ussite de l'attaque
	double getPRAttack(){
		return prArmes[numArme][0];
	}
	// donner la probabilit� de r�ussite de la d�fense/parade
	double getPRParade(){
		return prArmes[numArme][1];
	}
	// donner la probabilit� de r�ussite du soin
	double getPRSoin(){
		return prArmes[numArme][2];
	}
	
	// donner l'impact de l'attaque
	double getImpactAttack(){
		return iArmes[numArme][0];
	}
	// donner l'impact de la parade
	double getImpactParade(){
		return iArmes[numArme][1];
	}
	// donner l'impact du soin
	double getImpactSoin(){
		return iArmes[numArme][2];
	}
	
	// Afficher tous les armes, pour que l'utilisateur puisse choisir celles qu'ils veut 
	void afficherArmes() {
		for(int i = 0;i<6;i++) {
			System.out.println("[" + numArmes[i] + "] : " + nomArmes[i] + "\n");
		}
	}
	// Recevoir le nom de l'arme
	String getNom() {
		return this.nomArmes[numArme];
	}
}
