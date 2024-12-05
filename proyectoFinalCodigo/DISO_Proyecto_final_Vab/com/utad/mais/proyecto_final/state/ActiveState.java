package com.utad.mais.proyecto_final.state;

public class ActiveState extends AbstractPlayerState {

	
	//Constructor
	public ActiveState(Player player) {
		super();
		this.player = player;
	}

	//Método específico
	@Override
	public void process() {
		this.actionActiveState();
		
	}
	public void actionActiveState() {
		System.out.println("The player " + player.getName() + " is now in active state and prepared to fight");
		
	}
	
}
