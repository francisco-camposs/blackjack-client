package br.ufrn.imd.blackjackClient;

import br.imd.ufrn.blackjackClient.model.Player;
import br.ufrn.imd.blackjackClient.exceptions.InputTimeoutException;
import br.ufrn.imd.blackjackClient.services.GameClient;
import br.ufrn.imd.blackjackClient.services.PlayerInitializer;

public class BlackjackClient {

	public static void main(String[] args) {
		try {
			greetPlayer();
			startingGame();
		} catch (InputTimeoutException e) {
			System.out.println("O nome do jogador não foi adicionado a tempo.");
			endingGame();
		} 
	}
	
	private static void greetPlayer() {
		System.out.println("O jogo está iniciando...");
		System.out.println("Welcome To");
		System.out.println(
				  "  ____  _            _    _            _    \n"
				+ " |  _ \\| |          | |  (_)          | |   \n"
				+ " | |_) | | __ _  ___| | ___  __ _  ___| | __\n"
				+ " |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n"
				+ " | |_) | | (_| | (__|   <| | (_| | (__|   < \n"
				+ " |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n"
				+ "                        _/ |                \n"
				+ "                       |__/                 \n");
	}

	private static void startingGame() throws InputTimeoutException {
		System.out.println("Jogo iniciando ...");
		Player player = PlayerInitializer.buildPlayer();
		GameClient client = GameClient.builder().player(player).build();
		client.start();
	}
	
	private static void endingGame() {
		System.out.println("O jogo será encerrado.");
		System.out.println("Obrigado por jogar.");
		System.exit(0);
	}
	
}
