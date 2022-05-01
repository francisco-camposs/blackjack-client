package br.ufrn.imd.blackjack;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.ufrn.imd.blackjack.exceptions.EndingGameException;
import br.ufrn.imd.blackjack.exceptions.InputTimeoutException;
import br.ufrn.imd.blackjack.remotes.GameClient;
import br.ufrn.imd.blackjack.remotes.IGameServer;
import br.ufrn.imd.blackjack.utils.TimeoutInput;

public class BlackjackClient {

	public static void main(String[] args) {
		try {
			greetPlayer();
			startingGame();
		} catch (EndingGameException | RemoteException | MalformedURLException | NotBoundException | InputTimeoutException ex) {
			System.out.println(ex.getMessage());
			endingGame();
			System.exit(0);
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

	private static void startingGame() throws EndingGameException, 
												RemoteException, 
												MalformedURLException, 
												NotBoundException, 
												InputTimeoutException {
		System.out.println("Digite o nome do jogador em até 15s:");
		String name = TimeoutInput.string();
		if (name.isEmpty())
			throw new InputTimeoutException("Nome inválido");
		
		IGameServer server = (IGameServer) Naming.lookup("rmi://127.0.0.1:1098/blackjack-server");
		
		GameClient client = new GameClient();
		client.setName(name);
		server.addPlayer(client);
	}
	
	private static void endingGame() {
		System.out.println("O jogo será encerrado.");
		System.out.println("Obrigado por jogar.");
	}
	
}
