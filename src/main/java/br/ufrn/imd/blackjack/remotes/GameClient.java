package br.ufrn.imd.blackjack.remotes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufrn.imd.blackjack.exceptions.InputTimeoutException;
import br.ufrn.imd.blackjack.utils.TimeoutInput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameClient extends UnicastRemoteObject implements IGameClient{

	private String name;
	private static final long serialVersionUID = 1L;
	
	public GameClient() throws RemoteException {
		super();
	}
	
	@Override
	public void showMessage(String message) throws RemoteException {
		System.out.println(message);
	}
	
	@Override
	public String getCommand() throws InputTimeoutException, RemoteException {
		String command = TimeoutInput.string();
		if (command.isEmpty())
			throw new InputTimeoutException("Nenhum comando inserido");
		return command;
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

}
