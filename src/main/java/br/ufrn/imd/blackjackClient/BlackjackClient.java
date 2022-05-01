package br.ufrn.imd.blackjackClient;

import br.imd.ufrn.blackjackClient.model.Player;
import br.ufrn.imd.blackjackClient.exceptions.EndingGameException;
import br.ufrn.imd.blackjackClient.services.GameClient;

public class BlackjackClient {

	public static void main(String[] args) {
		try {
			greetPlayer();
			startingGame();
			endingGame();
		} catch (EndingGameException ex) {
			System.out.println(ex.getMessage());
			endingGame();
		} 
	}
	
	private static void greetPlayer() {
		System.out.println("O jogo está iniciando...");
		System.out.println("  ____  _            _    _            _    ");
		System.out.println(" |  _ \\| |          | |  (_)          | |   ");
		System.out.println(" | |_) | | __ _  ___| | ___  __ _  ___| | __");
		System.out.println(" |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /");
		System.out.println(" | |_) | | (_| | (__|   <| | (_| | (__|   < ");
		System.out.println(" |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\");
		System.out.println("                        _/ |                ");
		System.out.println("                       |__/                 ");
	}

	private static void startingGame() throws EndingGameException {
		Player player = Player.create();
		GameClient client = GameClient.builder().player(player).build();
		client.start();
	}
	
	private static void endingGame() {
		System.out.println("O jogo será encerrado.");
		System.out.println("Obrigado por jogar.");
		System.exit(0);
	}
	
}
