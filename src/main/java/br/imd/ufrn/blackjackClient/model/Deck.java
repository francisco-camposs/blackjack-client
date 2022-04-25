package br.imd.ufrn.blackjackClient.model;

import java.util.Map;
import java.util.Random;

import br.imd.ufrn.blackjackClient.enums.Rank;
import br.imd.ufrn.blackjackClient.enums.Suit;

public class Deck {
	
private Map<Integer, Card> cards;
	
	
	public Deck() {
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public Card pullCard() {
		Random random = new Random();
		
		for(;;) {
			int cardNumber = random.nextInt(51);
			
			int suit = cardNumber % 4;
			int rank = cardNumber % 13;
			
			Card card = new Card(Suit.values()[suit], Rank.values()[rank]);
			if(!cards.containsValue(cardNumber)) {
				cards.put(cardNumber, card);
				return card;
			}else {
				//Todas as cartas retiradas
				System.out.println("Deck vazio");
				break;
			}
		}
		return null;
	}
}
