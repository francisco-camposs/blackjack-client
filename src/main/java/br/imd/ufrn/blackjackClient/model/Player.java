package br.imd.ufrn.blackjackClient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Player {

	private String name;
	private int coins;
	private Hand hand;
	
}
