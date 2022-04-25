package br.ufrn.imd.blackjackClient.services;

import br.imd.ufrn.blackjackClient.model.Hand;
import br.imd.ufrn.blackjackClient.model.Player;
import br.ufrn.imd.blackjackClient.exceptions.InputTimeoutException;
import br.ufrn.imd.blackjackClient.utils.TimeoutInput;

public class PlayerInitializer {
	
	private static Integer DEFAULT_COIN = 3000;

	public static Player buildPlayer() throws InputTimeoutException {
		System.out.println("Insira o nome do player em até 15s ou o programa encerrará automaticamente");
		Hand hand = new Hand();
		String name = TimeoutInput.inputString();
		return Player.builder().coins(DEFAULT_COIN).name(name).hand(hand).build();
	}
	
}
