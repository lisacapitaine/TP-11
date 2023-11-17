package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
private int quilles ; 

private Tour [] tour ; 
private String joueur ; 
private int lancer ; 
private int nbTour ; 
private int nbLancer ; 

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur(String joueur, int lancer) {
	this.quilles = 10 ;
	this.joueur = joueur;
	this.tour = new Tour [11] ; 
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
		int score =  0 ; 
		for (int i=0 ; i<tour.length-1 ;  i++ ){
		score = score + tour[i].nbPoint(tour[i+1]) ; 
		}
		return score ; 
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean estTerminee() {
		int compteur = 0 ; 
		for (int i=0 ; i<tour.length-1 ;  i++ ){
		if (tour[i].getCompteur () > compteur ){
		compteur = tour[i].getCompteur () ; 
		} 
		}
		if (compteur == 10){
			return true ; 
		}
		else return false ; 
	    }

	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		int compteur = 0 ; 
		for (int i=0 ; i<tour.length-1 ;  i++ ){
		if (tour[i].getCompteur () > compteur ){
		compteur = tour[i].getCompteur () ; 
		}
	}
	return compteur ; 
	}





	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
public int numeroProchainLancer() {
		if (estTerminee()) return 0;
		else return nbLancer ; 
		
	}


}
