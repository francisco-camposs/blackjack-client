package br.imd.ufrn.blackjackClient.model;


import br.imd.ufrn.blackjackClient.enums.Rank;
import br.imd.ufrn.blackjackClient.enums.Suit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getValue() {
		return rank.value;
	}
}
