import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	// création de la liste Deck
	
	private ArrayList<Card> cards;
	
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	
	
	
	
	// création des cartes du jeu
	
	public void créerDeck() {
		
		// création des cartes avancer 
		for (int i =0; i<19 ; i++) {
			//
			this.cards.add(new Card(Valeurs.avancer ));
		}
		
		// création des cartes tourner à droite
		
		for(int j= 1; j<9; j++)
		{
			this.cards.add(new Card(Valeurs.tournerD ));
		}
		
		
		// création des cartes tourner à gauche	
		for(int k= 1; k<9; k++) {
			this.cards.add(new Card(Valeurs.tournerG));
		}
		
		// creation des cartes laser
		for(int l= 1; l<4; l++) {
			this.cards.add(new Card(Valeurs.LASER ));
		}
		
		// creation des cartes laser
		
		this.cards.add(new Card(Valeurs.BUG));
		this.cards.add(new Card(Valeurs.BUG));
		
	}
	
	
	
	
	
	
	// fonction qui mélange le deck
	
	public void mélanger() {
		
		// création d'un deck temporaire
		
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		
		int sizedeck = this.cards.size();
		for (int i = 0; i<sizedeck; i++) {
			
			// génération d'indice aléatoire
			randomCardIndex = random.nextInt((this.cards.size()-1 -0 )+1)+ 0;
			
			// on prends des cartes au hasard du deck pour les mettres dans le deck temporaire
			tmpDeck.add(this.cards.get(randomCardIndex));
			
			
			// enlèvement des cartes placées dans le deck temporaire
			this.cards.remove(randomCardIndex);	
		}
		
		// le deck temporaire devient le deck principal
		this.cards= tmpDeck;
	}
	
	// création de la fonction pour enlever une carte d'un deck
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	// fonction qui retourne une carte d'un deck
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	// fonction qui ajoute une carte dans un deck
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	
	
	//  Fonction qui pioche les cartes 
	public void draw (Deck provenance) {
		// prends ajoute une carte du deck dans un autre deck et supprime cette carte de ce deck
		this.cards.add(provenance.getCard(0));
		provenance.removeCard(0);
		
		
	}
	
public void Defausse(Deck provenance ) {
	int taille = this.cards.size();
	for(int i=0; i< taille -1; i++) {
		provenance.removeCard(i);
	}
		
	}
	
	

	public int TailleDeck() {
		return this.cards.size();	
	}
	
public String toString() {
		
		String cardListOutput ="";
		for (Card aCard: this.cards) {
			cardListOutput += "\n-" + aCard.toString();		}
		
		return cardListOutput;
			
	}
	
	
	
	
	
	
	public ArrayList<Card> Programme() {
			
			ArrayList<Card> à_éxécuter = new ArrayList<Card>();
			Card a;
			int taille = this.cards.size();
			System.out.println(this.cards);
			System.out.println("-----------------------------");
			
			for(int i=0; i< taille ; i++) {
				System.out.println("la carte traitée est " + this.cards.get(i));
				 a= this.cards.get(i);
				
				switch (a.getvaleurs()) {
			
			case avancer: 
				System.out.println("la tortue avance");
				à_éxécuter.add(new Card(Valeurs.avancer ));
				break;
			
			case tournerG:
				System.out.println("la tortue tourne à gauche");
				à_éxécuter.add(new Card(Valeurs.tournerG));
				break;
				
			
			case tournerD:
				System.out.println("la tortue tourne à droite");
				à_éxécuter.add(new Card(Valeurs.tournerD ));
				break;
				
			case LASER :
				System.out.println("laser bang bang ");
				à_éxécuter.add(new Card(Valeurs.LASER ));
				break;
			case BUG :
				à_éxécuter.add(new Card(Valeurs.BUG ));
				break;

			
				
			
			}				
		}
	
	return à_éxécuter;
		
	}
	

}
