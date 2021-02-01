abstract class Personnage {
	private String nom;
	public double vie;
	protected double force;
	protected double dexterite;
	protected double intelligence;
	protected double concentration;
	public boolean pdef = false;
	public double ppar;
	// Expérience
	protected int exp;
	// Armes (que 2 armes par personnage)
	protected int[] Armes = new int[3];
	
	// Constructeur
	public Personnage() {
		this.nom = "";		
	}
	public Personnage(String nom) {
		this.nom = nom;		
	}
	public Personnage(int force,int dexterite,int intelligence, int concentration) {
		this.force = force;
		this.dexterite = dexterite;
		this.intelligence = intelligence;
		this.concentration = concentration;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	// Donner le nombre de vie initiale du personnage
	public void setVie() {
		vie = 200 - (this.force + this.dexterite + this.intelligence + this.concentration) + this.exp*3;
	}
	
	// modifier la vie du personnage (ajouter de la vie si le personnage utilise une arme de soin ou diminuer la vie si le personnage reçoit une attaque)
	public void setVie(int n) {
		vie = vie + n;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	abstract void setAptitude();
	// Enregistrer les numéros des armes du Personnage
	public void setArmes(int a1, int a2, int a3) {
		Armes[0] = a1;
		Armes[1] = a2;
		Armes[2] = a3;
	}
	
	// Retourner le type du personnage.
		String getType() {
			return "Personnage";
		}
		
	// Recevoir l'expérience du Personnage
	int getExp() {
		return exp;
	}
	// Recevoir le nombre de vie qu'a le Personnage
	double getVie() {
		return (200-(this.force + this.dexterite + this.intelligence + this.concentration));
	}
	// Recevoir le nom du Personnage
	String getNom() {
		return nom;
	}
	// Afficher Toutes les Informations sur le personnage (nom, type, aptitudes,...)
	void getInfo() {
		System.out.println(this.nom + "Le Personnage est un " + this.getType() + "\n" + " Ces aptitudes sont : "
				+ "\n Force : " + this.force + "\n Dextérité : " + this.dexterite + "\n Intelligence : "+ this.intelligence + "\n concentration : " + this.concentration + "\n" + 
				"La somme des aptitudes est " + (this.force + this.dexterite + this.intelligence + this.concentration));
	}
	
	// donne le min et le max d'une aptitude
	String aptitudeMinMax(int type, String aptitude) {
		String r = "";
		// Guerrier
		if(type == 1) {
			if(aptitude == "f") {
				r = "(entre 10 et "+(100+exp)+")";
			}else if(aptitude == "d") {
				r = "(entre 0 et "+(100+exp-this.force)+")";
			}else if(aptitude == "i") {
				r = "(entre 0 et "+(100+(exp-this.force-this.dexterite))+")";
			}else if(aptitude == "c") {
				r = "(entre 0 et "+(100+(exp-this.force-this.dexterite-this.intelligence))+")";
			}
		}else if(type == 2) {
			if(aptitude == "f") {
				r = "(entre 20 et "+(40+exp)+")";
			}else if(aptitude == "d") {
				r = "(entre 20 et "+((60-this.force)+exp)+")";
			}else if(aptitude == "i") {
				r = "(entre 20 et "+((80-this.force-this.dexterite)+exp)+")";
			}else if(aptitude == "c") {
				r = "(entre 20 et "+((100-this.force-this.dexterite-this.intelligence)+exp)+")";
			}
			
		}else if(type == 3) {
			if(aptitude == "f") {
				r = "(inférieure à "+((70 + this.exp)/4)+")";
			}else if(aptitude == "d") {
				r = "(inférieure à "+((70 + exp - this.force)/4)+")";
			}else if(aptitude == "i") {
				r = "(entre "+(max(this.force,this.dexterite)+15)+" et "+(70 + exp - (2 * max(this.force,this.dexterite)))+")";
			}else if(aptitude == "c") {
				r = "(entre "+(max(this.force,this.dexterite)+15)+" et "+(100+exp - this.force - this.dexterite - this.intelligence)+")";
			}
		}
		return r;
	}
	double max(double n1,double n2) {
		if(n1 > n2) {
			return n1;
		}
		return n2;
	}
	// recevoir le min de deux nombres
	double min(double n1,double n2) {
		if(n1 > n2) {
			return n2;
		}
		return n1;
	}
	abstract boolean checkF(double f);
	abstract boolean checkD(double d);
	abstract boolean checkI(double i);
	abstract boolean checkC(double c);
	abstract int type();
}
