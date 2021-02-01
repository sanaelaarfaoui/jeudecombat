public class Arme {
	
	// Le numéro / identifiant de l'arme
	int numArme;
	double maniabilite,impact,parade,facilite,efficacite,protection;
	
	// Chaque arme est identifié par un numéro (ID de l'arme) à partire de 0 pour facilité la programmation
	private int[] numArmes = {0,1,2,3,4,5};
	// Tableau qui, à chaque id de l'arme (indices du tableau) associe une chaine de caractère qui contient le nom de cette arme
	String[] nomArmes = {"Epée","Sortilège Offencif","Bouclier","Sortilège Défensif","Remède","Sortilège guérisseur"};
	
	
	/* les caractéristiques de chaque Armes (L'énoncé ne spécifie par des valeurs pour ces caractéristique dans je les ai rempli moi même)
	*	Il s'agit d'un tableau de 6 colonnes (chaque colonne represente une caractéristique) par l'ordre suivant {maniabilite,impact,parade,facilite,efficacite,protection}
	* et 6 ligne (chaque ligne représente une arme)
	* Exemple cArmes[0][1] representre l'impact de l'épée; cArmes[3][3] représente la facilité du Bouclier
	*/ 
	private int[][] cArmes = {{325,5,1,0,0,0},{0,0,0,200,7,0},{0,0,0,200,0,4},{0,0,0,300,3,0},{0,0,0,200,1,0},{0,0,0,200,1,0}};
	
	
	// tableau des probabilité de réussite des Attaques/Parade/Soin de chaque arme, ils sont tous initialisé à 0 au début
	private double[][] prArmes = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	// tableau des impactes des Attaques/Parade/Soin de chaque arme, ils sont tous initialisé à 0 au début
	private double[][] iArmes = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
	// dans les deux tableau précedents chaque arme à 3 valeurs: la première (d'indice 0) est la valeur de l'attaque, la deuxième (indice 1) est la parade, la 3ème est le soin
	
	
	
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
		
		
		// Une boucle pour remplire les tableaux des probabilté de réussite et de l'impact de chaque arme;
		for(int i = 0; i<prArmes[numArme].length;i++) {
			switch(numArme) {
				case 0: // Epée
					// Attaque
					prArmes[numArme][0] = (p.dexterite*maniabilite)/10000; // (l'indice 0 pour l'attaque)
					iArmes[numArme][0] = (p.force*impact)/100;
					// Parade
					prArmes[numArme][1] = (p.dexterite*maniabilite); //(l'indice 1 pour la parade/defense)
					iArmes[numArme][1] = (p.force*parade)/100;
					break;
				case 1: // Soritlège Offensif
					// Attaque
					prArmes[numArme][0] = (p.concentration*facilite)/10000;
					iArmes[numArme][0] = (p.intelligence*efficacite)/100;
				case 2: // Bouclier
					// Parade
					prArmes[numArme][1] = (p.dexterite*maniabilite)/10000;
					iArmes[numArme][1] = (p.force*protection)/100;
					break;
				case 3: // Sortilège Défensif
					// Parade
					prArmes[numArme][1] = (p.concentration*facilite)/10000;
					iArmes[numArme][1] = (p.intelligence*efficacite)/100;
					break;
				case 4: // Remède
					// Parade (l'indice 2 represente l'attaque)
					prArmes[numArme][2] = (p.dexterite*facilite)/10000; // (l'indice 2 represente le soin)
					iArmes[numArme][2] = (p.dexterite*efficacite)/100;
					break;
				case 5: // Sortilège Guérisseur
					// Parade
					prArmes[numArme][2] = (p.concentration*facilite)/10000;
					iArmes[numArme][2] = (p.intelligence*efficacite)/100;
					break;
			}
		}
	}
	
	// donner la probabilité de réussite de l'attaque
	double getPRAttack(){
		return prArmes[numArme][0];
	}
	// donner la probabilité de réussite de la défense/parade
	double getPRParade(){
		return prArmes[numArme][1];
	}
	// donner la probabilité de réussite du soin
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
