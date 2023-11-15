package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
private int quilles ; 
private int score ; 
private int [] tour ; 
private String joueur ; 
private int lancer ; 
private int nbTour ; 
private int nbLancer ; 

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur(int score,String joueur, int lancer) {
	this.quilles = 10 ; 
	this.score = score ; 
	this.joueur = joueur;
	this.tour = new int[11]; 
	for(var i= 0; i < 11 ; i++) {
	tour[i]=0 ; 
	}
	this.lancer = lancer ; 
	this.nbTour = 0 ; 
	this.nbLancer = 0 ; 
	}

	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		nbLancer = nbLancer + 1 ; 
		if ( quilles - nombreDeQuillesAbattues ==0 || nbLancer== 2 ){
			quilles = 10 ; 
			return false ; 
			
		}
		if (nbLancer == 2){
			nbLancer =0 ; 
		}
		
		else quilles = quilles - nombreDeQuillesAbattues ; 
		return true; 
		
	}

	
	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		for ()
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		lancer = lancer-1 ; 
		if (lancer == 0)	{
			return true ; 

		}
		else return false ; 
		}


	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
	
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		throw new UnsupportedOperationException("Pas encore implémenté");
	}

}
