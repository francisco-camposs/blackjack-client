package br.ufrn.imd.blackjackClient.services;

import br.imd.ufrn.blackjackClient.model.Player;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameClient {
	
	private Player player;

	public void start() {
		
	}	

}
