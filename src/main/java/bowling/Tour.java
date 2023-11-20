package bowling;

import java.util.ArrayList;

public class Tour {
	private int tour;
	private ArrayList<Lancer> lesLancers = new ArrayList<>();
	private int coup = 1;
	private boolean termine = false;

	public Tour(int tour) {
		this.tour = tour;
	}

	public boolean estUnStrike() {
		return lesLancers.size() == 1 && lesLancers.get(0).getNbQuille() == PartieMonoJoueur.nbDeQuilles;
	}

	public boolean estUnSpare() {
		return coup == 2 && getScore(1) + getScore(2) == PartieMonoJoueur.nbDeQuilles && tour != PartieMonoJoueur.nbDeTours;
	}

	
	public int getCoupSuivant() {
		return coup;
	}
	
	public int getScore(int numLancer) {
		if (numLancer >= 1 && numLancer <= lesLancers.size()) {
			return lesLancers.get(numLancer - 1).getNbQuille();
		} else {
			return 0;
		}
	}

	public int getScore() {
		int score = 0;
		for (Lancer lancer : lesLancers) {
			score += lancer.getNbQuille();
		}
		return score;
	}

	
	public boolean estTermine() {
		return termine;
	}
	

	public boolean enregistreLancer(Lancer lancer) {
		if (coup == 1) {
			lesLancers.add(lancer);
			if (getScore() == PartieMonoJoueur.nbDeQuilles && tour != PartieMonoJoueur.nbDeTours) {
				termine = true;
			} else if (getScore() == PartieMonoJoueur.nbDeQuilles) {
				coup += 1;
			} else {
				coup++;
			}
		} else if (coup == 2) {
			lesLancers.add(lancer);
			termine = true;
			if (tour == PartieMonoJoueur.nbDeTours && !(getScore() < PartieMonoJoueur.nbDeQuilles)) {
				coup++;
				termine = false;
			}
		} else if (coup == 3) {
			lesLancers.add(lancer);
			termine = true;
		}

		return !termine;
	}
}

