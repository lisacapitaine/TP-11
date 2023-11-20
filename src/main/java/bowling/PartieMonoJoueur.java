package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancers successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class PartieMonoJoueur {
	private int numTour = 1;
	
	public static final int nbDeQuilles = 10;
	public static final int nbDeTours = 10;
	private ArrayList<Tour> partie = new ArrayList<>();

	/**
	 * Constructeur
	 */
	public PartieMonoJoueur() {
		for (int i = 1; i <= nbDeTours; i++) {
			partie.add(new Tour(i));
		}
	}



	/**
	 * Cette méthode doit être appelée à chaque lancer de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de ce lancer
	 * @throws IllegalStateException si la partie est terminée
	 * @return vrai si le joueur doit lancer à nouveau pour continuer son tour, faux sinon	
	 */
	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (fin()) throw new IllegalStateException("fin de la partie");

		Lancer lancer = new Lancer(nombreDeQuillesAbattues);
		boolean continuerTour = partie.get(numTour - 1).enregistreLancer(lancer);

		if (!continuerTour) {
			if (numTour < nbDeTours) numTour++;
		}

		return continuerTour;
	}

	/**
	 * Cette méthode donne le score du joueur.
	 * Si la partie n'est pas terminée, on considère que les lancers restants
	 * abattent 0 quille.
	 * @return Le score du joueur
	 */
	public int score() {
		int total = 0;

		for (int i = 0; i < nbDeTours - 1; i++) {
			Tour tour = partie.get(i);
			total += tour.getScore();

			if (tour.estUnSpare()) {
				total += partie.get(i + 1).getScore(1);
			} else if (tour.estUnStrike()) {
				if (i + 1 == nbDeTours - 1 || !partie.get(i + 1).estUnStrike()) {
					total += partie.get(i + 1).getScore();
				} else {
					total +=partie.get(i + 1).getScore(1) + partie.get(i + 2).getScore(1);
				}
			}
		}
		
		

		Tour dernierTour = partie.get(nbDeTours - 1);
		total += dernierTour.getScore();
		
		if (total>300){

			total=300;
		}
		return total;
	}

	/**
	 * @return vrai si la partie est terminée pour ce joueur, faux sinon
	 */
	public boolean fin() {
		boolean b=false;
		if(partie.get(nbDeTours-1).estTermine()) {
			b = true;
		}
		return b;


	}

	/**
	 * @return Le numéro du tour courant [1..10], ou 0 si le jeu est fini
	 */
	public int numeroTourCourant() {
		if (fin()) {
			numTour = 0;
		}
		return numTour;
	}

	/**
	 * @return Le numéro du prochain lancer pour tour courant [1..3], ou 0 si le jeu
	 *         est fini
	 */
	public int numeroProchainLancer() {
		if (fin()) {
			return 0;
		} else if (numTour == nbDeTours) {
			int ret = partie.get(nbDeTours - 1).getCoupSuivant();
			return ret;
		} else {
			int ret2 = partie.get(numTour).getCoupSuivant();
			return ret2;
		}
	}

}
